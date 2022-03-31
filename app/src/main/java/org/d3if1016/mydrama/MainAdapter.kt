package org.d3if1016.mydrama

import Drama
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import org.d3if1016.mydrama.databinding.GridItemBinding


class MainAdapter (private val data: List<Drama>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    class ViewHolder(
        private val binding: org.d3if1016.mydrama.databinding.GridItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(drama: Drama) = with(binding) {
            textJudul.text = drama.judul
            textGenre.text = drama.genre
            textNegara.text = drama.negara
            dramaPoster.setImageResource(drama.imageRestId)

            root.setOnClickListener {
                val message = root.context.getString(R.string.message, drama.judul)
                Toast.makeText(root.context, message, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = GridItemBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}