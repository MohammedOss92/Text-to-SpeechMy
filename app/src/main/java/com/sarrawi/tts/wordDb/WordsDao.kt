package com.sarrawi.tts.wordDb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.sarrawi.tts.model.SealedClass
import com.sarrawi.tts.model.Word

@Dao
interface WordsDao {

    @Query("select * from Words")
    fun getAllWordsDao(): LiveData<List<SealedClass.Word>>

    @Query("select * from Words_two")
    fun getAllWords_twoDao(): LiveData<List<SealedClass.Words_two>>

    @Query("select * from Word_three")
    fun getAllWord_threeDao(): LiveData<List<SealedClass.Word_three>>

    @Query("select * from tb_Adjectives")
    fun getAlltb_AdjectivesDao(): LiveData<List<SealedClass.Tb_Adjectives>>

    @Query("select * from tb_Clothes_and_toilet_articles")
    fun getAlltb_Clothes_and_toilet_articlesDao(): LiveData<List<SealedClass.Tb_Clothes_and_toilet_articles>>

    @Query("select * from tb_Colours")
    fun getAlltb_ColoursDao(): LiveData<List<SealedClass.Tb_Colours>>

    @Query("select * from tb_Family")
    fun getAlltb_FamilyDao(): LiveData<List<SealedClass.Tb_Family>>

    @Query("select * from tb_fruit")
    fun getAlltb_fruitDao(): LiveData<List<SealedClass.Tb_fruit>>

    @Query("select * from tb_Houseandfurniture")
    fun getAlltb_HouseandfurnitureDao(): LiveData<List<SealedClass.Tb_Houseandfurniture>>

    @Query("select * from tb_Human_body")
    fun getAlltb_Human_bodyDao(): LiveData<List<SealedClass.Tb_Human_body>>

    @Query("select * from tb_jobs")
    fun getAlltb_jobsDao(): LiveData<List<SealedClass.Tb_jobs>>

    @Query("select * from tb_Kitchen_tools")
    fun getAlltb_Kitchen_toolsDao(): LiveData<List<SealedClass.Tb_Kitchen_tools>>

    @Query("select * from tb_places")
    fun getAlltb_placesDao(): LiveData<List<SealedClass.Tb_places>>

    @Query("select * from tb_Pronoun")
    fun getAlltb_PronounDao(): LiveData<List<SealedClass.Tb_Pronoun>>

    @Query("select * from tb_school")
    fun getAlltb_schoolDao(): LiveData<List<SealedClass.Tb_school>>

    @Query("select * from tb_Similar_words")
    fun getAlltb_Similar_wordsDao(): LiveData<List<SealedClass.Tb_Similar_words>>

    @Query("select * from tb_The_animals")
    fun getAlltb_The_animalsDao(): LiveData<List<SealedClass.Tb_The_animals>>

    @Query("select * from tb_transports")
    fun getAlltb_transportsDao(): LiveData<List<SealedClass.Tb_transports>>

    @Query("select * from tv_verbs")
    fun getAlltv_verbsDao(): LiveData<List<SealedClass.Tv_verbs>>

    @Query("SELECT * FROM Words WHERE ID LIKE :searchQuery " +
            "OR English_Word LIKE :searchQuery " +
            "OR Arabic_Word LIKE :searchQuery")
    fun searchWords(searchQuery: String): LiveData<List<SealedClass.Word>>

}