package com.example.diffutilrv.api

import com.example.diffutilrv.ui.employee.model.Employee
import kotlinx.coroutines.flow.Flow

interface ApiService {
    fun getEmployeeList(): Flow<List<Employee>>
}