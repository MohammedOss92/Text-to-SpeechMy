package com.sarrawi.tts

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var tts: TextToSpeech
    private lateinit var editText: EditText
    private lateinit var buttonSpeak: Button
    private lateinit var languageSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // تأكد من استخدام اسم ملف XML الصحيح

        editText = findViewById(R.id.editText)
        buttonSpeak = findViewById(R.id.buttonSpeak)
        languageSpinner = findViewById(R.id.languageSpinner)

        tts = TextToSpeech(this, this)

        buttonSpeak.setOnClickListener {
            val text = editText.text.toString()
            val selectedLanguage = languageSpinner.selectedItem.toString()

            when (selectedLanguage) {
                "English" -> tts.language = Locale.US
                "العربية" -> tts.language = Locale("ar")
            }

            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            tts.language = Locale.US // تعيين لغة افتراضية
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
