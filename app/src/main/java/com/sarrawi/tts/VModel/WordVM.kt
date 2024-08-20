package com.sarrawi.tts.VModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sarrawi.tts.VRepo.WordRepo
import com.sarrawi.tts.model.Word

class WordVM constructor(application : Application) : ViewModel() {


    private val wordRepo: WordRepo = WordRepo(application)

    fun getAllWords(): LiveData<List<Word>> = wordRepo.getAllWords()

    fun SearchViewModel(searchQuery: String): LiveData<List<Word>> = wordRepo.searchRepo(searchQuery)

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