package com.annosz.smartrealestate.network

import android.util.JsonReader
import com.annosz.smartrealestate.model.AdvertisementData
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.util.concurrent.TimeUnit

class AdViewCountAPI {

    companion object {
        private const val BASE_URL = "https://demo8952134.mockable.io/AdViewCount"
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

    private fun httpPost(url: String, body: RequestBody): String {
        val request = Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Content-Type","application/json")
                .build()

        //The execute call blocks the thread
        val response = client.newCall(request).execute()
        return response.body()?.string() ?: "EMPTY"
    }

    fun getView(ad: AdvertisementData): Int {
        return try {
            var body = FormBody.Builder()
                    .add("county", ad.county)
                    .add("city", ad.city)
                    .add("postcode", ad.postcode.toString())
                    .add("property_type", ad.propertyType)
                    .add("property_subtype", ad.propertySubtype)
                    .add("property_condition_type", ad.propertyConditionType)
                    .add("property_floor", ad.propertyFloor.toString())
                    .add("building_floor_count", ad.buildingFloorCount.toString())
                    .add("view_type", ad.viewType)
                    .add("orientation", ad.orientation)
                    .add("garden_access", ad.gardenAccess.toString())
                    .add("heating_type", ad.heatingType)
                    .add("elevator_type", ad.elevatorType.toString())
                    .add("room_count", ad.roomCount.toString())
                    .add("small_room_count", ad.smallRoomCount.toString())
                    .add("property_area", ad.propertyArea.toString())
                    .add("balcony_area", ad.balconyArea.toString())
                    .add("price_created_at", ad.priceCreatedAt.toString())
                    .add("active_days", "30")
                    .build()

            var response = httpPost(BASE_URL,body)
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