package tech.thdev.simpleadapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

abstract class AndroidViewHolder(override val containerView: View)
    : RecyclerView.ViewHolder(containerView), LayoutContainer