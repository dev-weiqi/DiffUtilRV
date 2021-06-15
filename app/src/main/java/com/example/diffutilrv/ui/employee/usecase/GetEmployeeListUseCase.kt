package com.example.diffutilrv.ui.employee.usecase

import com.example.diffutilrv.ui.employee.SortType
import com.example.diffutilrv.ui.employee.model.Employee
import com.example.diffutilrv.ui.employee.repository.EmployeeRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetEmployeeListUseCase(private val employeeRepo: EmployeeRepo) {

    operator fun invoke(sortType: SortType): Flow<List<Employee>> {
        return employeeRepo.getEmployeeList()
            .map {
                when (sortType) {
                    SortType.NAME -> getEmployeeByName(it)
                    SortType.ROLE -> getEmployeeByRole(it)
                }
            }
    }

    private fun getEmployeeByName(employeeList: List<Employee>): List<Employee> {
        return employeeList.sortedBy { it.name }
    }

    private fun getEmployeeByRole(employeeList: List<Employee>): List<Employee> {
        return employeeList.sortedBy { it.role }
    }
}