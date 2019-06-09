package com.github.farzadfarazmand.cleanweather.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.farzadfarazmand.cleanweather.databinding.RowForecastListBinding
import com.github.farzadfarazmand.cleanweather.model.response.WeatherForecastResponse

class ForecastRecyclerViewAdapter(private var items: ArrayList<WeatherForecastResponse.ForecastDay>) :
    RecyclerView.Adapter<ForecastRecyclerViewAdapter.ForecastViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ForecastViewHolder(RowForecastListBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ForecastViewHolder(private val binding: RowForecastListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: WeatherForecastResponse.ForecastDay) {
            binding.weather = item
            binding.executePendingBindings()
        }
    }

    fun addItems(newItems: ArrayList<WeatherForecastResponse.ForecastDay>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

}