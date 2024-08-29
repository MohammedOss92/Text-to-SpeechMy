package com.sarrawi.tts.wordDb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.sarrawi.tts.model.SealedClass
import com.sarrawi.tts.model.Word

@Dao
interface WordsDao {

    @Query("select * from Words")
    fun getAllWordsDao(): LiveData<List<SealedClass.Word>>

    @Query("select * from Words_two")
    fun getAllWords_twoDao(): LiveData<List<SealedClass.Words_two>>

    @Query("select * from Word_three")
    fun getAllWord_threeDao(): LiveData<List<SealedClass.Word_three>>

    @Query("select * from tb_Adjectives")
    fun getAlltb_AdjectivesDao(): LiveData<List<SealedClass.Tb_Adjectives>>

    @Query("select * from tb_Clothes_and_toilet_articles")
    fun getAlltb_Clothes_and_toilet_articlesDao(): LiveData<List<SealedClass.Tb_Clothes_and_toilet_articles>>

    @Query("select * from tb_Colours")
    fun getAlltb_ColoursDao(): LiveData<List<SealedClass.Tb_Colours>>

    @Query("select * from tb_Family")
    fun getAlltb_FamilyDao(): LiveData<List<SealedClass.Tb_Family>>

    @Query("select * from tb_fruit")
    fun getAlltb_fruitDao(): LiveData<List<SealedClass.Tb_fruit>>

    @Query("select * from tb_Houseandfurniture")
    fun getAlltb_HouseandfurnitureDao(): LiveData<List<SealedClass.Tb_Houseandfurniture>>

    @Query("select * from tb_Human_body")
    fun getAlltb_Human_bodyDao(): LiveData<List<SealedClass.Tb_Human_body>>

    @Query("select * from tb_jobs")
    fun getAlltb_jobsDao(): LiveData<List<SealedClass.Tb_jobs>>

    @Query("select * from tb_Kitchen_tools")
    fun getAlltb_Kitchen_toolsDao(): LiveData<List<SealedClass.Tb_Kitchen_tools>>

    @Query("select * from tb_places")
    fun getAlltb_placesDao(): LiveData<List<SealedClass.Tb_places>>

    @Query("select * from tb_Pronoun")
    fun getAlltb_PronounDao(): LiveData<List<SealedClass.Tb_Pronoun>>

    @Query("select * from tb_school")
    fun getAlltb_schoolDao(): LiveData<List<SealedClass.Tb_school>>

    @Query("select * from tb_Similar_words")
    fun getAlltb_Similar_wordsDao(): LiveData<List<SealedClass.Tb_Similar_words>>

    @Query("select * from tb_The_animals")
    fun getAlltb_The_animalsDao(): LiveData<List<SealedClass.Tb_The_animals>>

    @Query("select * from tb_transports")
    fun getAlltb_transportsDao(): LiveData<List<SealedClass.Tb_transports>>

    @Query("select * from tv_verbs")
    fun getAlltv_verbsDao(): LiveData<List<SealedClass.Tv_verbs>>

    @Query("SELECT * FROM Words WHERE ID LIKE :searchQuery " +
            "OR English_Word LIKE :searchQuery " +
            "OR Arabic_Word LIKE :searchQuery")
    fun searchWords(searchQuery: String): LiveData<List<SealedClass.Word>>

    @Query("SELECT * FROM Words_two WHERE ID LIKE :searchQuery " +
            "OR English_Word LIKE :searchQuery " +
            "OR Arabic_Word LIKE :searchQuery")
    fun searchWords2(searchQuery: String): LiveData<List<SealedClass.Words_two>>

    @Query("SELECT * FROM Word_three WHERE ID LIKE :searchQuery " +
            "OR English_Word LIKE :searchQuery " +
            "OR Arabic_Word LIKE :searchQuery")
    fun searchWords3(searchQuery: String): LiveData<List<SealedClass.Word_three>>


    @Query("SELECT * FROM tb_Adjectives WHERE ID LIKE :query OR English_Word LIKE :query OR Arabic_Word LIKE :query")
    fun search4(query: String): LiveData<List<SealedClass.Tb_Adjectives>>

    @Query("SELECT * FROM tb_Clothes_and_toilet_articles WHERE ID LIKE :query OR English_Word LIKE :query OR Arabic_Word LIKE :query")
    fun search5(query: String): LiveData<List<SealedClass.Tb_Clothes_and_toilet_articles>>

    @Query("SELECT * FROM tb_Colours WHERE ID LIKE :query OR English_Word LIKE :query OR Arabic_Word LIKE :query")
    fun search6(query: String): LiveData<List<SealedClass.Tb_Colours>>

