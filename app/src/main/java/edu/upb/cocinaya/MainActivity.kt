package edu.upb.cocinaya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    
    private var showMessage = false
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // TEST MERGE
        Log.d("MainActivity", "asdasdasd")
        
        if(showMessage) {
            Toast.makeText(this, "PRUEBA!!", Toast.LENGTH_SHORT).show()
        }

        val button = findViewById<ImageView>(R.id.buttonTest)
        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}