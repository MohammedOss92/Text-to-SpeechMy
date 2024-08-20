package com.sarrawi.tts.Adapter

class ass {
//    package com.sarrawi.tts.Adapter
//
//    import android.content.Context
//    import android.speech.tts.TextToSpeech
//    import android.view.LayoutInflater
//    import android.view.View
//    import android.view.ViewGroup
//    import android.widget.TextView
//    import androidx.recyclerview.widget.AsyncListDiffer
//    import androidx.recyclerview.widget.DiffUtil
//    import androidx.recyclerview.widget.RecyclerView
//    import com.sarrawi.tts.R
//    import com.sarrawi.tts.model.SealedClass
//    import java.util.*
//
//    class AdapterWord(
//        private val context: Context,
//        private val tts: TextToSpeech
//    ) : RecyclerView.Adapter<AdapterWord.WordViewHolder>() {
//
//        init {
//            // تعيين اللغة الافتراضية للنطق إلى الإنجليزية
//            tts.language = Locale.US
//        }
//
//        private val diffCallback = object : DiffUtil.ItemCallback<SealedClass>() {
//            override fun areItemsTheSame(oldItem: SealedClass, newItem: SealedClass): Boolean {
//                return oldItem::class == newItem::class && oldItem.ID == newItem.ID
//            }
//
//            override fun areContentsTheSame(oldItem: SealedClass, newItem: SealedClass): Boolean {
//                return oldItem == newItem
//            }
//        }
//
//        private val differ = AsyncListDiffer(this, diffCallback)
//
//        var wordsList: List<SealedClass>
//            get() = differ.currentList
//            set(value) {
//                differ.submitList(value)
//            }
//
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
//            val view = LayoutInflater.from(parent.context)
//                .inflate(R.layout.item_word, parent, false)
//            return WordViewHolder(view, tts)
//        }
//
//        override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
//            val wordEntity = differ.currentList[position]
//            holder.bind(wordEntity)
//        }
//
//        override fun getItemCount(): Int = differ.currentList.size
//
//        class WordViewHolder(itemView: View, private val tts: TextToSpeech) : RecyclerView.ViewHolder(itemView) {
//            private val englishWordTextView: TextView = itemView.findViewById(R.id.englishWord)
//            private val arabicWordTextView: TextView = itemView.findViewById(R.id.arabicMeaning)
//
//            fun bind(wordEntity: SealedClass) {
//                englishWordTextView.text = wordEntity.English_Word
//                arabicWordTextView.text = wordEntity.Arabic_Word
//
//                englishWordTextView.setOnClickListener {
//                    wordEntity.English_Word?.let { word ->
//                        speak(word, Locale.US)
//                    }
//                }
//
//                arabicWordTextView.setOnClickListener {
//                    wordEntity.Arabic_Word?.let { word ->
//                        speak(word, Locale("ar"))
//                    }
//                }
//            }
//
//            private fun speak(text: String, locale: Locale) {
//                tts.language = locale
//                tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
//            }
//        }
//    }

}