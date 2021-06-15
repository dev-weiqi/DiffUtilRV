package com.example.diffutilrv.di

import com.example.diffutilrv.api.ApiService
import com.example.diffutilrv.api.DummyApiService
import com.example.diffutilrv.ui.employee.EmployeeViewModel
import com.example.diffutilrv.ui.employee.repository.EmployeeRepo
import com.example.diffutilrv.ui.employee.repository.EmployeeRepoImpl
import com.example.diffutilrv.ui.employee.usecase.GetEmployeeListUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class DiModule {

    private val networkModule = module {
        single<ApiService> { DummyApiService() }
    }

    private val repositoryModule = module {
        factory<EmployeeRepo> { EmployeeRepoImpl(api = get()) }
    }

    private val useCaseModule = module {
        factory { GetEmployeeListUseCase(employeeRepo = get()) }
    }

    private val viewModelModule = module {
        viewModel { EmployeeViewModel(getEmployeeListUseCase = get()) }
    }

    fun init() {
        startKoin {
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}