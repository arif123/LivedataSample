package com.ngsolutionsys.livedatasample.view
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.content.res.Configuration
import com.ngsolutionsys.livedatasample.model.Blog
import com.ngsolutionsys.livedatasample.R
import com.ngsolutionsys.livedatasample.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import android.arch.lifecycle.Observer


class MainActivity : AppCompatActivity() {

    var mainViewModel: MainViewModel? = null
    var mBlogAdapter: BlogAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        getPopularBlog()
        swiperefresh.setOnRefreshListener { getPopularBlog() }
    }

    fun getPopularBlog() {
        swiperefresh.setRefreshing(false)
        mainViewModel!!.allBlog.observe(this, Observer {  blogList ->
            prepareRecyclerView(blogList)
        })

    }

    private fun prepareRecyclerView(blogList: List<Blog>?) {

        mBlogAdapter = BlogAdapter(blogList)
        if (this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            blogRecyclerView.setLayoutManager(LinearLayoutManager(this))
        } else {
            blogRecyclerView.setLayoutManager(GridLayoutManager(this, 4))
        }
        blogRecyclerView.setItemAnimator(DefaultItemAnimator())
        blogRecyclerView.setAdapter(mBlogAdapter)

    }
}