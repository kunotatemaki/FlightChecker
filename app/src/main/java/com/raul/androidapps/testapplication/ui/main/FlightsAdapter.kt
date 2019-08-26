package com.raul.androidapps.testapplication.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.raul.androidapps.testapplication.R
import com.raul.androidapps.testapplication.databinding.BindingComponent
import com.raul.androidapps.testapplication.databinding.FlightItemBinding
import com.raul.androidapps.testapplication.domain.model.Itinerary
import com.raul.androidapps.testapplication.resources.ResourcesManager


class FlightsAdapter(
    private val resourcesManager: ResourcesManager,
    private val bindingComponent: BindingComponent
) :
    RecyclerView.Adapter<FlightViewHolder>() {

    private var flights: List<Itinerary> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<FlightItemBinding>(
                inflater,
                R.layout.flight_item,
                parent,
                false,
                bindingComponent
            )
        return FlightViewHolder(binding, resourcesManager)
    }

    override fun getItemCount(): Int = flights.size


    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        holder.bind(flights[position], position)
    }

    fun submitList(list: List<Itinerary>?) {
        list?.let {
            flights = list
            notifyDataSetChanged()
        }
    }

}