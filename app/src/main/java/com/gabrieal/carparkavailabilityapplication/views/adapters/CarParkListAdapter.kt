package com.gabrieal.carparkavailabilityapplication.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gabrieal.carparkavailabilityapplication.R
import com.gabrieal.carparkavailabilityapplication.models.dataModels.CarParkCategoryModel

class CarParkListAdapter(private val mList: ArrayList<CarParkCategoryModel>) :
    RecyclerView.Adapter<CarParkListAdapter.ViewHolder>() {

    var highest: String? = null
    var lowest: String? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_carpark_list_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsViewModel = mList[position]
        holder.tvCategory.text = itemsViewModel.category

        itemsViewModel.categoryItems?.forEach {
            if (it.totalLots == itemsViewModel.categoryItems?.first()?.totalLots) {
                if (lowest.isNullOrEmpty()) lowest = it.carParkNumber
                else lowest += ", " + it.carParkNumber
            }
            if (it.totalLots == itemsViewModel.categoryItems?.last()?.totalLots) {
                if (highest.isNullOrEmpty()) highest = it.carParkNumber
                else highest += ", " + it.carParkNumber
            }
        }

        holder.tvHighestTitle.text =
            "HIGHEST (" + itemsViewModel.categoryItems?.last()?.lotsAvailable.toString() + " lots available)"
        holder.tvHighestDesc.text = highest
        holder.tvLowestTitle.text =
            "LOWEST (" + itemsViewModel.categoryItems?.first()?.lotsAvailable.toString() + " lots available)"
        holder.tvLowestDesc.text = lowest
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tvCategory: TextView = itemView.findViewById(R.id.tvCategory)
        val tvHighestTitle: TextView = itemView.findViewById(R.id.tvHighestTitle)
        val tvHighestDesc: TextView = itemView.findViewById(R.id.tvHighestDesc)
        val tvLowestTitle: TextView = itemView.findViewById(R.id.tvLowestTitle)
        val tvLowestDesc: TextView = itemView.findViewById(R.id.tvLowestDesc)
    }
}