package com.sarrawi.tts.VRepo

import android.app.Application
import androidx.lifecycle.LiveData
import com.sarrawi.tts.model.Word
import com.sarrawi.tts.wordDb.DbWord
import com.sarrawi.tts.wordDb.WordsDao

class WordRepo (app: Application) {

    private var WordDao: WordsDao

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