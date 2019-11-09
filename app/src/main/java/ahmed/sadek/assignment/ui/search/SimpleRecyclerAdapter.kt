package ahmed.sadek.assignment.ui.search

import ahmed.sadek.assignment.R
import ahmed.sadek.assignment.data.network.HitObj
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.search_item.view.*

class SimpleRecyclerAdapter(private val context: Context, private val posts: List<HitObj>) : RecyclerView.Adapter<SimpleRecyclerAdapter.PostHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        return PostHolder(LayoutInflater.from(context).inflate(R.layout.search_item, parent, false))
    }

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.bind(posts[position])
    }

    class PostHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(post: HitObj) {
            itemView.projectName.text = post._source!!.studyTitle
            itemView.projectDesc.text = post._source!!.studyDescription
            //itemView.donation_project_image. = post._source!!.studyDescription

        }
    }
}