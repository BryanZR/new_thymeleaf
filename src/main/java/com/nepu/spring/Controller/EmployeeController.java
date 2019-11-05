package com.nepu.spring.Controller;

import com.nepu.spring.dao.DepartmentDao;
import com.nepu.spring.dao.EmployeeDao;
import com.nepu.spring.entities.Department;
import com.nepu.spring.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentdao;

    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中共享
        model.addAttribute("emps", employees);
        return "emp/list";
    }
    /*@PostMapping("/emps2")
    public String list2(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中共享
        model.addAttribute("emps", employees);
        return "emp/list";
    }*/

    @GetMapping("/emp")
    public String toadd(Model model) {
        //查所有的部门
        Collection<Department> departments = departmentdao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }


    //员工添加功能
    @PostMapping("/emp")
    public String addemp(Employee employee) {
//        springmvc自动请求参数和入参对象的属性一一绑定,请求参数的名字和javabean的入参的对象的属性一致
        //添加完成之后直接回到list页面
        System.out.println("保存的信息是: " + employee);
        employeeDao.save(employee);
        //    redirect表示重定向到一个地址(请求) /代表当前项目路径
        //    forward 表示转发到一个地址
        return "redirect:/emps";
    }

    //    来到修改页面查出当前然后再页面回显
    @GetMapping("/emp/{id}")
    public String editemp(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        System.out.println("emoloyee的内容是"+employee);
//查出部门名称
        Collection<Department> departments = departmentdao.getDepartments();
        model.addAttribute("depts", departments);
        //修改添加二合一
        return "emp/add";
    }

}
