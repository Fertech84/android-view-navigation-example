package com.example.constraint_layout_followup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.constraint_layout_followup.databinding.ActivitySecondViewBinding

class SecondView : AppCompatActivity() {

    private val binding : ActivitySecondViewBinding by lazy {
        ActivitySecondViewBinding.inflate(layoutInflater)
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

        val extraText = intent.getStringExtra("message")
        Toast.makeText(this, extraText, Toast.LENGTH_LONG).show()

        binding.sendButton.setOnClickListener{
            val intentToThirdView : Intent = Intent(this, ThirdActivity::class.java).apply {
                this.putExtra("secondMessage", binding.message.text.toString())
            }

            startActivity(intentToThirdView)
        }

    }
}