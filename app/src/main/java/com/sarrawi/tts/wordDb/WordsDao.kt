package com.sarrawi.tts.wordDb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface WordsDao {

    @Query("select * from Words")
    fun getAllWordsDao(): LiveData<List<Word>>

    @Query("SELECT * FROM Words WHERE ID LIKE :searchQuery " +
            "OR English_Word LIKE :searchQuery " +
            "OR Arabic_Word LIKE :searchQuery")
    fun searchWords(searchQuery: String): LiveData<List<Word>>

}