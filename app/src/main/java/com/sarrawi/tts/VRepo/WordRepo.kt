package com.sarrawi.tts.VRepo

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.Query
import com.sarrawi.tts.model.SealedClass
import com.sarrawi.tts.model.Word
import com.sarrawi.tts.wordDb.DbWord
import com.sarrawi.tts.wordDb.WordsDao

class WordRepo (app: Application) {

    private var WordDao: WordsDao

    init{
        val database = DbWord.getInstance(app)
        WordDao = database.getWordsDao()

    }

    fun getAllWords(): LiveData<List<SealedClass.Word>> {
        return WordDao.getAllWordsDao()
    }

    fun searchRepo1(searchQuery: String): LiveData<List<SealedClass.Word>> {
        return WordDao.searchWords(searchQuery)
    }

    fun searchRepo2(searchQuery: String): LiveData<List<SealedClass.Words_two>> {
        return WordDao.searchWords2(searchQuery)
    }

    fun searchRepo3(searchQuery: String): LiveData<List<SealedClass.Word_three>> {
        return WordDao.searchWords3(searchQuery)
    }

    fun searchRepo4(searchQuery: String): LiveData<List<SealedClass.Tb_Adjectives>> {
        return WordDao.search4(searchQuery)
    }

    fun searchRepo5(searchQuery: String): LiveData<List<SealedClass.Tb_Clothes_and_toilet_articles>> {
        return WordDao.search5(searchQuery)
    }

    fun searchRepo6(searchQuery: String): LiveData<List<SealedClass.Tb_Colours>> {
        return WordDao.search6(searchQuery)
    }

    fun searchRepo7(searchQuery: String): LiveData<List<SealedClass.Tb_Family>> {
        return WordDao.search7(searchQuery)
    }

    fun searchRepo8(searchQuery: String): LiveData<List<SealedClass.Tb_fruit>> {
        return WordDao.search8(searchQuery)
    }

    fun searchRepo9(searchQuery: String): LiveData<List<SealedClass.Tb_Houseandfurniture>> {
        return WordDao.search9(searchQuery)
    }

    fun searchRepo10(searchQuery: String): LiveData<List<SealedClass.Tb_Human_body>> {
        return WordDao.search10(searchQuery)
    }

    fun searchRepo11(searchQuery: String): LiveData<List<SealedClass.Tb_jobs>> {
        return WordDao.search11(searchQuery)
    }

    fun searchRepo12(searchQuery: String): LiveData<List<SealedClass.Tb_Kitchen_tools>> {
        return WordDao.search12(searchQuery)
    }

    fun searchRepo13(searchQuery: String): LiveData<List<SealedClass.Tb_places>> {
        return WordDao.search13(searchQuery)
    }

    fun searchRepo14(searchQuery: String): LiveData<List<SealedClass.Tb_Pronoun>> {
        return WordDao.search14(searchQuery)
    }

    fun searchRepo15(searchQuery: String): LiveData<List<SealedClass.Tb_school>> {
        return WordDao.search15(searchQuery)
    }

    fun searchRepo16(searchQuery: String): LiveData<List<SealedClass.Tb_Similar_words>> {
        return WordDao.search16(searchQuery)
    }

    fun searchRepo17(searchQuery: String): LiveData<List<SealedClass.Tb_The_animals>> {
        return WordDao.search17(searchQuery)
    }

    fun searchRepo18(searchQuery: String): LiveData<List<SealedClass.Tb_transports>> {
        return WordDao.search18(searchQuery)
    }

    fun searchRepo19(searchQuery: String): LiveData<List<SealedClass.Tv_verbs>> {
        return WordDao.search19(searchQuery)
    }

    fun getAllWords_twoRepo(): LiveData<List<SealedClass.Words_two>>{
        return WordDao.getAllWords_twoDao()
    }

    fun getAllWord_threeRepo(): LiveData<List<SealedClass.Word_three>>{
        return WordDao.getAllWord_threeDao()
    }

    fun getAlltb_AdjectivesRepo(): LiveData<List<SealedClass.Tb_Adjectives>>{
        return WordDao.getAlltb_AdjectivesDao()
    }

    fun getAlltb_Clothes_and_toilet_articlesRepo(): LiveData<List<SealedClass.Tb_Clothes_and_toilet_articles>>{
        return WordDao.getAlltb_Clothes_and_toilet_articlesDao()
    }

    fun getAlltb_ColoursRepo(): LiveData<List<SealedClass.Tb_Colours>>{
        return WordDao.getAlltb_ColoursDao()
    }

    fun getAlltb_FamilyRepo(): LiveData<List<SealedClass.Tb_Family>>{
        return WordDao.getAlltb_FamilyDao()
    }

    fun getAlltb_fruitRepo(): LiveData<List<SealedClass.Tb_fruit>>{
        return WordDao.getAlltb_fruitDao()
    }

    fun getAlltb_HouseandfurnitureRepo(): LiveData<List<SealedClass.Tb_Houseandfurniture>>{
        return WordDao.getAlltb_HouseandfurnitureDao()
    }

    fun getAlltb_Human_bodyRepo(): LiveData<List<SealedClass.Tb_Human_body>>{
        return WordDao.getAlltb_Human_bodyDao()
    }

    fun getAlltb_jobsRepo(): LiveData<List<SealedClass.Tb_jobs>>{
        return WordDao.getAlltb_jobsDao()
    }

    fun getAlltb_Kitchen_toolsRepo(): LiveData<List<SealedClass.Tb_Kitchen_tools>>{
        return WordDao.getAlltb_Kitchen_toolsDao()
    }

    fun getAlltb_placesRepo(): LiveData<List<SealedClass.Tb_places>>{
        return WordDao.getAlltb_placesDao()
    }

    fun getAlltb_PronounRepo(): LiveData<List<SealedClass.Tb_Pronoun>>{
        return WordDao.getAlltb_PronounDao()
    }

    fun getAlltb_schoolRepo(): LiveData<List<SealedClass.Tb_school>>{
        return WordDao.getAlltb_schoolDao()
    }

    fun getAlltb_Similar_wordsRepo(): LiveData<List<SealedClass.Tb_Similar_words>>{
        return WordDao.getAlltb_Similar_wordsDao()
    }

    fun getAlltb_The_animalsRepo(): LiveData<List<SealedClass.Tb_The_animals>>{
        return WordDao.getAlltb_The_animalsDao()
    }

    fun getAlltb_transportsRepo(): LiveData<List<SealedClass.Tb_transports>>{
        return WordDao.getAlltb_transportsDao()
    }

    fun getAlltv_verbsRepo(): LiveData<List<SealedClass.Tv_verbs>>{
        return WordDao.getAlltv_verbsDao()
    }

        suspend fun setBookmarkForWord(newBookmark: SealedClass.Word) {
        WordDao.setBookmarkForWord(newBookmark)
    }

    // ������� ������ ����� ������ ����� �� ���� Words_two
    suspend fun setBookmarkForWordsTwo(newBookmark: SealedClass.Words_two) {
        WordDao.setBookmarkForWordsTwo(newBookmark)
    }


}