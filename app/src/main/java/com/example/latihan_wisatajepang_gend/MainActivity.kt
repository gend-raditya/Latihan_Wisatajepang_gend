package com.example.latihan_wisatajepang_gend

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.latihan_wisatajepang_gend.adapter.WisataAdapter
import com.example.latihan_wisatajepang_gend.model.WisataList
import com.example.latihan_wisatajepang_gend.model.WisataModel

class MainActivity : AppCompatActivity() {
    private lateinit var rv_wisata : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        rv_wisata= findViewById(R.id.rv_wisata)

        rv_wisata.layoutManager = GridLayoutManager(this,  2)
        val adapter = WisataAdapter(WisataList.getModel() as ArrayList<WisataModel> , this)
        rv_wisata.adapter = adapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}