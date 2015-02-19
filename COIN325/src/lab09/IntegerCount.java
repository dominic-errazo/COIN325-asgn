package lab09;

/**
 *
 * @author Dominic
 */
public class IntegerCount {

    private int[] _count;
   
    
    public IntegerCount() {
        _count = new int[100];
        for(int i = 0; i < 100; i++)
            _count[i] = 0;
        
    }
    
    /**
     * Attempts to increment the count of an integer in the range [1,100]
     * received. Returns true if successful, false if unsuccessful.
     * 
     * @param i an integer provided to this method
     * @return indication of success or failure
     */
    public boolean receiveInteger(int i) {
        try {
            _count[i-1]++;
            return true;
        }
        catch(ArrayIndexOutOfBoundsException arr)
        {
            return false;
        }
    }
    
    /**
     * Returns the total number of times the given integer was received.
     * In the event an integer outside of the range [1,100] is specified,
     * the function returns the value -1.
     * @param i an integer whose count is desired
     * @return the number of times the integer was received, or -1 for an
     * improper value
     */
    public int receiveCount(int i) {
        try
        {
            return _count[i-1];
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            return -1;
        }
    }
    
    /**
     * Displays the counts for elements that have been received.
     */
    public void printout() {
        for(int total = 0; total < 100; total++)
            if(_count[total] > 0) System.out.println((total + 1) + ": " + _count[total]);
    }
    
    //==============CUSTOM TESTING METHODS==============
    
    /**
     * Adds multiple numbers from a string in the format:
     * 
     * "%n %n %n %n..."
     * Explicitly, integers delineated by spaces
     * 
     * @param s A string of integers formatted as specified above
     */
    public void addFromString(String s) {
        String[] tokens = s.split(" ");
        for(String token: tokens) {
            try {
                receiveInteger(Integer.parseInt(token));
            }
            catch(NumberFormatException e) {
                //ignore it
            }
        }
    }
    
    /**
     * Reset the counts of all integers.
     */
    public void clear() {
        for(int i = 0; i < 100; i++)
           _count[i] = 0;
    }
    
    public static void main(String[] args) {
        IntegerCount counter = new IntegerCount();
        
        counter.receiveInteger(20);
        counter.receiveInteger(30);
        counter.receiveInteger(50);
        
        counter.printout();
    }
}
