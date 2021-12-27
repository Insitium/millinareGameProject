/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.millionareassignment;

/**
 *
 * @author vashi
 */
public class HardOption extends Game{
    @Override
    public int roundAmount(int i){    //will get index i of for loop as input
        int[] Amount = {100, 200,300,500,1000,2000,4000,8000,16000,32000,64000,125000,250000,500000,1000000};   //array of prizes assiciated to each question
       
        
      
        return Amount[i];
    }
    
    

    @Override
    public int structure(char ansFromUser, String opA, String opB, String opC, String opD, String ans, int i) { //will return 1 if the asnwer is right and will return 0 if wrong
        int j = i+1;    //for output and checking the round numebrs
        
        if(ansFromUser == 'a' & opA.equals(ans)){//this will give the amount which has been won by the user
                System.out.println("Congratulations! Your answer is right and you have won $"+ roundAmount(i));
            }else if(ansFromUser == 'b' & opB.equals(ans)){
                System.out.println("Congratulations! Your answer is right and you have won $"+ roundAmount(i));
            }else if(ansFromUser == 'c' & opC.equals(ans)){
                System.out.println("Congratulations! Your answer is right and you have won $"+ roundAmount(i));
            }else if(ansFromUser == 'd' & opD.equals(ans)){
                System.out.println("Congratulations! Your answer is right and you have won $"+ roundAmount(i));
            }
            else{
                System.out.println("Alas! the option you have chosen is wrong and you do not win anything");
                return 1;   //for smooth exit from the code in main
            }
        if(j%5 == 0)// rounds are multiple of 5
        {
            if(j == 15){
                System.out.println("Congratulations You are a millionare Now");
                return 1;   //for smooth exit from the code in main
            }
            System.out.println("Congratulations you have cleared Round: "+ (j/5));// rounds are multiple of 3
            
            return 2;   //for smooth exit from the code in main
            
        }
        return 0;   //for smooth exit from the code in main
    }
}
