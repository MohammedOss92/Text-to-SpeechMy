package com.sarrawi.tts.VModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sarrawi.tts.VRepo.WordRepo
import com.sarrawi.tts.model.SealedClass
import com.sarrawi.tts.model.Word

class WordVM constructor(application : Application) : ViewModel() {


    private val wordRepo: WordRepo = WordRepo(application)

    fun getAllWords(): LiveData<List<SealedClass.Word>> = wordRepo.getAllWords()

    fun SearchViewModel(searchQuery: String): LiveData<List<SealedClass.Word>> = wordRepo.searchRepo(searchQuery)

    fun getAllWords_twoViewModel(): LiveData<List<SealedClass.Words_two>> = wordRepo.getAllWords_twoRepo()

    fun getAllWord_threeViewModel(): LiveData<List<SealedClass.Word_three>> = wordRepo.getAllWord_threeRepo()

    fun getAlltb_AdjectivesViewModel(): LiveData<List<SealedClass.Tb_Adjectives>> = wordRepo.getAlltb_AdjectivesRepo()

    fun getAlltb_Clothes_and_toilet_articlesViewModel(): LiveData<List<SealedClass.Tb_Clothes_and_toilet_articles>> = wordRepo.getAlltb_Clothes_and_toilet_articlesRepo()

    fun getAlltb_ColoursViewModel(): LiveData<List<SealedClass.Tb_Colours>> = wordRepo.getAlltb_ColoursRepo()

    fun getAlltb_FamilyViewModel(): LiveData<List<SealedClass.Tb_Family>> = wordRepo.getAlltb_FamilyRepo()

    fun getAlltb_fruitViewModel(): LiveData<List<SealedClass.Tb_fruit>> = wordRepo.getAlltb_fruitRepo()

    fun getAlltb_HouseandfurnitureViewModel(): LiveData<List<SealedClass.Tb_Houseandfurniture>> = wordRepo.getAlltb_HouseandfurnitureRepo()

    fun getAlltb_Human_bodyViewModel(): LiveData<List<SealedClass.Tb_Human_body>> = wordRepo.getAlltb_Human_bodyRepo()

    fun getAlltb_jobsViewModel(): LiveData<List<SealedClass.Tb_jobs>> = wordRepo.getAlltb_jobsRepo()

    fun getAlltb_Kitchen_toolsViewModel(): LiveData<List<SealedClass.Tb_Kitchen_tools>> = wordRepo.getAlltb_Kitchen_toolsRepo()

    fun getAlltb_placesViewModel(): LiveData<List<SealedClass.Tb_places>> = wordRepo.getAlltb_placesRepo()

    fun getAlltb_PronounViewModel(): LiveData<List<SealedClass.Tb_Pronoun>> = wordRepo.getAlltb_PronounRepo()

    fun getAlltb_schoolViewModel(): LiveData<List<SealedClass.Tb_school>> = wordRepo.getAlltb_schoolRepo()

    fun getAlltb_Similar_wordsViewModel(): LiveData<List<SealedClass.Tb_Similar_words>> = wordRepo.getAlltb_Similar_wordsRepo()

    fun getAlltb_The_animalsViewModel(): LiveData<List<SealedClass.Tb_The_animals>> = wordRepo.getAlltb_The_animalsRepo()

    fun getAlltb_transportsViewModel(): LiveData<List<SealedClass.Tb_transports>> = wordRepo.getAlltb_transportsRepo()

    fun getAlltv_verbsViewModel(): LiveData<List<SealedClass.Tv_verbs>> = wordRepo.getAlltv_verbsRepo()

    class WordVMFactory(private val application: Application): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(WordVM::class.java)){
                @Suppress("UNCHECKED_CAST")
                return WordVM(application) as T
            }
            throw IllegalArgumentException("Unable Constructore View Model")
        }
    }
}