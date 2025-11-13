package com.nit;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nit.controller.PayrollOperationsController;
import com.nit.model.Employee;

@SpringBootApplication
(scanBasePackages = {"com.Ganesh","com.nit"})
public class BootIocProj07LayeredAppMiniProjectRealtimeDIApplication {

	public static void main(String[] args) {
		
		try(//get access to IOC container
		ConfigurableApplicationContext ctx=SpringApplication.run(BootIocProj07LayeredAppMiniProjectRealtimeDIApplication.class, args);
				
				//get Scanner class object
				Scanner sc = new Scanner(System.in);
				){
			
			//get Controller Spring bean class obj ref
			PayrollOperationsController controller = ctx.getBean("controller",PayrollOperationsController.class);
			
			//====================gather inputs for employee registration================================
			
			System.out.println("Enter employee name::");
		    String name=sc.next();
		    System.out.println("Enter employee desg::");
		    String desg=sc.next();
		    System.out.println("Enter employee salary::");
		    float  salary=sc.nextFloat();
		    
		    //create Employee class obj having inputs
		    Employee emp1 = new Employee();
		   
		    emp1.setEname(name);
		    emp1.setJob(desg);
		    emp1.setSal(salary);
		    //invoke the b.method
		    try
		    {
		    	String msg=controller.processEmployee(emp1);
		    	System.out.println(msg);
		    	
		    }
		    catch(Exception e)
		    {
		    	System.out.println("Internal problem -- try again");
		    }
			
			
			
			
			//===================gather inputs for fetching the employee details ===============================
			//read inputs from the enduser
			System.out.println("Enter Desg1::");
			String desg1=sc.next();
			
			System.out.println("Enter Desg2::");
			String desg2=sc.next();
			
			System.out.println("Enter Desg3::");
			String desg3=sc.next();
			
			
			//invoke the b.methods
			List<Employee> list = controller.getEmployeesByDesgs(desg1, desg2, desg3);
			
			//display result
			System.out.println("Employees belonging to "+desg1+ " "+desg2+ " " +desg3+" are");
			list.forEach(emp->{
				System.out.println(emp);
				
			});
			
			}//try
		catch(Exception e)
		{
			System.out.println("internal problem::"+e.getMessage());
			e.printStackTrace();
		}
		
		
		
	}
}