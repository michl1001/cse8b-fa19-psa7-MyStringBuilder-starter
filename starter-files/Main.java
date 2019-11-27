/** Your beautiful file header here TODO */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;


/** Your beautiful class header here TODO */
public class Main
{
    private static final String USAGE = 
    "Enter one of the (not case-sensitive) commands and follow the"
    + " instructions:\n"
    + "(C)hoose a word from the internal list of MyStringBuilder objects\n"
    + "(X)truct a new MyStringBuilder object\n"
    + "(A)ppend to the current MyStringBuilder\n"
    + "(I)nsert into the current MyStringBuilder\n"
    + "(P)rint the current MyStringBuilder\n"
    + "(R)emove a character from the current MyStringBuilder\n"
    + "(D)elete part of the current MyStringBuilder\n"
    + "(L)ist all MyStringBuilders\n"
    + "C(O)ncatenate two MyStringBuilders\n"
    + "R(E)verse the current MyStringBuilder\n"
    + "Re(M)ove the current MyStringBuilder\n"
    + "(Q)uit\n";
    private static final String EMPTY_LIST = 
        "You have no current MyStringBuilders! Please create one with (X).";
    private static final String PROMPT = "\n\nCommand: ";
    private static final String ST_FMT_1 = "MyStringBuilders: %s";
    private static final String ST_FMT_2 = "No current word. ";
    private static final String ST_FMT_3 = 
        "Current MyStringBuilder is \"%s\", length is %d.";
    private static final String ST_FMT_4 = "\"%s\" removed. Now on index %d.";
    private static final String ST_FMT_5 = "Stayed at index %d.";
    private static final String ST_FMT_6 = "Now at index %d.";
    private static final String ST_FMT_7 = 
        "Ran into %d BadInputExceptions and %d MSBOutOfBoundsExceptions.";
    private static final char CHANGE = 'C';
    private static final char CONSTRUCT = 'X';
    private static final char APPEND = 'A';
    private static final char INSERT = 'I';
    private static final char PRINT = 'P';
    private static final char REMOVE = 'R';
    private static final char LIST = 'L';
    private static final char DELETE = 'D';
    private static final char CONCAT = 'O';
    private static final char DESTRUCT = 'M';
    private static final char QUIT = 'Q';
    private static final char REVERSE = 'E';
    private static final String RECURSIVE = "r";
    private static final String ITERATIVE = "i";

    /** Each of the below Strings should be used exactly once in readInput() */
    private static final String FMT_1="Change to which index? ";
    private static final String FMT_2="Create from what string? ";
    private static final String FMT_3="Created MyStringBuilder from %s.";
    private static final String FMT_4="Append what string to the current? ";
    private static final String FMT_5="Appended %s to current.";
    private static final String FMT_6="Insert what string? ";
    private static final String FMT_7="To what index? ";
    private static final String FMT_8="Inserted %s at index %d of current.";
    private static final String FMT_9="Word %d is %s.";
    private static final String FMT_10="Remove which index in the current? ";
    private static final String FMT_11="Removed index %d from current.";
    private static final String FMT_12=
        "Delete from which index in the current? ";
    private static final String FMT_13=
        "Delete to which index in the current? ";
    private static final String FMT_14=
        "Removed from index %d into index %d.";
    private static final String FMT_15="Concatenated index %d into index %d.";
    private static final String FMT_16="Recursive (r) or Iterative (i)? "; //EC
    private static final String FMT_17="Did not reverse. "; //EC

    
    private InputStream inStream;
    protected ArrayList<MyStringBuilder> words;
    protected int currInd;
    protected boolean quit;

    /**
     * Creates a driver that reads user input. 
     */
    public Main()
    {
        inStream = System.in;
        words = new ArrayList<MyStringBuilder>();
        currInd = -1;
        quit = false;
    }

    /**
     * Creates a driver that first reads from file then from 
     * System.in. Allows for continuation of commands 
     * as opposed to direct file redirection. 
     * 
     * @param  fileName The path to the file to be read. 
     */
    public Main(String fileName)
    {
        this();
        try
        {
            inStream = new FileInputStream(fileName);
        }
        catch (Exception e)
        {
            System.err.println(e.toString());
            System.exit(1);
        }
    }

    /**
     * Prints the usage of this driver to the console. 
     */
    private void printUsage()
    {
        System.out.println(USAGE);
    }

    /**
     * Prompts the user to input a command. 
     */
    private void promptUser()
    {
        System.out.print(PROMPT);
    }

    /**
     * Prints out the current list of words (MyStringBuilders) to the 
     * console. 
     */
    private void list()
    {
        System.out.println(String.format(ST_FMT_1, words.toString()));
    }

    /**
     * Prints the current word to the console. 
     */
    private void printCurrWord()
    {
        if(currInd == -1) 
            System.out.println(ST_FMT_2);
        else
            System.out.println(String.format(ST_FMT_3, 
                words.get(currInd).toString(), words.get(currInd).length()));
    }

    /**
     * Updates the current word and prints out information about 
     * a removed MyStringBuilder. 
     * 
     * @param msb The MyStringBuilder object that was removed. 
     */
    private void removed(MyStringBuilder msb)
    {
        currInd = words.size()-1;
        System.out.println(String.format(ST_FMT_4, msb.toString(), currInd));
    }

    /**
     * Switches to a different current word. 
     * 
     * @param ind The index of the new current word. 
     */
    private void switchTo(int ind)
    {
        if(ind<0 || ind>=words.size())
            System.out.println(String.format(ST_FMT_5, currInd));
        else
            System.out.println(String.format(ST_FMT_6, currInd=ind));
    }

    /**
     * Reads input from file (if needed) and then from the user. 
     */
    public void readInput()
    {
        Scanner sc = new Scanner(inStream);
        printUsage();

        // Loop until user quits with (Q)
        while(!quit)
        {
            promptUser();
            if(!sc.hasNextLine()) //For EOF
            {
                sc.close();
                sc = new Scanner(inStream = System.in);
            }
            String line = sc.nextLine();
            System.out.println(); // just to skip an extra line
            if (line.length() != 1)
            {
                printUsage();
                continue;
            }

            char command = Character.toUpperCase(line.charAt(0));
            if(currInd == -1 && command != CONSTRUCT && command != QUIT)
            {
                System.out.println(EMPTY_LIST);
                continue;
            }

            switch(command)
            {
                case CHANGE: 
                    // TODO
                    break;
                case CONSTRUCT: 
                    // TODO
                    break;
                case APPEND: 
                    // TODO
                    break;
                case INSERT: 
                    // TODO
                    break;
                case PRINT: 
                    // TODO
                    break;
                case REMOVE: 
                    // TODO
                    break;
                case LIST: 
                    list();
                    break;
                case DELETE: 
                    // TODO
                    break;
                case CONCAT: 
                    // TODO
                    break;
                case DESTRUCT: 
                    // TODO
                    break;
                case QUIT:
                    // TODO
                    break;
                default: 
                    printUsage();
            }
            if(!quit) printCurrWord();
        }
        list();
        System.out.println(String.format(ST_FMT_7, BadInputException.count,
                   MSBOutOfBoundsException.count));
    }

    /**
     * Main driver for this program. Run with an optional file path argument 
     * to load input from a file first. 
     * 
     * @param args Arguments from the command line. The first initial argument 
     *             (if any) should specify a file to read for input. 
     */
    public static void main(String[] args)
    {
        Main driver;
        if(args.length!=0)
        {
            driver = new Main(args[0]);
        }
        else
        {
            driver = new Main();
        }
        driver.readInput();
    }
}