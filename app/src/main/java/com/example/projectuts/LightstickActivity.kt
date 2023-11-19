package com.example.projectuts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class LightstickActivity : AppCompatActivity() {

    private var quantityNCT = 0
    private var quantityNJ = 0
    private var quantityTeuls = 0
    private var quantityEnha = 0
    private var quantityAespals = 0

    private lateinit var tvPricenct: TextView
    private lateinit var tvPriceLs: TextView
    private lateinit var tvPriceteuls: TextView
    private lateinit var tvPriceenhals: TextView
    private lateinit var tvPriceaespals: TextView

    private lateinit var btnCheckout: Button
    private lateinit var tvJumlahBarang: TextView
    private lateinit var tvTotalPrice: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lightstick)
        val toolbar: Toolbar = findViewById(R.id.backbtntoolbar)
        setSupportActionBar(toolbar)

        // Set the click listener for the navigation icon
        toolbar.setNavigationOnClickListener {
            // Handle the click event
            val intent = Intent(this@LightstickActivity, MainActivity::class.java)
            startActivity(intent)
            finish() // Optional: finish the current activity
        }

        // Initialize your TextViews and ImageButtons
        tvPricenct = findViewById(R.id.tvPricenct)
        tvPriceLs = findViewById(R.id.tvPriceLs)
        tvPriceteuls = findViewById(R.id.tvPriceteuls)
        tvPriceenhals = findViewById(R.id.tvPriceenhals)
        tvPriceaespals = findViewById(R.id.tvaespals)

        val imageMinusNCT: ImageButton = findViewById(R.id.imageMinus6)
        val imageAddNCT: ImageButton = findViewById(R.id.imageAdd6)

        val imageMinusNJ: ImageButton = findViewById(R.id.imageMinus7)
        val imageAddNJ: ImageButton = findViewById(R.id.imageAdd7)

        val imageMinusTeuls: ImageButton = findViewById(R.id.imageMinus8)
        val imageAddTeuls: ImageButton = findViewById(R.id.imageAdd8)

        val imageMinusEnha: ImageButton = findViewById(R.id.imageMinus9)
        val imageAddEnha: ImageButton = findViewById(R.id.imageAdd9)

        val imageMinusAespals: ImageButton = findViewById(R.id.imageMinus10)
        val imageAddAespals: ImageButton = findViewById(R.id.imageAdd10)

        // Set click listeners for image buttons
        imageMinusNCT.setOnClickListener { decreaseQuantity(tvPricenct, quantityNCT) }
        imageAddNCT.setOnClickListener { increaseQuantity(tvPricenct, quantityNCT) }

        imageMinusNJ.setOnClickListener { decreaseQuantity(tvPriceLs, quantityNJ) }
        imageAddNJ.setOnClickListener { increaseQuantity(tvPriceLs, quantityNJ) }

        imageMinusTeuls.setOnClickListener { decreaseQuantity(tvPriceteuls, quantityTeuls) }
        imageAddTeuls.setOnClickListener { increaseQuantity(tvPriceteuls, quantityTeuls) }

        imageMinusEnha.setOnClickListener { decreaseQuantity(tvPriceenhals, quantityEnha) }
        imageAddEnha.setOnClickListener { increaseQuantity(tvPriceenhals, quantityEnha) }

        imageMinusAespals.setOnClickListener { decreaseQuantity(tvPriceaespals, quantityAespals) }
        imageAddAespals.setOnClickListener { increaseQuantity(tvPriceaespals, quantityAespals) }

        // Initialize other views and set their listeners as needed
        btnCheckout = findViewById(R.id.btnCheckout2)
        tvJumlahBarang = findViewById(R.id.tvJumlahBarang2)
        tvTotalPrice = findViewById(R.id.tvTotalPrice2)
    }

    private fun decreaseQuantity(textView: TextView, quantity: Int) {
        if (quantity > 0) {
            val newQuantity = quantity - 1
            textView.text = newQuantity.toString()
            updateTotalQuantityAndPrice()
        }
    }

    private fun increaseQuantity(textView: TextView, quantity: Int) {
        val maxQuantity = 5 // Tentukan batas maksimum di sini
        if (quantity < maxQuantity) {
            val newQuantity = quantity + 1
            textView.text = newQuantity.toString()
            updateTotalQuantityAndPrice()
        }
    }

    private fun updateTotalQuantityAndPrice() {
        quantityNCT = tvPricenct.text.toString().toInt()
        quantityNJ = tvPriceLs.text.toString().toInt()
        quantityTeuls = tvPriceteuls.text.toString().toInt()
        quantityEnha = tvPriceenhals.text.toString().toInt()
        quantityAespals = tvPriceaespals.text.toString().toInt()

        val totalQuantity = quantityNCT + quantityNJ + quantityTeuls + quantityEnha + quantityAespals
        tvJumlahBarang.text = totalQuantity.toString()

        val totalPrice =
            (quantityNCT * 800000) + (quantityNJ * 800000) + (quantityTeuls * 800000) +
                    (quantityEnha * 800000) + (quantityAespals * 800000)
        tvTotalPrice.text = "Total: Rp ${totalPrice}"
    }
}
