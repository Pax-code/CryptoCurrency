package com.example.cryptocurrency.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.decode.Decoder
import coil.decode.SvgDecoder
import coil.load
import com.example.cryptocurrency.databinding.RecyclerRowBinding
import com.example.cryptocurrency.model.Coin

class RecyclerAdapter(private val coins: List<Coin>): RecyclerView.Adapter<RecyclerAdapter.RowHolder>() {

    class RowHolder(private val binding: RecyclerRowBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(coin: Coin){
            binding.cardView.setBackgroundColor(
                if(coin.color != null) {
                    Color.parseColor(coin.color)
                } else {Color.WHITE}
            )
            binding.cryptoNameText.text = coin.name
            binding.cryptoPriceText.text = coin.price
            binding.cryptoSymbolText.text = coin.symbol
            binding.cryptoLogo.load(coin.iconUrl) {
                decoderFactory { result, options, _ -> SvgDecoder(result.source, options) }
            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RowHolder(binding)


    }

    override fun getItemCount(): Int {
        return coins.size
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(coins[position])
    }

}