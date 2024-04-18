package com.forthcode

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.forthcode.adapter.ForthCodeAdapter
import com.forthcode.data.ForthCodePhotosItem
import com.forthcode.di.ForthCodeListViewModelFactory
import com.forthcode.viewmodel.ForthCodeViewModel


class MainActivity : ComponentActivity() {

    private val forthCodeListViewModel: ForthCodeViewModel by viewModels { ForthCodeListViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPhotosListAPI()
    }

    private fun getPhotosListAPI(){
        forthCodeListViewModel.getListOfPhotos()
        forthCodeListViewModel.photosItem.observe(this, Observer { response ->
            generateDataList(response)
        })
    }

    private fun generateDataList(photoList: List<ForthCodePhotosItem>) {
        val recyclerView = findViewById<RecyclerView>(R.id.rvPhotos)
        val adapter = ForthCodeAdapter(this)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        adapter.submitList(photoList)
    }
}

