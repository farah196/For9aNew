package com.example.farahal_kiswani.demo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.SearchView
import com.example.farahal_kiswani.demo.adapter.OpportunityAdapter
import com.example.farahal_kiswani.demo.models.Opportunity
import com.example.farahal_kiswani.demo.models.TimelineResponse2

import com.example.farahal_kiswani.demo.util.ApiClient
import kotlinx.android.synthetic.main.search_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Search : Fragment() {
    val oppertinuitySearchList = ArrayList<Opportunity>()
    var sinceIdString = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.search_fragment, container, false)


        return view
    }
    var opportunityAdapter: OpportunityAdapter = OpportunityAdapter(ArrayList())
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //adding a layoutmanager
        mSearchRecycler.layoutManager = LinearLayoutManager(view.context, LinearLayout.VERTICAL, false)

        opportunityAdapter = OpportunityAdapter(oppertinuitySearchList)
        mSearchRecycler.adapter = opportunityAdapter
        no_result.setVisibility(View.GONE)
        search_bar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                sinceIdString = ""
                Request(query)
                //Task HERE
                return false
            }

        })






    }
    companion object {
        fun newInstance(): Search {
            return Search()
        }
    }


//private fun Load_More ()

    private fun Request(term :String) {
        val apiServices = ApiClient.client.create(ApiService::class.java)

        val call = apiServices.getSearch(10, sinceIdString ,term);

        call.enqueue(object : Callback<TimelineResponse2> {
            override fun onResponse(call: Call<TimelineResponse2>, response: Response<TimelineResponse2>) {
                if (response.isSuccessful){

                    if (!response.body()?.results!!.isEmpty()){
                        opportunityAdapter.updateDataset(response.body()?.results!!)
                        sinceIdString = opportunityAdapter.infoList.get(opportunityAdapter.infoList.size - 1).id.toString()
                        no_result.setVisibility(View.GONE)
                    } else{
                        //Hanndle empty dataaset
                        opportunityAdapter.updateDataset(ArrayList())
                        no_result.setVisibility(View.VISIBLE)


                    }

                }



            }

            override fun onFailure(call: Call<TimelineResponse2>?, t: Throwable?) {
                Log.i("search", "Response Error")
            }

        })


    }
}
