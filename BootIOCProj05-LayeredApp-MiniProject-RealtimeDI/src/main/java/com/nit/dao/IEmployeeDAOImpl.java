package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nit.model.Employee;

@Repository("empDAO")
public class IEmployeeDAOImpl implements IEmployeeDAO {
	
	@Autowired
	private  DataSource  ds;
	private   static  final  String  GET_EMPS_BY_DESGS="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN (?,?,?) ORDER BY JOB";

	@Override
	public List<Employee> showEmployeesByDesgs(String desg1, String desg2, String desg3) throws Exception 
	{
		System.out.println("IEmployeeDAOImpl.showEmployeesByDesgs()");
		List<Employee> list=null;
		   // persistence logic using JDBC code
		try( //get Poold jdbc con object
				Connection con=ds.getConnection();
				//create PreparedSTatement object
				PreparedStatement  ps=con.prepareStatement(GET_EMPS_BY_DESGS);
				){
			  //set  values to Query params
			  ps.setString(1, desg1);
			  ps.setString(2, desg2);
			  ps.setString(3, desg3);
			  try(  //execute the SQL Query
					    ResultSet rs=ps.executeQuery();  ){
				  //copy  ResultSEt object records  List of Java bean class objs
				    list=new ArrayList();
				  while(rs.next()) {
					   //copy  each record of ResultSEt obj to Employee class obj
					  Employee emp=new Employee();
					  emp.setEmpNo(rs.getInt(1));
					  emp.setEname(rs.getString(2));
					  emp.setJob(rs.getString(3));
					  emp.setSal(rs.getFloat(4));
					  // add each Model class obj to List Collection
					  list.add(emp);
				  }//while
				  
			  }//try2
			}//try1
		catch(SQLException se) {
			throw se; //Exception rethrowing
		}
		catch(Exception e) {
			throw e;  //Exception rethrowing
		}
		return list;
	}//method	}

}
