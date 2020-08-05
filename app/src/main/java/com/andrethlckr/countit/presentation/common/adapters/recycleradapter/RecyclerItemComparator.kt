package com.andrethlckr.countit.presentation.common.adapters.recycleradapter

interface RecyclerItemComparator {
    fun isSameItem(other: RecyclerItem): Boolean
    fun isSameContent(other: RecyclerItem): Boolean
}
