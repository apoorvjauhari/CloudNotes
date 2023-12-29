package com.example.cloudnotes

import android.content.ContentValues.TAG
import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import me.example.cloudnotes.entities.Note

class ViewNote : AppCompatActivity() {
    val back:FloatingActionButton = findViewById(R.id.back)
    val edit:FloatingActionButton = findViewById(R.id.edit)
    val delete:FloatingActionButton = findViewById(R.id.delete)
    val save:FloatingActionButton = findViewById(R.id.save)
    val titleedit:EditText = findViewById(R.id.titleedit)
    val bodyedit:EditText = findViewById(R.id.bodyedit)
    val titletext:TextView = findViewById(R.id.titletextview)
    val bodytext:TextView = findViewById(R.id.bodytextview)
    val id=intent.getStringExtra("id").toString()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_note)

        var ref = FirebaseDatabase.getInstance().getReference("Notes").child(id)
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI
                val note = dataSnapshot.getValue<Note>()
                titleedit.setText(note!!.getTitle().toString())
                bodyedit.setText(note!!.getBody().toString())
                titletext.setText(note!!.getTitle().toString())
                bodytext.setText(note!!.getBody().toString())

                // ...
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }

        ref.addValueEventListener(postListener)
        back.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        })
        edit.setOnClickListener(View.OnClickListener {
                titleedit.visibility = View.VISIBLE
            bodyedit.visibility = View.VISIBLE
            titletext.visibility = View.GONE
            bodytext.visibility = View.GONE
            save.visibility = View.VISIBLE
            edit.visibility = View.GONE
        })
        delete.setOnClickListener(View.OnClickListener {
            //Delete the Particular ID child and startIntent to MAinActivity.
            ref.removeValue()
            startActivity(Intent(this, MainActivity::class.java))

        })
        save.setOnClickListener(View.OnClickListener {
            //Save will update the particular child. and startIntent to MAinActivity.
            ref.child("title").setValue(titleedit.text.toString())
            ref.child("body").setValue(bodyedit.text.toString())
            startActivity(Intent(this, MainActivity::class.java))
        })
    }

}