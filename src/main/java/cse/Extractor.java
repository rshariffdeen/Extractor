package cse;

import cse.exception.InvalidNICException;
import org.joda.time.DateTime;

public class Extractor {

    public Interpreter createInterpreter(String input){
        return new Interpreter(input);
    }

    public void validate(Interpreter prompt) throws InvalidNICException{
        String number = prompt.getID();
        if(number.length()!=10)                        //Invalid Input
            throw new InvalidNICException();
        if(!(number.charAt(9)=='V'||number.charAt(9)=='X'))   //Invalid Input
            throw new InvalidNICException();
        int year=0,day=0;
        try{
            year = Integer.parseInt(number.substring(0, 2));
            day = Integer.parseInt(number.substring(2, 5));
            Integer.parseInt(number.substring(5,9));
        }
        catch(NumberFormatException e){
            throw new InvalidNICException();
        }
        
        if(!((day>0&&day<=366)||(day>500&&day<=866)))   //date is not in the correct format
            throw new InvalidNICException();
        
        day = day<500 ? day : day-500;
        
        if(!(year%4==0&&year%400!=0)&&day==60)  //Feb 29 on a non-leap year
            throw new InvalidNICException();


    }

    public String[] calculator(Interpreter prompt) throws InvalidNICException{
        validate(prompt);
        String number = prompt.getID();
        int year=0,day=0;
        try{
            year = 1900+Integer.parseInt(number.substring(0, 2));
            day = Integer.parseInt(number.substring(2, 5));
        }
        catch(NumberFormatException e){
            throw new InvalidNICException();
        }

        String isVoter = number.charAt(9)=='V' ? "Yes" :"No";
        String gender= day<500 ? "Male" : "Female";

        day = day<500 ? day : day-500;
        if(day>60&&!(year%4==0&&year%400!=0))
            day--;
        DateTime dateTime = new DateTime(year,1,1,0,0);
        dateTime=dateTime.plusDays(day-1);

        int month, date;
        month=dateTime.monthOfYear().get();
        date=dateTime.dayOfMonth().get();

        String[] information = {year+"",month+"",date+"",gender+"",isVoter+""};
        return information;
    }
}
