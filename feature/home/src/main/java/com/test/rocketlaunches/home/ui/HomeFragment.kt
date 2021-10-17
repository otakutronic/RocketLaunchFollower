package com.test.rocketlaunches.home.ui

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.rocketlaunches.home.di.loadHomeModules
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.test.rocketlaunches.home.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModel()
    private fun injectFeatures() = loadHomeModules

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.let {
            injectFeatures()
            val adapter = HomeAdapter()
            it.launchListRecycler.adapter = adapter
            it.viewmodel = viewModel
            it.lifecycleOwner = this
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
