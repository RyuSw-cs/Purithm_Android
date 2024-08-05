package com.cmc.purithm.common.base

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import com.cmc.purithm.common.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * BottomSheetDialogFragment Base 코드
 *
 * @since 2024-07-14
 * @author Yu Seung Woo
 * */
abstract class BaseBottomSheetDialogFragment<T : ViewDataBinding> : BottomSheetDialogFragment() {
    private var _binding: T? = null
    val binding get() = requireNotNull(_binding)
    abstract val layoutResourceId: Int

    abstract fun initView()
    abstract fun initDataBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(
            DialogFragment.STYLE_NORMAL,
            com.cmc.purithm.design.R.style.style_transparent_bottom_sheet_dialog_fragment
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutResourceId, container, false)
        initDataBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setExpandedDialog()
    }

    /**
     * BottomSheetDialog를 전체 화면으로 설정
     * */
    private fun setExpandedDialog() {
        val bottomSheet =
            dialog?.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
        if (bottomSheet != null) {
            val behavior = BottomSheetBehavior.from<View>(bottomSheet)
            behavior.state = BottomSheetBehavior.STATE_EXPANDED

            behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                        behavior.state = BottomSheetBehavior.STATE_EXPANDED
                    }
                }

                override fun onSlide(bottomSheet: View, newState: Float) {
                    behavior.state = BottomSheetBehavior.STATE_EXPANDED
                }
            })
            bottomSheet.setBackgroundResource(com.cmc.purithm.design.R.drawable.bg_bottom_sheet_dialog)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}