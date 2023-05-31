package com.example.visitview

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Base64
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

import kotlin.collections.ArrayList

class adapter   : RecyclerView.Adapter<adapter.ViewHolder>()  {

    var Lugares:MutableList<MainActivity.Place> = ArrayList()

    lateinit var context: Context

    fun adapter(lugares: MutableList<MainActivity.Place>, context: Context){
        this. Lugares = lugares
        this.context = context

    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = Lugares.get(position)
        holder.bind(item, context)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_layout, parent, false))
    }
    override fun getItemCount(): Int {
        return Lugares.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val NOMBRE = view.findViewById(R.id.NOMBRE) as TextView

        val PROVINCIA = view.findViewById(R.id.PROVINCIA) as TextView
        val CANTON = view.findViewById(R.id.CANTON) as TextView
        val FOTO = view.findViewById(R.id.FOTO) as ImageView

        fun bind(lugar: MainActivity.Place, context: Context){
            NOMBRE.text = lugar.NOMBRE
            PROVINCIA.text =  lugar.PROVINCIA
            CANTON.text = lugar.CANTON
            if(lugar.FOTO != "") {
                try {
                    var imagenendos = lugar.FOTO.split(',')
                    Log.d("FOTO ", lugar.FOTO)
                    val imageBytes = Base64.decode(lugar.FOTO, Base64.DEFAULT)
                    val decodedImage =
                        BitmapFactory.decodeByteArray(imageBytes, 0, lugar.FOTO.length)
                    FOTO.setImageBitmap(decodedImage)
                } catch(e : Exception){

                }

            }

        }
    }

}