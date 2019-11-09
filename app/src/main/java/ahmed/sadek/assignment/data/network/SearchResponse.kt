package ahmed.sadek.assignment.data.network

import com.google.gson.annotations.SerializedName

data class SearchResponse (

    @SerializedName("hits")
    var hit:Hits
){}