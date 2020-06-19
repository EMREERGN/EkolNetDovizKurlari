package com.emreergun.ekolnetdovizkurlari.fragmentsUi.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.emreergun.ekolnetdovizkurlari.R
import com.emreergun.ekolnetdovizkurlari.model.RateModel
import kotlinx.android.synthetic.main.main_fragment.*
import java.util.*
import kotlin.collections.ArrayList

class MainFragment : Fragment() {

    private var rateList=ArrayList<RateModel>()
    private lateinit var recyclerView:RecyclerView

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val root =inflater.inflate(R.layout.main_fragment, container, false)


        recyclerView=root.findViewById(R.id.recyclerDoviz)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager=LinearLayoutManager(root.context)
        }


        return  root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setProgressVisibility(true) // on progress

        viewModel.dovizDataObservable.observe(viewLifecycleOwner, Observer {
            if (it!=null){
                mainTxtView.text="${it.date} Döviz Kurları"
                mainTxtView.setOnClickListener {
                    Toast.makeText(context,"Produced By Emre Ergün",Toast.LENGTH_LONG).show()
                }



                it.rates.toString()
                    .replace("Rates(","")
                    .replace(")","")
                    .split(",").forEach {
                        val rateName=it.split("=")[0].toUpperCase(Locale.ROOT) // lokale göre büyük harf yapıldı
                        val rateValue=it.split("=")[1]
                        val rateModel=RateModel(rateName=rateName,rateValue = rateValue)
                        rateList.add(rateModel)
                    }

                setProgressVisibility(false) // finish process


                val mainRecycAdapter=MainRecycAdapter(rateList=rateList,base = "TRY")
                recyclerView.adapter=mainRecycAdapter
                recyclerView.adapter!!.notifyDataSetChanged()


            }
        })
    }

    private fun setProgressVisibility(onProgress: Boolean) {
        if (onProgress)
        {
            progressBarRecycler.visibility=View.VISIBLE
            recyclerView.visibility=View.GONE
        }
        else
        {
            progressBarRecycler.visibility=View.GONE
            recyclerView.visibility=View.VISIBLE
        }
    }

}
