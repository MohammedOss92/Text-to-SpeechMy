package com.sarrawi.tts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AdapterView
import androidx.appcompat.widget.SearchView
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
//                    0 -> setUpRv(wordVM.getAllWords())
//                    1 -> setUpRvTwo(wordVM.getAllWords_twoViewModel())
//                    2 -> setUpRvThree(wordVM.getAllWord_threeViewModel())

                    0 -> setUpRecyclerView(wordVM.getAllWords(), SealedClass.Word::class.java)
                    1 -> setUpRecyclerView(wordVM.getAllWords_twoViewModel(), SealedClass.Words_two::class.java)
                    2  -> setUpRecyclerView(wordVM.getAllWord_threeViewModel(), SealedClass.Word_three::class.java)
                    3 -> setUpRecyclerView(wordVM.getAlltb_AdjectivesViewModel(), SealedClass.Tb_Adjectives::class.java)
                    4 -> setUpRecyclerView(wordVM.getAlltb_Clothes_and_toilet_articlesViewModel(), SealedClass.Tb_Clothes_and_toilet_articles::class.java)
                    5 -> setUpRecyclerView(wordVM.getAlltb_ColoursViewModel(), SealedClass.Tb_Colours::class.java)
                    6 -> setUpRecyclerView(wordVM.getAlltb_FamilyViewModel(), SealedClass.Tb_Family::class.java)
                    7 -> setUpRecyclerView(wordVM.getAlltb_fruitViewModel(), SealedClass.Tb_fruit::class.java)
                    8 -> setUpRecyclerView(wordVM.getAlltb_HouseandfurnitureViewModel(), SealedClass.Tb_Houseandfurniture::class.java)
                    9 -> setUpRecyclerView(wordVM.getAlltb_Human_bodyViewModel(), SealedClass.Tb_Human_body::class.java)
                    10-> setUpRecyclerView(wordVM.getAlltb_jobsViewModel(), SealedClass.Tb_jobs::class.java)
                    11 -> setUpRecyclerView(wordVM.getAlltb_Kitchen_toolsViewModel(), SealedClass.Tb_Kitchen_tools::class.java)
                    12 -> setUpRecyclerView(wordVM.getAlltb_placesViewModel(), SealedClass.Tb_places::class.java)
                    13 -> setUpRecyclerView(wordVM.getAlltb_PronounViewModel(), SealedClass.Tb_Pronoun::class.java)
                    14 -> setUpRecyclerView(wordVM.getAlltb_schoolViewModel(), SealedClass.Tb_school::class.java)
                    15 -> setUpRecyclerView(wordVM.getAlltb_Similar_wordsViewModel(), SealedClass.Tb_Similar_words::class.java)
                    16 -> setUpRecyclerView(wordVM.getAlltb_The_animalsViewModel(), SealedClass.Tb_The_animals::class.java)
                    17 -> setUpRecyclerView(wordVM.getAlltb_transportsViewModel(), SealedClass.Tb_transports::class.java)
                    18 -> setUpRecyclerView(wordVM.getAlltv_verbsViewModel(), SealedClass.Tv_verbs::class.java)
                    // أضف المزيد من الحالات حسب الحاجة
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // لا شيء هنا
            }
        }

        val searchView = findViewById<SearchView>(R.id.searchView)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapterWord.filter.filter(newText)
                return false
            }
        })

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
                    adapterWord.wordsListFull = listShows
                }
                itemType.isAssignableFrom(SealedClass.Words_two::class.java) -> {
                    @Suppress("UNCHECKED_CAST")
                    adapterWord.wordsList = listShows as List<SealedClass.Words_two>
                }
                itemType.isAssignableFrom(SealedClass.Word_three::class.java) -> {
                    @Suppress("UNCHECKED_CAST")
                    adapterWord.wordsList = listShows as List<SealedClass.Word_three>
                }

                itemType.isAssignableFrom(SealedClass.Tb_Adjectives::class.java) -> {
                    @Suppress("UNCHECKED_CAST")
                    adapterWord.wordsList = listShows as List<SealedClass.Tb_Adjectives>
                }

                itemType.isAssignableFrom(SealedClass.Tb_Clothes_and_toilet_articles::class.java) -> {
                    @Suppress("UNCHECKED_CAST")
                    adapterWord.wordsList = listShows as List<SealedClass.Tb_Clothes_and_toilet_articles>
                }

                itemType.isAssignableFrom(SealedClass.Tb_Colours::class.java) -> {
                    @Suppress("UNCHECKED_CAST")
                    adapterWord.wordsList = listShows as List<SealedClass.Tb_Colours>
                }

                itemType.isAssignableFrom(SealedClass.Tb_Family::class.java) -> {
                    @Suppress("UNCHECKED_CAST")
                    adapterWord.wordsList = listShows as List<SealedClass.Tb_Family>
                }

                itemType.isAssignableFrom(SealedClass.Tb_fruit::class.java) -> {
                    @Suppress("UNCHECKED_CAST")
                    adapterWord.wordsList = listShows as List<SealedClass.Tb_fruit>
                }

                itemType.isAssignableFrom(SealedClass.Tb_Houseandfurniture::class.java) -> {
                    @Suppress("UNCHECKED_CAST")
                    adapterWord.wordsList = listShows as List<SealedClass.Tb_Houseandfurniture>
                }

                itemType.isAssignableFrom(SealedClass.Tb_Human_body::class.java) -> {
                    @Suppress("UNCHECKED_CAST")
                    adapterWord.wordsList = listShows as List<SealedClass.Tb_Human_body>
                }

                itemType.isAssignableFrom(SealedClass.Tb_Kitchen_tools::class.java) -> {
                    @Suppress("UNCHECKED_CAST")
                    adapterWord.wordsList = listShows as List<SealedClass.Tb_Kitchen_tools>
                }

                itemType.isAssignableFrom(SealedClass.Tb_jobs::class.java) -> {
                    @Suppress("UNCHECKED_CAST")
                    adapterWord.wordsList = listShows as List<SealedClass.Tb_jobs>
                }

                itemType.isAssignableFrom(SealedClass.Tb_places::class.java) -> {
                    @Suppress("UNCHECKED_CAST")
                    adapterWord.wordsList = listShows as List<SealedClass.Tb_places>
                }

                itemType.isAssignableFrom(SealedClass.Tb_Pronoun::class.java) -> {
                    @Suppress("UNCHECKED_CAST")
                    adapterWord.wordsList = listShows as List<SealedClass.Tb_Pronoun>
                }

                itemType.isAssignableFrom(SealedClass.Tb_school::class.java) -> {
                    @Suppress("UNCHECKED_CAST")
                    adapterWord.wordsList = listShows as List<SealedClass.Tb_school>
                }

                itemType.isAssignableFrom(SealedClass.Tb_Similar_words::class.java) -> {
                    @Suppress("UNCHECKED_CAST")
                    adapterWord.wordsList = listShows as List<SealedClass.Tb_Similar_words>
                }

                itemType.isAssignableFrom(SealedClass.Tb_The_animals::class.java) -> {
                    @Suppress("UNCHECKED_CAST")
                    adapterWord.wordsList = listShows as List<SealedClass.Tb_The_animals>
                }

                itemType.isAssignableFrom(SealedClass.Tb_transports::class.java) -> {
                    @Suppress("UNCHECKED_CAST")
                    adapterWord.wordsList = listShows as List<SealedClass.Tb_transports>
                }

                itemType.isAssignableFrom(SealedClass.Tv_verbs::class.java) -> {
                    @Suppress("UNCHECKED_CAST")
                    adapterWord.wordsList = listShows as List<SealedClass.Tv_verbs>
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
