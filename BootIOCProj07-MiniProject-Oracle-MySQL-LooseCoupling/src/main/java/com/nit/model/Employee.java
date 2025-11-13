package com.nit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Employee 
{
	private Integer eid;
	@NonNull
	private String ename;
	@NonNull
	private String desg;
	@NonNull
	private double salary;
	
	private double grossSalary;
	private double netSalary;
	
	
	
	
	public Integer getEid() {
		return eid;
	}



	public void setEid(Integer eid) {
		this.eid = eid;
	}



	public String getEname() {
		return ename;
	}



	public void setEname(String ename) {
		this.ename = ename;
	}



	public String getDesg() {
		return desg;
	}



	public void setDesg(String desg) {
		this.desg = desg;
	}



	public Double getSalary() {
		return salary;
	}



	public void setSalary(Double salary) {
		this.salary = salary;
	}



	public Double getGrossSalary() {
		return grossSalary;
	}



	public void setGrossSalary(Double grossSalary) {
		this.grossSalary = grossSalary;
	}



	public Double getNetSalary() {
		return netSalary;
	}



	public void setNetSalary(Double netSalary) {
		this.netSalary = netSalary;
	}



	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", enmae=" + ename + ", desg=" + desg + ", salary=" + salary + ", grossSalary="
				+ grossSalary + ", netSalary=" + netSalary + "]";
	}
	
	

}
