package com.nit;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nit.controller.PayrollOperationsController;
import com.nit.model.Employee;

@SpringBootApplication
(scanBasePackages = {"com.Ganesh","com.nit"})
public class BootIocProj05LayeredAppMiniProjectRealtimeDIApplication {

	public static void main(String[] args) {
		
		try(//get access to IOC container
		ConfigurableApplicationContext ctx=SpringApplication.run(BootIocProj05LayeredAppMiniProjectRealtimeDIApplication.class, args);
				
				//get Scanner class object
				Scanner sc = new Scanner(System.in);
				){
			
			//get Controller Spring bean class obj ref
			PayrollOperationsController controller = ctx.getBean("controller",PayrollOperationsController.class);
			
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
	}//main
}//class
