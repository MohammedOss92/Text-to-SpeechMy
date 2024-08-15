package com.sarrawi.tts
//
//import android.os.Bundle
//import android.speech.tts.TextToSpeech
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import java.util.Locale
//
//class MainActivity2 : AppCompatActivity(), TextToSpeech.OnInitListener {
//
//    private lateinit var tts: TextToSpeech
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var adapter: WordAdapter
//    private var wordList = mutableListOf<Pair<String, String>>()
//    private var oldList = wordList.toList() // لحفظ القائمة القديمة
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main2)
//
//        recyclerView = findViewById(R.id.recyclerView)
//        tts = TextToSpeech(this, this)
//
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        adapter = WordAdapter(this, wordList, tts)
//        recyclerView.adapter = adapter
//
//        // تحميل البيانات
//        loadData()
//    }
//
//    private fun loadData() {
//        val newList = mutableListOf<Pair<String, String>>()
//        newList.add("Word " to "معنى ")
//
//        val wordList = listOf(
//            "Hello" to "مرحبا",
//            "Goodbye" to "وداعا",
//            "Thank you" to "شكرا"
//            // أضف المزيد من الكلمات والمعاني هنا
//        )
//        // استخدام DiffUtil لتحديث RecyclerView
//        val diffCallback = WordDiffCallback(oldList, newList)
//        val diffResult = DiffUtil.calculateDiff(diffCallback)
//
//        wordList = newList
//        diffResult.dispatchUpdatesTo(adapter)
//        oldList = newList // تحديث القائمة القديمة
//    }
//
//    override fun onInit(status: Int) {
//        if (status == TextToSpeech.SUCCESS) {
//            tts.language = Locale.US
//        }
//    }
//
//    override fun onDestroy() {
//        if (::tts.isInitialized) {
//            tts.stop()
//            tts.shutdown()
//        }
//        super.onDestroy()
//    }
//}
//



import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale
import androidx.recyclerview.widget.LinearLayoutManager
import com.sarrawi.tts.wordDb.WordVM
import kotlinx.coroutines.launch


class MainActivity2 : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var tts: TextToSpeech
    private lateinit var recyclerView: RecyclerView
    private lateinit var wordAdapter: WordAdapter

    private val wordVM: WordVM by lazy {
        ViewModelProvider(this, WordVM.WordVMFactory(this.application))[WordVM::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        recyclerView = findViewById(R.id.recyclerView)
        setUpRv()
        // تهيئة TextToSpeech
        tts = TextToSpeech(this, this)
    }

    private fun setUpRv() = wordVM.viewModelScope.launch {
        wordVM.getAllWords().observe(this@MainActivity2) { listShows ->
            wordAdapter = WordAdapter(this@MainActivity2, tts)
            wordAdapter.stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.ALLOW
            wordAdapter.words_list = listShows

            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity2)
            recyclerView.adapter = wordAdapter
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            tts.language = Locale.US
            // إعداد RecyclerView بعد التحقق من TextToSpeech
            setUpRv()
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
