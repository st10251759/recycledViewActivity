package com.firstproject.recycledviewactivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.firstproject.recycledviewactivity.databinding.ActivityAddUserBinding

class AddUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set up View Binding
        binding = ActivityAddUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Handle Save Button Click
        binding.btnSaveUser.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val age = binding.etAge.text.toString().toIntOrNull() ?: 0

            // Return data to MainActivity
            val resultIntent = Intent().apply {
                putExtra("name", name)
                putExtra("email", email)
                putExtra("age", age)
            }

            setResult(Activity.RESULT_OK, resultIntent)
            finish() // Close the activity
        }
    }
}