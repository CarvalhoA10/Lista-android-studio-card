package com.example.listacards

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Inserir : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inserir)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnInserir = findViewById<Button>(R.id.btnInserir)
        val nome = findViewById<TextView>(R.id.nomeProdutoInput)
        val valor = findViewById<TextView>(R.id.valorProdutoInput)

        btnInserir.setOnClickListener({

            if(nome.text.toString() != "" && valor.text.toString() != ""){
                val item = Itens(nome.text.toString(), valor.text.toString())

                if(nome.text.toString() != "" && valor.text.toString() != ""){
                    var check = false
                    ListaCache.itens.forEach {item ->
                        if(item.nome == nome.text.toString()) {
                            check = true
                        }
                    }

                    if(check == true){
                        AlertDialog.Builder(this)
                            .setTitle("Observação")
                            .setMessage("O item " + nome.text.toString() + " Já existe na lista")
                            .setPositiveButton("Sim") { Dialog, witch ->
                                startActivity(Intent(this, MainActivity::class.java))
                            }
                            .setNegativeButton("Permanecer", null)
                            .show()
                    }else{
                        ListaCache.itens.add(item)

                        startActivity(Intent(this, MainActivity::class.java))
                    }


                }


            }

        })

    }
}