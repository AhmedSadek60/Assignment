package ahmed.sadek.assignment.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.json.JSONObject

data class Hits (

    @SerializedName("hits")
    val hits: List<HitObj>?

){}