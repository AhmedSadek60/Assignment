package ahmed.sadek.assignment.ui.home.researcher

import ahmed.sadek.assignment.R
import ahmed.sadek.assignment.databinding.FragmentSearchBinding
import ahmed.sadek.assignment.ui.search.SearchViewModel
import android.R.layout
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_search.*

class ResearcherFragment  : Fragment() {

    private lateinit var searchViewModel: SearchViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)
        val binding: FragmentSearchBinding =  DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


       /* val adapter: List<String?> = List<String?>(layout.select_dialog_item, allNames)

        autoTextView.setThreshold(1) //will start working from first character

        autoTextView.setAdapter(adapter)*/
    }
}