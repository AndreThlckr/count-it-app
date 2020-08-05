package com.andrethlckr.countit.presentation.cashflow.cashflowlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.andrethlckr.countit.R
import com.andrethlckr.countit.databinding.CashFlowListFragmentBinding
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
    }
}
