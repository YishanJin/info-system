package com.yishanjin.infosystem.controller;

import com.yishanjin.infosystem.dao.DepartmentDao;
import com.yishanjin.infosystem.dao.EmployeeDao;
import com.yishanjin.infosystem.entities.Department;
import com.yishanjin.infosystem.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);

        //thymeleaf默认就会拼串
        //classpath:/templates/xxx.html
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到添加页面,查出所有部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){//SpringMVC自动将请求参数和入参对象的属性一一绑定，要求请求参数的名字和javaBean入参的对象属性名是一样的
        System.out.println(""+employee);
        employeeDao.save(employee);
        //来到员工列表页面
        //redirect:表示重定向到一个地址 /表示当项目路径
        //forward:表示转发到一个地址
        return "redirect:/emps";
    }
}
