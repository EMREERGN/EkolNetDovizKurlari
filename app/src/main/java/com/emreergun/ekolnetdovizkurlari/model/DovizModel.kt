package com.emreergun.ekolnetdovizkurlari.model


import com.google.gson.annotations.SerializedName

data class DovizModel(
    @SerializedName("base")
    val base: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("rates")
    val rates: Rates
)