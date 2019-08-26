package com.raul.androidapps.testapplication.ui.main

import androidx.recyclerview.widget.RecyclerView
import com.raul.androidapps.testapplication.R
import com.raul.androidapps.testapplication.databinding.FlightItemBinding
import com.raul.androidapps.testapplication.domain.model.Itinerary
import com.raul.androidapps.testapplication.resources.ResourcesManager


class FlightViewHolder(
    private val binding: FlightItemBinding,
    private val resourcesManager: ResourcesManager
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        itinerary: Itinerary
    ) {
        binding.itinerary = itinerary
        binding.stopsFirstLeg = getStops(itinerary.legs[0].stops)
        binding.stopsSecondLeg = getStops(itinerary.legs[1].stops)
        binding.executePendingBindings()

    }

    private fun getStops(stops: Int): String{
        return if(stops == 0){
            resourcesManager.getString(R.string.direct)
        }else{
            "$stops ${resourcesManager.getPlural(R.plurals.stops, stops)}"
        }
    }
}