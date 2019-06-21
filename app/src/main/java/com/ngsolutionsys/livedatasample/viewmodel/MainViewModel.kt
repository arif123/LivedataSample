package com.ngsolutionsys.livedatasample.viewmodel

/**
 * Created by Arif Hossen<arif123@gmail.com> on 6/21/2019.
 */
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.ngsolutionsys.livedatasample.model.Blog


class MainViewModel() : ViewModel() {

    val movieRepository= BlogRepository()
    val allBlog: LiveData<List<Blog>> get() = movieRepository.getMutableLiveData()

    override fun onCleared() {
        super.onCleared()
        movieRepository.completableJob.cancel()
    }
}