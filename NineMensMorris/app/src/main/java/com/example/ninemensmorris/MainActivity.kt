package com.example.ninemensmorris

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
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

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        game.value = Game(Board())
        binding.testButton1.setOnClickListener { view ->
            switchPlayer();
            binding.textViewPlayerActive.setText(dispPlayer.value.toString())
            switchColorPurple(binding.placeholder000)
        }
        binding.testButton2.setOnClickListener { view ->
            switchColorBlack(binding.placeholder000)
        }
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

    fun switchPlayer() {
        game.value?.switchPlayer()
        dispPlayer.value = game.value?.currentPlayer?.color?.name
    }

    fun switchColorBlack(button: Button){
        ViewCompat.setBackgroundTintList(button, ContextCompat.getColorStateList(this, R.color.black))
    }

    fun switchColorWhite(button: Button){
        ViewCompat.setBackgroundTintList(button, ContextCompat.getColorStateList(this, R.color.white))
    }

    fun switchColorPurple(button: Button){
        ViewCompat.setBackgroundTintList(button, ContextCompat.getColorStateList(this, R.color.purple_500))
    }

    /*override fun onClick(click: View?) {
        TODO("Not yet implemented")
    }*/
}