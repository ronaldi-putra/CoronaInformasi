package com.ronaldiputra.coronainformasi.model

data class ProvinsiResponse(val list_data: Provinsi){
    inner class Provinsi(
        val key: String,
        val jumlah_kasus: Int,
        val jumlah_sembuh: Int,
        val jumlah_meninggal: Int
    )
}
