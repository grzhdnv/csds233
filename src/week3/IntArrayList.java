package week3;

public class IntArrayList {
    // private data members
    private int [] data;
    private int numItems; //How many items are being stored in the list
                        // note this is NOT the same as the size of the array
    private int currentPos;// Which position in the list is considered the current one

    //constructor
    public IntArrayList() {
        data = new int [10]; // Initially allow for up to 10 items to be stored in our list
        currentPos = 0; // Set our "current" location to the beginning of the list
        numItems = 0; // Our list is initially empty
    }

    // add Methods
    // For all add methods you should consider what to do if the array is full before addition

    // adds item to the end of the list
    public boolean add(int item){
        checkCapacity(numItems + 1);
        data[numItems] = item;
        numItems++;
        return true;
    }

    // inserts item into the list at position pos.
    // currentPos is set to this position
    public void add(int pos, int item){
        if (pos < 0 || pos > numItems) {
            throw new IndexOutOfBoundsException();
        }
        checkCapacity(numItems + 1);
        for (int i = numItems; i > pos; i--)
            data[i] = data[i - 1];
        data[pos] = item;
        numItems++;
        currentPos = pos;
    }

    // For these next two (addAfter and addBefore)
    // place an int before or after the data[currentPos] int
    // this added item becomes the new currentPos.
    
    // If no valid currentPs, addAfter places item at the end of the list and
    // addBefore places item at beginning of list;
    // returns true if list is changed

    public boolean addAfter(int item){
        checkCapacity(numItems + 1);
        if (currentPos >= 0 && currentPos < numItems) {
            add(currentPos + 1, item);
        } else {
            add(item);
            currentPos = numItems - 1;
        }
        return true;
    }

    public boolean addBefore(int item){
        checkCapacity(numItems + 1);
        if (currentPos >= 0 && currentPos < numItems) {
            add(currentPos, item);
        } else {
            add(0, item);
            currentPos = 0;
        }
        return true;
    }

    // Appends items to the end of this list.
    // Returns true if the list changed as a result.
    // currentPos doesn’t change
    boolean addAll(IntArrayList items){
        if (items == null || items.numItems == 0)
            return false;
        checkCapacity(numItems + items.numItems);
        for (int i = 0; i < items.numItems; i++)
            data[numItems + i] = items.data[i];
        numItems += items.numItems;
        // could use System.arraycopy()
        return true;
    }

    private void checkCapacity(int reqCapacity) {
        if (data.length < reqCapacity) {                            // check if need to increase size
            int newSize = Math.max(data.length * 2, reqCapacity);   // get a new size
            int[] newData = new int[newSize];                       // create new data array
            for (int i = 0; i < numItems; i++)                      // copy existing data to new array
                newData[i] = data[i];

            // could also do:
            // data = Array.copyOf(data, newSize)
            data = newData;
        }
    }
}
