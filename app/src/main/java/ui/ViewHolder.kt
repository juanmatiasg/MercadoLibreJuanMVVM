package ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmmercadolibrejuan.R

class ViewHolder(view: View):RecyclerView.ViewHolder(view){
    var id = view.findViewById<TextView>(R.id.textViewId)
    var title = view.findViewById<TextView>(R.id.textViewTItle)
    var price = view.findViewById<TextView>(R.id.textViewPrecio)
    var photos = view.findViewById<ImageView>(R.id.imageView)
    var cardView = view.findViewById<CardView>(R.id.cardView)
}