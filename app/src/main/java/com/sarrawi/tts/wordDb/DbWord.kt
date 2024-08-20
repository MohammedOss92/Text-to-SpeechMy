package com.sarrawi.tts.wordDb


import android.content.Context
import androidx.room.Database
import androidx.room.Room

import androidx.room.RoomDatabase
import com.sarrawi.tts.model.Word


@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class DbWord : RoomDatabase() {

    abstract fun getWordsDao(): WordsDao


    companion object {
        @Volatile
        private var instance: DbWord? = null

        fun getInstance(con: Context): DbWord {
            if (instance == null) {
                synchronized(DbWord::class.java) {
                    if (instance == null) {
                        instance = Room.databaseBuilder(
                            con.applicationContext,
                            DbWord::class.java,
//                            "aa.db"
                            "words.db"
                        )
//                            .fallbackToDestructiveMigration()
                            .createFromAsset("database/words.db")
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return instance!!
        }

    }
}