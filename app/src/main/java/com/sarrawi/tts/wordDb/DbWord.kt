package com.sarrawi.tts.wordDb


import android.content.Context
import androidx.room.Database
import androidx.room.Room

import androidx.room.RoomDatabase
import com.sarrawi.tts.model.SealedClass
import com.sarrawi.tts.model.Word


@Database(entities = [SealedClass.Word::class,SealedClass.Words_two::class,SealedClass.Word_three::class,SealedClass.Tb_Adjectives::class,SealedClass.Tb_Clothes_and_toilet_articles::class,SealedClass.Tb_Colours::class,SealedClass.Tb_Family::class,SealedClass.Tb_fruit::class,SealedClass.Tb_Houseandfurniture::class,SealedClass.Tb_Human_body::class,SealedClass.Tb_jobs::class,SealedClass.Tb_Kitchen_tools::class,SealedClass.Tb_places::class,SealedClass.Tb_Pronoun::class,SealedClass.Tb_school::class,SealedClass.Tb_Similar_words::class,SealedClass.Tb_The_animals::class,SealedClass.Tb_transports::class,SealedClass.Tv_verbs::class], version = 1, exportSchema = false)
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