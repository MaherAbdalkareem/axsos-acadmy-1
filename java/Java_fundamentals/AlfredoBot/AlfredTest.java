
public  class  AlfredTest {
    /*
   * This main method will always be the starting point of a Java application
   * For now, we are using main to test all of our
   * AlfredQuotes methods.
   */ 
   public  static  void main( String [] args) {
        // Create an instance of AlfredQuotes to access all of your AlfredQuotes methods 
        AlfredQuotes alfredBot = new  AlfredQuotes ();
       
       // Do some test greetings, providing the necessary data 
       String testGreeting = alfredBot.basicGreeting();
       String testGuestGreeting = alfredBot.guestGreeting( "Maher Abdalkareem" );
       String testDateAnnouncement = alfredBot.dateAnnouncement();
       
       String alexisTest = alfredBot.respondBeforeAlexis("Alexis! Play some low-fi beats.");
       String alfredTest = alfredBot.respondBeforeAlexis("I can't find my yo-yo. Maybe Alfred knows where it is");
       String notRelevantTest = alfredBot.respondBeforeAlexis("Maybe that's what Batman is all about. Not winning. Failing...");
       
       // Print the greetings to test. 
       System .out.println(testGreeting);
       System .out.println(testGuestGreeting);
       System .out.println(testDateAnnouncement);
       System .out.println(alfredTest);

       // Uncomment one at a time as you implement each method. 
       // System.out.println(testGuestGreeting); 
       // System.out.println(testDateAnnouncement); 
       // System.out.println(alexisTest); 
       // System.out.println(alfredTest); 
       // System.out.println(notRelevantTest);
   }
}