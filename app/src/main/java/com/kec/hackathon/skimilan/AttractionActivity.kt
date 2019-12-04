package com.kec.hackathon.skimilan

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_attraction.*


class AttractionActivity : AppCompatActivity() {

    val TAG = "AttractionActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attraction)

        val databaseReference:DatabaseReference = FirebaseDatabase.getInstance().getReference("attraction")

        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) { // This method is called once with the initial value and again
            // whenever data at this location is updated.
                val nameAttractionOne = dataSnapshot.child("attraction1").child("name").getValue().toString()
                val descriptionAttractionOne = dataSnapshot.child("attraction1").child("description").getValue().toString()

                AttractionTextView.text = nameAttractionOne
                descriptionTextView.text = descriptionAttractionOne

                Log.d(TAG, "Value is: $nameAttractionOne $descriptionAttractionOne")
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
    }
}
