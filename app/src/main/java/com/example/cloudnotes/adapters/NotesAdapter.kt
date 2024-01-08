



import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

import androidx.recyclerview.widget.RecyclerView
import com.example.cloudnotes.R
import com.example.cloudnotes.ViewNote
import me.example.cloudnotes.entities.Note



 class NotesAdapter(private val userList : ArrayList<Note>) : RecyclerView.Adapter<NotesAdapter.MyViewHolder>() {
      lateinit var context:Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.note_card,
            parent,false)
            context = parent.context
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = userList[position]

        holder.title.text = currentitem.getTitle()
        holder.body.text = currentitem.getBody()
        holder.holdr.setOnClickListener(View.OnClickListener {

            val intent = Intent(context, ViewNote::class.java)
            intent.putExtra("id", currentitem.getId())
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

            context.startActivity(intent)
        })




    }

    override fun getItemCount(): Int {

        return userList.size
    }


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val title : TextView = itemView.findViewById(R.id.title)
        val body : TextView = itemView.findViewById(R.id.body)
        val holdr: ConstraintLayout = itemView.findViewById(R.id.layout)




    }

}