package com.ronaldiputra.coronainformasi.model

data class IndonesiaResponse(val update: Total){
    inner class Total (val total: Hasil)
    inner class Hasil(
        val jumlah_positif: Int,
        val jumlah_sembuh: Int,
        val jumlah_meninggal: Int
    )
}
