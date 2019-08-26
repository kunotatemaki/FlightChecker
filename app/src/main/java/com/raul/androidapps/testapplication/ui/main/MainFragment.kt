package com.raul.androidapps.testapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.raul.androidapps.testapplication.R
import com.raul.androidapps.testapplication.databinding.MainFragmentBinding
import com.raul.androidapps.testapplication.extensions.nonNull
import com.raul.androidapps.testapplication.network.ServerResult
import com.raul.androidapps.testapplication.ui.common.BaseFragment

class MainFragment : BaseFragment() {

    private lateinit var binding: MainFragmentBinding

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: FlightsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.main_fragment,
            container,
            false,
            bindingComponent
        )
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        binding.retryButton.setOnClickListener {
            binding.retryButton.visibility = View.GONE
            viewModel.startFetchingFlightsAsync()
        }

        adapter = FlightsAdapter(resourcesManager = resourcesManager, bindingComponent = bindingComponent)
        binding.list.adapter = adapter

        viewModel.getLoading()
            .nonNull()
            .observe(this, Observer { loading ->
                binding.progressCircular.visibility = if (loading) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
            })

        viewModel.getResult()
            .nonNull()
            .observe(this, Observer { result ->
                when (result) {
                    is ServerResult.Success -> {
                        binding.retryButton.visibility = View.GONE
                        adapter.submitList(result.data.itineraries)
                    }
                    is ServerResult.Failure -> {
                        binding.retryButton.visibility = View.VISIBLE
                    }
                }
            })

        viewModel.startFetchingFlightsAsync()
    }

}
