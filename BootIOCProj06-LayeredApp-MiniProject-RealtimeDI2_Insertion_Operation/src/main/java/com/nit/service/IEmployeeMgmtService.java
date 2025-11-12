package com.nit.service;

import java.util.List;

import com.nit.model.Employee;

public interface IEmployeeMgmtService 
{
	public  List<Employee>  fetchEmployeesByDesgs(String desg1,String desg2,String desg3)throws Exception;
    public String registerEmployee(Employee emp) throws Exception;
}
