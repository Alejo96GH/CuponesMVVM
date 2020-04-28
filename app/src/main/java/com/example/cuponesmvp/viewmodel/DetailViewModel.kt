package com.example.cuponesmvp.viewmodel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cuponesmvp.model.Oferta
import com.squareup.picasso.Picasso

class DetailViewModel: ViewModel() {

    private var cupon: MutableLiveData<Oferta> = MutableLiveData()

    fun setDetailCupon(cupon: Oferta){
        this.cupon.value = cupon
    }

    fun getCupon() = cupon

    companion object{
        @JvmStatic
        @BindingAdapter("loadImageDetail")
        fun loadImageDetail(imageView: ImageView, imageUrl: String){
            Picasso.get().load(imageUrl).into(imageView)
        }
    }
}