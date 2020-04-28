package com.example.cuponesmvp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.cuponesmvp.BR
import com.example.cuponesmvp.R
import com.example.cuponesmvp.viewmodel.MainViewModel
import com.example.cuponesmvp.model.Oferta

class           CuponesAdapter(var mainViewModel: MainViewModel) :
    RecyclerView.Adapter<CuponesAdapter.CuponesViewHolder>() {

    private var cuponesList : List<Oferta>? = null

    fun setCuponesList(cupones: List<Oferta>){
        this.cuponesList = cupones
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuponesViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding =
            DataBindingUtil.inflate(layoutInflater,viewType,parent,false)
        return CuponesViewHolder(binding)
    }

    override fun getItemCount(): Int = cuponesList?.size?:0

    override fun onBindViewHolder(holder: CuponesViewHolder, position: Int) {
        holder.setCupon(mainViewModel,position)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    private fun getLayoutIdForPosition (position: Int): Int {
        return R.layout.cupon_list_item
    }

    class CuponesViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root),
        View.OnClickListener{

        private var binding: ViewDataBinding?= null

        init {
            this.binding = binding
        }

        fun setCupon(mainViewModel: MainViewModel, position: Int) {
            binding?.setVariable(BR.model, mainViewModel)
            binding?.setVariable(BR.position, position)
            binding?.executePendingBindings()
        }

        override fun onClick(v: View?) {}
    }
}
