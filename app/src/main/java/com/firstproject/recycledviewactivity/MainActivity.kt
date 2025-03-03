package com.firstproject.recycledviewactivity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        // Sample Data
        val userList = listOf(
            User(R.mipmap.placeholder, "Alice Johnson", "alice@gmail.com", 25),
            User(R.mipmap.placeholder, "Bob Smith", "bob@gmail.com", 30),
            User(R.mipmap.placeholder, "Charlie Brown", "charlie@gmail.com", 22)
        )

        // Set up RecyclerView
        userAdapter = UserAdapter(userList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = userAdapter
    }
}