package com.raul.androidapps.testapplication.ui.main

import androidx.recyclerview.widget.RecyclerView
import com.raul.androidapps.testapplication.databinding.FlightItemBinding
import com.raul.androidapps.testapplication.domain.model.Flight
import com.raul.androidapps.testapplication.domain.model.Itinerary
import com.raul.androidapps.testapplication.resources.ResourcesManager


class FlightViewHolder(
    private val binding: FlightItemBinding,
    private val resourcesManager: ResourcesManager,
    private val copyView: Boolean = false
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: Itinerary,
        position: Int
    ) {
//        if (copyView) {
//            itemView.setBackgroundColor(resourcesManager.getColor(R.color.selected_item))
//        }
//        binding.currencyPriceEditable.removeTextChangedListener(basePriceListener?.textWatcher)
//        binding.code = item.code
//        if (item.isBasePrice) {
//            binding.price = basePriceListener?.getBasePrice()
//            binding.textColor = resourcesManager.getColor(R.color.colorPrimary)
//            binding.currencyPriceEditable.findFocus()
//        } else {
//            binding.textColor = resourcesManager.getColor(android.R.color.darker_gray)
//            binding.price = item.price
//        }
//        binding.isBasePrice = item.isBasePrice
//        binding.currencyPriceNonEditable.tag = item.code
//        binding.executePendingBindings()
//        if (item.isBasePrice) {
//            binding.currencyPriceEditable?.apply {
//                addTextChangedListener(basePriceListener?.textWatcher)
//                setSelection(this.text.length)
//            }
//            binding.root.apply {
//                setOnClickListener(null)
//                isClickable = false
//                isFocusable = false
//            }
//        } else {
//            binding.root.setOnClickListener {
//                val price = binding.currencyPriceNonEditable.text.toString()
//                basePriceListener?.onItemClicked(this.itemView, item.code, price, position)
//            }
//        }

    }
}