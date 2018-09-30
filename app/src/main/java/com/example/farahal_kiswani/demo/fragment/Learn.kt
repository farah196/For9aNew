package com.example.farahal_kiswani.demo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.farahal_kiswani.demo.models.Blog.Blogs
import kotlinx.android.synthetic.main.learn_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class Learn : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.learn_fragment, container, false)

        return view
    }

    var adapter: BlogAdapter = BlogAdapter(ArrayList())
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        mBlogRecycler.layoutManager = LinearLayoutManager(view.context, LinearLayout.VERTICAL, false)


        mBlogRecycler.adapter = adapter

        getLearnList()
        println(adapter.infoList.size - 1)
        mBlogRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if ((recyclerView.getLayoutManager() as LinearLayoutManager).findLastCompletelyVisibleItemPosition() == adapter.itemCount - 1) {

                    getLearnList()

                }
            }


        })

    }

    private fun getLearnList() {
        val apiServices = ApiClient1.client.create(ApiService::class.java)

        val call = apiServices.getBlog("MNrAG2QLv41sWs2qd-spRKT594bfwROM", 10);


        call.enqueue(object : Callback<List<Blogs>> {

            override fun onResponse(call: Call<List<Blogs>>, response: Response<List<Blogs>>) {
                if (response.isSuccessful) {
                    if (response.body() != null && !response.body()!!.isEmpty()) {

                        adapter.updateDataset(response.body()!!)


                    } else {
                        adapter.updateDataset(ArrayList())


                    }

                }

            }

            override fun onFailure(call: Call<List<Blogs>>, t: Throwable) {
                Log.i("blogerror", "Blog Error")
            }


        })
    }


    companion object {
        fun newInstance(): Learn {
            return Learn()
        }
    }

}

