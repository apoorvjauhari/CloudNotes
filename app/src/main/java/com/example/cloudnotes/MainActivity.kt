package com.example.cloudnotes

import NotesAdapter
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener



import me.example.cloudnotes.entities.Note

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val progrss:ProgressBar = findViewById(R.id.progressb)
        val addnote: ImageButton = findViewById(R.id.addnote)
        val topAppBar:MaterialToolbar = findViewById(R.id.topAppBar)
        progrss.visibility = View.VISIBLE


        var recyclerView: RecyclerView = findViewById(R.id.recycylerview)
        lateinit var list:ArrayList<Note>
        lateinit var notesAdapter: NotesAdapter


        list =  ArrayList<Note>()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView .setHasFixedSize(true)


        var dbref = FirebaseDatabase.getInstance().getReference("Notes")

        dbref.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){

                    for (userSnapshot in snapshot.children){


                        val user = userSnapshot.getValue(Note::class.java)
                        list.add(user!!)

                    }

                    recyclerView.adapter = NotesAdapter(list)


                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })
        progrss.visibility=View.GONE




        addnote.setOnClickListener{
            startActivity(Intent(this, NewNote::class.java))

        }

        topAppBar.setOnMenuItemClickListener { menuItem ->

            when (menuItem.itemId) {
                R.id.select -> {
                    // Handle favorite icon press
                    true
                }

                R.id.search -> {
                    // Handle search icon press
                    true
                }

                R.id.view -> {
                    // Handle more item (inside overflow menu) press
                    true
                }
                R.id.more -> {
                    // Handle more item (inside overflow menu) press
                    true
                }
                R.id.sort -> {
                    // Handle more item (inside overflow menu) press
                    true
                }


                else -> false
            }
        }


    }
}


