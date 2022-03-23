package ru.maksewsha.testtask.presentation.elements

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.maksewsha.testtask.R
import ru.maksewsha.testtask.data.models.Character
import ru.maksewsha.testtask.presentation.fragments.AboutPersonFragment
import ru.maksewsha.testtask.presentation.models.CharacterPresentation

class CharactersRecyclerAdapter(private val characters: List<CharacterPresentation>) :
    RecyclerView.Adapter<CharactersRecyclerAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.list_item_card_image)
        val textView = itemView.findViewById<TextView>(R.id.list_item_card_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_card,parent, false)
        return CharacterViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.textView.text = characters[position].name
        Glide.with(holder.imageView.context).load(characters[position].img).override(256, 256).into(holder.imageView)
        holder.itemView.setOnClickListener {
            (holder.imageView.context as AppCompatActivity).supportFragmentManager.beginTransaction().replace(R.id.main_activity_container, AboutPersonFragment(characters[position])).addToBackStack("").commit()
        }
    }

    override fun getItemCount(): Int {
        return characters.size
    }
}