package com.example.placesofinterest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_place.view.*

//extends RecuclerView.adapter
class PlaceAdapter(private val places: List<Place>) :
    RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {
    lateinit var context: Context

    //TODO comment
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_place, parent, false)
        )
    }

    /**
     * Gets the total item count in the places collection
     */
    override fun getItemCount(): Int {
        return places.size
    }

    /**
     * Is called when a new item is bound to the places collection. It is responsible for adding the
     * item to the viewHolder
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(places[position])
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(place: Place) {
            itemView.ivPlace.setImageDrawable(context.getDrawable(place.imageResId))
            itemView.tvPlace.text = place.name
        }
    }

}