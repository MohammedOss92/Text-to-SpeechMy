package com.sarrawi.tts.wordDb


import android.content.Context
import androidx.room.Database
import androidx.room.Room

import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.impl.WorkDatabaseMigrations.MIGRATION_1_2
import com.sarrawi.tts.model.SealedClass
import com.sarrawi.tts.model.Word
//
//
//@Database(entities = [SealedClass.Word::class,SealedClass.Words_two::class,SealedClass.Word_three::class,SealedClass.Tb_Adjectives::class,SealedClass.Tb_Clothes_and_toilet_articles::class,SealedClass.Tb_Colours::class,SealedClass.Tb_Family::class,SealedClass.Tb_fruit::class,SealedClass.Tb_Houseandfurniture::class,SealedClass.Tb_Human_body::class,SealedClass.Tb_jobs::class,SealedClass.Tb_Kitchen_tools::class,SealedClass.Tb_places::class,SealedClass.Tb_Pronoun::class,SealedClass.Tb_school::class,SealedClass.Tb_Similar_words::class,SealedClass.Tb_The_animals::class,SealedClass.Tb_transports::class,SealedClass.Tv_verbs::class], version = 2, exportSchema = false)
//abstract class DbWord : RoomDatabase() {
//
//    abstract fun getWordsDao(): WordsDao
//
//
//    companion object {
//        @Volatile
//        private var instance: DbWord? = null
//
//        val MIGRATION_1_2 = object : Migration(1, 2) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                // Update the table schema
//                database.execSQL("ALTER TABLE Words ADD COLUMN bookmark INTEGER NOT NULL DEFAULT 0")
//            }
//        }
//
//        fun getInstance(con: Context): DbWord {
//            if (instance == null) {
//                synchronized(DbWord::class.java) {
//                    if (instance == null) {
//                        instance = Room.databaseBuilder(
//                            con.applicationContext,
//                            DbWord::class.java,
//                            "words.db"
//                        )
//                            .createFromAsset("database/words.db")
//                            .addMigrations(MIGRATION_1_2)  // Include the migration
//                            .fallbackToDestructiveMigration()
//                            .build()
//                    }
//                }
//            }
//
//            return instance!!
//        }
//    }
//
//    }

@Database(entities = [SealedClass.Word::class,SealedClass.Words_two::class,SealedClass.Word_three::class,SealedClass.Tb_Adjectives::class,SealedClass.Tb_Clothes_and_toilet_articles::class,SealedClass.Tb_Colours::class,SealedClass.Tb_Family::class,SealedClass.Tb_fruit::class,SealedClass.Tb_Houseandfurniture::class,SealedClass.Tb_Human_body::class,SealedClass.Tb_jobs::class,SealedClass.Tb_Kitchen_tools::class,SealedClass.Tb_places::class,SealedClass.Tb_Pronoun::class,SealedClass.Tb_school::class,SealedClass.Tb_Similar_words::class,SealedClass.Tb_The_animals::class,SealedClass.Tb_transports::class,SealedClass.Tv_verbs::class], version = 2, exportSchema = false)
abstract class DbWord : RoomDatabase() {
    abstract fun getWordsDao(): WordsDao

    companion object {


        @Volatile
        private var instance: DbWord? = null

        fun getInstance(con: Context): DbWord {
            return instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    con.applicationContext,
                    DbWord::class.java,
                    "words.db"
                )
                    .addMigrations(MIGRATION_1_2)
                    .createFromAsset("database/words.db") // تأكد من أن هذا صحيح
                    .build()
                    .also { instance = it }
            }
        }

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Update the table schema
                database.execSQL("ALTER TABLE Words ADD COLUMN bookmark INTEGER NOT NULL DEFAULT 0")
                database.execSQL("ALTER TABLE Words_two ADD COLUMN bookmark INTEGER NOT NULL DEFAULT 0")
                database.execSQL("ALTER TABLE Word_three ADD COLUMN bookmark INTEGER NOT NULL DEFAULT 0")
                database.execSQL("ALTER TABLE tb_Adjectives ADD COLUMN bookmark INTEGER NOT NULL DEFAULT 0")
                database.execSQL("ALTER TABLE tb_Clothes_and_toilet_articles ADD COLUMN bookmark INTEGER NOT NULL DEFAULT 0")
                database.execSQL("ALTER TABLE tb_Colours ADD COLUMN bookmark INTEGER NOT NULL DEFAULT 0")
                database.execSQL("ALTER TABLE tb_Family ADD COLUMN bookmark INTEGER NOT NULL DEFAULT 0")
                database.execSQL("ALTER TABLE tb_fruit ADD COLUMN bookmark INTEGER NOT NULL DEFAULT 0")
                database.execSQL("ALTER TABLE tb_Houseandfurniture ADD COLUMN bookmark INTEGER NOT NULL DEFAULT 0")
                database.execSQL("ALTER TABLE tb_Human_body ADD COLUMN bookmark INTEGER NOT NULL DEFAULT 0")
                database.execSQL("ALTER TABLE tb_jobs ADD COLUMN bookmark INTEGER NOT NULL DEFAULT 0")
                database.execSQL("ALTER TABLE tb_Kitchen_tools ADD COLUMN bookmark INTEGER NOT NULL DEFAULT 0")
                database.execSQL("ALTER TABLE tb_places ADD COLUMN bookmark INTEGER NOT NULL DEFAULT 0")
                database.execSQL("ALTER TABLE tb_Pronoun ADD COLUMN bookmark INTEGER NOT NULL DEFAULT 0")
                database.execSQL("ALTER TABLE tb_school ADD COLUMN bookmark INTEGER NOT NULL DEFAULT 0")
                database.execSQL("ALTER TABLE tb_Similar_words ADD COLUMN bookmark INTEGER NOT NULL DEFAULT 0")
                database.execSQL("ALTER TABLE tb_The_animals ADD COLUMN bookmark INTEGER NOT NULL DEFAULT 0")
                database.execSQL("ALTER TABLE tb_transports ADD COLUMN bookmark INTEGER NOT NULL DEFAULT 0")
                database.execSQL("ALTER TABLE tv_verbs ADD COLUMN bookmark INTEGER NOT NULL DEFAULT 0")
            }
        }
    }
}
