package com.example.farahal_kiswani.demo.util


import android.support.design.widget.CoordinatorLayout.Behavior.setTag
import android.support.v4.view.ViewPager
import android.util.SparseArray
import android.view.View

public class ViewFindUtils {


    fun <Any : View> hold(view: View, id: Int): View? {

        var viewHolder: SparseArray<View>? = view.getTag() as SparseArray<View>?



        if (viewHolder == null) {

            viewHolder = SparseArray<View>()

            view.setTag(viewHolder)

        }


        var childView: View? = viewHolder.get(id)



        if (childView == null) {

            childView = view.findViewById(id)

            viewHolder.put(id, childView)

        }



        return childView

    }




    fun <Any : View> find(view: View, id: Int): ViewPager? {

        return view.findViewById(id)

    }

}