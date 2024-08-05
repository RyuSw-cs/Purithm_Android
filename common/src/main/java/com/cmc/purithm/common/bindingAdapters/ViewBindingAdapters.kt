package com.cmc.purithm.common.bindingAdapters

import android.view.View
import android.widget.ImageButton
import androidx.databinding.BindingAdapter
import com.cmc.purithm.common.R
import com.cmc.purithm.common.view.DelayClickEventListener

/**
 * 버튼에 공통적으로 사용되는 BindingAdapter
 *
 * @author Yu Seung Woo
 * @since 2024-07-05
 * */
object ViewBindingAdapters {
    /**
     * 클릭 이벤트 (default로 Delay 설정)
     *
     * @param listener 실제 View가 클릭됐을 때, 동작되는 Listener
     * */
    @JvmStatic
    @BindingAdapter("clickEvent")
    fun View.addButtonClickEvent(listener: View.OnClickListener) {
        this.setOnClickListener(DelayClickEventListener(onClickListener = listener))
    }

    /**
     * 찜 클릭
     * */
    @JvmStatic
    @BindingAdapter("liked")
    fun ImageButton.setLiked(isLiked: Boolean) {
        setImageResource(if (isLiked) com.cmc.purithm.design.R.drawable.ic_like_pressed else com.cmc.purithm.design.R.drawable.ic_like_unpressed)
    }

}