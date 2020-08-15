package com.ronaldiputra.coronainformasi.model

import com.google.gson.annotations.SerializedName

data class DetailResponse(val update: Penambahan){
    inner class Penambahan( val penambahan: Hasil)
    inner class Hasil(
        @SerializedName("jumlah_positif")
        val positif_detail: Int,
        @SerializedName("jumlah_sembuh")
        val sembuh_detail: Int,
        @SerializedName("jumlah_meninggal")
        val meninggal_detail: Int,
        val tanggal: String
    )
}