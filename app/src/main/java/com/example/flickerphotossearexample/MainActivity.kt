package com.example.flickerphotossearexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flickerphotossearexample.adapter.ImageListAdapter
import com.example.flickerphotossearexample.common.DataFetchState
import com.example.flickerphotossearexample.common.StateMachine
import com.example.flickerphotossearexample.core.BaseViewModelFactory
import com.example.flickerphotossearexample.core.PaginationScrollListener
import com.example.flickerphotossearexample.view.ImagesListViewHolder

class MainActivity : AppCompatActivity(), ImagesListViewHolder.ImageItemClickListener {


    private val factory = object : BaseViewModelFactory() {
        override fun createViewModel() = SearchImagesViewModel()
    }
    private val viewModel by viewModels<SearchImagesViewModel> { factory }
    private val adapter by lazy { ImageListAdapter(this) }
    private val stateMachine = StateMachine()
    private val page = 0;
    private var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        val recyclerView = findViewById<View>(R.id.image_recycler_view) as RecyclerView
        val searchEt = findViewById<View>(R.id.search_et) as EditText
        val searchBtn = findViewById<View>(R.id.search_btn) as Button

        recyclerView.layoutManager = LinearLayoutManager(this )

        searchBtn.setOnClickListener {
            viewModel.getImages(stateMachine, searchEt.text.toString())
        }

        stateMachine.observe(this, Observer {
            when(it) {
                is DataFetchState.Loading -> {
                    Log.e("loading", "loading")
                }

                is DataFetchState.Success -> {
                    Log.e("Success", "Success")
                    adapter.updateData(viewModel.items)
                    recyclerView.adapter = adapter

                }

                is DataFetchState.Error -> {
                    Log.e("Error", "Error")
                    Toast.makeText(this@MainActivity, it.error.displayError, Toast.LENGTH_SHORT).show()
                }
            }
        })

        recyclerView.addOnScrollListener(object : PaginationScrollListener(LinearLayoutManager(this)) {
//            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
//                viewModel.getImages(stateMachine, searchEt.text.toString(), page)
//            }

            override fun loadMoreItems() {
                isLoading = true
                viewModel.getImages(stateMachine, searchEt.text.toString(), page+1)
            }

            override fun getTotalPageCount(): Int {
                return viewModel.items.size
            }

            override fun isLastPage(): Boolean {
                return false
            }

            override fun isLoading(): Boolean {
                return isLoading
            }
        })

    }

    override fun onImageClickListener(imageUrl: String) {
        val intent = Intent(this@MainActivity, ImageDetailActivity::class.java)
        intent.putExtra("image", imageUrl)
        startActivity(intent)
    }
}