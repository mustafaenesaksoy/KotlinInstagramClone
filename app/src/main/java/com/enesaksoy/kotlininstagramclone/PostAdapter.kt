package com.enesaksoy.kotlininstagramclone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.enesaksoy.kotlininstagramclone.databinding.RecyclerRowBinding
import com.squareup.picasso.Picasso

class PostAdapter (val postList : ArrayList<Post>): RecyclerView.Adapter<PostAdapter.postHolder>() {

    class postHolder(val binding : RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): postHolder {
       val recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return postHolder(recyclerRowBinding)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: postHolder, position: Int) {
        holder.binding.recycleremailtext.setText(postList.get(position).email)
        holder.binding.recyclercommenttext.setText(postList.get(position).comment)
        Picasso.get().load(postList.get(position).downloadurl).into(holder.binding.recyclerimageview)
    }
}