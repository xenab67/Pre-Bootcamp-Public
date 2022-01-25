import java.util.Date;
public class AlfredQuotes {
    public String basicGreeting() {
        return "Hello, lovely to see you. How are you?";
    }

    /* 
    * Inputs: String name, String dayPeriod 
    *                      Assume "morning", "afternoon" or "evening".
    * Return Type: String
    * Description: Returns a greeting that includes the person's name
    *         as well as the day period. For example:
    *        "Good evening, Beth Kane. Lovely to see you."
    * Tip: Try using the String.format method for string interpolation in Java.
    */
    public String guestGreeting(String name, String dayPeriod) {
    // YOUR CODE HERE
        return String.format("Good %s, %s. Lovely to see you.", dayPeriod, name);
    }
    /* 
    Inputs: None
    * Return Type: String
    * Description: Returns a polite announcement of the current date.
    */
    public String dateAnnouncement() {
    // YOUR CODE HERE
        return String.format("The time is currently %s", new Date());
    }

        /*********************************************
        Final Challenge!
        Alfred is listening. Write a method that accepts any string of conversation. 
        If "Alexis" appears in the conversation return a snarky response, such as:
        "Right away, sir. She certainly isn't sophisticated enough for that." 
            
        If "Alfred" is in the conversation return an obliging response, for example: 
        "At your service. As you wish, naturally." 
            
        If neither name is found, return an appropriate response, for instance:
        "Right. And with that I shall retire." 
        **********************************************/
        /*
        * Inputs: String (A conversation)
        * Return Type: String (Something Alfred would say in response)
        * 
        * Tip: Use the indexOf String method
        */
    public String respondBeforeAlexis(String conversation) {
    if(conversation.indexOf("Alexis") > -1) {
        return "Right away, sir. She certainly isn't sophisticated enough for that.";
    }
    if (conversation.indexOf("Alfred") > -1){
        return "At your service. As you wish, naturally.";
    }
        return "Right. And with that I shall retire.";
    }


    public String busySchedule(String phrase) {
    if(phrase.indexOf("Friday") >-1){
        return "Friday is completely booked, sir. Tennis at 2:30 in the afternoon, followed by lunch with Mrs. O'Brien. Wouldn't want to miss that again..";
    }
    if(phrase.indexOf("Tuesday") >-1){
        return "Your morning is clear, sir. However, your evening is booked with the new showing of your latest tech innovations.";
    }
    if (phrase.indexOf("Xena")>-1){
        return "ah, yes. Hello, Xena AKA, The families, soon to-be millionaire with a giant badonkadonk and higher than normal IQ. How can I be of assistance to you today?";
    }
        return "Certainly, sir. Your day is free, how may I schedule you?";
    }
}
