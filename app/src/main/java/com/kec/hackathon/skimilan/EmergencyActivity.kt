package com.kec.hackathon.skimilan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_attraction.*
import kotlinx.android.synthetic.main.activity_emergency.*

class EmergencyActivity : AppCompatActivity() {

    val TAG = "Emergency Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency)

        val databaseReference:DatabaseReference = FirebaseDatabase.getInstance().getReference("emergency")

        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) { // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val medNum1 = dataSnapshot.child("Medical").child("number1").getValue().toString()
                val medNum2 = dataSnapshot.child("Medical").child("number2").getValue().toString()

                medNumber1.text = medNum1
                medNumber2.text = medNum2

                val lostNum1 = dataSnapshot.child("lostAndFound").child("number1").getValue().toString()
                val lostNum2 = dataSnapshot.child("lostAndFound").child("number2").getValue().toString()

                lostNumber1.text = lostNum1
                lostNumber2.text = lostNum2

                Log.d(TAG, "Value is: $lostNum1 $lostNum2 $medNum1 $medNum2")
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })

    }
}
