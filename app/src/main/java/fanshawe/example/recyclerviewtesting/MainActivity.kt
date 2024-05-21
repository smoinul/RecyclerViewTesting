package fanshawe.example.recyclerviewtesting

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import fanshawe.example.recyclerviewtesting.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding

    companion object MyData {
        var people:List<Person> = listOf<Person>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
    }

    fun onClickViewData(view: View) {
        val viewDataIntent: Intent = Intent(this, ViewData::class.java)
        startActivity(viewDataIntent)
    }

    fun onClickInsert(view: View) {
        val newPerson = Person(age = mainBinding.ageET.text.toString().toInt(), name = mainBinding.nameET.text.toString(), email = mainBinding.emailET.text.toString())

        // Add the new Person to the people list
        MyData.people += newPerson
    }
}