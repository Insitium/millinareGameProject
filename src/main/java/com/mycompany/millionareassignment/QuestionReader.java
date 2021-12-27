/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.millionareassignment;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;
public class QuestionReader {
    public int num;
    public ArrayList<Questions> questionList = new ArrayList();     //arraylist where we will save Question class type objects taken from the txt file
    public Questions questioncheck; //Question class type object to save step wise lines
    public ArrayList<Integer> numList = new ArrayList();    //to save the num which have already come to ensure non redundancy of questions

    public QuestionReader() {
    }

    public QuestionReader(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public ArrayList<Questions> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(ArrayList<Questions> questionList) {
        this.questionList = questionList;
    }

    public Questions getQuestioncheck() {
        return questioncheck;
    }

    public void setQuestioncheck(Questions questioncheck) {
        this.questioncheck = questioncheck;
    }

    public ArrayList<Integer> getNumList() {
        return numList;
    }

    public void setNumList(ArrayList<Integer> numList) {
        this.numList = numList;
    }
    
    
    
    public void readfile(){
        try{
            FileReader file = new FileReader("questionare.txt");    //reading the file questionare.txt which has questions and answers
            BufferedReader input = new BufferedReader(file);
            String line = input.readLine();
            while(line != null)
            {
                String data[] = line.split(",,");   //text file line split on the basis of ",,"
                
                questioncheck = new Questions(data[0],data[1],data[2],data[3],data[4],data[5]);     //txt file splitted and saved tp questioncheck in Questions class format
                this.questionList.add(questioncheck);   //adding the one Object to class of objects
                line = input.readLine();
            }
            
        }
        catch(FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch (IOException ex) 
        {
            System.out.println(ex.getMessage());
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
    }
    
       
    
    public void returnQuestion(){
        Random r = new Random();
            
            while(true){
                this.num = r.nextInt(25)+1; //picking random numbers from 1 to 25
                if(!(this.numList.contains(this.num))){     //to ensure non redundancy of questions where a number corresponding to arralylist index has been saved to a new arraylist and checked wether it is not coming
                    this.questioncheck = questionList.get(this.num);
                    this.numList.add(this.num);
                    break;
                }
            }
            

    }
}
