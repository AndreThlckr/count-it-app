package com.andrethlckr.countit.presentation.cashflow.cashflowlist

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import by.kirich1409.viewbindingdelegate.viewBinding
import com.andrethlckr.countit.R
import com.andrethlckr.countit.databinding.CashFlowListFragmentBinding
import com.andrethlckr.countit.presentation.common.adapters.cashflowadapter.CashFlowAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CashFlowListFragment : Fragment(R.layout.cash_flow_list_fragment) {
    private val binding: CashFlowListFragmentBinding by viewBinding()
    private val viewModel: CashFlowListViewModel by viewModels()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.apply {
            viewModel = this@CashFlowListFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }

        setupList()
        observeEvents()
    }

    private fun setupList() {
        val adapter = CashFlowAdapter()
        binding.list.adapter = adapter
        viewModel.cashflows.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun observeEvents() {
        viewModel.shouldShowSnackBar.observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }
}
