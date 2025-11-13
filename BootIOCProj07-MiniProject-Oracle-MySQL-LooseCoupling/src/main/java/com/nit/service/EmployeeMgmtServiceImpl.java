package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nit.dao.IEmployeeDAO;
import com.nit.model.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService
{
	@Autowired
	//@Qualifier("empMySQLDAO")
	//@Qualifier("empOraDAO")
	
	@Qualifier("mydao")
	private IEmployeeDAO empDAO;

	@Override
	public List<Employee> fetchEmployeeByDesgs(String desg1, String desg2, String desg3) throws Exception {
		
		System.out.println("EmployeeMgmtServiceImpl.fetchEmployeeByDesgs()");
		//convert given desgs into uppercase letters(b.logic)
		desg1 = desg1.toUpperCase();
		desg2 = desg2.toUpperCase();
		desg3 = desg3.toUpperCase();
		
		//use Dao
		List<Employee> list = empDAO.showEmployeesByDesgs(desg1, desg2, desg3);
		//calculate grosssalary and netsalary(b.logic)
		list.forEach(emp->{
			emp.setGrossSalary(emp.getSalary()+emp.getSalary()*0.2f);
			emp.setNetSalary(emp.getGrossSalary()-emp.getGrossSalary()*0.1f);
		});
		return list;
	}

	@Override
	public String registerEmployee(Employee emp) throws Exception {
		System.out.println("EmployeeMgmtServiceImpl.registerEmployee()");
		//convert the given to upper case letter l(b.logic)
		//emp.setDesg(emp.getDesg().toUpperCase());
		
		
		
		
		
		//use DAO
		int count=empDAO.insertEmployee(emp);
		return count ==0?"Employee not registered ":"Employee is registered";
		
	}
	

}
