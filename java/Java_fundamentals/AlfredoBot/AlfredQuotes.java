import java.util.Date;
import java.util.*;
 class  AlfredQuotes {
    
    public  String basicGreeting() {
        return  "Hello, nice to see you. How are you?" ;
    }
    
    public  String guestGreeting( String name) {
        return  "Hi," + name + " Nice to see you." ;
    }
    
    public  String dateAnnouncement() {
         Date myDate= new Date();
        return "It is currantlly " + myDate ;
    }
    public  String respondBeforeAlexis( String conversation) {
        int Alexis = conversation.indexOf("Alexis");
        int Alfred = conversation.indexOf("Alfred");
        if (Alexis != -1) {
            return "Right away, sir. You're certainly not sophisticated enough for that.";
        }
        else if (Alfred != -1){
            return "At your service. As you wish, of course.";
        }
        else {
            return "Fine. And with that, I'll be off.";
        }
    }
    
	// BONUS NINJA 
	// See the specs for overloading the guessGreeting method 
    // = "comment from-rainbow" > // BONUS SENSEI 
    // Write your own AlfredQuotes method using any of the String methods you've learned about!
}
