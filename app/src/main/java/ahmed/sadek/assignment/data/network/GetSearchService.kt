package ahmed.sadek.assignment.data.network

import retrofit2.Call
import retrofit2.http.GET

interface GetSearchService {

    @GET("search")
    fun getAllSearches(): Call<SearchResponse>

}
