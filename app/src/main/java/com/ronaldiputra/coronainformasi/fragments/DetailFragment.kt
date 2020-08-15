package com.ronaldiputra.coronainformasi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.ronaldiputra.coronainformasi.R
import com.ronaldiputra.coronainformasi.adapter.ProvinsiAdapter
import com.ronaldiputra.coronainformasi.api.RetrofitClient
import com.ronaldiputra.coronainformasi.model.ProvinsiResponse
import kotlinx.android.synthetic.main.fragment_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showDataProvinsi()
    }

    private fun showDataProvinsi() {

        rv_provinsi.setHasFixedSize(true)
        rv_provinsi.layoutManager = LinearLayoutManager(activity)

        RetrofitClient.instance.getProv().enqueue(object : Callback<ArrayList<ProvinsiResponse>>{
            override fun onFailure(call: Call<ArrayList<ProvinsiResponse>>, t: Throwable) {
                Toast.makeText(activity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<ArrayList<ProvinsiResponse>>,
                response: Response<ArrayList<ProvinsiResponse>>
            ) {
                val list = response.body()
                val adapter = list?.let { ProvinsiAdapter(it) }
                rv_provinsi.adapter = adapter
            }

        })
    }

}