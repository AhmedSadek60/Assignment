package ahmed.sadek.assignment.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HitSource (

    @SerializedName("Authoritative Source URL")

    var sourceURL: String?,

    @SerializedName("Study Title")

    var studyTitle: String?,

    @SerializedName("Study Public Release Date")

    var studyPublicReleaseDate : String?,

    @SerializedName("thumbnail")

    var thumbnail : String?,

    @SerializedName("Study Description")

    var studyDescription : String?,

    @SerializedName("Study Person")

    var studyPerson : StudyPerson?

){}


