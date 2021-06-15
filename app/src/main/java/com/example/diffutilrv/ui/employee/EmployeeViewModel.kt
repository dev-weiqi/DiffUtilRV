package com.example.diffutilrv.ui.employee

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diffutilrv.ui.employee.model.Employee
import com.example.diffutilrv.ui.employee.usecase.GetEmployeeListUseCase
import com.example.diffutilrv.uistate.StatefulLiveData
import com.example.diffutilrv.uistate.StatefulMutableLiveData
import com.example.diffutilrv.uistate.UiState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class EmployeeViewModel(private val getEmployeeListUseCase: GetEmployeeListUseCase) : ViewModel() {

    val employeeList: StatefulLiveData<List<Employee>>
        get() = _employeeList
    private val _employeeList = StatefulMutableLiveData<List<Employee>>()

    init {
        fetchEmployeeList(SortType.NAME)
    }

    fun fetchEmployeeListByName() {
        return fetchEmployeeList(SortType.NAME)
    }

    fun fetchEmployeeListByRole() {
        return fetchEmployeeList(SortType.ROLE)
    }

    private fun fetchEmployeeList(sortType: SortType) {
        viewModelScope.launch {
            getEmployeeListUseCase(sortType)
                .onStart { _employeeList.value = UiState.loading() }
                .catch { _employeeList.value = UiState.failure(it) }
                .collect { _employeeList.value = UiState.success(it) }
        }
    }
}