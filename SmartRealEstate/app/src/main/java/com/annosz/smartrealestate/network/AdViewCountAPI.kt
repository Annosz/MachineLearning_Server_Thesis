package com.annosz.smartrealestate.network

import android.util.JsonReader
import com.annosz.smartrealestate.model.AdvertisementData
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import okhttp3.*
import java.util.concurrent.TimeUnit

class AdViewCountAPI {

    companion object {
        private const val BASE_URL = "http://adviewcount.herokuapp.com/"
        private const val UTF_8 = "UTF-8"
        private const val TAG = "Network"
        private const val RESPONSE_ERROR = -1
    }

    private val client = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()

    private fun httpGet(url: String): String {
        val request = Request.Builder()
                .url(url)
                .build()

        //The execute call blocks the thread
        val response = client.newCall(request).execute()
        return response.body()?.string() ?: "EMPTY"
    }

    private fun httpPost(url: String, json: String): String {
        val body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json)

        val request = Request.Builder()
                .url(url)
                .post(body)
                .build()

        //The execute call blocks the thread
        val response = client.newCall(request).execute()
        return response.body()?.string() ?: "EMPTY"
    }

    fun getView(ad: AdvertisementData): Int {
        return try {
            val json = """{
                "county":"${ad.county}",
                "city":"${ad.city}",
                "postcode":"${ad.postcode.toString()}",
                "property_type":"${ad.propertyType}",
                "property_subtype":"${ad.propertySubtype}",
                "property_condition_type":"${ad.propertyConditionType}",
                "property_floor":"${ad.propertyFloor.toString()}",
                "building_floor_count":"${ad.buildingFloorCount.toString()}",
                "view_type":"${ad.viewType}",
                "orientation":"${ad.orientation}",
                "garden_access":"${ad.gardenAccess.toString()}",
                "heating_type":"${ad.heatingType}",
                "elevator_type":"${ad.elevatorType.toString()}",
                "room_count":"${ad.roomCount.toString()}",
                "small_room_count":"${ad.smallRoomCount.toString()}",
                "property_area":"${ad.propertyArea.toString()}",
                "balcony_area":"${ad.balconyArea.toString()}",
                "price_created_at":"${ad.priceCreatedAt.toString()}",
                "active_days":"30"
                }""".trimIndent()

            var response = httpPost(BASE_URL + "predict",json)
            if (response == "EMPTY")
            {
                -1
            }
            else
            {
                val gson = Gson()
                gson.fromJson(response, Response::class.java).viewCount
            }
        } catch (e: Exception) {
            e.printStackTrace()
            RESPONSE_ERROR
        }
    }

    private data class Response (
        @SerializedName("view_count")
        val viewCount: Int
    )

}