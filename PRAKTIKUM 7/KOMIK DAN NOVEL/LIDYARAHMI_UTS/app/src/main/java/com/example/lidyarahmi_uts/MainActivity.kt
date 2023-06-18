package com.example.lidyarahmi_uts

import android.content.ClipData
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.View
import android.widget.RelativeLayout
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.Objects

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter : KomikAdapter
    private lateinit var novelAdapter: NovelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.pink)))

        // Mengubah warna latar belakang
        val rootView = findViewById<View>(android.R.id.content)
        rootView.setBackgroundColor(Color.RED)

        val relativeLayout: RelativeLayout = findViewById(R.id.relative_layout)
        val backgroundColor = ContextCompat.getColor(this, R.color.card_background_color)
        relativeLayout.setBackgroundColor(backgroundColor)
        recyclerView = findViewById(R.id.recyclerView)

        adapter = KomikAdapter(getItemList(), object : KomikAdapter.OnItemClickListener {
            override fun onItemClick(data: DataKomik) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
                    putExtra("name", data.judul)
                    putExtra("image", data.gambar)
                    putExtra("deskripsi", data.des)
                    putExtra("author", data.author)
                    putExtra("publish", data.publish)
                }
                startActivity(intent)
            }
        })
        // adapter untuk novel

        novelAdapter = NovelAdapter(getItemList2(), object : NovelAdapter.OnItemClickListener {
            override fun onItemClick(data: DataNovel) {
                val intent = Intent(this@MainActivity, DetailActivity2::class.java).apply {
                    putExtra("name2", data.judul2)
                    putExtra("image2", data.gambar2)
                    putExtra("deskripsi2", data.des2)
                    putExtra("author2", data.author2)
                    putExtra("publish2", data.publish2)
                }
                startActivity(intent)
            }
        })

        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { data ->
            when (data.itemId){
                R.id.KomikButton ->{
                    recyclerView.adapter = adapter
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.NovelButton->{
                    recyclerView.adapter = novelAdapter
                    return@setOnNavigationItemSelectedListener true
                }
                else -> return@setOnNavigationItemSelectedListener false
            }
        }
    }

    private fun getItemList(): List<DataKomik> {
        val content = mutableListOf<DataKomik>()
        content.add(
            DataKomik(
                "Abdul Solatif",
            "Bang Rahardian",
            "Komik ini merupakan komik berjudul Abdul Solatif, authornya adalah Bang Rahardian, serta dipublish pada tahun 2014. Bergenre Horror, Gore",
            "Publish : 2014",
                R.drawable.abdulsolatif,
            "Genre : Horor, Gore",
                R.drawable.abdulsolatif

            )
        )
        content.add(
            DataKomik(
                "Tahilalats",
                "Author: Nurfadli",
                "Tahilalats adalah komik strip bergenre komedi yang ditulis dan digambar oleh Nurfadhli Mursyid.",
                "Publish : 2014",
                R.drawable.tahilalat1,
                "Genre : Komedi",
                R.drawable.tahilalat
            )
        )
        content.add(
            DataKomik(
                "Ayam Goreng",
                "Author: PJD",
                "Minah, sang wanita cantik, tiba-tiba berubah menjadi sepotong ayam goreng?! Kisah absurd tentang seorang ayah dan pegawai magang yang berusaha mengembalikan",
                "Publish : 2019",
                R.drawable.ayamgorengkomik,
                "Genre : Drama",
                R.drawable.ayamgoreng
            )
        )
        content.add(
            DataKomik(
                "Dalang Pelo",
                "Author: Nur Alif Ramadhan",
                "Dalang Pelo (sebelumnya Animasi Gombrong, Animastrip Gombrong, atau Gombrong adalah sebuah serial animasi dan buku komik yang dibuat oleh Nur Alif Ramadhan.",
                "Publish : 2016",
                R.drawable.dalangpelokomik,
                "Genre : Horor, Gore",
                R.drawable.dalangpelo
            )
        )
        content.add(
            DataKomik(
                "Ghosty's comic",
                "Author: GHOSTYCORP",
                "Asam manis perkhilafan dan cerita lainnya, Bergabunglah bersama Jaret, Emon, Sultan, dan teman-teman lainnya dalam menghadapi suka dan duka dunia perhobian!",
                "Publish : 2016",
                R.drawable.ghostykomik,
                "Genre : Horor, Gore",
                R.drawable.ghost
            )
        )
        content.add(
            DataKomik(
                "Ghostpath",
                "Author: Joo dong Guen",
                "Cerita-cerita seram yang ada di sekitarmu..",
                "Publish : 2016",
                R.drawable.ghostpathkomik,
                "Genre : Horor",
                R.drawable.ghostpath
            )
        )
        content.add(
            DataKomik(
                "Gloomy Sunday",
                "Author: Fanky Landerson",
                "Komik ini mengandung tema kekerasan dan pembunuhan. Cerita aneh, kelam, dan horor.",
                "Publish : 2023",
                R.drawable.gloomykomik,
                "Genre : Horor",
                R.drawable.glommy
            )
        )
        content.add(
            DataKomik(
                "Si Juki",
                "Author: Faza Meonk",
                "Lika-liku anak kos yang kocak! Komik asli Indonesia yang mengisahkan pahit manisnya kehidupan anak kos. Penuh canda dan tawa dengan selipan kritik tentang isu yang sedang hangat saat ini",
                "Publish : 2015",
                R.drawable.jukikomik,
                "Genre : Horor, Gore",
                R.drawable.sijuki
            )
        )
        content.add(
            DataKomik(
                "Kecoa dan Dendam",
                "Author: Renato Adhitama",
                "Kisah kehidupan seekor kecoa yang ingin memerangi manusia untuk membalaskan dendam kematian keluarganya. Dapatkan para kecoa mengalahkan manusia?",
                "Publish : 2020",
                R.drawable.kecoakomik,
                "Genre : Komedi",
                R.drawable.kecoa
            )
        )
        content.add(
            DataKomik(
                "Lookism",
                "Author: Taejun Pak (박태준)",
                "Cowok ini punya 2 wujud! Pilih yang mana ya..?",
                "Publish : 2023",
                R.drawable.lookismkomik,
                "Genre : Komedi, Drama",
                R.drawable.lookism
            )
        )
        content.add(
            DataKomik(
                "One Punch Man",
                "Author: One, Shueisha",
                "One-Punch Man ( ワンパンマン Wanpanman) adalah sebuah serial manga Jepang yang menceritakan seorang superhero yang bernama Saitama. One-Punch Man dibuat oleh seorang penulis yang asal jepang dengan nama samaran ONE",
                "Publish : 2009",
                R.drawable.onepunchkomik,
                "Genre : ksi, Komedi, Superhero, Fiksi",
                R.drawable.onepunchman
            )
        )
        content.add(
            DataKomik(
                "Si Ocong",
                "Author: Agung Gunawan",
                "si ocong adalah sosok yang songong nyebelin tapi ngangenin",
                "Publish : 2023",
                R.drawable.siocongkomik,
                "Genre : Komedi",
                R.drawable.siocong
            )
        )
        content.add(
            DataKomik(
                "Si Udin",
                "Author: Niksen",
                "Mengisahkan cerita kehidupan sehari-hari Si Udin dan teman-temannya.i",
                "Publish : 2022",
                R.drawable.siudinkomik,
                "Genre : Komedi",
                R.drawable.siudin
            )
        )
        content.add(
            DataKomik(
                "Tuti and Friends",
                "Author:  Pionicon",
                "Tuti adalah anak super polos, ceria tapi terkadang lemot! Ikuti keseharian Tuti dan teman-temannya!",
                "Publish : 2014",
                R.drawable.tutiikomik,
                "Genre : Komedi, Manga",
                R.drawable.tuti
            )
        )
        content.add(
            DataKomik(
                "Yotsuba",
                "Author: One, Yūsuke Murata",
                "Yotsuba dan ayahnya menghabiskan waktu yang sedikit spesial, dengan naik kereta yang ramai, berjalan-jalan di Harajuku, dan menyantap makan siang yang mewah. Lalu, ada karakter yang baru pertama kali muncul?",
                "Publish : 2003",
                R.drawable.yotsubakomik,
                "Genre : Comedy, Slice of life",
                R.drawable.yotsuba
            )
        )


        return content
    }

    private fun getItemList2(): List<DataNovel> {
        val content = mutableListOf<DataNovel>()
        content.add(
            DataNovel(
                "Hello Cheyry",
                "Author: JRUBIED",
                "Cheyry Kamilah, Kapten Basket Putri di salah satu club basket di Jakarta Selatan dengan Poni yang identik dengannya itu harus mengalami kecelakaan hebat setelah pulang dari latihan basketnya.",
                "Publish : 3 Januari 2023",
                R.drawable.hellocheyry,
                "Genre : Romance",
                R.drawable.hellocheyry

            )
        )
        content.add(
            DataNovel(
                "Weddings' Smuggler [END]",
                "Author: lyanchan",
                "Wanda E. Pangestu, meneliti berbagai pesta pernikahan orang asing sebagai referensi novelnya yang sudah harus terbit dalam waktu dekat.",
                "Publish : 16 May 2023",
                R.drawable.wedding,
                "Genre : Horor, Romance",
                R.drawable.wedding
            )
        )
        content.add(
            DataNovel(
                "Nessa istri tuan George",
                "Author: anakgabut95",
                "Nessa seorang gadis remaja yang hobi sekali membaca novel, namun akibat hobinya tersebut ia malah bertransmigrasi ke tubuh seorang figuran dalam cerita yang terakhir ia bacai",
                "Publish : 9 Januari 2023",
                R.drawable.nessa,
                "Genre : Romance",
                R.drawable.nessa
        )
        )
        content.add(
            DataNovel(
                "tׁׅꭈׁׅɑׁׅ݊ꪀᧁׁꭈׁׅɑׁׅׅ..",
                "Author: SuciRamadani310",
                "Cantika Adalah seorang gadis yatim piatu yang hidup sendiri, ia tiada di usia muda dengan alasan konyol sebenarnya. ",
                "Publish : 2023",
                R.drawable.trasmigrasi,
                "Genre : Fantasy",
                R.drawable.trasmigrasi
            )
        )
        content.add(
            DataNovel(
                "Become Female Lead Stepmother!",
                "Author: EzzGrey19",
                "Kia Amajaya, gadis pekerja keras yang selalu siap menerobos segala rintangan hidup. Membuatnya menjadi wanita independent yang hebat, tapi seakan dunia mempermainkan-nya karena semenjak saat itu semua hal buruk mulai berdatangan.",
                "Publish : 18 Mei 2023",
                R.drawable.stepmother,
                "Genre : Fantasy",
                R.drawable.stepmother
            )
        )
        content.add(
            DataNovel(
                "One More Chance,Bagas",
                "Author: Jellokun18",
                "menceritakan seorang pemuda yang tinggal sendiri bernama Bagaskara Xavier. Seorang pemuda barbar gak kenal aturan dan bebas. Menemukan sebuah novel di gudang rumahnya berjudul \"I am The Princess\".",
                "Publish : April 2023",
                R.drawable.onemore,
                "Genre : Fantasi",
                R.drawable.onemore
            )
        )
        content.add(
            DataNovel(
                "Butterfly world",
                "Author: mutiyanikmah",
                "Alzetta gadis berumur 25 tahun yang menikmati karir nya sebagai dokter bedah, hanya karena kelalaiannya dalam menyebrang dia ber transmigrasi di novel because of love. ",
                "Publish : 28 Mei 2023",
                R.drawable.butterfly,
                "Genre : Fantasi",
                R.drawable.butterfly
            )
        )
        content.add(
            DataNovel(
                "Antagonis? yes! i'm?",
                "Author: Kinairaa19",
                "Bukan cerita transmigrasi ke orang berpengaruh di dunia melainkan ini kisah seorang penulis yang jiwanya berpindah ke novel buatannya sendiri.\n" +
                        "Bahkan lebih parahnya lagi ketubuh seorang antagonis dengan segala kesempurnaannya.",
                "Publish : 06-10-2022",
                R.drawable.antagonis,
                "Genre : Fantasi",
                R.drawable.antagonis
            )
        )
        content.add(
            DataNovel(
                "Menjadi Pelayan Pangeran Terkutuk",
                "Author: EnvyBill",
                "Qiara Amaletha Myesha,\n" +
                        "Ia merupakan gadis remaja yang duduk di bangku SMA, gadis yang kerap dipanggil Qiara oleh semua orang ini lumayan pendiam dengan wajah datar andalannya, tetapi ia juga merupakan priabadi yang lembut.",
                "Publish : 20222",
                R.drawable.pelayan,
                "Genre : Fantasi",
                R.drawable.pelayan
            )
        )
        content.add(
            DataNovel(
                "Another Villain",
                "Author: xxxilsam",
                "Dikatakan di dalam novel yang berjudul 'The Emperor is My Husband' bahwa Aleen adalah seorang antagonis sampingan. Iya, kalian tidak salah membaca tentang antagonis sampingan tersebut.\n",
                "Publish : 2023",
                R.drawable.villian,
                "Genre : Fantasi",
                R.drawable.villian
            )
        )
        content.add(
            DataNovel(
                "Become the Antagonist °xiel° (Tamat)",
                "Author: ari_riavv",
                "Shaka, pemuda berusia 18 tahun tiba-tiba jiwanya berpindah pada salah satu tokoh antagonis dalam novel.",
                "Publish : 2022",
                R.drawable.become,
                "Genre : Fantasi",
                R.drawable.become
            )
        )
        content.add(
            DataNovel(
                "Our Precious Mom [END]",
                "Author: mufidn68",
                "Lyla Agatha terbangun dalam tubuh seorang wanita berusia dua puluh lima setelah dikhianati temannya. ",
                "Publish : 2022",
                R.drawable.mom,
                "Genre : Fantasi",
                R.drawable.mom
            )
        )
        content.add(
            DataNovel(
                "Javier (bl)",
                "Author: ken_leo2912",
                "Seorang gadis 23 tahun bernama Carrel Queenzy Alderic, meninggal akibat kecelakaan yang di alami nya dan bertransmigrasi ke tubuh lelaki yang merupakan salah satu abang dari antagonis serta figuran dalam novel berjudul \"With U\".",
                "Publish : 2021",
                R.drawable.javier,
                "Genre : Fantasi",
                R.drawable.javier
            )
        )
        content.add(
            DataNovel(
                "Chloe The Antagonist Princess",
                "Author: N4nAa__Aa",
                "Chloe, Seorang putri Kerajaan Graysian yang terkenal memiliki sikap yang sangat buruk. Bahkan hampir semua orang percaya kalau Chloe adalah putri terkutuk, karena tidak cukup membuat sang ratu sakit-sakitan setelah melahirkan, ia juga tumbuh menjadi gadis kekanakan pengemis cinta dengan temperamen yang buruk. ",
                "Publish : 2021",
                R.drawable.chloe,
                "Genre : Fantasi",
                R.drawable.chloe
            )
        )
        content.add(
            DataNovel(
                "I'm The Villain's And Hero's Mom",
                "Author: IceBae_",
                "Liviana Putri adalah seorang budak korporat yang selalu bekerja seharian. Dia mati karena kelelahan saat membaca novel setelah punya waktu untuk beristirahat. ",
                "Publish : 21 Februari 2023",
                R.drawable.villianmom,
                "Genre : Fantasi",
                R.drawable.villianmom
            )
        )



        return content
    }

}