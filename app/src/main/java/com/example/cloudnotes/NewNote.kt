package com.example.cloudnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import me.example.cloudnotes.entities.Note

class NewNote : AppCompatActivity() {
    val delete:FloatingActionButton = findViewById(R.id.delete)
    val save:FloatingActionButton = findViewById(R.id.save)
    val notetitle:TextInputEditText = findViewById(R.id.newnotetitle)
    val notebody:TextInputEditText = findViewById(R.id.newnotebody)
    lateinit var database:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)
        database = Firebase.database.reference
        val title:String = notetitle.editableText.toString()
        val body:String = notebody.editableText.toString()
        val id:String = database.push().key.toString()
        save.setOnClickListener{
                writeNewNote(id,title,body)
            val toast = Toast.makeText(applicationContext, "Successfully Added Notes", Toast.LENGTH_LONG)
            toast.show()
        }


    }
    private fun writeNewNote(id: String, title: String, body: String) {
        val note = Note(title, body,id)

        database.child("notes").child(id).setValue(note)
    }
}