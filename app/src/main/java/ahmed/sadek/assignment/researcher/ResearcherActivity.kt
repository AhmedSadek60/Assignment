package ahmed.sadek.assignment.researcher

import ahmed.sadek.assignment.databinding.ActivityResearcherBinding
import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

import kotlinx.android.synthetic.main.activity_researcher.*


class ResearcherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(ahmed.sadek.assignment.R.layout.activity_researcher)

        val binding: ActivityResearcherBinding = DataBindingUtil.setContentView(this, ahmed.sadek.assignment.R.layout.activity_researcher)

        var bundle :Bundle ?=intent.extras
        first_name_data.text = bundle!!.getString("firstName") // 1
       // var strUser: String = intent.getStringExtra("value") // 2
        middle_name_data.text = bundle!!.getString("middleName")
        last_name_data.text = bundle!!.getString("lastName")


    }


}