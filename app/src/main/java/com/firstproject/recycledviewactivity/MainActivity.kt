package com.firstproject.recycledviewactivity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.firstproject.recycledviewactivity.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var userAdapter: UserAdapter

    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        // Set up View Binding

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // Initialize Room database

        database = AppDatabase.getInstance(this)

        // Set up RecyclerView

        userAdapter = UserAdapter(emptyList())

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.recyclerView.adapter = userAdapter


        // Perform database operations asynchronously

        // Load existing users from database
        lifecycleScope.launch {
            loadUsers()
        }

// Set click listener for FAB to open AddUserActivity
        binding.fabAddUser.setOnClickListener {
            val intent = Intent(this, AddUserActivity::class.java)
            addUserResultLauncher.launch(intent)
        }
    }
// Handle result from AddUserActivity
        private val addUserResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {

                val name = result.data?.getStringExtra("name") ?: return@registerForActivityResult
                val email = result.data?.getStringExtra("email") ?: return@registerForActivityResult
                val age = result.data?.getIntExtra("age", 0) ?: 0

                // Insert new user and refresh list
                lifecycleScope.launch {
                    val newUser = User(profileImage = R.mipmap.placeholder, name = name, email = email, age = age)
                    database.userDao().insertUser(newUser)
                    loadUsers() // Refresh RecyclerView
                }
            }
        }

        // Load users from database and update RecyclerView
        private suspend fun loadUsers() {
            val users = database.userDao().getAllUsers()
            userAdapter.updateData(users)
        }

}