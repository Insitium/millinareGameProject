
package com.mycompany.millionareassignment;
import java.util.concurrent.TimeUnit;

public class PhoneFriend extends LifelLine{
    
    @Override
    public void lifeline() {
        int countdown = 60;
        System.out.println("The timer for 60 seconds has started");     // a timer fo r60 seconds is started and calling someone is allowed
        while(countdown!=0){
            try{
                
                System.out.println(countdown);
                TimeUnit.SECONDS.sleep(1);
                countdown--;
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
}
