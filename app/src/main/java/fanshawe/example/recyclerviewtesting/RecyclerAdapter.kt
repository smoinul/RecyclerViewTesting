package fanshawe.example.recyclerviewtesting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val dataSet: List<Person>):RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTV: TextView
        val emailTV: TextView
        val agePB: ProgressBar

        init {
            // Define click listener for the ViewHolder's View.
            nameTV = view.findViewById(R.id.nameTV)
            emailTV = view.findViewById(R.id.emailTV)
            agePB = view.findViewById(R.id.agePB)
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.recycler_item, viewGroup, false)

        // add the 3 lines of code below to show 5 recycler items in the activity at a time
        val lp = view.getLayoutParams()
        lp.height = viewGroup.measuredHeight/5
        view.setLayoutParams(lp)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.nameTV.text = dataSet[position].name.toString()
        viewHolder.emailTV.text = dataSet[position].email.toString()
        viewHolder.agePB.progress = dataSet[position].age
    }

    override fun getItemCount() = dataSet.size
}