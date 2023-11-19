package com.example.projectuts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class AlbumActivity : AppCompatActivity() {

    private var quantityNCTalbum = 0
    private var quantityTWCalbum = 0
    private var quantitySVTalbum = 0
    private var quantityAespaalbum = 0
    private var quantityEnhaalbum = 0

    private lateinit var tvPriceAlbumNCT: TextView
    private lateinit var tvPriceAlbumTwc: TextView
    private lateinit var tvPriceAlbumSVT: TextView
    private lateinit var tvPriceAlbumAespa: TextView
    private lateinit var tvPriceAlbumEnha: TextView

    private lateinit var btnCheckout: Button
    private lateinit var tvJumlahBarangalbum: TextView
    private lateinit var tvTotalPricealbum: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)
        val toolbar: Toolbar = findViewById(R.id.toolbaralbum)
        setSupportActionBar(toolbar)

        // Set the click listener for the navigation icon
        toolbar.setNavigationOnClickListener {
            // Handle the click event
            val intent = Intent(this@AlbumActivity, MainActivity::class.java)
            startActivity(intent)
            finish() // Optional: finish the current activity
        }

        // Initialize your TextViews and ImageButtons
        tvPriceAlbumNCT = findViewById(R.id.tvPriceAlbumNCT)
        tvPriceAlbumTwc = findViewById(R.id.tvPriceAlbumTwc)
        tvPriceAlbumSVT = findViewById(R.id.tvPriceAlbumSVT)
        tvPriceAlbumAespa = findViewById(R.id.tvPriceAlbumAespa)
        tvPriceAlbumEnha = findViewById(R.id.tvPriceAlbumEnha)

        val imageMinusNCTalbum: ImageButton = findViewById(R.id.imageMinus1)
        val imageAddNCTalbum: ImageButton = findViewById(R.id.imageAdd1)

        val imageMinusTWCalbum: ImageButton = findViewById(R.id.imageMinus2)
        val imageAddTWCalbum: ImageButton = findViewById(R.id.imageAdd2)

        val imageMinusSVTalbum: ImageButton = findViewById(R.id.imageMinus3)
        val imageAddSVTalbum: ImageButton = findViewById(R.id.imageAdd3)

        val imageMinusAespaalbum: ImageButton = findViewById(R.id.imageMinus4)
        val imageAddAespaalbum: ImageButton = findViewById(R.id.imageAdd4)

        val imageMinusEnhaalbum: ImageButton = findViewById(R.id.imageMinus5)
        val imageAddEnhaalbum: ImageButton = findViewById(R.id.imageAdd5)

        // Set click listeners for image buttons
        imageMinusNCTalbum.setOnClickListener { decreaseQuantity(tvPriceAlbumNCT, quantityNCTalbum) }
        imageAddNCTalbum.setOnClickListener { increaseQuantity(tvPriceAlbumNCT, quantityNCTalbum) }

        imageMinusTWCalbum.setOnClickListener { decreaseQuantity(tvPriceAlbumTwc, quantityTWCalbum) }
        imageAddTWCalbum.setOnClickListener { increaseQuantity(tvPriceAlbumTwc, quantityTWCalbum) }

        imageMinusSVTalbum.setOnClickListener { decreaseQuantity(tvPriceAlbumSVT, quantitySVTalbum) }
        imageAddSVTalbum.setOnClickListener { increaseQuantity(tvPriceAlbumSVT, quantitySVTalbum) }

        imageMinusAespaalbum.setOnClickListener { decreaseQuantity(tvPriceAlbumAespa, quantityAespaalbum) }
        imageAddAespaalbum.setOnClickListener { increaseQuantity(tvPriceAlbumAespa, quantityAespaalbum) }

        imageMinusEnhaalbum.setOnClickListener { decreaseQuantity(tvPriceAlbumEnha, quantityEnhaalbum) }
        imageAddEnhaalbum.setOnClickListener { increaseQuantity(tvPriceAlbumEnha, quantityEnhaalbum) }

        // Initialize other views and set their listeners as needed
        btnCheckout = findViewById(R.id.btnCheckout)
        tvJumlahBarangalbum = findViewById(R.id.tvJumlahBarang)
        tvTotalPricealbum = findViewById(R.id.tvTotalPrice)
    }

    private fun decreaseQuantity(textView: TextView, quantity: Int) {
        if (quantity > 0) {
            val newQuantity = quantity - 1
            textView.text = newQuantity.toString()
            updateTotalQuantityAndPrice()
        }
    }

    private fun increaseQuantity(textView: TextView, quantity: Int) {
        val maxQuantity = 9 // Tentukan batas maksimum di sini
        if (quantity < maxQuantity) {
            val newQuantity = quantity + 1
            textView.text = newQuantity.toString()
            updateTotalQuantityAndPrice()
        }
    }

    private fun updateTotalQuantityAndPrice() {
        quantityNCTalbum = tvPriceAlbumNCT.text.toString().toInt()
        quantityTWCalbum = tvPriceAlbumTwc.text.toString().toInt()
        quantitySVTalbum = tvPriceAlbumSVT.text.toString().toInt()
        quantityAespaalbum = tvPriceAlbumAespa.text.toString().toInt()
        quantityEnhaalbum = tvPriceAlbumEnha.text.toString().toInt()

        val totalQuantity = quantityNCTalbum + quantityTWCalbum + quantitySVTalbum + quantityAespaalbum + quantityEnhaalbum
        tvJumlahBarangalbum.text = totalQuantity.toString()

        val totalPrice =
            (quantityNCTalbum * 300000) + (quantityTWCalbum * 200000) + (quantitySVTalbum * 400000) +
                    (quantityAespaalbum * 300000) + (quantityEnhaalbum * 300000)
        tvTotalPricealbum.text = "Total: Rp ${totalPrice}"
    }
}
