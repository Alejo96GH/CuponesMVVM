package com.example.cuponesmvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.cuponesmvp.R
import com.example.cuponesmvp.viewmodel.DetailViewModel
import com.example.cuponesmvp.databinding.ActivityDetailBinding
import com.example.cuponesmvp.model.Oferta

class DetailActivity : AppCompatActivity() {
    private var detailViewModel : DetailViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setupBinding(savedInstanceState)
    }

    fun setupBinding(savedInstanceState: Bundle?){

        var activityDetailBinding: ActivityDetailBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_detail)

        detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        activityDetailBinding.model = detailViewModel
        activityDetailBinding.lifecycleOwner = this

        detailViewModel?.setDetailCupon(intent?.getSerializableExtra("cupon") as Oferta)
    }

}