    @Query("SELECT * FROM tb_Family WHERE ID LIKE :query OR English_Word LIKE :query OR Arabic_Word LIKE :query")
    fun search7(query: String): LiveData<List<SealedClass.Tb_Family>>

    @Query("SELECT * FROM tb_fruit WHERE ID LIKE :query OR English_Word LIKE :query OR Arabic_Word LIKE :query")
    fun search8(query: String): LiveData<List<SealedClass.Tb_fruit>>

    @Query("SELECT * FROM tb_Houseandfurniture WHERE ID LIKE :query OR English_Word LIKE :query OR Arabic_Word LIKE :query")
    fun search9(query: String): LiveData<List<SealedClass.Tb_Houseandfurniture>>

    @Query("SELECT * FROM tb_Human_body WHERE ID LIKE :query OR English_Word LIKE :query OR Arabic_Word LIKE :query")
    fun search10(query: String): LiveData<List<SealedClass.Tb_Human_body>>

    @Query("SELECT * FROM tb_jobs WHERE ID LIKE :query OR English_Word LIKE :query OR Arabic_Word LIKE :query")
    fun search11(query: String): LiveData<List<SealedClass.Tb_jobs>>

    @Query("SELECT * FROM tb_Kitchen_tools WHERE ID LIKE :query OR English_Word LIKE :query OR Arabic_Word LIKE :query")
    fun search12(query: String): LiveData<List<SealedClass.Tb_Kitchen_tools>>

    @Query("SELECT * FROM tb_places WHERE ID LIKE :query OR English_Word LIKE :query OR Arabic_Word LIKE :query")
    fun search13(query: String): LiveData<List<SealedClass.Tb_places>>

    @Query("SELECT * FROM tb_Pronoun WHERE ID LIKE :query OR English_Word LIKE :query OR Arabic_Word LIKE :query")
    fun search14(query: String): LiveData<List<SealedClass.Tb_Pronoun>>

    @Query("SELECT * FROM tb_school WHERE ID LIKE :query OR English_Word LIKE :query OR Arabic_Word LIKE :query")
    fun search15(query: String): LiveData<List<SealedClass.Tb_school>>

    @Query("SELECT * FROM tb_Similar_words WHERE ID LIKE :query OR English_Word LIKE :query OR Arabic_Word LIKE :query")
    fun search16(query: String): LiveData<List<SealedClass.Tb_Similar_words>>

    @Query("SELECT * FROM tb_The_animals WHERE ID LIKE :query OR English_Word LIKE :query OR Arabic_Word LIKE :query")
    fun search17(query: String): LiveData<List<SealedClass.Tb_The_animals>>

    @Query("SELECT * FROM tb_transports WHERE ID LIKE :query OR English_Word LIKE :query OR Arabic_Word LIKE :query")
    fun search18(query: String): LiveData<List<SealedClass.Tb_transports>>

    @Query("SELECT * FROM tv_verbs WHERE ID LIKE :query OR English_Word LIKE :query OR Arabic_Word LIKE :query")
    fun search19(query: String): LiveData<List<SealedClass.Tv_verbs>>


