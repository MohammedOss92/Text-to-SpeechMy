package com.sarrawi.tts

import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.Locale

class SpeechHelper(context: Context) : TextToSpeech.OnInitListener {

    private var tts: TextToSpeech? = null

    init {
        tts = TextToSpeech(context, this)
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            // إعداد اللغة الافتراضية إذا كنت تريد
            tts?.setLanguage(Locale.US)
        }
    }

    fun speak(text: String, locale: Locale) {
        tts?.language = locale
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    fun stop() {
        tts?.stop()
    }

    fun shutdown() {
        tts?.shutdown()
    }
}
