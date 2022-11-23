package com.example.ninemensmorris

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    val userName = MutableLiveData<String>()

}