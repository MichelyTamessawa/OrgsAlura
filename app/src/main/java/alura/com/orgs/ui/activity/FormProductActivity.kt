package alura.com.orgs.ui.activity

import alura.com.orgs.R
import alura.com.orgs.dao.ProductDao
import alura.com.orgs.model.Product
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.math.BigDecimal

class FormProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_product)
        configureSaveButton()
    }

    private fun configureSaveButton() {
        val saveButton = findViewById<Button>(R.id.button_save)
        val dao = ProductDao()
        saveButton.setOnClickListener {
            val newProduct = createNewProduct()
            dao.insert(newProduct)

            finish()
        }
    }

    private fun createNewProduct(): Product {
        val fieldName = findViewById<EditText>(R.id.editText_name)
        val fieldDesc = findViewById<EditText>(R.id.editText_description)
        val fieldValue = findViewById<EditText>(R.id.editText_value)

        val name = fieldName.text.toString()
        val desc = fieldDesc.text.toString()
        val valueText = fieldValue.text.toString()

        val value = if (valueText.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valueText)
        }

        return Product(name = name, description = desc, value = value)
    }
}