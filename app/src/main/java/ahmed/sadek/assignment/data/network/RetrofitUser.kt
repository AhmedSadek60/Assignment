package ahmed.sadek.assignment.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUser {

    private var retrofit:Retrofit?=null
    private var BASE_URL = "http://genelab-data.ndc.nasa.gov/genelab/data/"

    val retrofitInstance: Retrofit?
    get() {
        if(retrofit == null){
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyAPI::class.java)
        }
        return retrofit
    }


    /*operator fun invoke() : MyAPI{

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyAPI::class.java)
    }*/

}