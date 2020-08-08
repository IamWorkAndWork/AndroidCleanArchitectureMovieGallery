package practice.app.myapplication.presentation.view.home

import android.os.Handler
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import practice.app.myapplication.R
import practice.app.myapplication.databinding.MovieListItemBinding
import practice.app.myapplication.presentation.models.MovieUIModel
import java.lang.Exception

class HomeMovieAdapter : ListAdapter<MovieUIModel, RecyclerView.ViewHolder>(diffItem) {

    private var layoutInflater: LayoutInflater? = null

    private var onMovieClickListener: OnMovieClickListener? = null

    interface OnMovieClickListener {
        fun setOnMovieClickListener(movieId: Int)
    }

    companion object {
        val diffItem = object : DiffUtil.ItemCallback<MovieUIModel>() {
            override fun areItemsTheSame(oldItem: MovieUIModel, newItem: MovieUIModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieUIModel, newItem: MovieUIModel): Boolean {
                return oldItem == newItem
            }

        }
    }

    fun setListener(onMovieClickListener: OnMovieClickListener?) {
        this.onMovieClickListener = onMovieClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.context)
        }

        val binding: MovieListItemBinding =
            DataBindingUtil.inflate(layoutInflater!!, R.layout.movie_list_item, parent, false)

        return ViewHolder(
            binding, onMovieClickListener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = (holder as ViewHolder)
        viewHolder.bindItem(getItem(position))
    }

    class ViewHolder(
        private val binding: MovieListItemBinding,
        private val onMovieClickListener: OnMovieClickListener?
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindItem(movie: MovieUIModel?) {
            binding.movieTitle.text = movie?.title
            binding.itemView.setOnClickListener {
                movie?.id?.let { it1 -> onMovieClickListener?.setOnMovieClickListener(it1) }
            }
            Handler().postDelayed(
                Runnable {
                    Picasso.get().load("https://image.tmdb.org/t/p/w200/${movie?.posterPath}")
                        .into(binding.movieImage, object : Callback {
                            override fun onSuccess() {
                                binding.imageProgress.hide()
                            }

                            override fun onError(e: Exception?) {
                                binding.imageProgress.hide()
                            }
                        })
                }, 1000
            )
        }
    }
}