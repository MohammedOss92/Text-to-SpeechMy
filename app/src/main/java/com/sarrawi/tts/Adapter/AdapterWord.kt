package com.sarrawi.tts.Adapter

import android.content.Context
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sarrawi.tts.R
import com.sarrawi.tts.model.SealedClass
import java.util.*


class AdapterWord( private val context: Context,
                  private val tts: TextToSpeech
) :
    RecyclerView.Adapter<AdapterWord.WordViewHolder>(), Filterable {
    var wordsListFull: List<SealedClass> = listOf()


    init {
        // تعيين اللغة الافتراضية للنطق إلى الإنجليزية
        tts.language = Locale.US
    }

    private val diffCallback = object : DiffUtil.ItemCallback<SealedClass>() {
        override fun areItemsTheSame(oldItem: SealedClass, newItem: SealedClass): Boolean {
            // هنا يجب التأكد من أن الكلاس القديم والجديد من نفس النوع ومطابقين في الـ ID
            return when {
                oldItem is SealedClass.Word && newItem is SealedClass.Word -> oldItem.ID == newItem.ID
                oldItem is SealedClass.Words_two && newItem is SealedClass.Words_two -> oldItem.ID == newItem.ID
                oldItem is SealedClass.Word_three && newItem is SealedClass.Word_three -> oldItem.ID == newItem.ID
                oldItem is SealedClass.Tb_Adjectives && newItem is SealedClass.Tb_Adjectives -> oldItem.ID == newItem.ID
                oldItem is SealedClass.Tb_Clothes_and_toilet_articles && newItem is SealedClass.Tb_Clothes_and_toilet_articles -> oldItem.ID == newItem.ID
                oldItem is SealedClass.Tb_Colours && newItem is SealedClass.Tb_Colours -> oldItem.ID == newItem.ID
                oldItem is SealedClass.Tb_Family && newItem is SealedClass.Tb_Family -> oldItem.ID == newItem.ID
                oldItem is SealedClass.Tb_fruit && newItem is SealedClass.Tb_fruit -> oldItem.ID == newItem.ID
                oldItem is SealedClass.Tb_Houseandfurniture && newItem is SealedClass.Tb_Houseandfurniture -> oldItem.ID == newItem.ID
                oldItem is SealedClass.Tb_Human_body && newItem is SealedClass.Tb_Human_body -> oldItem.ID == newItem.ID
                oldItem is SealedClass.Tb_jobs && newItem is SealedClass.Tb_jobs -> oldItem.ID == newItem.ID
                oldItem is SealedClass.Tb_Kitchen_tools && newItem is SealedClass.Tb_Kitchen_tools -> oldItem.ID == newItem.ID
                oldItem is SealedClass.Tb_places && newItem is SealedClass.Tb_places -> oldItem.ID == newItem.ID
                oldItem is SealedClass.Tb_Pronoun && newItem is SealedClass.Tb_Pronoun -> oldItem.ID == newItem.ID
                oldItem is SealedClass.Tb_school && newItem is SealedClass.Tb_school -> oldItem.ID == newItem.ID
                oldItem is SealedClass.Tb_Similar_words && newItem is SealedClass.Tb_Similar_words -> oldItem.ID == newItem.ID
                oldItem is SealedClass.Tb_The_animals && newItem is SealedClass.Tb_The_animals -> oldItem.ID == newItem.ID
                oldItem is SealedClass.Tb_transports && newItem is SealedClass.Tb_transports -> oldItem.ID == newItem.ID
                oldItem is SealedClass.Tv_verbs && newItem is SealedClass.Tv_verbs -> oldItem.ID == newItem.ID
                // أضف الحالات الأخرى كما هو مذكور أعلاه
                else -> false
            }
        }

        override fun areContentsTheSame(oldItem: SealedClass, newItem: SealedClass): Boolean {
            // هنا يمكنك استخدام المساواة الاعتيادية
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
//    var wordsList: List<SealedClass>
//        get() = differ.currentList
//        set(value) {
//            differ.submitList(value)
//        }

    var wordsList: List<SealedClass> = emptyList()
        set(value) {
            field = value
            wordsListFull = value.toList()
            differ.submitList(value)
        }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_word, parent, false) // افترضنا أن لديك layout مشترك للجميع
        return WordViewHolder(view,tts)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val wordEntity = wordsList[position]
        holder.bind(wordEntity)

    }

    override fun getItemCount(): Int = wordsList.size


    class WordViewHolder(itemView: View, private val tts: TextToSpeech) : RecyclerView.ViewHolder(itemView) {

        private val englishWordTextView: TextView = itemView.findViewById(R.id.englishWord)
        private val arabicWordTextView: TextView = itemView.findViewById(R.id.arabicMeaning)
//        val bookmarkButton: ImageView = itemView.findViewById(R.id.bookmarkButton)

        fun bind(wordEntity: SealedClass) {
            when (wordEntity) {
                is SealedClass.Word -> {
                    englishWordTextView.text = wordEntity.English_Word
                    arabicWordTextView.text = wordEntity.Arabic_Word

                    englishWordTextView.setOnClickListener {
                        speak(wordEntity.English_Word!!, Locale.US)
                    }

                    arabicWordTextView.setOnClickListener {
                        speak(wordEntity.Arabic_Word!!, Locale("ar"))
                    }
                }

                is SealedClass.Words_two -> {
                    englishWordTextView.text = wordEntity.English_Word
                    arabicWordTextView.text = wordEntity.Arabic_Word

                    englishWordTextView.setOnClickListener {
                        speak(wordEntity.English_Word!!, Locale.US)
                    }

                    arabicWordTextView.setOnClickListener {
                        speak(wordEntity.Arabic_Word!!, Locale("ar"))
                    }
                }

                is SealedClass.Word_three -> {
                    englishWordTextView.text = wordEntity.English_Word
                    arabicWordTextView.text = wordEntity.Arabic_Word

                    englishWordTextView.setOnClickListener {
                        speak(wordEntity.English_Word!!, Locale.US)
                    }

                    arabicWordTextView.setOnClickListener {
                        speak(wordEntity.Arabic_Word!!, Locale("ar"))
                    }
                }
                is SealedClass.Tb_Adjectives -> {
                    englishWordTextView.text = wordEntity.English_Word
                    arabicWordTextView.text = wordEntity.Arabic_Word

                    englishWordTextView.setOnClickListener {
                        speak(wordEntity.English_Word!!, Locale.US)
                    }

                    arabicWordTextView.setOnClickListener {
                        speak(wordEntity.Arabic_Word!!, Locale("ar"))
                    }
                }

                is SealedClass.Tb_Clothes_and_toilet_articles ->{
                    englishWordTextView.text = wordEntity.English_Word
                    arabicWordTextView.text = wordEntity.Arabic_Word

                    englishWordTextView.setOnClickListener {
                        speak(wordEntity.English_Word!!, Locale.US)
                    }

                    arabicWordTextView.setOnClickListener {
                        speak(wordEntity.Arabic_Word!!, Locale("ar"))
                    }
                }

                is SealedClass.Tb_Colours ->{
                    englishWordTextView.text = wordEntity.English_Word
                    arabicWordTextView.text = wordEntity.Arabic_Word

                    englishWordTextView.setOnClickListener {
                        speak(wordEntity.English_Word!!, Locale.US)
                    }

                    arabicWordTextView.setOnClickListener {
                        speak(wordEntity.Arabic_Word!!, Locale("ar"))
                    }
                }

                is SealedClass.Tb_Family ->{
                    englishWordTextView.text = wordEntity.English_Word
                    arabicWordTextView.text = wordEntity.Arabic_Word

                    englishWordTextView.setOnClickListener {
                        speak(wordEntity.English_Word!!, Locale.US)
                    }

                    arabicWordTextView.setOnClickListener {
                        speak(wordEntity.Arabic_Word!!, Locale("ar"))
                    }
                }

                is SealedClass.Tb_fruit ->{
                    englishWordTextView.text = wordEntity.English_Word
                    arabicWordTextView.text = wordEntity.Arabic_Word

                    englishWordTextView.setOnClickListener {
                        speak(wordEntity.English_Word!!, Locale.US)
                    }

                    arabicWordTextView.setOnClickListener {
                        speak(wordEntity.Arabic_Word!!, Locale("ar"))
                    }
                }

                is SealedClass.Tb_Houseandfurniture ->{
                    englishWordTextView.text = wordEntity.English_Word
                    arabicWordTextView.text = wordEntity.Arabic_Word

                    englishWordTextView.setOnClickListener {
                        speak(wordEntity.English_Word!!, Locale.US)
                    }

                    arabicWordTextView.setOnClickListener {
                        speak(wordEntity.Arabic_Word!!, Locale("ar"))
                    }
                }

                is SealedClass.Tb_Human_body ->{
                    englishWordTextView.text = wordEntity.English_Word
                    arabicWordTextView.text = wordEntity.Arabic_Word

                    englishWordTextView.setOnClickListener {
                        speak(wordEntity.English_Word!!, Locale.US)
                    }

                    arabicWordTextView.setOnClickListener {
                        speak(wordEntity.Arabic_Word!!, Locale("ar"))
                    }
                }

                is SealedClass.Tb_jobs ->{
                    englishWordTextView.text = wordEntity.English_Word
                    arabicWordTextView.text = wordEntity.Arabic_Word

                    englishWordTextView.setOnClickListener {
                        speak(wordEntity.English_Word!!, Locale.US)
                    }

                    arabicWordTextView.setOnClickListener {
                        speak(wordEntity.Arabic_Word!!, Locale("ar"))
                    }
                }

                is SealedClass.Tb_Kitchen_tools ->{
                    englishWordTextView.text = wordEntity.English_Word
                    arabicWordTextView.text = wordEntity.Arabic_Word

                    englishWordTextView.setOnClickListener {
                        speak(wordEntity.English_Word!!, Locale.US)
                    }

                    arabicWordTextView.setOnClickListener {
                        speak(wordEntity.Arabic_Word!!, Locale("ar"))
                    }
                }

                is SealedClass.Tb_places ->{
                    englishWordTextView.text = wordEntity.English_Word
                    arabicWordTextView.text = wordEntity.Arabic_Word

                    englishWordTextView.setOnClickListener {
                        speak(wordEntity.English_Word!!, Locale.US)
                    }

                    arabicWordTextView.setOnClickListener {
                        speak(wordEntity.Arabic_Word!!, Locale("ar"))
                    }
                }

                is SealedClass.Tb_Pronoun ->{
                    englishWordTextView.text = wordEntity.English_Word
                    arabicWordTextView.text = wordEntity.Arabic_Word

                    englishWordTextView.setOnClickListener {
                        speak(wordEntity.English_Word!!, Locale.US)
                    }

                    arabicWordTextView.setOnClickListener {
                        speak(wordEntity.Arabic_Word!!, Locale("ar"))
                    }
                }

                is SealedClass.Tb_school ->{
                    englishWordTextView.text = wordEntity.English_Word
                    arabicWordTextView.text = wordEntity.Arabic_Word

                    englishWordTextView.setOnClickListener {
                        speak(wordEntity.English_Word!!, Locale.US)
                    }

                    arabicWordTextView.setOnClickListener {
                        speak(wordEntity.Arabic_Word!!, Locale("ar"))
                    }
                }

                is SealedClass.Tb_Similar_words ->{
                    englishWordTextView.text = wordEntity.English_Word
                    arabicWordTextView.text = wordEntity.Arabic_Word

                    englishWordTextView.setOnClickListener {
                        speak(wordEntity.English_Word!!, Locale.US)
                    }

                    arabicWordTextView.setOnClickListener {
                        speak(wordEntity.Arabic_Word!!, Locale("ar"))
                    }
                }

                is SealedClass.Tb_The_animals ->{
                    englishWordTextView.text = wordEntity.English_Word
                    arabicWordTextView.text = wordEntity.Arabic_Word

                    englishWordTextView.setOnClickListener {
                        speak(wordEntity.English_Word!!, Locale.US)
                    }

                    arabicWordTextView.setOnClickListener {
                        speak(wordEntity.Arabic_Word!!, Locale("ar"))
                    }
                }

                is SealedClass.Tb_transports ->{
                    englishWordTextView.text = wordEntity.English_Word
                    arabicWordTextView.text = wordEntity.Arabic_Word

                    englishWordTextView.setOnClickListener {
                        speak(wordEntity.English_Word!!, Locale.US)
                    }

                    arabicWordTextView.setOnClickListener {
                        speak(wordEntity.Arabic_Word!!, Locale("ar"))
                    }
                }

                is SealedClass.Tv_verbs ->{
                    englishWordTextView.text = wordEntity.English_Word
                    arabicWordTextView.text = wordEntity.Arabic_Word

                    englishWordTextView.setOnClickListener {
                        speak(wordEntity.English_Word!!, Locale.US)
                    }

                    arabicWordTextView.setOnClickListener {
                        speak(wordEntity.Arabic_Word!!, Locale("ar"))
                    }
                }

                // أضف الحالات الأخرى هنا...
                else -> {}
            }
        }

        private fun speak(text: String, locale: Locale) {
            tts.language = locale
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filteredList = ArrayList<SealedClass>()

                if (constraint == null || constraint.isEmpty()) {
                    filteredList.addAll(wordsListFull)
                } else {
                    val filterPattern = constraint.toString().lowercase(Locale.ROOT).trim()

                    for (item in wordsListFull) {
                        if (item.toString().lowercase(Locale.ROOT).contains(filterPattern)) {
                            filteredList.add(item)
                        }
                    }
                }

                val results = FilterResults()
                results.values = filteredList
                return results
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                wordsList = results?.values as List<SealedClass>
                notifyDataSetChanged()
            }
        }
    }

    fun setLetters(wordsList:List<SealedClass.Word>){
        this.wordsList = wordsList
        notifyDataSetChanged()
    }

    fun setLetters2(wordsList:List<SealedClass.Words_two>){
        this.wordsList = wordsList
        notifyDataSetChanged()
    }
}

/*fun binda(wordEntity: SealedClass) {
            // جميع الحالات تشترك في نفس طريقة عرض البيانات
            when (wordEntity) {
                is SealedClass.Word,
                is SealedClass.Words_two,
                is SealedClass.Word_three,
                is SealedClass.Tb_Adjectives,
                is SealedClass.Tb_Clothes_and_toilet_articles,
                is SealedClass.Tb_Colours,
                is SealedClass.Tb_Family,
                is SealedClass.Tb_Houseandfurniture,
                is SealedClass.Tb_Human_body,
                is SealedClass.Tb_jobs,
                is SealedClass.Tb_Kitchen_tools,
                is SealedClass.Tb_places,
                is SealedClass.Tb_Pronoun,
                is SealedClass.Tb_school,
                is SealedClass.Tb_Similar_words,
                is SealedClass.Tb_The_animals,
                is SealedClass.Tb_transports,
                is SealedClass.Tv_verbs -> {
                    englishWordTextView.text = wordEntity.English_Word
                    arabicWordTextView.text = wordEntity.Arabic_Word
                }
                else -> {}
            }
        }*/
