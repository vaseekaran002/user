package com.mycompany.user;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mycompany.user.controller.UserController;
import com.mycompany.user.pojo.User;

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
      
            	User user = new User("vaseekaran","vasee@vtr");
            	userController.insertUser(user);
            
        	}
        	else if(ch == 2) {
        		User user = new User("vaseekaran","vasee@vtr");
            	userController.loginUser(user);
        	}
        	else if(ch == 3) {
        
        		User user = new User("vaseekaran","vasee@002");
        		userController.resetPassword(user);
        		
        	}
//        	else if(ch == 4) {
//        		userController.displayUser();
//        	}11
        	else if(ch == 0) {
        		System.out.println("Exited");
        		break;
        	}
	}

	}
}
