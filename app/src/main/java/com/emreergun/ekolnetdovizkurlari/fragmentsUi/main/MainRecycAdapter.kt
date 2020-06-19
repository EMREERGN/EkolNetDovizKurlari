package com.emreergun.ekolnetdovizkurlari.fragmentsUi.main

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.emreergun.ekolnetdovizkurlari.R
import com.emreergun.ekolnetdovizkurlari.model.DovizModel
import com.emreergun.ekolnetdovizkurlari.model.RateModel
import com.emreergun.ekolnetdovizkurlari.model.Rates
import kotlinx.android.synthetic.main.doviz_card_item.view.*


class MainRecycViewHolder(view:View):RecyclerView.ViewHolder(view){
    val context:Context=view.context
    val baseTxtView:TextView=view.findViewById(R.id.cardBaseTxt)
    val rateTxtView:TextView=view.findViewById(R.id.cardRateTxt)
}



class MainRecycAdapter(private val rateList:ArrayList<RateModel>,private val base:String):RecyclerView.Adapter<MainRecycViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRecycViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.doviz_card_item,parent,false)
        return MainRecycViewHolder(root)
    }

    override fun getItemCount(): Int {
        return rateList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MainRecycViewHolder, position: Int) {
        val rateCurrent =rateList[position]

        // Biraz Matematik yapalım :))
        // 1 TRY = 0.2125038977 AUD
        // 1 AUD = ? TRY


        val tryConvert=1.div(rateCurrent.rateValue.toDouble())

        holder.baseTxtView.text="1 $base"
        holder.rateTxtView.text="${rateCurrent.rateValue} ${rateCurrent.rateName}"


        holder.baseTxtView.text="1 ${rateCurrent.rateName}" // 1 AUD
        holder.rateTxtView.text="${tryConvert}  TRY" // ? TRY



    }

}