package com.example.ninemensmorris

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.example.ninemensmorris.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var game: MutableLiveData<Game> = MutableLiveData<Game>()
    var dispPlayer: MutableLiveData<String> = MutableLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var clickedPiecesOfPlayer1 = false
        var clickedPiecesOfPlayer2 = false
        var clickedPlaceholder000 = false
        var clickedPlaceholder001 = false

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        game.value = Game(Board())
        binding.testButton1.setOnClickListener {
            switchPlayer();
            binding.textViewPlayerActive.text = dispPlayer.value.toString()
            switchColorPurple(binding.placeholder000)
        }
        binding.testButton2.setOnClickListener {
            switchColorBlack(binding.placeholder000)
        }
        binding.piecesOfPlayer1.setOnClickListener {
            clickedPiecesOfPlayer1 = true
        }
        binding.piecesOfPlayer2.setOnClickListener {
            clickedPiecesOfPlayer2 = true
        }
        binding.placeholder000.setOnClickListener {
            clickedPlaceholder000
            if(clickedPiecesOfPlayer1){
                switchColorWhite(binding.placeholder000)
                clickedPiecesOfPlayer1 = false
            }
        }
        binding.placeholder001.setOnClickListener {
            clickedPlaceholder001 = true
            if(clickedPiecesOfPlayer2){
                switchColorWhite(binding.placeholder001)
                clickedPiecesOfPlayer2 = false
            }
        }
        //change text for player 1
        binding.textViewPiecesOfPlayer1.text = game.value!!.player1.stonesToPlace.toString()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun switchPlayer() {
        game.value?.switchPlayer()
        dispPlayer.value = game.value?.currentPlayer?.color?.name
    }

    private fun switchColorBlack(button: Button){
        ViewCompat.setBackgroundTintList(button, ContextCompat.getColorStateList(this, R.color.black))
    }

    private fun switchColorWhite(button: Button){
        ViewCompat.setBackgroundTintList(button, ContextCompat.getColorStateList(this, R.color.white))
    }

    private fun switchColorPurple(button: Button){
        ViewCompat.setBackgroundTintList(button, ContextCompat.getColorStateList(this, R.color.purple_500))
    }
}