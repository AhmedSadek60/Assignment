package ahmed.sadek.assignment.ui.home

import ahmed.sadek.assignment.MainActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ahmed.sadek.assignment.R
import ahmed.sadek.assignment.data.network.GetSearchService
import ahmed.sadek.assignment.data.network.SearchList
import ahmed.sadek.assignment.data.network.SearchResponse
import ahmed.sadek.assignment.databinding.FragmentHomeBinding
import android.content.Context
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val binding:FragmentHomeBinding =  DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        return binding.root

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       // linearLayoutManager = LinearLayoutManager(requireContext())
        //recyclerView.layoutManager = linearLayoutManager

        var retrofit = Retrofit.Builder()
            .baseUrl("http://genelab-data.ndc.nasa.gov/genelab/data/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // var service = retrofit.create<GetSearchService>(GetSearchService::class.java!!)
        var service = retrofit.create<GetSearchService>(GetSearchService::class.java)

        //val service = RetrofitUser.retrofitInstance?.create(GetSearchService::class.java)
        //val service= MyAPI.invoke()
        val call = service.getAllSearches()


        call.enqueue(object : Callback<SearchResponse> {

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                Toast.makeText(context,getText(R.string.request_failed),Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {
                val body =response.body()
                val hits = body?.hit?.hits!!
                SearchList.newlist=hits

                recyclerView.apply {
                    // set a LinearLayoutManager to handle Android
                    // RecyclerView behavior
                    layoutManager = LinearLayoutManager(activity)
                    // set the custom adapter to the RecyclerView
                    adapter = SearchesAdapter(context,body?.hit?.hits!!)
                    (adapter as SearchesAdapter).notifyDataSetChanged();
                    recyclerView.adapter=adapter
                }

            }

        })



    }
}