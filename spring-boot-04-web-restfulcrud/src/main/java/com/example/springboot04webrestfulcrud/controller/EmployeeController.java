package com.example.springboot04webrestfulcrud.controller;

import com.example.springboot04webrestfulcrud.dao.DepartmentDao;
import com.example.springboot04webrestfulcrud.dao.EmployeeDao;
import com.example.springboot04webrestfulcrud.entities.Department;
import com.example.springboot04webrestfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author 李家幸
 * @class 计科三班
 * @create 2019-12-06 15:38
 */
@Controller
public class EmployeeController {
    private EmployeeDao employeeDao;
    private DepartmentDao departmentDao;

    @Autowired
    public EmployeeController(EmployeeDao employeeDao, DepartmentDao departmentDao) {
        this.employeeDao = employeeDao;
        this.departmentDao = departmentDao;
    }

    @GetMapping("/emps")
    public String EmpList(Model model) {
        Collection<Employee> employeeCollections = employeeDao.getAll();
        model.addAttribute("emps", employeeCollections);
        return "emps/list";
    }

    @GetMapping("/emp")
    public String toAddEmployeePage(Model model) {
        Collection<Department> departmentCollections = departmentDao.getDepartments();
        model.addAttribute("departments", departmentCollections);
        return "emps/addemp";
    }

    @PostMapping("/emp")
    public String addEmployee(Employee employee) {
        //来到员工查询页面
        System.out.println("保存的员工信息" + employee);
        //保存员工信息
        employeeDao.save(employee);
        return "redirect:emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditEmployee(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        System.out.println(employee);
        model.addAttribute("emp", employee);
        Collection<Department> departmentCollections = departmentDao.getDepartments();
        model.addAttribute("departments", departmentCollections);
        return "emps/addemp";
    }

    //员工修改；需要提交员工id；
    @RequestMapping(value = "/emp", method = RequestMethod.PUT)
    public String updateEmployee(Employee employee) {
        System.out.println("修改的员工数据：" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
