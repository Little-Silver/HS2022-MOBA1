package com.example.ninemensmorris

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.ninemensmorris.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    //, View.OnClickListener
    private lateinit var binding: ActivityMainBinding
    private var game = Game()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var text = game.currentPlayer.color.name

        binding.placeholder000.setOnClickListener { view ->
            Snackbar.make(view, "Button 1 clicked", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        binding.testButton1.setOnClickListener { view ->
            Snackbar.make(view, text, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        binding.testButton2.setOnClickListener { view ->
            Snackbar.make(view, "Test Button 2 clicked", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
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

    /*override fun onClick(click: View?) {
        TODO("Not yet implemented")
    }*/
}