package com.mycompany.user;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mycompany.user.controller.UserController;

@SpringBootApplication
public class UserApplication implements CommandLineRunner {
    @Autowired
    private ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
		
		
	}
	
	@Override
    public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		UserController userController = applicationContext.getBean(UserController.class);
	
		while(true) {
			System.out.print("\tMenu \n1.insert \n2.delete \n3.update\n4.display \n0.exit"); 
			System.out.print("\nEnter your choice :");
        	int ch = sc.nextInt();	 	
        	if(ch == 1) {
        		System.out.println("Enter the id :");
            	int insert_id = sc.nextInt();
            	System.out.println("Enter the name :");
            	String insert_name = sc.next();
            	System.out.println("Enter the phone :");
            	String insert_phone = sc.next();
            	userController.createUser(insert_id, insert_name, insert_phone);
        	}
        	else if(ch == 2) {
        		System.out.println("Enter the id to delete");
            	int delet_id = sc.nextInt();
            	userController.deleteUser(delet_id);
        	}
        	else if(ch == 3) {
        		System.out.println("Enter the id to change name:");
        		int upt_id = sc.nextInt();
        		System.out.println("Enter the new name");
        		String upt_name = sc.next();
        		userController.updateUser(upt_id, upt_name);
        		
        	}
        	else if(ch == 4) {
        		userController.displayUser();
        	}
        	else if(ch == 0) {
        		System.out.println("Exited");
        		break;
        	}
	}

	}
}
