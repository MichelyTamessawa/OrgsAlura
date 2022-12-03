package alura.com.orgs.ui.activity

import alura.com.orgs.R
import alura.com.orgs.dao.ProductDao
import alura.com.orgs.ui.recyclerview.adapter.ProductsListAdapter
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProductListActivity : AppCompatActivity() {
    private val dao = ProductDao()
    private val adapter = ProductsListAdapter(this, dao.getAll())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)
        configureRecyclerView()
        configureFab()
    }

    private fun configureFab() {
        val addButton = findViewById<FloatingActionButton>(R.id.addButton)
        addButton.setOnClickListener {
            val intent = Intent(this, FormProductActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.update(dao.getAll())
    }

    private fun configureRecyclerView() {
        val productsListRecyclerView = findViewById<RecyclerView>(R.id.product_list)
        productsListRecyclerView.adapter = adapter
    }
}