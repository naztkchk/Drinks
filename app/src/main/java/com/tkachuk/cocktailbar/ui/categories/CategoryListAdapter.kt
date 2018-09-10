package com.tkachuk.cocktailbar.ui.categories

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.tkachuk.cocktailbar.R
import com.tkachuk.cocktailbar.databinding.ItemCategoryBinding
import com.tkachuk.cocktailbar.model.Category
import com.tkachuk.cocktailbar.ui.categories.drinks.FilteredDrinksFragment
import com.tkachuk.cocktailbar.ui.main.IMainActivity
import android.os.Bundle

class CategoryListAdapter(private val iMainActivity: IMainActivity) : RecyclerView.Adapter<CategoryListAdapter.ViewHolder>() {

    private var categoryList: List<Category> = listOf()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        iMainActivity.setTitleSupportActionBar("")
        val binding: ItemCategoryBinding = DataBindingUtil.inflate(LayoutInflater.from(p0.context),
                R.layout.item_category, p0, false)
        return ViewHolder(binding)
    }

    fun setList(list: List<Category>) {
        categoryList = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(categoryList[p1])
        p0.itemView.setOnClickListener {
            val filteredDrinksFragment = FilteredDrinksFragment()
            val bundle = Bundle()
            bundle.putString("category", categoryList[p1].strCategory)
            filteredDrinksFragment.arguments = bundle
            iMainActivity.replaceFragment(filteredDrinksFragment, true)
            iMainActivity.setTitleSupportActionBar(categoryList[p1].strCategory)
        }
    }

    class ViewHolder(private val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = CategoryViewModel()

        fun bind(category: Category) {
            viewModel.bind(category)
            binding.categoryViewModel = viewModel
        }
    }
}