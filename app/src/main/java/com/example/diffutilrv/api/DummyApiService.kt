package com.example.diffutilrv.api

import com.example.diffutilrv.ui.employee.model.Employee
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DummyApiService : ApiService {

    override fun getEmployeeList(): Flow<List<Employee>> {
        return flow {
            // 模擬耗時請求
            delay(1000)
            emit(mutableListOf<Employee>().apply {
                add(Employee(1, "Employee 1", "Developer"))
                add(Employee(2, "Employee 2", "Tester"))
                add(Employee(3, "Employee 3", "Support"))
                add(Employee(4, "Employee 4", "Sales Manager"))
                add(Employee(5, "Employee 5", "Manager"))
                add(Employee(6, "Employee 6", "Team lead"))
                add(Employee(7, "Employee 7", "Scrum Master"))
                add(Employee(8, "Employee 8", "Sr. Tester"))
                add(Employee(9, "Employee 9", "Sr. Developer"))
            })
        }
    }
}