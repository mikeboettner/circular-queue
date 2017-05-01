import java.util.Scanner;

/**
 * @author      Michael Boettner
 * @version     1.0
 * Driver class containing menu-driven main method utilizing CircularQueue
 */

public class Driver {
    
    static Scanner keyboard = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("***********************");
        System.out.println("* COSC 311 Homework 2 *");
        System.out.println("*   Circular Queue    *");
        System.out.println("*  Michael Boettner   *");
        System.out.println("***********************");
        
        System.out.print("\n   Number of data elements in queue? ");
        
        /**
        * User-specified number of elements to store in queue
        */
        int numOfElements = keyboard.nextInt();

        /**
        * New CircularQueue object initialized
        */
        CircularQueue myQ = new CircularQueue(numOfElements);
        
        /**
        * variable used for menu navigation
        */
        int menuSelection = 0;
        
        while(menuSelection != 4)
        {
            System.out.println();
            System.out.println("(1) Enqueue Data");
            System.out.println("(2) Dequeue Data");
            System.out.println("(3) Print Queue");
            System.out.println("(4) Exit Program");

            System.out.print("\nSelection: ");
            menuSelection = keyboard.nextInt();
            
            switch(menuSelection)
            {
                case 1:
                    enqueue(myQ);
                    break;
                case 2:
                    dequeue(myQ);
                    break;
                case 3:
                    print(myQ);
                    break;
                case 4:
                    System.out.println("Exiting Program");
                    break;
                default:
                    System.out.println("Invalid Selection!");
            }
        }
    }
      
     /**
     * Adds a new data element to the specified queue
     *
     * @param  q CircularQueue object
     */
    static void enqueue(CircularQueue q)
    {
        if(q.isFull())
        {
            System.out.println("**********");
            System.out.println("     Error: The queue is at capacity");
            System.out.println("**********");
        }
        else
        {
            System.out.print("\n     Enter an integer to enqueue: ");
             
            /**
            * User-specified integer value to add to the queue
            */
            int intToEnqueue = keyboard.nextInt();
            
            q.insert(intToEnqueue);
            System.out.println("**********");
            System.out.println("\"" + intToEnqueue +
                    "\" has been added to the queue.");
            System.out.println("**********");
        }
    }
        
     /**
     * Removes the first element from the specified queue
     *
     * @param  q CircularQueue object
     */
    static void dequeue(CircularQueue q)
    {
        if(q.isEmpty())
        {
            System.out.println("**********");
            System.out.println("     Error: The queue is empty");
            System.out.println("**********");
        }
        else
        {
            System.out.println("**********");
            System.out.println("\"" + q.delete() + "\" has been dequeued.");
            System.out.println("**********");
        }
    }
        
     /**
     * Calls toString method to print the specified queue
     *
     * @param  q CircularQueue object
     */
    static void print(CircularQueue q)
    {
        System.out.println("**********");
        System.out.println("Queue contents:\n" + q.toString());
        System.out.print("**********");
    }     
}