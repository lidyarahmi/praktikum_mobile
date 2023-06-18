package com.example.lidyarahmi_uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


            val gambarKomikView : ImageView = findViewById(R.id.gambar1)
            val namaKomikView : TextView = findViewById(R.id.judul1)
            val authorKomikView: TextView = findViewById(R.id.author1)
            val desKomikView: TextView= findViewById(R.id.des1)
            val publisherView: TextView= findViewById(R.id.textView4)

            val judul1 = intent.getStringExtra("name")
            val gambar1 = intent.getIntExtra("image", 0)
            val publish1 = intent.getStringExtra("publish")
            val des1 = intent.getStringExtra("deskripsi")
            val author1 = intent.getStringExtra("author")

            namaKomikView.text = judul1
            authorKomikView.text = author1
            publisherView.text = publish1
            desKomikView.text = des1
            gambarKomikView.setImageResource(gambar1)


    }
}