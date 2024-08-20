package com.sarrawi.tts.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

sealed class SealedClass {

    @Entity(tableName ="Words")
    data class Word (
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo("ID")
        var ID:Int,
        @ColumnInfo("English_Word")
        var English_Word :String?,
        @ColumnInfo("Arabic_Word")
        var Arabic_Word :String?,
    ): SealedClass()

    @Entity(tableName ="Words_two")
    data class Words_two(    @PrimaryKey(autoGenerate = true)
                             @ColumnInfo("ID")
                             var ID:Int,
                             @ColumnInfo("English_Word")
                             var English_Word :String?,
                             @ColumnInfo("Arabic_Word")
                             var Arabic_Word :String?,
    ): SealedClass()

    @Entity(tableName ="Word_three")
    data class Word_three(    @PrimaryKey(autoGenerate = true)
                              @ColumnInfo("ID")
                              var ID:Int,
                              @ColumnInfo("English_Word")
                              var English_Word :String?,
                              @ColumnInfo("Arabic_Word")
                              var Arabic_Word :String?,
    ): SealedClass()

    @Entity(tableName ="tb_Adjectives")
    data class Tb_Adjectives(    @PrimaryKey(autoGenerate = true)
                                 @ColumnInfo("ID")
                                 var ID:Int,
                                 @ColumnInfo("English_Word")
                                 var English_Word :String?,
                                 @ColumnInfo("Arabic_Word")
                                 var Arabic_Word :String?,
    ): SealedClass()

    @Entity(tableName ="tb_Clothes_and_toilet_articles")
    data class Tb_Clothes_and_toilet_articles(    @PrimaryKey(autoGenerate = true)
                                                  @ColumnInfo("ID")
                                                  var ID:Int,
                                                  @ColumnInfo("English_Word")
                                                  var English_Word :String?,
                                                  @ColumnInfo("Arabic_Word")
                                                  var Arabic_Word :String?,
    ): SealedClass()

    @Entity(tableName ="tb_Colours")
    data class Tb_Colours(    @PrimaryKey(autoGenerate = true)
                              @ColumnInfo("ID")
                              var ID:Int,
                              @ColumnInfo("English_Word")
                              var English_Word :String?,
                              @ColumnInfo("Arabic_Word")
                              var Arabic_Word :String?,
    ): SealedClass()

    @Entity(tableName ="tb_Family")
    data class Tb_Family(    @PrimaryKey(autoGenerate = true)
                             @ColumnInfo("ID")
                             var ID:Int,
                             @ColumnInfo("English_Word")
                             var English_Word :String?,
                             @ColumnInfo("Arabic_Word")
                             var Arabic_Word :String?,
    ): SealedClass()

    @Entity(tableName ="tb_fruit")
    data class Tb_fruit(    @PrimaryKey(autoGenerate = true)
                            @ColumnInfo("ID")
                            var ID:Int,
                            @ColumnInfo("English_Word")
                            var English_Word :String?,
                            @ColumnInfo("Arabic_Word")
                            var Arabic_Word :String?,
    ): SealedClass()

    @Entity(tableName ="tb_Houseandfurniture")
    data class Tb_Houseandfurniture(    @PrimaryKey(autoGenerate = true)
                                        @ColumnInfo("ID")
                                        var ID:Int,
                                        @ColumnInfo("English_Word")
                                        var English_Word :String?,
                                        @ColumnInfo("Arabic_Word")
                                        var Arabic_Word :String?,
    ): SealedClass()

    @Entity(tableName ="tb_Human_body")
    data class Tb_Human_body(    @PrimaryKey(autoGenerate = true)
                                 @ColumnInfo("ID")
                                 var ID:Int,
                                 @ColumnInfo("English_Word")
                                 var English_Word :String?,
                                 @ColumnInfo("Arabic_Word")
                                 var Arabic_Word :String?,
    ): SealedClass()

    @Entity(tableName ="tb_jobs")
    data class Tb_jobs(    @PrimaryKey(autoGenerate = true)
                           @ColumnInfo("ID")
                           var ID:Int,
                           @ColumnInfo("English_Word")
                           var English_Word :String?,
                           @ColumnInfo("Arabic_Word")
                           var Arabic_Word :String?,
    ): SealedClass()

    @Entity(tableName ="tb_Kitchen_tools")
    data class Tb_Kitchen_tools(    @PrimaryKey(autoGenerate = true)
                                    @ColumnInfo("ID")
                                    var ID:Int,
                                    @ColumnInfo("English_Word")
                                    var English_Word :String?,
                                    @ColumnInfo("Arabic_Word")
                                    var Arabic_Word :String?,
    ): SealedClass()

    @Entity(tableName ="tb_places")
    data class Tb_places(    @PrimaryKey(autoGenerate = true)
                             @ColumnInfo("ID")
                             var ID:Int,
                             @ColumnInfo("English_Word")
                             var English_Word :String?,
                             @ColumnInfo("Arabic_Word")
                             var Arabic_Word :String?,
    ): SealedClass()

    @Entity(tableName ="tb_Pronoun")
    data class Tb_Pronoun(    @PrimaryKey(autoGenerate = true)
                              @ColumnInfo("ID")
                              var ID:Int,
                              @ColumnInfo("English_Word")
                              var English_Word :String?,
                              @ColumnInfo("Arabic_Word")
                              var Arabic_Word :String?,
    ): SealedClass()

    @Entity(tableName ="tb_school")
    data class Tb_school(    @PrimaryKey(autoGenerate = true)
                             @ColumnInfo("ID")
                             var ID:Int,
                             @ColumnInfo("English_Word")
                             var English_Word :String?,
                             @ColumnInfo("Arabic_Word")
                             var Arabic_Word :String?,
    ): SealedClass()

    @Entity(tableName ="tb_Similar_words")
    data class Tb_Similar_words(    @PrimaryKey(autoGenerate = true)
                                    @ColumnInfo("ID")
                                    var ID:Int,
                                    @ColumnInfo("English_Word")
                                    var English_Word :String?,
                                    @ColumnInfo("Arabic_Word")
                                    var Arabic_Word :String?,
    ): SealedClass()

    @Entity(tableName ="tb_The_animals")
    data class Tb_The_animals(    @PrimaryKey(autoGenerate = true)
                                  @ColumnInfo("ID")
                                  var ID:Int,
                                  @ColumnInfo("English_Word")
                                  var English_Word :String?,
                                  @ColumnInfo("Arabic_Word")
                                  var Arabic_Word :String?,
    ): SealedClass()

    @Entity(tableName ="tb_transports")
    data class Tb_transports(    @PrimaryKey(autoGenerate = true)
                                 @ColumnInfo("ID")
                                 var ID:Int,
                                 @ColumnInfo("English_Word")
                                 var English_Word :String?,
                                 @ColumnInfo("Arabic_Word")
                                 var Arabic_Word :String?,
    ): SealedClass()

    @Entity(tableName ="tv_verbs")
    data class Tv_verbs(    @PrimaryKey(autoGenerate = true)
                            @ColumnInfo("ID")
                            var ID:Int,
                            @ColumnInfo("English_Word")
                            var English_Word :String?,
                            @ColumnInfo("Arabic_Word")
                            var Arabic_Word :String?,
    ): SealedClass()
}