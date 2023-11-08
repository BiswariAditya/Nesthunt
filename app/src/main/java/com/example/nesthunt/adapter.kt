package com.example.nesthunt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.recyclerview.widget.RecyclerView
import com.example.nesthunt.databinding.ItemBinding

class adapter(private var datalist: ArrayList<dataclass>, private var context: Context) :
    RecyclerView.Adapter<adapter.viewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val binding=ItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return viewHolder(binding)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        animation(holder.itemView)
        holder.binding.image.setImageResource(datalist[position].image)
        holder.binding.name.text= datalist[position].name
        holder.binding.address.text= datalist[position].address
    }

    inner class viewHolder(var binding:ItemBinding): RecyclerView.ViewHolder(binding.root)

    fun animation(view: View){
        val anim=AlphaAnimation(0.0f,1.0f)
        anim.duration=1500
        view.startAnimation(anim)
    }


}