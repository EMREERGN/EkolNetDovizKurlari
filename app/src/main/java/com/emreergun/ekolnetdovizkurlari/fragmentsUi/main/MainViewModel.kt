package com.emreergun.ekolnetdovizkurlari.fragmentsUi.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.emreergun.ekolnetdovizkurlari.model.DovizModel
import com.emreergun.ekolnetdovizkurlari.repository.DataRepository

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    val dovizDataObservable: LiveData<DovizModel> = DataRepository().getDovizDatas()
}
