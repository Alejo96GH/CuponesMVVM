package com.example.cuponesmvp.model

import androidx.lifecycle.MutableLiveData

interface IMainRepository {
    fun callCuponesAPI()
    fun getCupones(): MutableLiveData<List<Oferta>>
}