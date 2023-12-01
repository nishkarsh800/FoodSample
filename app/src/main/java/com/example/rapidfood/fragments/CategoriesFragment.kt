package com.example.rapidfood

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rapidfood.activities.MainActivity
import com.example.rapidfood.adapter.CategoriesAdapter
import com.example.rapidfood.adapter.FavoritesMealsAdapter
import com.example.rapidfood.databinding.FragmentCategoriesBinding
import com.example.rapidfood.databinding.MealItemBinding
import com.example.rapidfood.viewModel.HomeViewModel

class CategoriesFragment : Fragment() {
   private lateinit var binding: FragmentCategoriesBinding
   private lateinit var categoriesAdapter: CategoriesAdapter
   private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCategoriesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prepareRecyclerView()
        observeCategories()
    }

    private fun observeCategories() {
        viewModel.observeCategoriesLiveData().observe(viewLifecycleOwner, Observer {categories->
        categoriesAdapter.setCategoryList(categories)

        })
    }

    private fun prepareRecyclerView() {
      categoriesAdapter = CategoriesAdapter()
        binding.rvCategories.apply {
            layoutManager = GridLayoutManager(context,3,GridLayoutManager.VERTICAL,false)
            adapter = categoriesAdapter
        }
    }


}