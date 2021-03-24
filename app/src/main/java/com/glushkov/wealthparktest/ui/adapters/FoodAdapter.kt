package com.glushkov.wealthparktest.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.glushkov.wealthparktest.data.MealDto
import com.glushkov.wealthparktest.databinding.ItemMealBinding

class FoodAdapter : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {
    class ViewHolder internal constructor
        (val binding: ItemMealBinding, val context: Context)
        : RecyclerView.ViewHolder(binding.root)
    private var foodSource: List<MealDto> = listOf()

    private var onClickAction : (MealDto) -> Unit = {}

    fun setDataSource(data: List<MealDto>, listener: (MealDto) -> Unit) {
        foodSource = data
        notifyDataSetChanged()

        onClickAction = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMealBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            parent.context
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model: MealDto = foodSource[position]
        val binding = holder.binding

        binding.imgCover.load(model.image)

        binding.textCity.text = model.name
        binding.item.setOnClickListener {
            onClickAction(model)
        }
    }
    override fun getItemCount() = foodSource.size
}