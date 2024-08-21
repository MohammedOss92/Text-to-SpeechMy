package com.sarrawi.tts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AdapterView
import android.widget.Spinner
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sarrawi.tts.Adapter.AdapterWord
import com.sarrawi.tts.VModel.WordVM
import com.sarrawi.tts.model.SealedClass
import kotlinx.coroutines.launch
import java.util.*


class MainActivity3 : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var tts: TextToSpeech
    private lateinit var recyclerView: RecyclerView
    private lateinit var spinner: Spinner

    private lateinit var adapterWord: AdapterWord

    private val wordVM: WordVM by lazy {
        ViewModelProvider(this, WordVM.WordVMFactory(this.application))[WordVM::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // تهيئة TextToSpeech
        tts = TextToSpeech(this, this)

        recyclerView = findViewById(R.id.recyclerView)
        spinner = findViewById(R.id.spinner)

        // إعداد AdapterWord و RecyclerView
        adapterWord = AdapterWord(this@MainActivity3, tts)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity3)
        recyclerView.adapter = adapterWord

        // إعداد Spinner
        val spinnerAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.table_options,
            android.R.layout.simple_spinner_item
        )
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = spinnerAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> setUpRv(wordVM.getAllWords())
                    1 -> setUpRvTwo(wordVM.getAllWords_twoViewModel())
                    2 -> setUpRvThree(wordVM.getAllWord_threeViewModel())
                    3 -> setUpRvTb_Adjectives(wordVM.getAlltb_AdjectivesViewModel())
                    4 -> setUpRvTb_Clothes_and_toilet_articles(wordVM.getAlltb_Clothes_and_toilet_articlesViewModel())
                    5 -> setUpRvTb_Colours(wordVM.getAlltb_ColoursViewModel())
                    6 -> setUpRvTb_Family(wordVM.getAlltb_FamilyViewModel())
                    7 -> setUpRvTb_fruit(wordVM.getAlltb_fruitViewModel())
                    8 -> setUpRvTb_Houseandfurniture(wordVM.getAlltb_HouseandfurnitureViewModel())
                    9 -> setUpRvTb_Human_body(wordVM.getAlltb_Human_bodyViewModel())
                    10 -> setUpRvTb_Tb_jobs(wordVM.getAlltb_jobsViewModel())
                    11 -> setUpRvTb_Kitchen_tools(wordVM.getAlltb_Kitchen_toolsViewModel())
                    12 -> setUpRvTb_Tb_places(wordVM.getAlltb_placesViewModel())
                    13 -> setUpRvTb_Pronoun(wordVM.getAlltb_PronounViewModel())
                    14 -> setUpRvTb_school(wordVM.getAlltb_schoolViewModel())
                    15 -> setUpRvSimilar_words(wordVM.getAlltb_Similar_wordsViewModel())
                    16 -> setUpRvTb_The_animals(wordVM.getAlltb_The_animalsViewModel())
                    17 -> setUpRvTb_transports(wordVM.getAlltb_transportsViewModel())
                    18 -> setUpRvTv_verbs(wordVM.getAlltv_verbsViewModel())
                    // أضف المزيد من الحالات حسب الحاجة
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // لا شيء هنا
            }
        }
    }

    /* 0 -> setUpRecyclerView(wordVM.getAllWords(), SealedClass.Word::class.java)
            1 -> setUpRecyclerView(wordVM.getAllWords_twoViewModel(), SealedClass.Words_two::class.java)
            2 -> setUpRecyclerView(wordVM.getAllWords_threeViewModel(), SealedClass.Word_three::class.java)*/
    private fun <T> setUpRecyclerView(liveData: LiveData<List<T>>, itemType: Class<T>) {
        liveData.observe(this) { listShows ->
            // تحقق من النوع وتحديث adapterWord بناءً على ذلك
            when {
                itemType.isAssignableFrom(SealedClass.Word::class.java) -> {
                    @Suppress("UNCHECKED_CAST")
                    adapterWord.wordsList = listShows as List<SealedClass.Word>
                }
                itemType.isAssignableFrom(SealedClass.Words_two::class.java) -> {
                    @Suppress("UNCHECKED_CAST")
                    adapterWord.wordsList = listShows as List<SealedClass.Words_two>
                }
                itemType.isAssignableFrom(SealedClass.Word_three::class.java) -> {
                    @Suppress("UNCHECKED_CAST")
                    adapterWord.wordsList = listShows as List<SealedClass.Word_three>
                }
                // أضف المزيد من التحقق إذا لزم الأمر
            }
        }
    }



    private fun setUpRv(liveData: LiveData<List<SealedClass.Word>>) {
        liveData.observe(this) { listShows ->
            adapterWord.wordsList = listShows
        }
    }

    private fun setUpRvTwo(liveData: LiveData<List<SealedClass.Words_two>>) {
        liveData.observe(this) { listShows ->
            adapterWord.wordsList = listShows
        }
    }

    private fun setUpRvThree(liveData: LiveData<List<SealedClass.Word_three>>) {
        liveData.observe(this) { listShows ->
            adapterWord.wordsList = listShows
        }
    }

    private fun setUpRvTb_Adjectives(liveData: LiveData<List<SealedClass.Tb_Adjectives>>) {
        liveData.observe(this) { listShows ->
            adapterWord.wordsList = listShows
        }
    }

    private fun setUpRvTb_Clothes_and_toilet_articles(liveData: LiveData<List<SealedClass.Tb_Clothes_and_toilet_articles>>) {
        liveData.observe(this) { listShows ->
            adapterWord.wordsList = listShows
        }
    }

    private fun setUpRvTb_Colours(liveData: LiveData<List<SealedClass.Tb_Colours>>) {
        liveData.observe(this) { listShows ->
            adapterWord.wordsList = listShows
        }
    }

    private fun setUpRvTb_Family(liveData: LiveData<List<SealedClass.Tb_Family>>) {
        liveData.observe(this) { listShows ->
            adapterWord.wordsList = listShows
        }
    }

    private fun setUpRvTb_fruit(liveData: LiveData<List<SealedClass.Tb_fruit>>) {
        liveData.observe(this) { listShows ->
            adapterWord.wordsList = listShows
        }
    }

    private fun setUpRvTb_Houseandfurniture(liveData: LiveData<List<SealedClass.Tb_Houseandfurniture>>) {
        liveData.observe(this) { listShows ->
            adapterWord.wordsList = listShows
        }
    }

    private fun setUpRvTb_Human_body(liveData: LiveData<List<SealedClass.Tb_Human_body>>) {
        liveData.observe(this) { listShows ->
            adapterWord.wordsList = listShows
        }
    }

    private fun setUpRvTb_Tb_jobs(liveData: LiveData<List<SealedClass.Tb_jobs>>) {
        liveData.observe(this) { listShows ->
            adapterWord.wordsList = listShows
        }
    }

    private fun setUpRvTb_Kitchen_tools(liveData: LiveData<List<SealedClass.Tb_Kitchen_tools>>) {
        liveData.observe(this) { listShows ->
            adapterWord.wordsList = listShows
        }
    }

    private fun setUpRvTb_Tb_places(liveData: LiveData<List<SealedClass.Tb_places>>) {
        liveData.observe(this) { listShows ->
            adapterWord.wordsList = listShows
        }
    }

    private fun setUpRvTb_Pronoun(liveData: LiveData<List<SealedClass.Tb_Pronoun>>) {
        liveData.observe(this) { listShows ->
            adapterWord.wordsList = listShows
        }
    }

    private fun setUpRvTb_school(liveData: LiveData<List<SealedClass.Tb_school>>) {
        liveData.observe(this) { listShows ->
            adapterWord.wordsList = listShows
        }
    }

    private fun setUpRvSimilar_words(liveData: LiveData<List<SealedClass.Tb_Similar_words>>) {
        liveData.observe(this) { listShows ->
            adapterWord.wordsList = listShows
        }
    }

    private fun setUpRvTb_The_animals(liveData: LiveData<List<SealedClass.Tb_The_animals>>) {
        liveData.observe(this) { listShows ->
            adapterWord.wordsList = listShows
        }
    }

    private fun setUpRvTb_transports(liveData: LiveData<List<SealedClass.Tb_transports>>) {
        liveData.observe(this) { listShows ->
            adapterWord.wordsList = listShows
        }
    }

    private fun setUpRvTv_verbs(liveData: LiveData<List<SealedClass.Tv_verbs>>) {
        liveData.observe(this) { listShows ->
            adapterWord.wordsList = listShows
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            tts.language = Locale.US
        }
    }

    override fun onDestroy() {
        if (::tts.isInitialized) {
            tts.stop()
            tts.shutdown()
        }
        super.onDestroy()
    }
}
