package com.ronaldiputra.coronainformasi.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.ronaldiputra.coronainformasi.R
import com.ronaldiputra.coronainformasi.adapter.ProvinsiAdapter
import com.ronaldiputra.coronainformasi.api.RetrofitClient
import com.ronaldiputra.coronainformasi.model.DetailResponse
import com.ronaldiputra.coronainformasi.model.IndonesiaResponse
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    lateinit var provinsiAdapter: ProvinsiAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        actionToDetail()
        tampilDataUpdate()
        tampilDataDetail()
    }

    private fun tampilDataDetail() {
        RetrofitClient.instance.getDetail().enqueue(object : Callback<DetailResponse>{
            override fun onFailure(call: Call<DetailResponse>, t: Throwable) {
                Toast.makeText(activity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<DetailResponse>,
                response: Response<DetailResponse>
            ) {
                val detail = response.body()?.update?.penambahan
                tv_tanggal.text = detail?.tanggal.toString()
                tv_posititf_detail.text = detail?.positif_detail.toString()
                tv_sembuh_detail.text = detail?.sembuh_detail.toString()
                tv_meninggal_detail.text = detail?.meninggal_detail.toString()
            }

        })
    }

    private fun actionToDetail(){
        tv_detail.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
        }
    }

    private fun tampilDataUpdate() {
        RetrofitClient.instance.getUpdate().enqueue(object: Callback<IndonesiaResponse>{
            override fun onFailure(call: Call<IndonesiaResponse>, t: Throwable) {
                Toast.makeText(activity, "Problem Network",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<IndonesiaResponse>,
                response: Response<IndonesiaResponse>
            ) {
                val update = response.body()?.update?.total
                tv_positif.text = update?.jumlah_positif.toString()
                tv_sembuh.text = update?.jumlah_sembuh.toString()
                tv_meninggal.text = update?.jumlah_meninggal.toString()
            }
        })
    }
}