package com.annosz.smartrealestate.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.annosz.smartrealestate.R
import kotlinx.android.synthetic.main.fragment_add_house.*
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.text.Editable
import android.text.TextWatcher
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.Spinner
import com.annosz.smartrealestate.converters.Converters
import com.annosz.smartrealestate.model.AdvertisementData
import com.annosz.smartrealestate.network.AdViewCountAPI
import com.annosz.smartrealestate.network.AdViewCountEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.io.ByteArrayOutputStream
import java.util.*


class AddHouseFragment : Fragment() {

    var madeImage: Boolean = false
    var advertisemendData: AdvertisementData = AdvertisementData()

    private val adViewCountAPI = AdViewCountAPI()

    //region lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var v = inflater.inflate(R.layout.fragment_add_house, container, false)

        if (savedInstanceState != null)
        {
            madeImage = savedInstanceState.getBoolean("madeImage")
            if (madeImage)
            {
                var bytearray = savedInstanceState.getByteArray("image")
                var imageView = v.findViewById<ImageView>(R.id.FormImage)
                imageView.setImageBitmap(BitmapFactory.decodeByteArray(bytearray, 0, bytearray!!.size))
            }
        }

        val preferences = this.activity.getSharedPreferences(context.packageName + "_preferences", Context.MODE_PRIVATE)
        if (preferences.getBoolean("server_connection", true))
        {
            v.findViewById<TextView>(R.id.form_AdViewCount_text).text = context.getString(R.string.form_adViewCount_on,"0")
        }
        else
        {
            v.findViewById<TextView>(R.id.form_AdViewCount_text).text = context.getString(R.string.form_adViewCount_off)
        }


        val textChangeWatcher = TextChangeWatcher(this)
        val itemSelectedChangeListener = ItemSelectedChangeListener(this)
        v.findViewById<TextView>(R.id.FormCounty).addTextChangedListener(textChangeWatcher)
        v.findViewById<TextView>(R.id.FormCity).addTextChangedListener(textChangeWatcher)
        v.findViewById<TextView>(R.id.FormPostcode).addTextChangedListener(textChangeWatcher)
        v.findViewById<Spinner>(R.id.FormPropertyType).onItemSelectedListener = itemSelectedChangeListener
        v.findViewById<Spinner>(R.id.FormPropertyConditionType).onItemSelectedListener = itemSelectedChangeListener
        v.findViewById<TextView>(R.id.FormPropertyFloor).addTextChangedListener(textChangeWatcher)
        v.findViewById<TextView>(R.id.FormBuildingFloorCount).addTextChangedListener(textChangeWatcher)
        v.findViewById<Spinner>(R.id.FormViewType).onItemSelectedListener = itemSelectedChangeListener
        v.findViewById<Spinner>(R.id.FormOrientation).onItemSelectedListener = itemSelectedChangeListener
        v.findViewById<TextView>(R.id.FormGardenAccess).addTextChangedListener(textChangeWatcher)
        v.findViewById<Spinner>(R.id.FormHeatingType).onItemSelectedListener = itemSelectedChangeListener
        v.findViewById<TextView>(R.id.FormElevatorType).addTextChangedListener(textChangeWatcher)
        v.findViewById<TextView>(R.id.FormRoomCount).addTextChangedListener(textChangeWatcher)
        v.findViewById<TextView>(R.id.FormSmallRoomCount).addTextChangedListener(textChangeWatcher)
        v.findViewById<TextView>(R.id.FormPropertyArea).addTextChangedListener(textChangeWatcher)
        v.findViewById<TextView>(R.id.FormBalconyArea).addTextChangedListener(textChangeWatcher)
        v.findViewById<TextView>(R.id.FormPriceCreatedAt).addTextChangedListener(textChangeWatcher)

