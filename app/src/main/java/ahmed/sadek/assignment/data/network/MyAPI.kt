package ahmed.sadek.assignment.data.network

import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyAPI {

    @GET("search?term=*&type=cgene")
    fun getSearhes() : Response<WikiSearchResponses>

   /* companion object{
        operator fun invoke() : MyAPI{

            return Retrofit.Builder()
                .baseUrl("https://genelab-data.ndc.nasa.gov/genelab/data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyAPI::class.java)
        }
    }*/

}