package com.ronaldiputra.coronainformasi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ronaldiputra.coronainformasi.R
import com.ronaldiputra.coronainformasi.model.ProvinsiResponse
import kotlinx.android.synthetic.main.item_provinsi.view.*

class ProvinsiAdapter (private val list: ArrayList<ProvinsiResponse>): RecyclerView.Adapter<ProvinsiAdapter.ProvinsiViewHolder>(){
    inner class ProvinsiViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(provinsi: ProvinsiResponse){
            with(itemView){
                tv_nama_prov.text = provinsi.list_data.key
                tv_positif_prov.text = provinsi.list_data.jumlah_kasus.toString()
                tv_sembuh_prov.text = provinsi.list_data.jumlah_sembuh.toString()
                tv_meninggal_prov.text = provinsi.list_data.jumlah_meninggal.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinsiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_provinsi, parent, false)
        return ProvinsiViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ProvinsiViewHolder, position: Int) {
        holder.bind(list[position])
    }
}