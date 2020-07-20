package com.andrethlckr.countit.presentation.adapters

import android.text.format.DateUtils
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.andrethlckr.countit.presentation.adapters.recycleradapter.RecyclerItem
import com.andrethlckr.countit.presentation.adapters.recycleradapter.RecyclerViewAdapter
import com.google.android.material.textfield.TextInputLayout
import java.util.*

infix fun Int.with(x: Int) = this.or(x)

@BindingAdapter("items")
fun setRecyclerViewItems(
    recyclerView: RecyclerView,
    items: List<RecyclerItem>?
) {
    var adapter = (recyclerView.adapter as? RecyclerViewAdapter)

    if (adapter == null) {
        adapter = RecyclerViewAdapter()
        recyclerView.adapter = adapter
    }

    adapter.updateData(items.orEmpty())
}

@BindingAdapter("app:error")
fun setError(
    textInputLayout: TextInputLayout,
    resId: Int?
) {
    val currentError = textInputLayout.error.toString()

    if(resId == null) {
        if (currentError.isEmpty()) return

        textInputLayout.error = null
        textInputLayout.isErrorEnabled = false
    } else {
        val newError = textInputLayout.context.getString(resId)
        if(newError == currentError) return
        textInputLayout.error = newError
    }
}

@BindingAdapter("app:text")
fun setText(
    textView: TextView,
    date: GregorianCalendar
) {
    textView.text = DateUtils.formatDateTime(
        textView.context,
        date.timeInMillis,
        DateUtils.FORMAT_SHOW_DATE with
                DateUtils.FORMAT_NUMERIC_DATE with
                DateUtils.FORMAT_SHOW_YEAR
    )
}