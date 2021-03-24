package com.glushkov.wealthparktest.ui.city_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.glushkov.wealthparktest.databinding.FragmentCityBinding
import com.glushkov.wealthparktest.ui.base.BaseFragment
import com.glushkov.wealthparktest.ui.city_info.view_model.CityViewModel
import com.glushkov.wealthparktest.ui.dashboard.DashboardFragmentDirections

class CityFragment : BaseFragment() {

    private lateinit var binding: FragmentCityBinding
    private val vm : CityViewModel by viewModels()
    private val args: CityFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCityBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.validateModel(args.city)
        showLoading(binding.loadingAnimation)

        vm.cityLiveData.observe(viewLifecycleOwner) {
            hideLoading(binding.loadingAnimation)
            binding.imgCover.load(it.image)
            binding.textTitle.text = it.name
            binding.textDescription.text = it.description
        }

        subscribeToErrorLiveData(vm.errorLiveData, viewLifecycleOwner) {
            findNavController().navigate(DashboardFragmentDirections.actionToErrorFragment(it))
        }

    }
}