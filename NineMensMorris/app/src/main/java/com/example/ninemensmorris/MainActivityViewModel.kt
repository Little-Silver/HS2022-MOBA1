package com.example.ninemensmorris

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    val userName = MutableLiveData<String>()

    fun switchPlayer(view: View) {
        userName.value = "test"
    }
}