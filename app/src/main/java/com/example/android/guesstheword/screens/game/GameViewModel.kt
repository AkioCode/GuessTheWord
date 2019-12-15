package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel(){
    private val _word = MutableLiveData<String>()
    val word: LiveData<String>
        get() = _word
    private val _score =MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score
    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish
    private lateinit var wordList: MutableList<String>



    init {
        Log.i("GameViewModel","Here is GameViewModel !")
        _word.value = ""
        _score.value = 0
        resetList()
        nextWord()
    }

    fun resetList() {
        wordList = mutableListOf(
                "queen",
                "hospital",
                "basketball",
                "cat",
                "change",
                "snail",
                "soup",
                "calendar",
                "sad",
                "desk",
                "guitar",
                "home",
                "railway",
                "zebra",
                "jelly",
                "car",
                "crow",
                "trade",
                "bag",
                "roll",
                "bubble"
        )
        wordList.shuffle()
    }
    fun nextWord() {
        if (!wordList.isEmpty()) {
            //Select and remove a word from the list
            _word.value = wordList.removeAt(0)
        }
        else
            onGameFinished()
    }
    fun onSkip() {
        if (!wordList.isEmpty()) {
            _score.value = (_score.value)?.minus(1)
        }
        nextWord()
    }

    fun onCorrect() {
        if (!wordList.isEmpty()) {
            _score.value = (_score.value)?.plus(1)
        }
        nextWord()
    }

    fun onGameFinished(){
        _eventGameFinish.value = true
    }

    fun onGameFinishedComplete(){
        _eventGameFinish.value = false
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel","GameViewModel cleaned!")
    }
}