package com.example.constraint_layout_followup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.constraint_layout_followup.databinding.ActivityEightBinding

class EightActivity : AppCompatActivity() {

    private val binding : ActivityEightBinding by lazy {
        ActivityEightBinding.inflate(layoutInflater)
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

        Toast.makeText(this, intent.getStringExtra("messageTo8th"), Toast.LENGTH_LONG).show()

        binding.sendButton.setOnClickListener{
            startActivity(Intent(this, NinethView::class.java).apply {
                this.putExtra("lastMessage", binding.message.text.toString())
            })
        }


        Intent(this, NinethView::class.java)


    }
}