    @Query("UPDATE Words SET bookmark = 0 WHERE bookmark = 1")
    suspend fun resetBookmarksInWords()
    @Query("UPDATE Words_two SET bookmark = 0 WHERE bookmark = 1")
    suspend fun resetBookmarksInWordsTwo()
    @Query("UPDATE Word_three SET bookmark = 0 WHERE bookmark = 1")
    suspend fun resetBookmarksInWord_three()
    @Query("UPDATE tb_Adjectives SET bookmark = 0 WHERE bookmark = 1")
    suspend fun resetBookmarksIntb_Adjectives()
    @Query("UPDATE tb_Clothes_and_toilet_articles SET bookmark = 0 WHERE bookmark = 1")
    suspend fun resetBookmarksIntb_Clothes_and_toilet_articles()
    @Query("UPDATE tb_Colours SET bookmark = 0 WHERE bookmark = 1")
    suspend fun resetBookmarksIntb_Colours()
    @Query("UPDATE tb_Family SET bookmark = 0 WHERE bookmark = 1")
    suspend fun resetBookmarksIntb_Family()
    @Query("UPDATE tb_fruit SET bookmark = 0 WHERE bookmark = 1")
    suspend fun resetBookmarksIntb_fruit()
    @Query("UPDATE tb_Houseandfurniture SET bookmark = 0 WHERE bookmark = 1")
    suspend fun resetBookmarksIntb_Houseandfurniture()
    @Query("UPDATE tb_Human_body SET bookmark = 0 WHERE bookmark = 1")
    suspend fun resetBookmarksIntb_Human_body()
    @Query("UPDATE tb_jobs SET bookmark = 0 WHERE bookmark = 1")
    suspend fun resetBookmarksIntb_jobs()
    @Query("UPDATE tb_Kitchen_tools SET bookmark = 0 WHERE bookmark = 1")
    suspend fun resetBookmarksIntb_Kitchen_tools()
    @Query("UPDATE tb_places SET bookmark = 0 WHERE bookmark = 1")
    suspend fun resetBookmarksIntb_places()
    @Query("UPDATE tb_Pronoun SET bookmark = 0 WHERE bookmark = 1")
    suspend fun resetBookmarksIntb_Pronoun()
    @Query("UPDATE tb_school SET bookmark = 0 WHERE bookmark = 1")
    suspend fun resetBookmarksIntb_school()
    @Query("UPDATE tb_Similar_words SET bookmark = 0 WHERE bookmark = 1")
    suspend fun resetBookmarksIntb_Similar_words()
    @Query("UPDATE tb_The_animals SET bookmark = 0 WHERE bookmark = 1")
    suspend fun resetBookmarksIntb_The_animals()
    @Query("UPDATE tb_transports SET bookmark = 0 WHERE bookmark = 1")
    suspend fun resetBookmarksIntb_transports()
    @Query("UPDATE tv_verbs SET bookmark = 0 WHERE bookmark = 1")
    suspend fun resetBookmarksIntv_verbs()

    // ����� ������ ������ ������ �����
    @Update
    suspend fun updateWord(word: SealedClass.Word)
    @Update
    suspend fun updateWordsTwo(word: SealedClass.Words_two)
    @Update
    suspend fun updateWord_three(word: SealedClass.Word_three)
    @Update
    suspend fun updateTb_Adjectives(word: SealedClass.Tb_Adjectives)
    @Update
    suspend fun updateTb_Clothes_and_toilet_articles(word: SealedClass.Tb_Clothes_and_toilet_articles)
    @Update
    suspend fun updateTb_Colours(word: SealedClass.Tb_Colours)
    @Update
    suspend fun updateTb_Family(word: SealedClass.Tb_Family)
    @Update
    suspend fun updateTb_fruit(word: SealedClass.Tb_fruit)
    @Update
    suspend fun updateTb_Houseandfurniture(word: SealedClass.Tb_Houseandfurniture)
    @Update
    suspend fun updateTb_Human_body(word: SealedClass.Tb_Human_body)
    @Update
    suspend fun updateTb_jobs(word: SealedClass.Tb_jobs)
    @Update
    suspend fun updateTb_Kitchen_tools(word: SealedClass.Tb_Kitchen_tools)
    @Update
    suspend fun updateTb_places(word: SealedClass.Tb_places)
    @Update
    suspend fun updateTb_Pronoun(word: SealedClass.Tb_Pronoun)
    @Update
    suspend fun updateTb_school(word: SealedClass.Tb_school)
    @Update
    suspend fun updateTb_Similar_words(word: SealedClass.Tb_Similar_words)
    @Update
    suspend fun updateTb_The_animals(word: SealedClass.Tb_The_animals)
    @Update
    suspend fun updateTb_transports(word: SealedClass.Tb_transports)
    @Update
    suspend fun updateTv_verbs(word: SealedClass.Tv_verbs)


    //@Transaction: هذه الأنوتيشن تضمن أن الدالة تعمل كمعاملة واحدة (Transaction).
    // إذا حدث خطأ في أي جزء من المعاملة، سيتم التراجع عن كل التغييرات التي تمت فيها، مما يضمن عدم ترك قاعدة البيانات في حالة غير متناسقة.
    @Transaction
    suspend fun setBookmarkForWord(newBookmark: SealedClass.Word) {
        // ����� ����� �������� �������� �������
        resetBookmarksInWords()
        // ����� ������� �������� �������
        updateWord(newBookmark.copy(bookmark = 1))
    }

    //@Transaction: هذه الأنوتيشن تضمن أن الدالة تعمل كمعاملة واحدة (Transaction).
    // إذا حدث خطأ في أي جزء من المعاملة، سيتم التراجع عن كل التغييرات التي تمت فيها، مما يضمن عدم ترك قاعدة البيانات في حالة غير متناسقة.
    @Transaction
    suspend fun setBookmarkForWordsTwo(newBookmark: SealedClass.Words_two) {
        resetBookmarksInWordsTwo()
        updateWordsTwo(newBookmark.copy(bookmark = 1))
    }

