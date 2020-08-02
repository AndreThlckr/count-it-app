package com.andrethlckr.countit.presentation.common.adapters.recycleradapter

import com.andrethlckr.countit.presentation.common.adapters.recycleradapter.RecyclerItem

interface RecyclerItemComparator {
    fun isSameItem(other: RecyclerItem): Boolean
    fun isSameContent(other: RecyclerItem): Boolean
}