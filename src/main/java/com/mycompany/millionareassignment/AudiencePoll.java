
package com.mycompany.millionareassignment;
import java.util.Random; 

public class AudiencePoll extends LifelLine{
    private Questions question;
    public int firstNum;    //first poll precentage
    public int secondNum;   //second poll percentage
    public int thirdNum;    //third poll percentage
    public int fourthNum;   //fourth poll percentage
    
    public AudiencePoll() {
    }

    public AudiencePoll(Questions question, int firstNum, int secondNum, int thirdNum, int fourthNum) {
        this.question = question;
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        this.thirdNum = thirdNum;
        this.fourthNum = fourthNum;
    }

    public Questions getQuestion() {
        return question;
    }

    public void setQuestion(Questions question) {
        this.question = question;
    }

    public int getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(int firstNum) {
        this.firstNum = firstNum;
    }

    public int getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(int secondNum) {
        this.secondNum = secondNum;
    }

    public int getThirdNum() {
        return thirdNum;
    }

    public void setThirdNum(int thirdNum) {
        this.thirdNum = thirdNum;
    }

    public int getFourthNum() {
        return fourthNum;
    }

    public void setFourthNum(int fourthNum) {
        this.fourthNum = fourthNum;
    }

    
    
    @Override
    public void lifeline() {
        Random random = new Random();
        this.firstNum = random.nextInt(50);
        this.secondNum = 50-this.firstNum;
        this.thirdNum = random.nextInt(50);
        this.fourthNum = 50 - this.thirdNum;
    }

    @Override
    public String toString() {
        return "AudiencePoll{" + "question=" + question + '}';
    }

    

    
    
}
