package com.thugrzz.kodeinsample.di

import com.thugrzz.kodeinsample.data.model.Note
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val dataSourceModule = DI.Module(
    name = "DataSourceModule",
    init = {
        bind {
            singleton {
                val configuration = RealmConfiguration.create(
                    schema = setOf(
                        Note::class,
                    ),
                )
                Realm.open(configuration)
            }
        }
    }
)

val DiUtil.db: Realm
    get() = DiUtil.di.instance()