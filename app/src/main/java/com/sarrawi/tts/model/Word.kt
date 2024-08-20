package com.sarrawi.tts.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="Words")
data class Word (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("ID")
    var ID:Int,
    @ColumnInfo("English_Word")
    var English_Word :String?,
    @ColumnInfo("Arabic_Word")
    var Arabic_Word :String?,
        )
