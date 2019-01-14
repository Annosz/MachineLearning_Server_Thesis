package com.annosz.smartrealestate.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.annosz.smartrealestate.R
import com.annosz.smartrealestate.adapter.AdvertisementAdapter
import com.annosz.smartrealestate.model.AdvertisementData
import com.annosz.smartrealestate.adapter.VerticalSpaceItemDecoration
import java.io.Serializable


class ListOwnHousesFragment : Fragment() {
    private var listener: OnFragmentInteractionListener? = null

    private var ads: List<AdvertisementData> = emptyList()

    private lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var v = inflater.inflate(R.layout.fragment_list_own_houses, container, false)


        recyclerView = v.findViewById(R.id.list_own_houses_list) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = AdvertisementAdapter()

        val dividerItemDecoration = VerticalSpaceItemDecoration(6)
        recyclerView.addItemDecoration(dividerItemDecoration)

        if (savedInstanceState != null)
        {
            (recyclerView.adapter as AdvertisementAdapter).setAds(savedInstanceState.getSerializable("list") as List<AdvertisementData>)
        }

        return v
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState!!.putSerializable("list", (recyclerView.adapter as AdvertisementAdapter).getAds() as Serializable)
    }

    //TODO ez még más lesz
    fun onButtonPressed(id: Int) {
        listener?.onDetailsClicked(id)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        fun onDetailsClicked(id: Int)
    }

    fun AddHouseList(ads: List<AdvertisementData>) {
        (recyclerView.adapter as AdvertisementAdapter).setAds(ads)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                ListOwnHousesFragment().apply {
                }
    }
}
