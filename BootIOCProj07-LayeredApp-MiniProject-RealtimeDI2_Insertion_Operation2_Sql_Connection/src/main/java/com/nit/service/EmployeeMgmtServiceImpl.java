package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nit.dao.IEmployeeDAO;
import com.nit.model.Employee;

@Service("empservice")
public class EmployeeMgmtServiceImpl  implements IEmployeeMgmtService
{
	@Autowired
	@Qualifier("empMYSQLDAO")
	private IEmployeeDAO empDAO;
	

	@Override
	public List<Employee> fetchEmployeesByDesgs(String desg1, String desg2, String desg3) throws Exception {
		System.out.println("EmployeeMgmtServiceImpl.fetchEmployeesByDesgs()");
		
		//convert given desgs into uppercase letters(b.logic)
		desg1=desg1.toUpperCase();
		desg2=desg2.toUpperCase();
		desg3=desg3.toUpperCase();
		
		//use DAO
		List<Employee> list = empDAO.showEmployeesByDesgs(desg1, desg2, desg3);
		//calculate grossSalary and netSalary (b.logic)
				list.forEach(emp->{
					emp.setGrossSalary(emp.getSal()+emp.getSal()*0.2f);
					emp.setNetSalary(emp.getGrossSalary()-emp.getGrossSalary()*0.1f);
				});
				return list;
	}
				
				
				@Override
				public String registerEmployee(Employee emp) throws Exception
				{
					//use DAO
					int result = empDAO.insertEmployee(emp);
					return result ==0?"Employee not registered ":"Employee is registered";
					
				
	}

}

