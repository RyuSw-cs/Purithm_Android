package com.cmc.purithm.common.ui.bindingAdapters

import android.view.View
import android.widget.Button
import androidx.databinding.BindingAdapter
import com.cmc.purithm.common.ui.view.DelayClickEventListener

/**
 * 버튼에 공통적으로 사용되는 BindingAdapter
 *
 * @author Yu Seung Woo
 * @since 2024-07-05
 * */
object ButtonBindingAdapters {
    /**
     * 클릭 이벤트 (default로 Delay 설정)
     *
     * @param listener 실제 View가 클릭됐을 때, 동작되는 Listener
     * */
    @JvmStatic
    @BindingAdapter("clickEvent")
    fun Button.addButtonClickEvent(listener : View.OnClickListener){
        this.setOnClickListener(DelayClickEventListener(onClickListener = listener))
    }
}