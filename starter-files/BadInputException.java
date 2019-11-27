/**
 * BadInputException.java 
 * @author Charles Tianchen Yu 
 *
 * This file is for use in cse8b sp19 psa8: MyStringBuilder. 
 *
 * DO NOT MODIFY THIS FILE. 
 */

public class BadInputException extends MyException
{
    protected static int count = 0;

    public BadInputException(String from, String message)
    {
        super(from, message);
        count++;
    }

    public String toString()
    {
        return String.format("BadInput%s", super.toString());
    }
}