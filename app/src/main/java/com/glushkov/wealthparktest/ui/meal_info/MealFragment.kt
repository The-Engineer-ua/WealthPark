package com.glushkov.wealthparktest.ui.meal_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.glushkov.wealthparktest.databinding.FragmentMealBinding
import com.glushkov.wealthparktest.ui.base.BaseFragment
import com.glushkov.wealthparktest.ui.dashboard.DashboardFragmentDirections
import com.glushkov.wealthparktest.ui.meal_info.view_model.MealViewModel

class MealFragment : BaseFragment() {

    private lateinit var binding: FragmentMealBinding
    private val vm: MealViewModel by viewModels()
    private val args: MealFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMealBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.validateModel(args.meal)
        showLoading(binding.loadingAnimation)

        vm.mealLiveData.observe(viewLifecycleOwner) {
            hideLoading(binding.loadingAnimation)
            binding.imgCover.load(it.image)
            binding.textTitle.text = it.name
        }

        subscribeToErrorLiveData(vm.errorLiveData, viewLifecycleOwner) {
            findNavController().navigate(DashboardFragmentDirections.actionToErrorFragment(it))
        }

    }
}