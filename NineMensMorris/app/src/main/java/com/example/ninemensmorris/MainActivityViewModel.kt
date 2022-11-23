package com.example.ninemensmorris

import android.graphics.Color
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    var game: MutableLiveData<Game> = MutableLiveData<Game>()
    var dispPlayer: MutableLiveData<String> = MutableLiveData()

    fun switchPlayer(view: View) {
        game.value?.switchPlayer()
        dispPlayer.value = game.value?.currentPlayer?.color?.name
    }
}