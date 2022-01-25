package com.ukejee.lushandroidtaskapplication.feature.launch

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.ukejee.lushandroidtaskapplication.databinding.FragmentLaunchListBinding
import com.ukejee.lushandroidtaskapplication.di.viewModel.ViewModelFactory
import com.ukejee.lushandroidtaskapplication.feature.launch.adapter.LaunchListRvAdapter
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class LaunchListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var _binding: FragmentLaunchListBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: LaunchListViewModel

    private lateinit var adapter: LaunchListRvAdapter

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLaunchListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupUi()
        observeData()
    }

    private fun setupViewModel() {
        viewModel =
            ViewModelProvider(requireActivity(), viewModelFactory)[LaunchListViewModel::class.java]
    }

    private fun setupUi() {
        adapter = LaunchListRvAdapter()
        viewModel.getErrorMessage().observe(viewLifecycleOwner) {
            binding.errorMessage.text = it
        }
        viewModel.getIsRefreshing().observe(viewLifecycleOwner) {
            binding.swipeLayout.isRefreshing = it
        }
        viewModel.getErrorMessageVisibility().observe(viewLifecycleOwner) {
            binding.errorMessage.visibility = it
        }
        binding.swipeLayout.setOnRefreshListener { viewModel.fetchLaunchList() }
    }

    private fun observeData() {
        viewModel.getLaunchList().observe(viewLifecycleOwner) {
            adapter.replaceList(it)
            binding.launchListRv.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}