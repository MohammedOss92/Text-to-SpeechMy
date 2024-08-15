package com.sarrawi.tts.wordDb

import android.app.Application
import androidx.lifecycle.LiveData

class WordRepo (app: Application) {

    private var WordDao:WordsDao

    init{
        val database = DbWord.getInstance(app)
        WordDao = database.getWordsDao()

    }

    fun getAllWords(): LiveData<List<Word>> {
        return WordDao.getAllWordsDao()
    }

    fun searchRepo(searchQuery: String): LiveData<List<Word>> {
        return WordDao.searchWords(searchQuery)
    }
}