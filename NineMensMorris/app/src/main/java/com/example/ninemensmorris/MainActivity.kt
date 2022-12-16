package com.example.ninemensmorris

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.ninemensmorris.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private var clickList : MutableList<Placeholder> = mutableListOf()
    private val mutableDict : MutableMap<Placeholder, Button> = mutableMapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.game.value = Game(Board())
        viewModel.dispPlayer.value = ""

        mutableDict[viewModel.game.value!!.board.p000] = binding.placeholder000
        mutableDict[viewModel.game.value!!.board.p001] = binding.placeholder001
        mutableDict[viewModel.game.value!!.board.p002] = binding.placeholder002
        mutableDict[viewModel.game.value!!.board.p010] = binding.placeholder010
        mutableDict[viewModel.game.value!!.board.p020] = binding.placeholder020
        mutableDict[viewModel.game.value!!.board.p100] = binding.placeholder100
        mutableDict[viewModel.game.value!!.board.p012] = binding.placeholder012
        mutableDict[viewModel.game.value!!.board.p021] = binding.placeholder021
        mutableDict[viewModel.game.value!!.board.p022] = binding.placeholder022

        mutableDict[viewModel.game.value!!.board.p101] = binding.placeholder101
        mutableDict[viewModel.game.value!!.board.p102] = binding.placeholder102
        mutableDict[viewModel.game.value!!.board.p110] = binding.placeholder110
        mutableDict[viewModel.game.value!!.board.p112] = binding.placeholder112
        mutableDict[viewModel.game.value!!.board.p120] = binding.placeholder120
        mutableDict[viewModel.game.value!!.board.p121] = binding.placeholder121
        mutableDict[viewModel.game.value!!.board.p122] = binding.placeholder122

        mutableDict[viewModel.game.value!!.board.p200] = binding.placeholder200
        mutableDict[viewModel.game.value!!.board.p201] = binding.placeholder201
        mutableDict[viewModel.game.value!!.board.p202] = binding.placeholder202
        mutableDict[viewModel.game.value!!.board.p210] = binding.placeholder210
        mutableDict[viewModel.game.value!!.board.p212] = binding.placeholder212
        mutableDict[viewModel.game.value!!.board.p221] = binding.placeholder221
        mutableDict[viewModel.game.value!!.board.p222] = binding.placeholder222
        mutableDict[viewModel.game.value!!.board.p220] = binding.placeholder220

        for (mutableEntry in mutableDict) {
            mutableEntry.value.setOnClickListener(View.OnClickListener {
                clickList.add(mutableEntry.key)
                viewModel.game.value!!.move(clickList)
                refresh()
            })
        }

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

    private fun refresh() {
        for (mutableEntry in mutableDict) {
            when (mutableEntry.key.state) {
                State.WHITE -> switchColorWhite(mutableEntry.value)
                State.BLACK -> switchColorBlack(mutableEntry.value)
                else -> switchColorPurple(mutableEntry.value)
            }
        }
        viewModel.dispPlayer.value = viewModel.game.value!!.currentPlayer.color.toString()
        viewModel.dispState.value = viewModel.game.value!!.state.toString()
        viewModel.p1Pieces.value = viewModel.game.value!!.player1.stonesToPlace.toString()
        viewModel.p2Pieces.value = viewModel.game.value!!.player2.stonesToPlace.toString()
        viewModel.p1State.value = viewModel.game.value!!.player1.playerState.toString()
        viewModel.p2State.value = viewModel.game.value!!.player2.playerState.toString()
        viewModel.winner.value = viewModel.game.value!!.winner.toString()
        viewModel.error.value = viewModel.game.value!!.error
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

}