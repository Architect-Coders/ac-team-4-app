package com.team4.boulderBuild.ui.common

import android.util.Log
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob

interface Scope : CoroutineScope {

    class Impl : Scope {
        override lateinit var job: Job
    }

    var job: Job
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    fun initScope() {
        Log.d("ScopedViewModel", "init!!!!!!!!!!!!!!!!!!!!!!!!!!!!" )
        job = SupervisorJob()
    }

    fun destroyScope() {
        job.cancel()
    }
}