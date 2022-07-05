package com.thugrzz.kodeinsample.android.ext

import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import org.kodein.di.DIAware
import org.kodein.di.direct
import org.kodein.di.instance

inline fun <reified VM : ViewModel, T> T.activityViewModel(): Lazy<VM> where T : DIAware, T : FragmentActivity {
    return viewModels(factoryProducer = { direct.instance() })
}