package com.example.presentation.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.SearchModel
import com.example.presentation.model.DetailModel
import com.example.presentation.R
import com.example.presentation.adapter.BookAdapter
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentSearchBinding
import com.example.presentation.util.ItemClickListener
import com.example.presentation.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment() : BaseFragment<FragmentSearchBinding>() {
    private val viewModel: SearchViewModel by viewModels()

    private val bookList = arrayListOf<SearchModel.BookModel>()
    private val bookAdapter by lazy {
        BookAdapter(bookList, object : ItemClickListener<DetailModel> {
            override fun itemClick(position: Int, data: DetailModel) {
                super.itemClick(position, data)

                startActivity(Intent(requireContext(), DetailActivity::class.java).apply { putExtra("data", data) })
            }
        })
    }

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?) = FragmentSearchBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listener()
        initAdapter()
        lifeCycleScope()
    }

    private fun lifeCycleScope() = lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            launch {
                viewModel.search.collect {
                    it?.let {
                        binding.run {
                            if (it.total > 0) {
                                if (viewModel.initQuery) {
                                    totalText.text = getString(R.string.search_count, it.total)

                                    totalText.visibility = View.VISIBLE
                                    binding.emptyText.visibility = View.GONE
                                    binding.bookRecycler.visibility = View.VISIBLE

                                    bookList.clear()
                                    bookList.addAll(it.bookList)
                                    bookAdapter.notifyDataSetChanged()

                                    viewModel.totalCount = it.total
                                    viewModel.initQuery = false
                                } else {
                                    bookList.addAll(it.bookList)
                                    bookAdapter.notifyItemRangeInserted(bookList.lastIndex - 9, bookList.lastIndex)
                                }
                            } else {
                                bookList.clear()

                                totalText.visibility = View.GONE
                                binding.emptyText.visibility = View.VISIBLE
                                binding.bookRecycler.visibility = View.GONE
                            }
                        }
                    }
                }
            }
        }
    }

    private fun listener() = with(binding) {
        searchButton.setOnClickListener {
            viewModel.initQuery = true
            viewModel.start = 1
            viewModel.query = searchEdit.text.toString()

            viewModel.getSearch(viewModel.query, viewModel.start, viewModel.display)
        }

        searchEdit.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                v.clearFocus()

                viewModel.initQuery = true
                viewModel.start = 1
                viewModel.query = searchEdit.text.toString()

                viewModel.getSearch(viewModel.query, viewModel.start, viewModel.display)

                return@setOnEditorActionListener false
            }

            return@setOnEditorActionListener true
        }

        bookRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val lastPosition = (bookRecycler.layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition()
                val itemTotalCount = (bookRecycler.adapter?.itemCount ?: 0) - 1

                if (lastPosition == itemTotalCount && (viewModel.totalCount > itemTotalCount + 1)) {
                    ++viewModel.start
                    viewModel.getSearch(viewModel.query, viewModel.start, viewModel.display)
                }
            }
        })
    }

    private fun initAdapter() = with(binding) {
        bookRecycler.apply {
            itemAnimator = null
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = bookAdapter
        }
    }
}