    @Transaction
    suspend fun setBookmarkForTWord_three(newBookmark: SealedClass.Word_three) {
        resetBookmarksInWord_three()
        updateWord_three(newBookmark.copy(bookmark = 1))
    }

    @Transaction
    suspend fun setBookmarkForTb_Adjectives(newBookmark: SealedClass.Tb_Adjectives) {
        resetBookmarksIntb_Adjectives()
        updateTb_Adjectives(newBookmark.copy(bookmark = 1))
    }

    @Transaction
    suspend fun setBookmarkForTb_Clothes_and_toilet_articles(newBookmark: SealedClass.Tb_Clothes_and_toilet_articles) {
        resetBookmarksIntb_Clothes_and_toilet_articles()
        updateTb_Clothes_and_toilet_articles(newBookmark.copy(bookmark = 1))
    }

    @Transaction
    suspend fun setBookmarkForTb_Colours(newBookmark: SealedClass.Tb_Colours) {
        resetBookmarksIntb_Colours()
        updateTb_Colours(newBookmark.copy(bookmark = 1))
    }

    @Transaction
    suspend fun setBookmarkForTb_Family(newBookmark: SealedClass.Tb_Family) {
        resetBookmarksIntb_Family()
        updateTb_Family(newBookmark.copy(bookmark = 1))
    }

    @Transaction
    suspend fun setBookmarkForTb_fruit(newBookmark: SealedClass.Tb_fruit) {
        resetBookmarksIntb_fruit()
        updateTb_fruit(newBookmark.copy(bookmark = 1))
    }

    @Transaction
    suspend fun setBookmarkForTb_Houseandfurniture(newBookmark: SealedClass.Tb_Houseandfurniture) {
        resetBookmarksIntb_Houseandfurniture()
        updateTb_Houseandfurniture(newBookmark.copy(bookmark = 1))
    }

    @Transaction
    suspend fun setBookmarkForTb_Human_body(newBookmark: SealedClass.Tb_Human_body) {
        resetBookmarksIntb_Human_body()
        updateTb_Human_body(newBookmark.copy(bookmark = 1))
    }

    @Transaction
    suspend fun setBookmarkForTb_jobs(newBookmark: SealedClass.Tb_jobs) {
        resetBookmarksIntb_jobs()
        updateTb_jobs(newBookmark.copy(bookmark = 1))
    }

    @Transaction
    suspend fun setBookmarkForTb_Kitchen_tools(newBookmark: SealedClass.Tb_Kitchen_tools) {
        resetBookmarksIntb_Kitchen_tools()
        updateTb_Kitchen_tools(newBookmark.copy(bookmark = 1))
    }

    @Transaction
    suspend fun setBookmarkForTb_places(newBookmark: SealedClass.Tb_places) {
        resetBookmarksIntb_places()
        updateTb_places(newBookmark.copy(bookmark = 1))
    }

    @Transaction
    suspend fun setBookmarkForTb_Pronoun(newBookmark: SealedClass.Tb_Pronoun) {
        resetBookmarksIntb_Pronoun()
        updateTb_Pronoun(newBookmark.copy(bookmark = 1))
    }

    @Transaction
    suspend fun setBookmarkForTb_school(newBookmark: SealedClass.Tb_school) {
        resetBookmarksIntb_school()
        updateTb_school(newBookmark.copy(bookmark = 1))
    }

    @Transaction
    suspend fun setBookmarkForTb_Similar_words(newBookmark: SealedClass.Tb_Similar_words) {
        resetBookmarksIntb_Similar_words()
        updateTb_Similar_words(newBookmark.copy(bookmark = 1))
    }

    @Transaction
    suspend fun setBookmarkForTb_The_animals(newBookmark: SealedClass.Tb_The_animals) {
        resetBookmarksIntb_The_animals()
        updateTb_The_animals(newBookmark.copy(bookmark = 1))
    }

    @Transaction
    suspend fun setBookmarkForTb_transports(newBookmark: SealedClass.Tb_transports) {
        resetBookmarksIntb_transports()
        updateTb_transports(newBookmark.copy(bookmark = 1))
    }

    @Transaction
    suspend fun setBookmarkForTv_verbs(newBookmark: SealedClass.Tv_verbs) {
        resetBookmarksIntv_verbs()
        updateTv_verbs(newBookmark.copy(bookmark = 1))
    }



//    constructor() : this(0, "", "")
}