        return v
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        outState!!.putBoolean("madeImage", madeImage)
        if(madeImage)
        {
            val bitmap = (view!!.findViewById<ImageView>(R.id.FormImage).drawable as BitmapDrawable).bitmap
            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream)
            outState!!.putByteArray("image", stream.toByteArray())
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        EventBus.getDefault().register(this)
    }

    override fun onDetach() {
        EventBus.getDefault().unregister(this)
        super.onDetach()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AddHouseFragment().apply {
            }
    }
    //endregion

    //region event handling
    private class TextChangeWatcher(val fragment: AddHouseFragment): TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
            fragment.createAd()

            val preferences = fragment.activity.getSharedPreferences(fragment.context.packageName + "_preferences", Context.MODE_PRIVATE)
            if (preferences.getBoolean("server_connection", true)) {
                fragment.getPredictions()
            }
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }
    }

    private class ItemSelectedChangeListener(val fragment: AddHouseFragment): AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            fragment.createAd()

            val preferences = fragment.activity.getSharedPreferences(fragment.context.packageName + "_preferences", Context.MODE_PRIVATE)
            if (preferences.getBoolean("server_connection", true)) {
                fragment.getPredictions()
            }
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
        }
    }

    fun createAd() {
        advertisemendData = AdvertisementData()

        if (madeImage) {
            val bitmap = (FormImage.drawable as BitmapDrawable).bitmap
            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream)
            advertisemendData.image = stream.toByteArray()
        }
        else {
            advertisemendData.image = null
        }

        advertisemendData.county = FormCounty.text.toString()
        advertisemendData.city = FormCity.text.toString()
        advertisemendData.postcode = FormPostcode.text.toString().toIntOrNull() ?: 0
        advertisemendData.propertyType = FormPropertyType.selectedItem.toString()
        //advertisemendData.propertySubtype
        advertisemendData.propertyConditionType = FormPropertyConditionType.selectedItem.toString()
        advertisemendData.propertyFloor = FormPropertyFloor.text.toString().toIntOrNull() ?: 0
        advertisemendData.buildingFloorCount = FormBuildingFloorCount.text.toString().toIntOrNull() ?: 0
        advertisemendData.viewType = FormViewType.selectedItem.toString()
        advertisemendData.orientation = FormOrientation.selectedItem.toString()
        advertisemendData.gardenAccess = FormGardenAccess.isChecked
        advertisemendData.heatingType = FormHeatingType.selectedItem.toString()
        advertisemendData.elevatorType = FormElevatorType.isChecked
        advertisemendData.roomCount = FormRoomCount.text.toString().toIntOrNull() ?: 0
        advertisemendData.smallRoomCount = FormSmallRoomCount.text.toString().toIntOrNull() ?: 0
        advertisemendData.propertyArea = FormPropertyArea.text.toString().toDoubleOrNull() ?: 0.0
        advertisemendData.balconyArea = FormBalconyArea.text.toString().toDoubleOrNull() ?: 0.0
        advertisemendData.priceCreatedAt = FormPriceCreatedAt.text.toString().toDoubleOrNull() ?: 0.0

        var currentTime = Calendar.getInstance().time
        var converters = Converters()
        advertisemendData.creationDate = converters.dateToTimestamp(currentTime) ?: 0
        advertisemendData.modificationDate = converters.dateToTimestamp(currentTime) ?: 0
    }
    //endregion

    //region network
    private fun getPredictions()
    {
        async {
            val response = adViewCountAPI.getView(advertisemendData)
            EventBus.getDefault().post(AdViewCountEvent(response))
        }
    }

    private fun async(call: () -> Unit) = Thread { call() }.start()

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMoveUserResponse(event: AdViewCountEvent) {
        if (event.response == -1)
        {
            form_AdViewCount_text.text = context.getString(R.string.form_adViewCount_error)
        }
        else
        {
            form_AdViewCount_text.text = context.getString(R.string.form_adViewCount_on, event.response.toString())
        }
    }
    //endregion
}
