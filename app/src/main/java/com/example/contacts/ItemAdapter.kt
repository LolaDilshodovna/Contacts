package com.example.contacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(var list:MutableList<Contact>, var itemInterface: ItemInterface) : RecyclerView.Adapter<ItemAdapter.ItemHolder>() {

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var name: TextView = itemView.findViewById(R.id.textView3)
        var phone: TextView = itemView.findViewById(R.id.textView2)
        var layout: ConstraintLayout = itemView.findViewById(R.id.cont_lay)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        var holder = ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))
        return holder
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var item = list[position]
        holder.name.text = item.name
        holder.phone.text = item.phone
        holder.layout.setOnClickListener {
            itemInterface.onClick(item)
        }
    }

    interface ItemInterface{
        fun onClick(contact: Contact){

        }
    }

}