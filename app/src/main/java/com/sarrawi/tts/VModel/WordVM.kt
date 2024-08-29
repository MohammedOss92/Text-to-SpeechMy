package com.sarrawi.tts.VModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.sarrawi.tts.VRepo.WordRepo
import com.sarrawi.tts.model.SealedClass
import com.sarrawi.tts.model.Word
import kotlinx.coroutines.launch

class WordVM constructor(application : Application) : ViewModel() {


    private val wordRepo: WordRepo = WordRepo(application)

    fun getAllWords(): LiveData<List<SealedClass.Word>> = wordRepo.getAllWords()

    fun search1(searchQuery: String): LiveData<List<SealedClass.Word>> = wordRepo.searchRepo1(searchQuery)
    fun search2(searchQuery: String): LiveData<List<SealedClass.Words_two>> = wordRepo.searchRepo2(searchQuery)
    fun search3(searchQuery: String): LiveData<List<SealedClass.Word_three>> = wordRepo.searchRepo3(searchQuery)
    fun search4(searchQuery: String): LiveData<List<SealedClass.Tb_Adjectives>> = wordRepo.searchRepo4(searchQuery)
    fun search5(searchQuery: String): LiveData<List<SealedClass.Tb_Clothes_and_toilet_articles>> = wordRepo.searchRepo5(searchQuery)
    fun search6(searchQuery: String): LiveData<List<SealedClass.Tb_Colours>> = wordRepo.searchRepo6(searchQuery)
    fun search7(searchQuery: String): LiveData<List<SealedClass.Tb_Family>> = wordRepo.searchRepo7(searchQuery)
    fun search8(searchQuery: String): LiveData<List<SealedClass.Tb_fruit>> = wordRepo.searchRepo8(searchQuery)
    fun search9(searchQuery: String): LiveData<List<SealedClass.Tb_Houseandfurniture>> = wordRepo.searchRepo9(searchQuery)
    fun search10(searchQuery: String): LiveData<List<SealedClass.Tb_Human_body>> = wordRepo.searchRepo10(searchQuery)
    fun search11(searchQuery: String): LiveData<List<SealedClass.Tb_jobs>> = wordRepo.searchRepo11(searchQuery)
    fun search12(searchQuery: String): LiveData<List<SealedClass.Tb_Kitchen_tools>> = wordRepo.searchRepo12(searchQuery)
    fun search13(searchQuery: String): LiveData<List<SealedClass.Tb_places>> = wordRepo.searchRepo13(searchQuery)
    fun search14(searchQuery: String): LiveData<List<SealedClass.Tb_Pronoun>> = wordRepo.searchRepo14(searchQuery)
    fun search15(searchQuery: String): LiveData<List<SealedClass.Tb_school>> = wordRepo.searchRepo15(searchQuery)
    fun search16(searchQuery: String): LiveData<List<SealedClass.Tb_Similar_words>> = wordRepo.searchRepo16(searchQuery)
    fun search17(searchQuery: String): LiveData<List<SealedClass.Tb_The_animals>> = wordRepo.searchRepo17(searchQuery)
    fun search18(searchQuery: String): LiveData<List<SealedClass.Tb_transports>> = wordRepo.searchRepo18(searchQuery)
    fun search19(searchQuery: String): LiveData<List<SealedClass.Tv_verbs>> = wordRepo.searchRepo19(searchQuery)

    fun getAllWords_twoViewModel(): LiveData<List<SealedClass.Words_two>> = wordRepo.getAllWords_twoRepo()

    fun getAllWord_threeViewModel(): LiveData<List<SealedClass.Word_three>> = wordRepo.getAllWord_threeRepo()

    fun getAlltb_AdjectivesViewModel(): LiveData<List<SealedClass.Tb_Adjectives>> = wordRepo.getAlltb_AdjectivesRepo()

    fun getAlltb_Clothes_and_toilet_articlesViewModel(): LiveData<List<SealedClass.Tb_Clothes_and_toilet_articles>> = wordRepo.getAlltb_Clothes_and_toilet_articlesRepo()

    fun getAlltb_ColoursViewModel(): LiveData<List<SealedClass.Tb_Colours>> = wordRepo.getAlltb_ColoursRepo()

    fun getAlltb_FamilyViewModel(): LiveData<List<SealedClass.Tb_Family>> = wordRepo.getAlltb_FamilyRepo()

