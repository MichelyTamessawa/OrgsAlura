package alura.com.orgs.ui.recyclerview.adapter

import alura.com.orgs.R
import alura.com.orgs.model.Product
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductsListAdapter(
    private val context: Context,
    private val products: List<Product>
) : RecyclerView.Adapter<ProductsListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(product: Product) {
            val name = itemView.findViewById<TextView>(R.id.name)
            val description = itemView.findViewById<TextView>(R.id.description)
            val value = itemView.findViewById<TextView>(R.id.value)
            name.text = product.name
            description.text = product.description
            value.text = product.value.toPlainString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int {
        return products.size
    }

}
