package ahmed.sadek.assignment.ui.settings

import ahmed.sadek.assignment.MainActivity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentActivity

class Mode(var fragmentActivity:FragmentActivity) {

    fun setDark(){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        val intent = Intent(fragmentActivity, MainActivity::class.java)
        startActivity(fragmentActivity,intent,null)
        fragmentActivity.finish()
    }

    fun setLight(){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        val intent = Intent(fragmentActivity, MainActivity::class.java)
        startActivity(fragmentActivity,intent,null)
        fragmentActivity.finish()
    }
}