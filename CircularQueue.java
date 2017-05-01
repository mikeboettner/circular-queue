/**
 * @author      Michael Boettner
 * @version     1.0
 * Circular Queue class allows for creation of an array-based queue of
 * user-specified size for storage of integers, data entry and deletion, and
 * printing of queue elements
 */
public class CircularQueue {
    
    /**
    * Index reference to the first element of the queue
    */
    private int head;
    
    /**
    * Index reference to next available insertion point for new data entries
    */
    private int tail;
    
    /**
    * User-specified size of the queue
    */
    private final int size;
    
    /**
    * Array of Integer objects used to store queue values
    */
    private final Integer[] myArray;
    
    /**
     * Constructor initializes the array, head, and tail references. Array
     * will be one element larger than the size parameter, since this
     * implementation requires one cell to remain empty.
     *
     * @param  arraySize Number of elements the user specifies for the queue
     */
    CircularQueue(int arraySize)
    {
        size = arraySize + 1; //1 added to accomodate necessary empty cell
        head = tail = 0; //index 0 is starting point for both head and tail
        myArray = new Integer[size];
    }
    
    /**
    * Determines whether the queue is full or not.
    *
    * @return boolean true if queue is full, false if queue is not full
    */
    public boolean isFull()
    {
        //% size operation is needed to implement circular queue
        return (head == (tail + 1) % size); 
    }
    
    /**
    * Determines whether the queue is empty or not
    *
    * @return boolean true if the queue is empty, false if the queue is
    * not empty
    */
    public boolean isEmpty()
    {
        return (head == tail);
    }
    
    /**
    * Inserts an int value to the current end of the queue
    *
    * @param x The integer being added to the queue
    */
    public void insert(int x)
    {
        //if queue has room, insert new data in tail location
        if(!isFull())
        {
            myArray[tail] = x;
            tail = (tail + 1) % size; //increment tail 
        }
        else
            System.out.print(
            "\nError: Insertion was not successful. "
                    + "The queue is at capacity\n");
    }
    
    /**
    * Deletes the first element in queue
    *
    * @return Integer value of the node being deleted
    */
    public Integer delete()
    {
        //if queue is not empty, return the first element and increment head
        if(!isEmpty())
        {
            int returnValue = myArray[head];
            head = (head + 1) % size; //increment head of the queue
            return returnValue;
        }
        else
            return null;
    }
    
    /**
    * Gives access to data of first item in queue without changing the queue
    *
    * @return Integer value of the first element in queue
    */
    public Integer peek()
    {
        //if queue is not empty, return the first element
        if(!isEmpty())
        {
            int returnValue = myArray[head];
            return returnValue;
        }
        else
            return null;
    }
    
    /**
     * creates String containing data values of all queue items
     *
     * @return String formatted with line breaks between values
     */
    @Override
    public String toString()
    {
        String myReturnString = "";
        
        if(head != tail)
        {
            for(int index = head; index != tail;
                    index = (index + 1) % size)
            {
                myReturnString += myArray[index] + "\n";
            }
            return myReturnString;
        }
        return "\nError: No entries exist in the queue.";
    }
}