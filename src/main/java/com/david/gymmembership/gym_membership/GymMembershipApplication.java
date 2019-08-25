package com.david.gymmembership.gym_membership;

import com.david.gymmembership.gym_membership.Model.Member;
import com.david.gymmembership.gym_membership.Model.MembershipManagement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.LinkedList;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class GymMembershipApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymMembershipApplication.class, args);

		//declare variables
		String mem;
		MembershipManagement memMan = new MembershipManagement();

		FileHandler fh = new FileHandler(); //this calls the readFile method in FileHandler class and assigns it to variable called fh
		LinkedList<Member> members = fh.readFile(); //this reads from members.csv file and converts to LinkedList of Member object

		int choice = memMan.getMenuChoice(); //this calls getMenuChoice method from the MembershipManagement class


		/*
		* switch statement inside a while statement:
		* - while statement prompts user to enter a choice from returned getMenuChoice() in MembershipManagement class,
		* 	as long as user does not enter -1 to exit
		* - switch statement will take users choice and assign it to appropriate case
		* */
		while (choice != -1) {
			switch (choice) {
				case 1:
					mem = memMan.addMembers(members); //will use addMembers method in MembershipManagement class to add member to LinkedList<Member>
					fh.appendFile(mem); //will invoke the appendFile method in MembershipManagement class to add member to members.csv file
					break;
				case 2:
					memMan.removeMember(members); //will invoke removeMembers method in MembershipManagement class to remove member from LinkedList<Member>
					fh.overwriteFile(members); //will invoke the overwriteFile method in MembershipManagement to remove member from members.csv file
					break;
				case 3:
					memMan.showMemberInfo(members); //will call the showMemberInfo in MembershipManagement class to display member info
					break;
				default:
					System.out.print("\nYou have selected an Invalid option. \n\n");
					break;
			}
			choice = memMan.getMenuChoice(); //This will prompt user to select a new choice
		}
		System.out.println("\nThank You and GoodBye");
	}

}
