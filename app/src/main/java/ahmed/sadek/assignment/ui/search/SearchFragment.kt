package ahmed.sadek.assignment.ui.search

import ahmed.sadek.assignment.R
import ahmed.sadek.assignment.data.network.HitObj
import ahmed.sadek.assignment.data.network.SearchList
import ahmed.sadek.assignment.databinding.FragmentSearchBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.jakewharton.rxbinding2.widget.textChanges
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_search.*
import java.util.concurrent.TimeUnit
import java.util.regex.Matcher
import java.util.regex.Pattern


class SearchFragment : Fragment() {

    private lateinit var searchViewModel: SearchViewModel

    val originalPosts= listOf<HitObj>() //SearchList.newlist
    val filteredPosts: MutableList<HitObj> = mutableListOf()
    val oldFilteredPosts: MutableList<HitObj> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)
        val binding:FragmentSearchBinding =  DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)


        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       /* recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = context?.let { SimpleRecyclerAdapter(it, oldFilteredPosts) }*/
       /* autoTextView
            .textChanges()
            .debounce(500, TimeUnit.MILLISECONDS)
            .subscribe {
                search(it.toString())
                    .subscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        val diffResult = DiffUtil.calculateDiff(PostsDiffUtilCallback(oldFilteredPosts, filteredPosts))
                        oldFilteredPosts.clear()
                        oldFilteredPosts.addAll(filteredPosts)
                        diffResult.dispatchUpdatesTo(recyclerView!!.adapter!!)
                    }
            }*/
    }

  /*  init {
        oldFilteredPosts.addAll(originalPosts)
    }

    fun search(query: String): Completable = Completable.create {
        val wanted = originalPosts.filter {
            it._source!!.studyTitle!!.contains(query) && checkRepeat(it._source!!.studyTitle!!)
        }.toList()

        filteredPosts.clear()
        filteredPosts.addAll(wanted)
        it.onComplete()
    }

    fun checkRepeat(string: String):Boolean{
        val p: Pattern = Pattern.compile("(.)\\1{2,}", Pattern.DOTALL)
        var m = p.matcher(string);

        if (m.find()){
            Toast.makeText(context,"Not valid input",Toast.LENGTH_LONG).show()
            return true
        }
        return false
    }*/
}