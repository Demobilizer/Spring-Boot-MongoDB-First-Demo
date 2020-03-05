/**
 * 
 */
package com.demo.controller;

import java.util.List;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.model.Employee;
import com.demo.repository.EmployeeRepo;

/**
 * @author Mehul
**/

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@RequestMapping(value = "/add-employee", method = RequestMethod.POST)
	@ResponseBody
	public String addEmployee(@RequestBody Employee employee) {
		employeeRepo.save(employee);
		return "employee added successfully with: "+employee;
	}
	
	@RequestMapping(value = "/get-employees", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}
	
	@RequestMapping(value = "/delete/{empId}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteEmployee(@PathVariable int empId) {
		employeeRepo.deleteById(empId);
		return "deleted employee with Id: "+empId;
	}
	
	@RequestMapping(value = "/update/{empId}", method = RequestMethod.PUT)
	@ResponseBody
	public String updateEmployee(@PathVariable int empId, @RequestBody Employee employee) {
		employee.setEmpId(empId);
		employeeRepo.save(employee);
		return "updated employee with Id: "+empId;
	}
	
}
