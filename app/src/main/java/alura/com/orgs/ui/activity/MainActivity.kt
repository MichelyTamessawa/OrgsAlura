package alura.com.orgs.ui.activity

import alura.com.orgs.R
import alura.com.orgs.model.Product
import alura.com.orgs.ui.recyclerview.adapter.ProductsListAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val productsListRecyclerView = findViewById<RecyclerView>(R.id.product_list)
        productsListRecyclerView.adapter = ProductsListAdapter(this, listOf(
            Product("teste 1", "descricao 1", BigDecimal("10.99")),
            Product("teste 2", "descricao 2", BigDecimal("20.99")),
            Product("teste 3", "descricao 3", BigDecimal("30.99")),
        ))
    }
}