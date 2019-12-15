package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel(private val finalScore: Int) :ViewModel(){
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score
    private val _playAgain = MutableLiveData<Boolean>()
    val playAgain: LiveData<Boolean>
        get() = _playAgain
    init{
        Log.i("ScoreViewModel", "ScoreViewModel Called")
        _score.value = finalScore
    }

    fun onPlayAgain(){
        _playAgain.value = true
    }

    fun onPlayAgainComplete(){
        _playAgain.value = false
    }
}