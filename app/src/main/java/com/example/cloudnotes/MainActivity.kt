package com.example.cloudnotes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

import me.argraur.notes.adapters.NotesAdapter
import me.example.cloudnotes.entities.Note

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val addnote:FloatingActionButton = findViewById(R.id.addnote)
        val scrollview:RecyclerView = findViewById(R.id.recycylerview)

        var recyclerView: RecyclerView = findViewById(R.id.recycylerview)
        lateinit var list:ArrayList<Note>
        lateinit var notesAdapter: NotesAdapter

        var ref = FirebaseDatabase.getInstance().getReference("notes")
        list =  ArrayList<Note>()

        recyclerView.layoutManager = LinearLayoutManager(this)

        

        val menuListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
               for(data in dataSnapshot.children){
                   list.clear()
                   val notedata = data.getValue(Note::class.java)
                   list.add(notedata!!)
                   notesAdapter = NotesAdapter(list,this@MainActivity)
                   recyclerView.adapter = notesAdapter
               }

            }
            override fun onCancelled(databaseError: DatabaseError) {
                // handle error
            }
        }
        ref.addListenerForSingleValueEvent(menuListener)



        addnote.setOnClickListener{
            startActivity(Intent(this, NewNote::class.java))

        }


    }
}