    fun getAlltb_fruitViewModel(): LiveData<List<SealedClass.Tb_fruit>> = wordRepo.getAlltb_fruitRepo()

    fun getAlltb_HouseandfurnitureViewModel(): LiveData<List<SealedClass.Tb_Houseandfurniture>> = wordRepo.getAlltb_HouseandfurnitureRepo()

    fun getAlltb_Human_bodyViewModel(): LiveData<List<SealedClass.Tb_Human_body>> = wordRepo.getAlltb_Human_bodyRepo()

    fun getAlltb_jobsViewModel(): LiveData<List<SealedClass.Tb_jobs>> = wordRepo.getAlltb_jobsRepo()

    fun getAlltb_Kitchen_toolsViewModel(): LiveData<List<SealedClass.Tb_Kitchen_tools>> = wordRepo.getAlltb_Kitchen_toolsRepo()

    fun getAlltb_placesViewModel(): LiveData<List<SealedClass.Tb_places>> = wordRepo.getAlltb_placesRepo()

    fun getAlltb_PronounViewModel(): LiveData<List<SealedClass.Tb_Pronoun>> = wordRepo.getAlltb_PronounRepo()

    fun getAlltb_schoolViewModel(): LiveData<List<SealedClass.Tb_school>> = wordRepo.getAlltb_schoolRepo()

    fun getAlltb_Similar_wordsViewModel(): LiveData<List<SealedClass.Tb_Similar_words>> = wordRepo.getAlltb_Similar_wordsRepo()

    fun getAlltb_The_animalsViewModel(): LiveData<List<SealedClass.Tb_The_animals>> = wordRepo.getAlltb_The_animalsRepo()

    fun getAlltb_transportsViewModel(): LiveData<List<SealedClass.Tb_transports>> = wordRepo.getAlltb_transportsRepo()

    fun getAlltv_verbsViewModel(): LiveData<List<SealedClass.Tv_verbs>> = wordRepo.getAlltv_verbsRepo()


    fun setBookmarkForWord(word: SealedClass.Word) {
        viewModelScope.launch {
            wordRepo.setBookmarkForWord(word)
        }
    }

    fun setBookmarkForWordsTwo(wordsTwo: SealedClass.Words_two) {
        viewModelScope.launch {
            wordRepo.setBookmarkForWords_two(wordsTwo)
        }
    }

    fun setBookmarkForWord_three(word_three: SealedClass.Word_three) {
        viewModelScope.launch {
            wordRepo.setBookmarkForWord_three(word_three)
        }
    }

    fun setBookmarkForTb_Adjectives(tb_Adjectives: SealedClass.Tb_Adjectives) {
        viewModelScope.launch {
            wordRepo.setBookmarkForTb_Adjectives(tb_Adjectives)
        }
    }

    fun setBookmarkForTb_Clothes_and_toilet_articles(tb_Clothes_and_toilet_articles: SealedClass.Tb_Clothes_and_toilet_articles) {
        viewModelScope.launch {
            wordRepo.setBookmarkForTb_Clothes_and_toilet_articles(tb_Clothes_and_toilet_articles)
        }
    }

    fun setBookmarkForTb_Colours(tb_Colours: SealedClass.Tb_Colours) {
        viewModelScope.launch {
            wordRepo.setBookmarkForTb_Colours(tb_Colours)
        }
    }

    fun setBookmarkForTb_Family(tTb_Family: SealedClass.Tb_Family) {
        viewModelScope.launch {
            wordRepo.setBookmarkForTb_Family(tTb_Family)
        }
    }

    fun setBookmarkForTb_fruit(tTb_fruit: SealedClass.Tb_fruit) {
        viewModelScope.launch {
            wordRepo.setBookmarkForTb_fruit(tTb_fruit)
        }
    }

    fun setBookmarkForTb_Houseandfurniture(tTb_Houseandfurniture: SealedClass.Tb_Houseandfurniture) {
        viewModelScope.launch {
            wordRepo.setBookmarkForTb_Houseandfurniture(tTb_Houseandfurniture)
        }
    }

    fun setBookmarkForTb_Human_body(tTb_Human_body: SealedClass.Tb_Human_body) {
        viewModelScope.launch {
            wordRepo.setBookmarkForTb_Human_body(tTb_Human_body)
        }
    }

