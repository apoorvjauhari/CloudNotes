package com.example.cloudnotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import me.example.cloudnotes.entities.Note

class NewNote : AppCompatActivity() {
    lateinit var database:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)
        val delete:FloatingActionButton = findViewById(R.id.delete)
        val save:FloatingActionButton = findViewById(R.id.save)
        val notetitle:EditText = findViewById(R.id.newnotetitle)
        val notebody:EditText = findViewById(R.id.newnotebody)


        database = Firebase.database.reference
        val title:String = notetitle.editableText.toString()
        val body:String = notebody.editableText.toString()
        val id:String = database.push().key.toString()
        delete.setOnClickListener(View.OnClickListener {
            val toast = Toast.makeText(applicationContext, "Note Discarded", Toast.LENGTH_SHORT)
            toast.show()
            startActivity(Intent(this, MainActivity::class.java))
        })
        save.setOnClickListener{
                writeNewNote(id,title,body)
            val toast = Toast.makeText(applicationContext, "Successfully Added Notes", Toast.LENGTH_LONG)
            toast.show()
            startActivity(Intent(this, MainActivity::class.java))
        }


    }
    private fun writeNewNote(id: String, title: String, body: String) {
        val note = Note(title, body,id)

        database.child("notes").child(id).setValue(note)
    }
}