package com.example.paw_store

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecycleAdapter(var list:List<Datalist>):RecyclerView.Adapter<RecycleAdapter.Mainholder>() {
    private lateinit var mListsener:onItemclickListener
    interface onItemclickListener{
        fun onItemclick(position: Int)
    }
    fun onItemclickListener(listener:onItemclickListener){
        mListsener=listener
    }


    inner class Mainholder(val itemView: View,listener:onItemclickListener):RecyclerView.ViewHolder(itemView){

            val tname = itemView.findViewById<TextView>(R.id.text5)
            val tpass = itemView.findViewById<TextView>(R.id.text6)
        init{
            itemView.setOnClickListener{
                listener.onItemclick(adapterPosition)
            }
        }


    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Mainholder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycle,parent,false)
        return Mainholder(itemView,mListsener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Mainholder, position: Int) {
        var current = list[position]
        holder.tname.text = current.nam
        holder.tpass.text = current.pass


    }

}