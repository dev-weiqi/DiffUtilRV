package com.example.diffutilrv.ui.employee

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutilrv.databinding.ItemEmployeeBinding
import com.example.diffutilrv.ui.employee.model.Employee

class EmployeeAdapter :
    ListAdapter<Employee, EmployeeAdapter.EmployeeViewHolder>(EmployeeDiffItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        return EmployeeViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onViewRecycled(holder: EmployeeViewHolder) {
        holder.unbind()
    }

    class EmployeeViewHolder(private val binding: ItemEmployeeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(employee: Employee) {
            binding.employeeName.text = employee.name
            binding.employeeRole.text = employee.role
        }

        fun unbind() {
        }

        companion object {
            fun create(parent: ViewGroup): EmployeeViewHolder {
                return EmployeeViewHolder(
                    ItemEmployeeBinding.inflate(
                        LayoutInflater
                            .from(parent.context), parent, false
                    )
                )
            }
        }
    }

    class EmployeeDiffItemCallback : DiffUtil.ItemCallback<Employee>() {
        override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean {
            return oldItem.name == newItem.name
        }
    }
}