package com.glushkov.wealthparktest.ui.error

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.glushkov.wealthparktest.databinding.FragmentErrorBinding

class ErrorFragment : Fragment() {

    private lateinit var binding: FragmentErrorBinding

    private val args: ErrorFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentErrorBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (args.message.isNotEmpty())
            binding.errorText.text = args.message

        binding.btnRetry.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}