package com.sarrawi.tts

//import android.content.Context
//import android.speech.tts.TextToSpeech
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.RecyclerView
//import java.util.Locale
//
//class WordAdapter(
//    private val context: Context,
//    private var wordList: List<Pair<String, String>>,
//    private val tts: TextToSpeech
//) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {
//
//    init {
//        tts.language = Locale.US
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_word, parent, false)
//        return WordViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
//        val (englishWord, arabicMeaning) = wordList[position]
//
//        holder.englishWord.text = englishWord
//        holder.arabicMeaning.text = arabicMeaning
//
//        holder.englishWord.setOnClickListener {
//            speak(englishWord, Locale.US)
//        }
//
//        holder.arabicMeaning.setOnClickListener {
//            speak(arabicMeaning, Locale("ar"))
//        }
//    }
//
//    private fun speak(text: String, locale: Locale) {
//        tts.language = locale
//        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
//    }
//
//    override fun getItemCount(): Int = wordList.size
//
//    fun updateData(newList: List<Pair<String, String>>) {
//        val diffCallback = WordDiffCallback(wordList, newList)
//        val diffResult = DiffUtil.calculateDiff(diffCallback)
//
//        wordList = newList
//        diffResult.dispatchUpdatesTo(this)
//    }
//
//    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//        val englishWord   =itemView.findViewById<TextView>(R.id.englishWord)
//        val arabicMeaning =itemView.findViewById<TextView>(R.id.arabicMeaning)
//    }
//}
//
//
////
import android.content.Context
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

//class WordAdapter(
//    private val context: Context,
//    private val wordList: List<Pair<String, String>>,
//    private val tts: TextToSpeech
//) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {
//
//    init {
//        // تعيين اللغة الافتراضية للنطق إلى الإنجليزية
//        tts.language = Locale.US
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_word, parent, false)
//        return WordViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
//        val (englishWord, arabicMeaning) = wordList[position]
//
//        // عرض الكلمات والمعاني في العناصر المناسبة
//        holder.tvEn.text = englishWord
//        holder.tvAr.text = arabicMeaning
//
//        // تعيين حدث الضغط لنطق الكلمة
//        holder.tvEn.setOnClickListener {
//            speak(englishWord, Locale.US)
//        }
//
//        holder.tvAr.setOnClickListener {
//            speak(arabicMeaning, Locale("ar"))
//        }
//    }
//
//    private fun speak(text: String, locale: Locale) {
//        tts.language = locale
//        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
//    }
//
//    override fun getItemCount(): Int = wordList.size
//
//
//
//    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//        var tvAr=itemView.findViewById<TextView>(R.id.arabicMeaning)
//        var tvEn=itemView.findViewById<TextView>(R.id.englishWord)
//    }
//}


import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.sarrawi.tts.wordDb.Word


class WordAdapter(
    private val context: Context,
    private val tts: TextToSpeech
) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    init {
        // تعيين اللغة الافتراضية للنطق إلى الإنجليزية
        tts.language = Locale.US
    }

    private val diffCallback = object : DiffUtil.ItemCallback<Word>() {
        override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem.ID == newItem.ID
        }

        override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var words_list: List<Word>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_word, parent, false)
        return WordViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = words_list[position]

        // عرض الكلمات والمعاني في العناصر المناسبة
        holder.tvEn.text = word.English_Word
        holder.tvAr.text = word.Arabic_Word

        // تعيين حدث الضغط لنطق الكلمة
        holder.tvEn.setOnClickListener {
            speak(word.English_Word!!, Locale.US)
        }

        holder.tvAr.setOnClickListener {
            speak(word.Arabic_Word!!, Locale("ar"))
        }
    }

    private fun speak(text: String, locale: Locale) {
        tts.language = locale
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    override fun getItemCount(): Int = words_list.size

    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvAr = itemView.findViewById<TextView>(R.id.arabicMeaning)
        var tvEn = itemView.findViewById<TextView>(R.id.englishWord)
    }
}
