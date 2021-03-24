package com.glushkov.wealthparktest.ui.base

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData


/**
 * Simple functionality set up here, to not waste time on workarounds, but to keep code clean and not repeated.
 */
open class BaseFragment : Fragment() {

    fun subscribeToErrorLiveData(data: LiveData<String>, lifecycleOwner: LifecycleOwner, callback : (String) -> Unit) {
        data.observe(lifecycleOwner) {
            callback(it)
        }
    }

    /**
     * Set loading view visible
     * @param view loading view
     */
    fun showLoading(view: View) {
        view.visibility = View.VISIBLE
    }


    /**
     * Set loading view invisible
     * @param view loading view
     */
    fun hideLoading(view: View) {
        view.visibility = View.GONE
    }
}