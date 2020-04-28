package com.example.cuponesmvp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Cupones(
    @SerializedName("offers")
    val offers: List<Oferta>,
    @SerializedName("result")
    val result: Boolean
)