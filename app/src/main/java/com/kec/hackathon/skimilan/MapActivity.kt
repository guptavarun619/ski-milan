package com.kec.hackathon.skimilan

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_attraction.*
import kotlinx.android.synthetic.main.activity_map.*

class MapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val databaseReference = FirebaseDatabase.getInstance().getReference("map")

        val alertDialog = ProgressDialog(this@MapActivity)
        alertDialog.setTitle("Loading Map")
        alertDialog.setMessage("Please wait while the map is loading")
        alertDialog.show()
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) { // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val mapUrl = dataSnapshot.child("map1").getValue().toString();
                Picasso.get().load(mapUrl).into(mapImageView)
                alertDialog.dismiss()
                Log.d("MapActivity", "Value is: $mapUrl")
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Log.w("MapActivity", "Failed to read value.", error.toException())
            }
        })

    }
}
