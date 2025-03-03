package com.firstproject.recycledviewactivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val userList: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage: ImageView = itemView.findViewById(R.id.ivProfileImage)
        val nameTextView: TextView = itemView.findViewById(R.id.tvName)
        val emailTextView: TextView = itemView.findViewById(R.id.tvEmail)
        val ageTextView: TextView = itemView.findViewById(R.id.tvAge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_layout, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.profileImage.setImageResource(user.profileImage) // Load profile image
        holder.nameTextView.text = user.name
        holder.emailTextView.text = user.email
        holder.ageTextView.text = "Age: ${user.age}"
    }

    override fun getItemCount() = userList.size
}