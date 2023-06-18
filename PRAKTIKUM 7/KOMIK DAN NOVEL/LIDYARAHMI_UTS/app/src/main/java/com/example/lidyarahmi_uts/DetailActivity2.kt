package com.example.lidyarahmi_uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class DetailActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail2)


        val gambarNovelView : ImageView = findViewById(R.id.gambar2)
        val namaNovelView : TextView = findViewById(R.id.judul2)
        val authorNovelView: TextView = findViewById(R.id.author2)
        val desNovelView: TextView= findViewById(R.id.des2)
        val publisherView: TextView= findViewById(R.id.textView42)

        val judul2 = intent.getStringExtra("name2")
        val gambar2 = intent.getIntExtra("image2", 0)
        val publish2 = intent.getStringExtra("publish2")
        val des2 = intent.getStringExtra("deskripsi2")
        val author2 = intent.getStringExtra("author2")

        namaNovelView.text = judul2
        authorNovelView.text = author2
        publisherView.text = publish2
        desNovelView.text = des2
        gambarNovelView.setImageResource(gambar2)


    }
}