package task1;

public class task1 {
	/**
     * This function returns an ArrayFunctions that counts
     * how many times a certain number that is passed as an argument occurs in an array
     *
     */
    public static ArrayFunctions counter( double value ) {
        return array -> {
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                if ( array[i] == value )
                    count++;
            }
            return count;
        };
    }
    
    
    /**
     * A lambda that finds the maximum
     * value of an array and then returns it.
     */
    public static final ArrayFunctions getMax = array -> {
        double max = array[0];
        for (int i = 0; i < array.length; i++) {
            if ( array[i] > max)
                max = array[i];
        }
        return max;
    };
    
    
    /**
     * A lambda that finds the minimum
     * value of an array and then returns it.
     */
    public static final ArrayFunctions getMin = array -> {
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if ( array[i] < min)
                min = array[i];
        }
        return min;
    };
    
    
    /**
     * A lambda that calculates the sum of the
     * values in an array and then returns it.  
     */
    public static final ArrayFunctions getSum = array -> {
        double total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }
        return total;
    };
    
    
    /**
     * A lambda that calculates the average of the
     * values in an array and then returns it.  
     */
    public static final ArrayFunctions getAvg = 
            array -> getSum.apply(array) / array.length;

}
