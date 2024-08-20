package com.sarrawi.tts.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Word_three(    @PrimaryKey(autoGenerate = true)
                          @ColumnInfo("ID")
                          var ID:Int,
                          @ColumnInfo("English_Word")
                          var English_Word :String?,
                          @ColumnInfo("Arabic_Word")
                          var Arabic_Word :String?,
)
