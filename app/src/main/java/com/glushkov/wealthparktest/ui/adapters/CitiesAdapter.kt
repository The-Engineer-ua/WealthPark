package com.glushkov.wealthparktest.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.glushkov.wealthparktest.data.CityDto
import com.glushkov.wealthparktest.databinding.ItemCityBinding

class CitiesAdapter : RecyclerView.Adapter<CitiesAdapter.ViewHolder>() {
    class ViewHolder internal constructor
        (val binding: ItemCityBinding, val context: Context)
        : RecyclerView.ViewHolder(binding.root)
    private var citySource: List<CityDto> = listOf()

    private var onClickAction : (CityDto) -> Unit = {}

    fun setDataSource(data: List<CityDto>, listener: (CityDto) -> Unit) {
        citySource = data
        notifyDataSetChanged()

        onClickAction = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCityBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            parent.context
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model: CityDto = citySource[position]
        val binding = holder.binding

        binding.imgCover.load(model.image)

        binding.textCity.text = model.name
        binding.textDescription.text = model.description
        binding.item.setOnClickListener {
            onClickAction(model)
        }
    }
    override fun getItemCount() = citySource.size
}