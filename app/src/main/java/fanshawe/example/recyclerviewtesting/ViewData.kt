package fanshawe.example.recyclerviewtesting

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fanshawe.example.recyclerviewtesting.databinding.ActivityMainBinding
import fanshawe.example.recyclerviewtesting.databinding.ActivityViewDataBinding

class ViewData : AppCompatActivity() {
    lateinit var viewDataBinding: ActivityViewDataBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = ActivityViewDataBinding.inflate(layoutInflater)
        setContentView(viewDataBinding.root)

        viewManager = LinearLayoutManager(this)
        viewAdapter = RecyclerAdapter(MainActivity.people)  // pass in data to be displayed
        recyclerView = findViewById<RecyclerView>(R.id.dataInRecyclerView).apply{
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter  }
    }
}