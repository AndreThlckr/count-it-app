package com.andrethlckr.countit.presentation.common.adapters

import android.text.format.DateUtils
import android.view.View
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.andrethlckr.countit.presentation.common.adapters.recycleradapter.RecyclerAdapter
import com.andrethlckr.countit.presentation.common.adapters.recycleradapter.RecyclerItem
import com.andrethlckr.countit.presentation.common.getColorCompat
import com.google.android.material.textfield.TextInputLayout
import java.time.LocalDate
import java.time.ZoneOffset

infix fun Int.with(x: Int) = this.or(x)

@BindingAdapter("items")
fun setRecyclerViewItems(
    recyclerView: RecyclerView,
    items: List<RecyclerItem>?
) {
    var adapter = (recyclerView.adapter as? RecyclerAdapter)

    if (adapter == null) {
        adapter = RecyclerAdapter()
        recyclerView.adapter = adapter
    }

    adapter.submitList(items.orEmpty())
}

@BindingAdapter("app:error")
fun setError(
    textInputLayout: TextInputLayout,
    resId: Int?
) {
    val currentError = textInputLayout.error.toString()

    if (resId == null) {
        if (currentError.isEmpty()) return

        textInputLayout.error = null
        textInputLayout.isErrorEnabled = false
    } else {
        val newError = textInputLayout.context.getString(resId)
        if (newError == currentError) return
        textInputLayout.error = newError
    }
}

@BindingAdapter("app:text")
fun setText(
    textView: TextView,
    date: LocalDate
) {
    textView.text = DateUtils.formatDateTime(
        textView.context,
        date.atStartOfDay(ZoneOffset.UTC).toEpochSecond(),
        DateUtils.FORMAT_SHOW_DATE with
            DateUtils.FORMAT_NUMERIC_DATE with
            DateUtils.FORMAT_SHOW_YEAR
    )
}

@BindingAdapter("app:textColorRes")
fun setText(
    textView: TextView,
    @ColorRes color: Int
) {
    textView.setTextColor(textView.context.getColorCompat(color))
}

@BindingAdapter("app:onClick")
fun onClick(view: View, onClick: () -> Unit) {
    view.setOnClickListener {
        onClick()
    }
}
