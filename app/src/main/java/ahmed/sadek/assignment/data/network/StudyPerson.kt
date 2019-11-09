package ahmed.sadek.assignment.data.network


import com.google.gson.annotations.SerializedName

data class StudyPerson(
    @SerializedName("Last Name")

    var lastName: String?,

    @SerializedName("Middle Initials")

    var middleInitials: String?,

    @SerializedName("First Name")

    var firstName: String?

){}
