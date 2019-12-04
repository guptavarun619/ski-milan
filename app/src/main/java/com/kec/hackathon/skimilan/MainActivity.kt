package com.kec.hackathon.skimilan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mapButton.setOnClickListener {View->
            val mapActivityIntent : Intent =  Intent(this, MapActivity::class.java)
            startActivity(mapActivityIntent)
        }

        emergencyButton.setOnClickListener{View->
            val emergencyActivityIntent : Intent = Intent(this, EmergencyActivity::class.java)
            startActivity(emergencyActivityIntent)
        }

        attractionButton.setOnClickListener {View->
            val attractionActivityIntent : Intent = Intent(this, AttractionActivity::class.java)
            startActivity(attractionActivityIntent)
        }

        barcodeButton.setOnClickListener {View->
            val barcodeActivityIntent : Intent = Intent(this,  BarcodeActivity::class.java)
            startActivity(barcodeActivityIntent)
        }
    }
}
