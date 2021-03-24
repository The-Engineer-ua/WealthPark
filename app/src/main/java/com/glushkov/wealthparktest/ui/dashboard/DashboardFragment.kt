package com.glushkov.wealthparktest.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.glushkov.wealthparktest.MainApplication
import com.glushkov.wealthparktest.databinding.FragmentMainBinding
import com.glushkov.wealthparktest.ui.adapters.CitiesAdapter
import com.glushkov.wealthparktest.ui.adapters.FoodAdapter
import com.glushkov.wealthparktest.ui.base.BaseFragment
import com.glushkov.wealthparktest.ui.dashboard.view_model.DashboardViewModel
import javax.inject.Inject

class DashboardFragment : BaseFragment() {

    private lateinit var binding: FragmentMainBinding
    private val vm: DashboardViewModel by viewModels()

    @Inject
    lateinit var citiesAdapter : CitiesAdapter
    @Inject
    lateinit var foodAdapter: FoodAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)

        (requireActivity().application as MainApplication).appComponent.inject(this)
        initRecyclers()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()
    }

    private fun initData() {
        vm.citiesLiveData.observe(viewLifecycleOwner, {
            hideLoading(binding.loadingAnimation)
            citiesAdapter.setDataSource(it) { city ->
                findNavController().navigate(
                    DashboardFragmentDirections.actionDashboardFragmentToCityFragment(
                        city
                    )
                )
            }
        })
        vm.foodLiveData.observe(viewLifecycleOwner, {
            hideLoading(binding.loadingAnimation)
            foodAdapter.setDataSource(it) { meal ->
                findNavController().navigate(
                    DashboardFragmentDirections.actionDashboardFragmentToMealFragment(
                        meal
                    )
                )
            }
        })
        subscribeToErrorLiveData(vm.errorLiveData, viewLifecycleOwner, {
            hideLoading(binding.loadingAnimation)
            if (it.isNotEmpty()) {
                findNavController().navigate(DashboardFragmentDirections.actionToErrorFragment(it))
            }
        })

        vm.loadServerData()
        showLoading(binding.loadingAnimation)
    }

    private fun initRecyclers() {
        binding.rcCities.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = citiesAdapter
        }
        binding.rcFood.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = foodAdapter
        }
    }
}