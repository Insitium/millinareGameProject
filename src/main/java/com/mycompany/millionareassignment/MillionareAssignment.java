/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.millionareassignment;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MillionareAssignment {
    public static void main(String[] args) {
        System.out.println("Welcome To Who Wants To Be A Millionaire");
        Scanner s = new Scanner(System.in);
        System.out.println("-------Who wants to be a Millionare---------");
        System.out.println("Please enter your First Name: ");
        String fname = s.nextLine();
        System.out.println("Please enter your second name: ");
        String lname = s.nextLine();
        Contestant contestant = new Contestant(fname,lname);
        contestant.fullName();
        while (true) {  // It is there to ensure that if the user press wrong key other than s, r and e so he may get the manu back to redo it
            int value = 100;
            System.out.println("Press s to start the game ");
            System.out.println("Press r to view rules ");
            System.out.println("Press e to exit the game ");
            char inp = s.next().charAt(0);
            if(inp == 's'){
            
            
                System.out.println("Choose level of difficulty");
                System.out.println("Press h for hard and e for easy");
             
            
                char lev = s.next().charAt(0);
                QuestionReader firstPlayerquestion = new QuestionReader();  //makes a questionreader object which reads questions and sends questions, options and answer to the main class
                firstPlayerquestion.readfile(); // method in the function to read the file
                int fiftycheck = 0;         //put a check to ensure that the lifeline is not used multiple times
                int audiencecheck = 0;      //put a check to ensure that the lifeline is not used multiple times
                int phonecheck = 0;         //put a check to ensure that the lifeline is not used multiple times
                if(lev == 'e'){
                for(int i = 0; i<9;i++){
                    int j = i+1;
                    firstPlayerquestion.returnQuestion();
                    String Ques = firstPlayerquestion.questioncheck.getQuestion();      //question returned by QuestionReader class
                    String optiona = firstPlayerquestion.questioncheck.getOptionA();    //returned by QuestionReader class
                    String optionb = firstPlayerquestion.questioncheck.getOptionB();    //returned by QuestionReader class
                    String optionc = firstPlayerquestion.questioncheck.getOptionC();    //returned by QuestionReader class
                    String optiond = firstPlayerquestion.questioncheck.getOptionD();    //returned by QuestionReader class
                    String ans = firstPlayerquestion.questioncheck.getAnswer();
                    System.out.println("The number "+ j +" Question and its options are on your screen,");
                    System.out.println(Ques);
                    System.out.println(optiona);
                    System.out.println(optionb);
                    System.out.println(optionc);
                    System.out.println(optiond);
                    if(i>=0){
                        System.out.println("If you wish to use lifeline Press p for Audience Poll and f for FiftyFifty and c for Phone your friend or n for No");
                        char lifeline = s.next().charAt(0);
                        if(lifeline == 'p'){    //to use lifelines audience poll
                            if(audiencecheck == 0)
                            {
                                AudiencePoll ap = new AudiencePoll();   //making of audience poll object
                                ap.lifeline();      //the method will tell the audience mood 
                                System.out.println("Option A: "+ap.firstNum+"; Option B: "+ap.secondNum+"; Option C: "+ap.thirdNum+"; Option D: "+ap.fourthNum);
                                audiencecheck = 1;  //is equal to 1 because the lifeline has been used
                            }else{
                                System.out.println("You have used Audience Poll");
                            }


                        }else if(lifeline == 'f')   //to use lifelines audience fiftyfifty
                        {
                            if(fiftycheck == 0){
                                FiftyFifty ff = new FiftyFifty(optiona, optionb, optionc, optiond, ans);    //making of FIftyFifty object
                                ff.lifeline();  //the method will call fifty fifty and give two options to select from
                                fiftycheck = 1; //is equal to 1 because the lifeline has been used
                            }else{
                                System.out.println("You have used fiftyFifty already");
                            }
                        }else if(lifeline == 'c')   //to use lifelines audience phone a friend
                        {
                            if(phonecheck == 0){
                                System.out.println("You will now be given 60 seconds to call you friend and ask for help");
                                PhoneFriend pf = new PhoneFriend(); //making PhoneFriend object
                                pf.lifeline();
                                phonecheck =1;//is equal to 1 because the lifeline has been used
                            }else{
                                System.out.println("You have used Phone a friend lifeline already");
                            }
                        }
                    }
                    char userAns = s.next().charAt(0);  //answer input ptovided by user
                    System.out.println("Are you sure about the answer? If not then press n else press any other character");
                    
                    char surityCheck = s.next().charAt(0);  //to check if the user want to changfe the answer
                    if(surityCheck == 'n'){     //if n is clicked then it will go through  it and ask for the answer again
                        System.out.println("Enter the answer again: ");
                        userAns = s.next().charAt(0);
                    }

                    EasyOption easygame = new EasyOption();     //easyoption subclass of superclass game which returns the amount earned and wether the answer is right or not
                    value = easygame.structure(userAns,optiona,optionb,optionc,optiond,ans,i); //value returned by the method to understand what to do next
                    if(value == 1)  //the returned 1 value from structure method means that the option chosen was wrong and the program will be terminated
                    {
                        break;
                    }else if(value == 2){   // the returned 2 value means that the round has been completed to ensure the user get a chance to walk away
                        System.out.println("You may choose to walk away by pressing w or could continue by pressing any character key");
                        char roundcheckpoint = s.next().charAt(0);  //walk away chance input
                        
                        if(roundcheckpoint == 'w')  //walk away chance check
                        {
                            value = 3;      //will help in exiting the whole game
                            break;
                        }
                    }
                }


                }else if(lev == 'h'){   //if hard option is chosen
                    for(int i = 0; i<15;i++){   //will iterate 15 times for 15 questions
                    int j = i+1;
                    firstPlayerquestion.returnQuestion();
                    String Ques = firstPlayerquestion.questioncheck.getQuestion();      //question returned by QuestionReader class
                    String optiona = firstPlayerquestion.questioncheck.getOptionA();    //returned by QuestionReader class
                    String optionb = firstPlayerquestion.questioncheck.getOptionB();    //returned by QuestionReader class
                    String optionc = firstPlayerquestion.questioncheck.getOptionC();    //returned by QuestionReader class
                    String optiond = firstPlayerquestion.questioncheck.getOptionD();    //returned by QuestionReader class
                    String ans = firstPlayerquestion.questioncheck.getAnswer();
                    System.out.println("The number "+ j +" Question and its options are on your screen,");
                    System.out.println(Ques);
                    System.out.println(optiona);
                    System.out.println(optionb);
                    System.out.println(optionc);
                    System.out.println(optiond);
                    if(i>4){
                        System.out.println("If you wish to use lifeline Press p for Audience Poll and f for FiftyFifty and c for Phone your friend or n for No");
                        char lifeline = s.next().charAt(0);
                        if(lifeline == 'p'){    //to use lifelines audience poll
                            if(audiencecheck == 0)
                            {
                                AudiencePoll ap = new AudiencePoll();   //making of AudiencePoll object
                                ap.lifeline();      //calling method lifeline of the above class
                                System.out.println("Option A: "+ap.firstNum+"; Option B: "+ap.secondNum+"; Option C: "+ap.thirdNum+"; Option D: "+ap.fourthNum);
                                audiencecheck = 1;//is equal to 1 because the lifeline has been used
                            }else{
                                System.out.println("You have used Audience Poll");
                            }


                        }else if(lifeline == 'f')   //to use lifelines audience fiftyfifty
                        {
                            if(fiftycheck == 0){
                                FiftyFifty ff = new FiftyFifty(optiona, optionb, optionc, optiond, ans);    //making of FiftyFifty object
                                ff.lifeline();//the method will call fifty fifty and give two options to select from
                                fiftycheck = 1;//is equal to 1 because the lifeline has been used
                            }else{
                                System.out.println("You have used fiftyFifty already");
                            }
                        }else if(lifeline == 'c')   //to use lifelines audience phone a friend
                        {
                            if(phonecheck == 0){
                                System.out.println("You will now be given 60 seconds to call you friend and ask for help");
                                PhoneFriend pf = new PhoneFriend(); //making of PhoneFriend object
                                pf.lifeline();  //calling lifeline method in the class
                                phonecheck =1;//is equal to 1 because the lifeline has been used
                            }else{
                                System.out.println("You have used Phone a friend lifeline already");
                            }
                        }
                    }
                    char userAns = s.next().charAt(0);  //answer input ptovided by user
                    System.out.println("Are you sure about the answer? If not then press n else press any other character");
                    
                    char surityCheck = s.next().charAt(0);  //to check if the user want to changfe the answer
                    if(surityCheck == 'n'){     //if n is clicked then it will go through  it and ask for the answer again
                        System.out.println("Enter the answer again: ");
                        userAns = s.next().charAt(0);
                    }
                    HardOption hardgame = new HardOption();     //easyoption subclass of superclass game which returns the amount earned and wether the answer is right or not
                    value = hardgame.structure(userAns,optiona,optionb,optionc,optiond,ans,i); //value returned by the method to understand what to do next
                    if(value == 1)  //the returned 1 value from structure method means that the option chosen was wrong and the program will be terminated
                    {
                        break;
                    }else if(value == 2){   // the returned 2 value means that the round has been completed to ensure the user get a chance to walk away
                        System.out.println("You may choose to walk away by pressing w or could continue by pressing any character key");
                        char roundcheckpoint = s.next().charAt(0);  //walk away chance input
                        
                        if(roundcheckpoint == 'w')  //walk away chance check
                        {
                            value = 3;      //will help in exiting the whole game
                            break;
                        }
                    }
                }
                }else{
                    System.out.println("You will be redirected to the main menu");
                }
            }else if(inp == 'r'){

                try {
                    FileReader file = new FileReader("rules.txt");  //reading file rules.txt
                    BufferedReader input = new BufferedReader(file);        //readbuffer
                    String line = input.readLine();

                    while(line != null){    //to ensure the the line till null is read(end is null)
                        System.out.println(line);   //printing the rules line 1
                        line = input.readLine();

                    }
                    input.close();
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }catch(IOException e)
                {
                    System.out.println(e.getMessage());
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
                while(true){
                    System.out.println("Press m to go back to main menu");  
                    char back = s.next().charAt(0); //taking input m to go to main menu
                    if(back == 'm'){
                        break;
                    }
                }

            }else if(inp == 'e'){   // to exit
                break;
            }
            else{
                System.out.println("Invalid Input: Input one among r or s");
            }
            if(value == 1 || value == 3)    //to exit the game because 1 means the game is done and 3 means it has been quitted intentionally
            {
                return;
            }

            }
        
        
    }
}


