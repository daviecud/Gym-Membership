package com.david.gymmembership.gym_membership.Model;

import com.david.gymmembership.gym_membership.Interface.Calculator;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagement {

    final private Scanner reader = new Scanner(System.in);

    private int getIntegerInput() {
        int choice = 0;
        while (choice == 0) {
            try {
                choice = reader.nextInt();
                if (choice == 0)
                throw new InputMismatchException();
                reader.nextLine();
            }
            catch (InputMismatchException e) {
                reader.nextLine();
                System.out.println("\nError: INVALID INPUT!! Please try again.");
            }
        }
        return choice;
    }

    private void showClubOptions() {
        System.out.println("\n) Club Renfrew");
        System.out.println("2) Club Paisley");
        System.out.println("3) Club Erskine");
        System.out.println("4) Multi Clubs");
    }

    public int getMenuChoice() {
        int choice;

        System.out.println("\nWELCOME TO RENFREWSHIRE GYMS");

        System.out.println("===============================================");
        System.out.println("1) Add Member");
        System.out.println("2) Remove Member");
        System.out.println("3) Display Member Information");

        System.out.println("\nPlease select an option (or Enter -1 to quit):");
        choice = getIntegerInput();
        return choice;
    }

    public String addMembers(LinkedList<Member> m) {
        //create fields
        String name;
        int club;
        String mem;
        double fees;
        int memberID;
        Member membr;
        Calculator<Integer> calc;

        System.out.println("\nPlease enter the member's name: ");

        name = reader.nextLine();

        showClubOptions();

        System.out.println("\nPlease enter the member's Club ID");

        club = getIntegerInput();

        while (club < 1 || club > 4) {
            System.out.println("\nINVALID CLUB ID, Please try again!!");

            club = getIntegerInput();
        }

        if (m.size() > 0)
            memberID = m.getLast().getMemberID() + 1;
        else
            memberID = 1;


        if (club != 4) {
            calc = (n) -> {
                switch (n) {
                    case 1: return 900;
                    case 2: return 950;
                    case 3: return 1000;
                    default: return -1;
                }
            };

            fees = calc.calculateFees(club);

            membr = new SingleClubMember("Single", memberID, name, fees, club);
            m.add(membr);
            mem = membr.toString();

            System.out.println("\nSTATUS: Single Club Member Added\n");
        }
        else {
            calc = (n) -> {
                if (n == 4)
                    return 1200;
                else
                    return -1;
            };

            fees = calc.calculateFees(club);

            membr = new MultiClubMember("Multi", memberID, name, fees, 100);
            m.add(membr);
            mem = membr.toString();

            System.out.println("\nSTATUS: Multi Club Member Added\n");
        }
        return mem;
    }

    public void removeMember(LinkedList<Member> m) {
        int memberID;

        System.out.println("\nEnter Member ID to remove: ");

        memberID = getIntegerInput();

        for (int i = 0; i < m.size(); i++) {

            if (m.get(i).getMemberID() == memberID) {
                m.remove(i);
                System.out.println("\nMember Removed\n");
                return;
            }

        }
        System.out.println("\nMember ID not found!!\n");
    }

    public void showMemberInfo(LinkedList<Member> m) {
        int memberID;

        System.out.println("\nEnter Member ID to view member Information: ");

        memberID = getIntegerInput();

        for (int i = 0; i < m.size(); i++) {
            if (m.get(i).getMemberID() == memberID) {
                String[] memberInfo = m.get(i).toString().split(", ");

                System.out.println("\nMember Type: " + memberInfo[0]);
                System.out.println("\nMember ID: " + memberInfo[1]);
                System.out.println("\nMember Name: " + memberInfo[2]);
                System.out.println("\nMembership Fees: £" + memberInfo[3]);

                if (memberInfo[0].equals("Single")) {
                    System.out.println("Club ID: " + memberInfo[4]);
                } else {
                    System.out.println("Membership Points: " + memberInfo[4]);
                }
                return;
            }
        }

        System.out.println("\nMember ID not found!!\n");
    }
}
