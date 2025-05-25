package com.example.listacards

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ListaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnInserir :Button = findViewById<MaterialButton>(R.id.btnTelaInserir)
        val lista = findViewById<RecyclerView>(R.id.recycleItens)

        lista.layoutManager = LinearLayoutManager(this)
        adapter = ListaAdapter(ListaCache.itens)

        lista.adapter = adapter

        btnInserir.setOnClickListener({
            val intent = Intent(this, Inserir::class.java)
            startActivity(intent)
        })

    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}