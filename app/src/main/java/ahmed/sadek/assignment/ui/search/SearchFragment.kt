package ahmed.sadek.assignment.ui.search

import ahmed.sadek.assignment.R
import ahmed.sadek.assignment.data.network.HitObj
import ahmed.sadek.assignment.data.network.SearchList
import ahmed.sadek.assignment.databinding.FragmentSearchBinding
import android.R.layout
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.widget.AppCompatAutoCompleteTextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_search.*
import java.util.*


class SearchFragment : Fragment() {

    private lateinit var searchViewModel: SearchViewModel

    val originalPosts = listOf<HitObj>() //SearchList.newlist
    val filteredPosts: MutableList<HitObj> = mutableListOf()
    val oldFilteredPosts: MutableList<HitObj> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)
        val binding: FragmentSearchBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* val adapter: List<String> = List<String>(extractList(SearchList.newlist).size,  R.layout.select_dialog_item,extractList(SearchList.newlist))
        autoTextView.threshold = 1 //will start working from first character

        autoTextView.setAdapter(adapter)

        val selected = ArrayList<String>()
        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        List_Of_Selected_Researches.setLayoutManager(llm)

        autoTextView.onItemClickListener =
            OnItemClickListener { adapterView, view, i, l ->
                val text = adapterView.getItemAtPosition(i).toString()
                if (!selected.contains(text)) {
                    for (eff in allEffectiveMatData) {
                        if (eff.getName().toString().equals(text) or eff.getCommercialNames().contains(
                                text
                            )
                        ) {
                            if (!selected.contains(eff.getName())) {
                                selected.add(eff.getName())
                                autoTextView.setText("")
                            }
                        }
                    }
                }
                val adapter =
                    MedicationAdapter(getApplicationContext(), selected)
                List_Of_Selected_Researches.setAdapter(adapter)
            }

    }

    internal fun setSpinner(medications: List<*>?): List<String> {
        val spinnerArrayAdapter: List<String> =
            List<String?>(medications.size, layout.simple_spinner_item, medications)
        spinnerArrayAdapter.setDropDownViewResource(layout.simple_spinner_dropdown_item) // The drop down view

        return spinnerArrayAdapter
    }

    fun extractList(list:List<HitObj>):List<String>{
        var stringList= listOf<String>()
        for (i in list){
            if(i._source!!.studyTitle.toString().contains("",true)){
                stringList.toMutableList().add(i._source!!.studyTitle.toString())
            }
        }

        return stringList
    }*/


        /* List_Of_Selected_Researches.layoutManager = LinearLayoutManager(context)
        List_Of_Selected_Researches.adapter = context?.let { SimpleRecyclerAdapter(it, oldFilteredPosts) }
        autoTextView
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
                        diffResult.dispatchUpdatesTo(List_Of_Selected_Researches!!.adapter!!)
                    }
            }*/
    }
}


   /* init {
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
