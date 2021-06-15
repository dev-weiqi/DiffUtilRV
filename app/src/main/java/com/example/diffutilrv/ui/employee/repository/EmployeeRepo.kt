package com.example.diffutilrv.ui.employee.repository

import com.example.diffutilrv.api.ApiService
import com.example.diffutilrv.ui.employee.model.Employee
import kotlinx.coroutines.flow.Flow

interface EmployeeRepo {
    fun getEmployeeList(): Flow<List<Employee>>
}

class EmployeeRepoImpl(private val api: ApiService) : EmployeeRepo {
    override fun getEmployeeList(): Flow<List<Employee>> {
        return api.getEmployeeList()
    }
}