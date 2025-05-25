package com.example.listacards

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListaAdapter (val itens : MutableList<Itens>) : RecyclerView.Adapter<ListaAdapter.ItemViewHolder>() {

    class ItemViewHolder(carditem : View ) : RecyclerView.ViewHolder(carditem){
        val img = carditem.findViewById<ImageView>(R.id.imageView)
        val nome = carditem.findViewById<TextView>(R.id.nomeProduto)
        val valor = carditem.findViewById<TextView>(R.id.valorProduto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaAdapter.ItemViewHolder {
        val lista = LayoutInflater.from(parent.context)
            .inflate(R.layout.carditem, parent, false)
        return ItemViewHolder(lista)
    }

    override fun onBindViewHolder(holder: ListaAdapter.ItemViewHolder, position: Int) {
        holder.nome.text = itens[position].nome
        holder.valor.text = itens[position].valor
        holder.img.setImageResource(R.drawable.ic_launcher_background)
    }

    override fun getItemCount(): Int {
        return this.itens.size
    }

}