    fun setBookmarkForTb_jobs(tTb_jobs: SealedClass.Tb_jobs) {
        viewModelScope.launch {
            wordRepo.setBookmarkForTb_jobs(tTb_jobs)
        }
    }

    fun setBookmarkForTb_Kitchen_tools(tTb_Kitchen_tools: SealedClass.Tb_Kitchen_tools) {
        viewModelScope.launch {
            wordRepo.setBookmarkForTb_Kitchen_tools(tTb_Kitchen_tools)
        }
    }

    fun setBookmarkForTb_places(tTb_places: SealedClass.Tb_places) {
        viewModelScope.launch {
            wordRepo.setBookmarkForTb_places(tTb_places)
        }
    }

    fun setBookmarkForTb_Pronoun(tTb_Pronoun: SealedClass.Tb_Pronoun) {
        viewModelScope.launch {
            wordRepo.setBookmarkForTb_Pronoun(tTb_Pronoun)
        }
    }

    fun setBookmarkForTb_school(tTb_school: SealedClass.Tb_school) {
        viewModelScope.launch {
            wordRepo.setBookmarkForTb_school(tTb_school)
        }
    }

    fun setBookmarkForTb_Similar_words(tTb_Similar_words: SealedClass.Tb_Similar_words) {
        viewModelScope.launch {
            wordRepo.setBookmarkForTb_Similar_words(tTb_Similar_words)
        }
    }

    fun setBookmarkForTb_The_animals(wordsTwo: SealedClass.Tb_The_animals) {
        viewModelScope.launch {
            wordRepo.setBookmarkForTb_The_animals(wordsTwo)
        }
    }

    fun setBookmarkForTb_transports(tTb_transports: SealedClass.Tb_transports) {
        viewModelScope.launch {
            wordRepo.setBookmarkForTb_transports(tTb_transports)
        }
    }

    fun setBookmarkForTv_verbs(tTv_verbs: SealedClass.Tv_verbs) {
        viewModelScope.launch {
            wordRepo.setBookmarkForTv_verbs(tTv_verbs)
        }
    }

    class WordVMFactory(private val application: Application): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(WordVM::class.java)){
                @Suppress("UNCHECKED_CAST")
                return WordVM(application) as T
            }
            throw IllegalArgumentException("Unable Constructore View Model")
        }
    }

    //class WordViewModel(private val dao: WordDao) : ViewModel() {
    //
    //    fun searchAllTables(query: String): LiveData<List<SealedClass>> {
    //        val wordResults = dao.searchWords(query)
    //        val wordTwoResults = dao.searchWordsTwo(query)
    //        // Combine results from other queries...
    //
    //        // Combine all results into a single LiveData list
    //        return MediatorLiveData<List<SealedClass>>().apply {
    //            addSource(wordResults) { value = it }
    //            addSource(wordTwoResults) { value = it }
    //            // Add sources from other queries...
    //        }
    //    }
    //}
    //الخطوات بالتفصيل:
    //استدعاء الاستعلامات: أولاً، الدالة تقوم باستدعاء استعلامات البحث الخاصة بكل جدول من الجداول الموجودة. على سبيل المثال:
    //
    //wordResults تخزن النتائج التي ترجع من استعلام البحث في جدول Words.
    //wordTwoResults تخزن النتائج التي ترجع من استعلام البحث في جدول Words_two.
    //دمج النتائج: بعد ذلك، يتم استخدام MediatorLiveData لدمج جميع النتائج التي تم الحصول عليها من الاستعلامات المختلفة في LiveData واحدة.
    //
    //إضافة المصادر: يتم إضافة النتائج كمصادر باستخدام addSource بحيث يتم تحديث القيمة (value) في MediatorLiveData في كل مرة يتم فيها تحديث أحد المصادر. هذا يعني أن LiveData الناتجة ستحتوي على جميع النتائج المجمعة من مختلف الجداول.
    //
    //كيف تعمل MediatorLiveData:
    //MediatorLiveData تتيح لك مراقبة عدة مصادر LiveData، ودمج البيانات من هذه المصادر في مصدر واحد.
    //في كل مرة يتغير أحد هذه المصادر (مثل wordResults أو wordTwoResults)، يتم تحديث القيمة المجمعة تلقائياً في MediatorLiveData.
}