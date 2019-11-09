package ahmed.sadek.assignment.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HitObj (

    @SerializedName("_source")
    val _source: HitSource?

){}