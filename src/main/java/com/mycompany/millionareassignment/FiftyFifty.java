
package com.mycompany.millionareassignment;

import java.util.Random;

public class FiftyFifty extends LifelLine{

    public String a;    //option a of the question
    public String b;    //option b of the question
    public String c;    //option c of the question
    public String d;    //option d of the question
    public String ans;  //answer of the question
    public FiftyFifty() {
    }

    public FiftyFifty(String a, String b, String c, String d, String ans) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.ans = ans;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }
    
    
    @Override
    public void lifeline() {    //trimming ythe options to two
        System.out.println("Choose Options between these two: ");
        System.out.println(this.ans);   //the asnswer
        if(this.ans != this.a){         //this will ensure that the other option other than ans should be printed
            System.out.println(this.a);     
        }else if(this.ans != this.b){
            System.out.println(this.b);
        }
        else if(this.ans != this.c){
            System.out.println(this.c);
        }
        else if(this.ans != this.d){
            System.out.println(this.d);
        }
        
    }

    @Override
    public String toString() {
        return "FiftyFifty{" + "a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + ", ans=" + ans + '}';
    }

    
    
    
}
 
