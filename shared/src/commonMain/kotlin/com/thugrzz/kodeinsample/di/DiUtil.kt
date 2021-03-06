package com.thugrzz.kodeinsample.di

import org.kodein.di.DI
import org.kodein.di.DirectDI
import org.kodein.di.direct
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object DiUtil {

    internal val di: DirectDI
        get() = requireNotNull(_di)
    private var _di: DirectDI? = null

    fun init() {
        if (_di != null) {
            _di = null
        }

        val direct = DI {
            importAll(
                dataSourceModule,
                repositoryModule,
            )
        }.direct

        _di = direct
    }
}