package ahmed.sadek.assignment.ui.home

import ahmed.sadek.assignment.GlideApp
import ahmed.sadek.assignment.MainActivity
import ahmed.sadek.assignment.R
import ahmed.sadek.assignment.data.network.HitObj
import ahmed.sadek.assignment.researcher.ResearcherActivity
import ahmed.sadek.assignment.ui.home.researcher.ResearcherFragment
import android.R.attr.fragment
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*


class SearchesAdapter(internal var context: Context, searches: List<HitObj>) :
    RecyclerView.Adapter<SearchesAdapter.ViewHolder?>() {

    var searches: List<HitObj>
    val baseURL:String = "https://genelab-data.ndc.nasa.gov"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchesAdapter.ViewHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.search_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchesAdapter.ViewHolder, position: Int) {

        var hitObj:HitObj= searches[position]
        holder.projectName.setText(hitObj._source!!.studyTitle)
        holder.projectDesc.setText(hitObj._source!!.studyDescription)
        holder.date.text= getDateTime(hitObj._source!!.studyPublicReleaseDate!!).toString()

        GlideApp.with(context)
            .load(baseURL+hitObj._source!!.thumbnail)
            .into(holder.donation_project_image)

        holder.constraintLayout.setOnClickListener {
            /*val manager: FragmentManager = (context as AppCompatActivity).supportFragmentManager
            val transaction: FragmentTransaction = manager.beginTransaction()
            transaction.add(R.id.container, ResearcherFragment())
            transaction.commit()*/

            val intent = Intent(context, ResearcherActivity::class.java)
            // To pass any data to next activity
            intent.putExtra("firstName", hitObj!!._source!!.studyPerson!!.firstName)
            intent.putExtra("middleName", hitObj!!._source!!.studyPerson!!.middleInitials)
            intent.putExtra("lastName", hitObj!!._source!!.studyPerson!!.lastName)
            // start your next activity
            startActivity(context,intent,null)

        }
    }

    override fun getItemCount(): Int {
        return searches.size
    }


     class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var donation_project_image: ImageView
        var projectName: TextView
         var projectDesc:TextView
        var date: TextView
        var constraintLayout: ConstraintLayout

        init {
            donation_project_image = itemView.findViewById(R.id.donation_project_image)
            projectName = itemView.findViewById(R.id.projectName)
            projectDesc = itemView.findViewById(R.id.projectDesc)
            date = itemView.findViewById(R.id.date)
            constraintLayout = itemView.findViewById(R.id.ResearchCard)
        }
    }

    init {
        this.searches = searches
    }

    private fun getDateTime(s: String): String? {
        try {
            val sdf = SimpleDateFormat("MM/dd/yyyy")
            val netDate = Date(s.toLong())
            return sdf.format(netDate)
        } catch (e: Exception) {
            return e.toString()
        }
    }

}