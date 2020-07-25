package com.andrethlckr.countit.presentation.adapters.recycleradapter.comparators

import com.andrethlckr.countit.presentation.adapters.recycleradapter.RecyclerItem

interface RecyclerItemComparator {
    fun isSameItem(other: RecyclerItem): Boolean
    fun isSameContent(other: RecyclerItem): Boolean
}