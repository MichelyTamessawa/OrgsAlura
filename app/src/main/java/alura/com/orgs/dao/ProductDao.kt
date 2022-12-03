package alura.com.orgs.dao

import alura.com.orgs.model.Product

class ProductDao {

    fun insert (product: Product) {
        Companion.products.add(product)
    }

    fun getAll () : List<Product> {
        return Companion.products.toList()
    }

    companion object {
        private val products = mutableListOf<Product>()
    }
}