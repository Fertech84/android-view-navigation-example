package com.example.constraint_layout_followup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.constraint_layout_followup.databinding.ActivityFifthViewBinding

class FifthView : AppCompatActivity() {

    private val binding : ActivityFifthViewBinding by lazy {
        ActivityFifthViewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        Toast.makeText(this,intent.getStringExtra("4thMessage"), Toast.LENGTH_LONG)
            .show()

        binding.sendButton.setOnClickListener{
            val intentTo6th : Intent = Intent(this, SixthView::class.java).apply {
                this.putExtra("messageTo6th", binding.message.text.toString())
            }

            startActivity(intentTo6th)
        }



    }
}