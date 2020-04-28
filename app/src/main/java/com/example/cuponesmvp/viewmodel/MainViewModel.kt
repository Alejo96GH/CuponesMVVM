package com.example.cuponesmvp.viewmodel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cuponesmvp.model.MainObservable
import com.example.cuponesmvp.model.Oferta
import com.example.cuponesmvp.view.CuponesAdapter
import com.squareup.picasso.Picasso

class MainViewModel : ViewModel() {
    private var mainObservable: MainObservable = MainObservable()
    private var cuponesAdapter: CuponesAdapter? = null

    private var cuponSelected: MutableLiveData<Oferta> = MutableLiveData()

    fun callCupones() {
        mainObservable.callCupones()
    }

    fun getCupones(): MutableLiveData<List<Oferta>> {
        return mainObservable.getCupones()
    }

    fun getCuponSelected(): MutableLiveData<Oferta> {
        return cuponSelected
    }

    fun setCuponesInCuponesAdapter(cupones: List<Oferta>){
        cuponesAdapter?.setCuponesList(cupones)
        cuponesAdapter?.notifyDataSetChanged()
    }

    fun getRecyclerCuponesAdapter(): CuponesAdapter?{
        cuponesAdapter = CuponesAdapter(this)
        return cuponesAdapter
    }

    fun getCuponAt(position: Int): Oferta? {
        var cupon: List<Oferta>? = mainObservable.getCupones().value
        return cupon?.get(position)
    }

    fun onItemClick(position: Int) {
        val cupon = getCuponAt(position)
        cuponSelected.value = cupon
    }

    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: ImageView, imageURL: String) {
            if (!imageURL.isNullOrBlank())
                Picasso.get().load(imageURL).into(imageView)
        }
    }
}

