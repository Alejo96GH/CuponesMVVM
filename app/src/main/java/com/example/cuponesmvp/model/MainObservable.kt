package com.example.cuponesmvp.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData

class MainObservable: BaseObservable() {
    private var mainRepository: IMainRepository = MainRepository()

    fun callCupones(){
        mainRepository.callCuponesAPI()
    }

    fun getCupones() : MutableLiveData<List<Oferta>>{
        return mainRepository.getCupones()
    }
}