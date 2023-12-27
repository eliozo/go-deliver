package com.example.test1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private var itemList: List<String>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val itemName = itemList[position]
        holder.bindItem(itemName)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setItems(items: List<String>) {
        itemList = items
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemNameTextView: TextView = itemView.findViewById(R.id.itemNameTextView)
        private val itemCheckbox: CheckBox = itemView.findViewById(R.id.itemCheckbox)
        private val quantityEditText: EditText = itemView.findViewById(R.id.quantityEditText)

        fun bindItem(itemName: String) {
            itemNameTextView.text = itemName
        }
    }
}

