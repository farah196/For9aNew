package com.example.farahal_kiswani.demo.fragment

import android.content.Context
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.LinearLayout
import com.example.farahal_kiswani.demo.ApiClient1
import com.example.farahal_kiswani.demo.ApiService
import com.example.farahal_kiswani.demo.adapter.OpportunityAdapter
import com.example.farahal_kiswani.demo.R
import com.example.farahal_kiswani.demo.controller.ActivityCallBack
import com.example.farahal_kiswani.demo.models.Opportunity
import com.example.farahal_kiswani.demo.models.TimelineResponse2
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.home_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Home : Fragment(){



    val OpertinutyList = ArrayList<Opportunity>()
    var mCallback: ActivityCallBack? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val view = inflater.inflate(R.layout.home_fragment, container, false)


        return view
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //adding a layoutmanager
        mOppertinutyRecycler.layoutManager = GridLayoutManager(view.context, 2, GridLayout.VERTICAL, false)
        mCallback!!.ListIcon(mOppertinutyRecycler)
        mCallback!!.GridIcon(mOppertinutyRecycler)

















        getOpportunityList()



        mOppertinutyRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if ((recyclerView.getLayoutManager() as LinearLayoutManager).findLastCompletelyVisibleItemPosition() == OpertinutyList.size - 1) {
                    getOpportunityList()
                }
            }
        })



    }


    private fun getOpportunityList() {

        val apiServices = ApiClient1.client.create(ApiService::class.java)

        val call = apiServices.getTimeline("MNrAG2QLv41sWs2qd-spRKT594bfwROM", 10, 10);


        call.enqueue(object : Callback<TimelineResponse2> {
            override fun onResponse(call: Call<TimelineResponse2>, response: Response<TimelineResponse2>) {
                if (response.isSuccessful) {
                    for (mOpportunity: Opportunity in response.body()?.results!!) {
                        Log.i("Test", mOpportunity.name)
                        OpertinutyList.add(mOpportunity)
                    }
                }
                val adapter = OpportunityAdapter(OpertinutyList)
                mOppertinutyRecycler.adapter = adapter

            }

            override fun onFailure(call: Call<TimelineResponse2>?, t: Throwable?) {
                Log.i("Test", "Response Error")
            }

        })
    }
        companion object {
            fun newInstance(): Home {
                return Home()
            }
        }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            mCallback = context as ActivityCallBack
        } catch (e: ClassCastException) {
            throw ClassCastException(context.toString() + " must implement IFragmentToActivity")
        }

    }

    override fun onDetach() {
        mCallback = null
        super.onDetach()
    }

    }


