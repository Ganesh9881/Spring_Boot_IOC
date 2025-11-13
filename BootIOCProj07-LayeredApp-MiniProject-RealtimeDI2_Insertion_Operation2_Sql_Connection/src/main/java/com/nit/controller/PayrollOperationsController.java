package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nit.model.Employee;
import com.nit.service.IEmployeeMgmtService;

@Controller("controller")
public class PayrollOperationsController 
{
	@Autowired
	private  IEmployeeMgmtService  empService;
	
	public    List<Employee> getEmployeesByDesgs(String desg1,String desg2,String desg3 ) throws Exception{
		System.out.println("PayrollOperationsController.getEmployeesByDesgs()");
		 //use service
		List<Employee>  list=empService.fetchEmployeesByDesgs(desg1, desg2, desg3);
		return list;
	}
	
	public String processEmployee(Employee emp) throws Exception
	{
		//use service
		String resultMsg = empService.registerEmployee(emp);
		return resultMsg;
	}

	
}
