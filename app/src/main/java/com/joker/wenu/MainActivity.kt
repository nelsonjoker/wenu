package com.joker.wenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

const val ACTIVITY_RESULT_SCAN_QR = 1


class MainActivity : AppCompatActivity() {

    private lateinit var buttonScan : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonScan = findViewById(R.id.buttonScan)

        // Register a listener for the 'Scan QR' button.
        buttonScan.setOnClickListener{ scanQR() }



    }


    fun scanQR(){
        val intent = Intent(this, ScanQR::class.java)
        startActivityForResult(intent, ACTIVITY_RESULT_SCAN_QR);
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == ACTIVITY_RESULT_SCAN_QR){
            if (resultCode == RESULT_OK) {
                val code = data?.getStringExtra("code");
                Log.d(MainActivity::class.simpleName, "Got QR code : $code");
            }
        }

    }

}