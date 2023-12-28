package com.example.cloudnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ViewNote : AppCompatActivity() {
    val back:FloatingActionButton = findViewById(R.id.back)
    val edit:FloatingActionButton = findViewById(R.id.edit)
    val delete:FloatingActionButton = findViewById(R.id.delete)
    val title:TextView = findViewById(R.id.title)
    val body:TextView = findViewById(R.id.body)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_note)
    }
}