package com.example.test1

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MyOrdersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_orders)

        // Get the table layouts from the layout file
        val ordersTable: TableLayout = findViewById(R.id.ordersTable)
        val statusTable: TableLayout = findViewById(R.id.statusTable)

        // Dummy data for orders and statuses (replace with your actual data)
        val orders = listOf(
            listOf("Item A, Item B, Item C"),
            listOf("Item X, Item Y, Item Z"),
            listOf("Item P, Item Q, Item R")
        )
        val statuses = listOf("New", "Processing", "Completed")

        // Format for date display
        val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale("lv"))

        // Populate the tables with orders and statuses
        for (i in orders.indices) {
            val orderRow = TableRow(this)
            val orderText = TextView(this)
            orderText.text = orders[i].joinToString(", ")
            orderText.setPadding(16, 16, 16, 16)
            orderText.textSize = 16f
            orderText.setTypeface(null, Typeface.BOLD)
            orderRow.addView(orderText)
            ordersTable.addView(orderRow)

            val dateRow = TableRow(this)
            val dateText = TextView(this)
            val currentDate = Date() // Replace with your actual date value
            dateText.text = dateFormat.format(currentDate)
            dateText.setPadding(16, 0, 16, 16)
            dateText.textSize = 14f
            dateRow.addView(dateText)
            ordersTable.addView(dateRow)

            val statusRow = TableRow(this)
            val statusText = TextView(this)
            statusText.text = statuses[i]
            statusText.setPadding(16, 16, 16, 16)
            statusText.textSize = 16f

            when (statuses[i]) {
                "New" -> statusText.setTextColor(Color.BLUE)
                "Processing" -> statusText.setTextColor(Color.RED)
                "Completed" -> statusText.setTextColor(Color.GREEN)
            }

            statusRow.addView(statusText)
            statusTable.addView(statusRow)
        }
    }
}
