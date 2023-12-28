package com.example.cloudnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText

class NewNote : AppCompatActivity() {
    val delete:FloatingActionButton = findViewById(R.id.delete)
    val save:FloatingActionButton = findViewById(R.id.save)
    val notetitle:TextInputEditText = findViewById(R.id.newnotetitle)
    val notebody:TextInputEditText = findViewById(R.id.newnotebody)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)
    }
}