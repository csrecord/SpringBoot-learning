package com.example.dao;


import com.example.pojo.Department;
import com.example.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;

@Repository
public class EmployeeDao {
    //模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;
    //所属部门
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees.put(1001, new Employee(1001, "陈三", "1223456@qq.com", 1, new Department(101, "教学")));
        employees.put(1002, new Employee(1002, "陈飞", "1223462@qq.com", 0, new Department(102, "管理")));
        employees.put(1003, new Employee(1003, "陈小", "1232344@qq.com", 1, new Department(103, "教研")));
        employees.put(1004, new Employee(1004, "小陈", "1212333@qq.com", 0, new Department(104, "运营")));
        employees.put(1005, new Employee(1005, "小李", "1254326@qq.com", 1, new Department(105, "市场")));
    }

    //主键自增
    private static Integer initId = 1006;

    //增加一个员工
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    //查询全部员工信息
    public Collection<Employee> getAll() {
        return employees.values();
    }

    //通过ID查询员工
    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    //删除ID
    public Employee deleteEmployeeById(Integer id) {
        return employees.remove(id);
    }

}
