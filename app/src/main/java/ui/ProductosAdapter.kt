package ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmmercadolibrejuan.R
import com.example.mvvmmercadolibrejuan.model.BaseProductos
import com.example.mvvmmercadolibrejuan.model.Items
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_producto.view.*


class ProductosAdapter(private val lista: ArrayList<Items>) : RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_producto, parent, false))
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.id.setText(ID + lista.get(position).id)
        holder.title.setText(TITLE + lista.get(position).title)
        holder.price.setText(PRECIO + lista.get(position).price.toString() + "$")
        Picasso.get().load(lista.get(position).thumbnail).into(holder.photos)
        holder.cardView.setOnClickListener {

            val bundle = Bundle()
            bundle.putParcelable("items",lista.get(position))
            it.findNavController().navigate(R.id.action_mainFragment2_to_detailFragment,bundle)
        }
    }


    fun getAddListProducto(list: List<Items>) {
        lista.clear()
        lista.addAll(list)
        notifyDataSetChanged()
    }


    companion object {
        const val ID = "ID: "
        const val TITLE = "Titulo: "
        const val PRECIO = "Precio: "
        const val CARRITO = "Se agrego al Carrito"
        const val LIST_KEY = "list_ley"
    }


}


