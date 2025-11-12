package com.nit.model;

import lombok.Data;

@Data
public class Employee 
{
	private Integer EmpNo;
	private String Ename;
	private String Job;
	private Float Sal;
	
	private Float grossSalary;
	private Float netSalary;
	
	
	
	public Integer getEmpNo() {
		return EmpNo;
	}
	public void setEmpNo(Integer empNo) {
		EmpNo = empNo;
	}
	public String getEname() {
		return Ename;
	}
	public void setEname(String ename) {
		Ename = ename;
	}
	public String getJob() {
		return Job;
	}
	public void setJob(String job) {
		Job = job;
	}
	public Float getSal() {
		return Sal;
	}
	public void setSal(Float sal) {
		Sal = sal;
	}
	public Float getGrossSalary() {
		return grossSalary;
	}
	public void setGrossSalary(Float grossSalary) {
		this.grossSalary = grossSalary;
	}
	public Float getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(Float netSalary) {
		this.netSalary = netSalary;
	}
	
	
	@Override
	public String toString() {
	    return "Employee [EmpNo=" + EmpNo +
	           ", Ename=" + Ename +
	           ", Job=" + Job +
	           ", Sal=" + Sal +
	           ", GrossSalary=" + grossSalary +
	           ", NetSalary=" + netSalary + "]";
	}

	
	
	
	
	

}
