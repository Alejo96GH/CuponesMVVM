package com.example.cuponesmvp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cuponesmvp.R
import com.example.cuponesmvp.viewmodel.MainViewModel
import com.example.cuponesmvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mainViewModel : MainViewModel ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBindings(savedInstanceState)
    }

    private fun setupBindings(savedInstanceState: Bundle?) {
        var activityMainBinding : ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        activityMainBinding.lifecycleOwner = this
        activityMainBinding.model = mainViewModel

        setUpListUpdate()
    }

    fun setUpListUpdate(){
        mainViewModel?.callCupones()

        mainViewModel?.getCupones()?.observe(this, Observer {cupon ->
            Log.d("Cupon", cupon[0].title)
            mainViewModel?.setCuponesInCuponesAdapter(cupon)
        })

        setUpListClick()
    }

    private fun setUpListClick(){
        mainViewModel?.getCuponSelected()?.observe(this, Observer {cupon ->
            val intent = Intent (this, DetailActivity::class.java)
            intent.putExtra("cupon", cupon)
            startActivity(intent)
        })
    }
}