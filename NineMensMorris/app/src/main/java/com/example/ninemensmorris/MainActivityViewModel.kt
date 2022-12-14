package com.example.ninemensmorris

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    var game: MutableLiveData<Game> = MutableLiveData<Game>()
    var dispPlayer: MutableLiveData<String> = MutableLiveData()
    var dispState: MutableLiveData<String> = MutableLiveData()
    var p1Pieces: MutableLiveData<String> = MutableLiveData()
    var p2Pieces: MutableLiveData<String> = MutableLiveData()
    var p1State: MutableLiveData<String> = MutableLiveData()
    var p2State: MutableLiveData<String> = MutableLiveData()
    var winner: MutableLiveData<String> = MutableLiveData()
    var error: MutableLiveData<String> = MutableLiveData()

}