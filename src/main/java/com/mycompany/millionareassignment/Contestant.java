
package com.mycompany.millionareassignment;


public class Contestant {
    public String firstName;    //first name of the contestant
    public String lastName;     //second name of the contestant

    public Contestant() {
    }

    public Contestant(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public void fullName(){
        System.out.println("Welcome Mr./Ms. "+this.firstName+" "+this.lastName+" To the Who wants to be a Millionare Game");        //full name of the contestant
    }
}
