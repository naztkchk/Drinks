package com.tkachuk.cocktailbar.ui.drinks

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.tkachuk.cocktailbar.R
import com.tkachuk.cocktailbar.databinding.ItemDrinkBinding
import com.tkachuk.cocktailbar.model.Drink

class DrinkListAdapter : RecyclerView.Adapter<DrinkListAdapter.ViewHolder>() {

    private var drinkList: List<Drink> = listOf()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val binding: ItemDrinkBinding = DataBindingUtil.inflate(LayoutInflater.from(p0.context),
                R.layout.item_drink, p0, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return drinkList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(drinkList[p1])
        p0.itemView.setOnClickListener {
            //TODO show cocktails description by choosed coctail"
            //Toast.makeText(p0.itemView.context,drinkList[p1].strDrink, Toast.LENGTH_SHORT).show()
        }
    }

    fun addToList(result: MutableList<Drink>) {
        drinkList += result.toList()
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemDrinkBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = DrinkViewModel()

        fun bind(drink: Drink) {
            viewModel.bind(drink)
            binding.drinkViewModel = viewModel
        }
    }
}
