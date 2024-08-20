package com.sarrawi.tts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AdapterView
import android.widget.Spinner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sarrawi.tts.Adapter.AdapterWord
import com.sarrawi.tts.VModel.WordVM
import kotlinx.coroutines.launch
import java.util.*


class MainActivity3 : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var tts: TextToSpeech
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterWord: AdapterWord

    private val wordVM: WordVM by lazy {
        ViewModelProvider(this, WordVM.WordVMFactory(this.application))[WordVM::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        recyclerView = findViewById(R.id.recyclerView)
        setUpRv2()
// تهيئة TextToSpeech
        tts = TextToSpeech(this, this)
    }

    private fun setUpRv() = wordVM.viewModelScope.launch {
        wordVM.getAllWords().observe(this@MainActivity3) { listShows ->
            adapterWord = AdapterWord(listShows,this@MainActivity3, tts)
            adapterWord.stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.ALLOW
            adapterWord.wordsList = listShows
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity3)
            recyclerView.adapter = adapterWord
        }


    }

    private fun setUpRv2() = wordVM.viewModelScope.launch {
        wordVM.getAllWords_twoViewModel().observe(this@MainActivity3) { listShows ->
            adapterWord = AdapterWord(listShows, this@MainActivity3, tts)
            adapterWord.stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.ALLOW
            adapterWord.wordsList = listShows
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity3)
            recyclerView.adapter = adapterWord
        }
    }


    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            tts.language = Locale.US
            // إعداد RecyclerView بعد التحقق من TextToSpeech

        }
    }

    //هذه الصيغة تضمن أن المتغير tts تم تهيئته بالفعل قبل محاولة استخدامه. هذا مهم لأن الوصول إلى المتغيرات غير المهيئة يمكن أن يؤدي إلى أخطاء تشغيلية.::
    override fun onDestroy() {
        if (::tts.isInitialized) {
            tts.stop()
            tts.shutdown()
        }
        super.onDestroy()
    }
}