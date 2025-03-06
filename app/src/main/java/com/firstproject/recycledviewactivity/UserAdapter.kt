package com.firstproject.recycledviewactivity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firstproject.recycledviewactivity.databinding.RecyclerItemLayoutBinding

class UserAdapter(private var userList: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(val binding: RecyclerItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = RecyclerItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.binding.ivProfileImage.setImageResource(user.profileImage)
        holder.binding.tvName.text = user.name
        holder.binding.tvEmail.text = user.email
        holder.binding.tvAge.text = "Age: ${user.age}"
    }

    override fun getItemCount() = userList.size

    // Update data in the adapter
    fun updateData(newList: List<User>) {
        userList = newList
        notifyDataSetChanged()
    }
}