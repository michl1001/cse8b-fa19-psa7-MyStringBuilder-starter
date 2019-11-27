/** Your beautiful file header here TODO */

/** Your beautiful class header here TODO */
public class MyStringBuilder
{
    protected CharNode start; 
    protected CharNode end; 
    protected int length; 

    /************* For use in Exception messages *************/
    private static final String FROM_APPEND_STR = "append(String)";
    private static final String FROM_INSERT_CHAR = "insert(char, int)";
    private static final String FROM_INSERT_STR = "insert(String, int)";
    private static final String FROM_FIND = "findIndex(int)";
    private static final String FROM_FINDFROM = "findIndexFrom(CharNode, int)";
    private static final String FROM_REMOVE = "remove(int)";
    private static final String FROM_DELETE = "delete(int)";
    private static final String FROM_DELETE_INTERVAL = "delete(int, int)";
    private static final String FROM_CONCAT = "concat(MyStringBuilder)";

    public MyStringBuilder(char c)
    {
        // TODO
    }

    public MyStringBuilder(String str)
    throws BadInputException
    {
        // TODO
    }

    public MyStringBuilder(CharNode start)
    {
        // TODO
    }

    public int length()
    {
        // TODO
        return -1;
    }

    public MyStringBuilder append(char c)
    {
        // TODO
        return this;
    }

    public MyStringBuilder append(String str)
    throws BadInputException
    {
        // TODO
        return this;
    }

    public MyStringBuilder insert(char c, int index)
    throws MSBOutOfBoundsException
    {
        // TODO
        return this;
    }

    public MyStringBuilder insert(String str, int index)
    throws BadInputException, MSBOutOfBoundsException
    {
        // TODO
        return this;
    }

    protected CharNode findIndex(int index)
    throws MSBOutOfBoundsException
    {
        // TODO
        return null;
    }

    protected CharNode findIndexFrom(CharNode cNode, int index)
    throws MSBOutOfBoundsException
    {
        // TODO
        return null;
    }

    public MyStringBuilder remove(int index)
    throws MSBOutOfBoundsException
    {
        // TODO
        return this;
    }

    public MyStringBuilder delete(int startIndex)
    throws MSBOutOfBoundsException
    {
        // TODO
        return this;
    }

    public MyStringBuilder delete(int startIndex, int endIndex)
    throws BadInputException, MSBOutOfBoundsException
    {
        // TODO
        return this;
    }

    public MyStringBuilder concat(MyStringBuilder rightOperand)
    throws BadInputException
    {
        // TODO
        return this;
    }

    public String toString()
    {
        // TODO
        return "";
    }
}
