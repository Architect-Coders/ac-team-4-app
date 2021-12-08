package com.team4.boulderbuild

import android.app.Application
import com.team4.boulderbuild.model.data.database.GymDatabase
import com.team4.boulderbuild.model.data.database.GymsRoomDataSource
import com.team4.boulderbuild.model.data.server.GymsRemoteDataSourceFake
import com.team4.boulderbuild.ui.dashboard.DashboardFragment
import com.team4.boulderbuild.ui.dashboard.DashboardViewModel
import com.team4.boulderbuild.ui.gymform.GymFormFragment
import com.team4.boulderbuild.ui.gymform.GymFormViewModel
import com.team4.boulderbuild.ui.gyms.GymsFragment
import com.team4.boulderbuild.ui.gyms.GymsViewModel
import com.team4.boulderbuild.ui.notifications.NotificationsFragment
import com.team4.boulderbuild.ui.notifications.NotificationsViewModel
import com.team4.data.repository.GymsRepository
import com.team4.data.source.GymsLocalDataSource
import com.team4.data.source.GymsRemoteDataSource
import com.team4.usecases.FindGymById
import com.team4.usecases.GetAllGyms
import com.team4.usecases.UpdateGym
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

fun Application.initDI() {
    startKoin {
        androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
        androidContext(this@initDI)
        modules(listOf(appModule, dataModule, scopesModule))
    }
}

private val appModule = module {
    single { GymDatabase.build(get()) }
    factory<GymsLocalDataSource> { GymsRoomDataSource(get()) }
    factory<GymsRemoteDataSource> { GymsRemoteDataSourceFake() }

    single<CoroutineDispatcher> { Dispatchers.Main }
}

val dataModule = module {
    factory { GymsRepository(get(), get()) }
}

private val scopesModule = module {
    scope<GymsFragment> {
        viewModel { GymsViewModel(get(), get()) }
        scoped { GetAllGyms(get()) }
    }

    scope<DashboardFragment> {
        viewModel { DashboardViewModel() }
    }

    scope<NotificationsFragment> {
        viewModel { NotificationsViewModel() }
    }

    scope<GymFormFragment> {
        viewModel { (id: Int) -> GymFormViewModel(id, get(), get(), get()) }
        scoped { FindGymById(get()) }
        scoped { UpdateGym(get()) }
    }
}
