package com.david.gymmembership.gym_membership;

import com.david.gymmembership.gym_membership.Model.Member;
import com.david.gymmembership.gym_membership.Model.MultiClubMember;
import com.david.gymmembership.gym_membership.Model.SingleClubMember;
import net.bytebuddy.dynamic.scaffold.MethodGraph;

import java.io.*;
import java.util.LinkedList;

public class FileHandler {

    /*
    * The readFile method below returns a LinkedList of member object/class
    */
    public LinkedList<Member> readFile() {

        //declare variables
        LinkedList<Member> m = new LinkedList<>();
        String lineRead;
        String[] splitLine;
        Member mem;

        /*
        * Below try-with-resources statement is used to create a BufferedReader object and FileReader reads member.csv file
        * */
        try(BufferedReader reader = new BufferedReader(new FileReader("members.csv")))
        {
            lineRead = reader.readLine(); //readLine method from BufferReader class will read the first line from the members.csv file

            while (lineRead != null) { //while local variable lineRead is not null the while statement will read members.csv line by line
                splitLine = lineRead.split(", ");//splitLine will split values in lineRead into a String array and use ", " as the separator on the file

                if (splitLine[0].equals("Single")) // .equals will compare the first element[0] of splitLine array
                {
                    // if statement equals true then we instantiate the SingleClubMember object/class
                    mem = new SingleClubMember("Single", Integer.parseInt(splitLine[1]), splitLine[2], Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));

                    } else {
                    // if statement equals false then we instantiate the MultiClubMember object/class
                    mem = new MultiClubMember("Multi", Integer.parseInt(splitLine[1]), splitLine[2], Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));
                }

                        m.add(mem); //add value of mem to LinkedList<Member> m
                        lineRead = reader.readLine(); //we call reader.readLine() to read next line
                }
            }
                catch (IOException e)
                {
                    System.out.println(e.getMessage());
                }
                return m; //this returns LinkedList<Member>
            }

            /*
            * The appendFile method below appends a new line in members.csv when a new member is created by the user
            */
            public void appendFile(String mem) {

                /*
                Below creates a new BufferWriter object and pass in FileWriter object which appends members.csv, 2nd parameter indicate we wish to append file
                 */
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.csv", true))) {
                    writer.write(mem + "\n"); //concatenate "/n" to mem which will move cursor to next line
                }
                catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }

            /*
            This overwriteFile method will remove a member from LinkedList<Member>
            - Create a temporary file to write data in LinkedList<Member> to temp file
            - delete original members.csv and rename members.temp file to members.csv
             */
            public void overwriteFile(LinkedList<Member> m) {
                //TODO fix problem with file deleting only the first entry and not the numbered ID
                String s;


                try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.temp", false))) {
                    for (int i=0; i < m.size(); i++) { //for statement loops through LinkedList<Member> passed in as parameter
                        s = m.get(i).toString();
                        writer.write(s + "\n");
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

                //delete original members.csv file and rename newly created members.temp file to members.csv (member will be removed from list)
                try {
                    File f = new File("members.csv"); //assign members.csv to variable f
                    File tf = new  File("members.temp");

                    f.delete(); //will delete members.csv file
                    tf.renameTo(f); //will rename created members.temp file to members.csv which will have removed member from list
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        }
    }

