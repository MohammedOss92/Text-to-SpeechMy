package com.sarrawi.tts

import androidx.recyclerview.widget.DiffUtil

class WordDiffCallback(
    private val oldList: List<Pair<String, String>>,
    private val newList: List<Pair<String, String>>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size
    override fun getNewListSize() = newList.size
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]
}
