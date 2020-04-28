package com.example.cuponesmvp.model

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository() : IMainRepository {

    private var cupones = MutableLiveData<List<Oferta>>()

    override fun callCuponesAPI() {
        val apiKey = "25fb8437ab8853357111dc2b6f29cfb0"
        var cuponesList: ArrayList<Oferta>? = ArrayList()

        ApiService.create()
            .getTopRated(apiKey)
            .enqueue(object : Callback<Cupones> {
                override fun onFailure(call: Call<Cupones>, t: Throwable) {
                   // mainPresenter.showErrorMsg(t.message)
                }

                override fun onResponse(call: Call<Cupones>, response: Response<Cupones>) {
                    if (response.isSuccessful) {
                       cuponesList = response.body()?.offers as ArrayList<Oferta>
                    }
                    cupones.value = cuponesList
                }
            })
    }

    override fun getCupones() : MutableLiveData<List<Oferta>>{
        return cupones
    }
}