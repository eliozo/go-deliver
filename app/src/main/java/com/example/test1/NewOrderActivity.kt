package com.example.test1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NewOrderActivity : AppCompatActivity() {
    private lateinit var shopSpinner: Spinner
    private lateinit var itemRecyclerView: RecyclerView
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_order)

        shopSpinner = findViewById(R.id.shopSpinner)
        itemRecyclerView = findViewById(R.id.itemRecyclerView)

        // Populate spinner with shop names
        ArrayAdapter.createFromResource(
            this,
            R.array.shop_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            shopSpinner.adapter = adapter
        }

        val completeOrderButton: Button = findViewById(R.id.completeOrderButton)
        completeOrderButton.setOnClickListener {
            val intent = Intent(this, MyOrdersActivity::class.java)
            startActivity(intent)
        }

        // Set up an empty RecyclerView initially
        itemAdapter = ItemAdapter(emptyList())
        itemRecyclerView.layoutManager = LinearLayoutManager(this)
        itemRecyclerView.adapter = itemAdapter

        // Add a listener to the shopSpinner
        shopSpinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedShop = parent.getItemAtPosition(position).toString()

                // Load the item list based on the selected shop
                val itemList = getItemListForShop(selectedShop)
                itemAdapter.setItems(itemList)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        })

        // Add any additional code or functionality here
    }

    private fun getItemListForShop(shop: String): List<String> {
        // TODO: Implement your logic to fetch the item list for the selected shop
        // Return the actual item list based on the selected shop
        // For now, returning a dummy list of items
        return when (shop) {
            "Shop 1" -> listOf("Item A", "Item B", "Item C")
            "Shop 2" -> listOf("Item X", "Item Y", "Item Z")
            "Shop 3" -> listOf("Item P", "Item Q", "Item R")
            else -> emptyList()
        }
    }
}
