package practice.app.myapplication.presentation.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.android.viewmodel.ext.android.viewModel
import practice.app.myapplication.R
import practice.app.myapplication.presentation.utils.ViewState

class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        lifecycle.addObserver(viewModel)

        val homeMovieAdapter = HomeMovieAdapter()

        movie_recycler_view_list.adapter = homeMovieAdapter

        viewModel.topRatedMovies.observe(this, Observer {
            when (it.status) {
                ViewState.Status.LOADING -> {
                    Log.e("moviess", "loading")
                }
                ViewState.Status.ERROR -> {
                    Log.e("moviess", it.message!!)
                }
                ViewState.Status.SUCCESS -> {
                    Log.e("moviesss", "success : " + it.data!!.size.toString())
                    homeMovieAdapter.submitList(it.data)
                }
            }
        })

    }
}