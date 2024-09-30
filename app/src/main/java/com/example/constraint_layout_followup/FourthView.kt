package com.example.constraint_layout_followup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.constraint_layout_followup.databinding.ActivityFourthViewBinding

class FourthView : AppCompatActivity() {

    private val binding : ActivityFourthViewBinding by lazy {
        ActivityFourthViewBinding.inflate(layoutInflater)
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

        Toast.makeText(this, intent.getStringExtra("thirdMessage"), Toast.LENGTH_LONG)
            .show()

        binding.sendButton.setOnClickListener{
            val intentTo5th : Intent = Intent(this, FifthView::class.java).apply {
                this.putExtra("4thMessage", binding.message.text.toString())
            }

            startActivity(intentTo5th)
        }

    }
}