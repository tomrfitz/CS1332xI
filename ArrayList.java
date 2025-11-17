// [Executed at:Mon Nov 17 12:13:48 PST 2025]
// ============================================================
// ArrayList.java successfully compiled.
// ============================================================
// Tests Passed:10/23
// [Test Failure:addToFront][-0.43]:IllegalArgumentException not thrown when
// attempting to add null data to the front.

// [Test Failure:addToFront][-0.43]:This addToFront test was inconclusive due
// to:java.lang.ArrayIndexOutOfBoundsException:Index 9 out of bounds for
// length 9.
// Here is the stack trace to help identify the error in your code:
//      at ArrayList.addToFront,line number:43

// [Test Failure:addToFront][-0.43]:This addToFront test was inconclusive due
// to:java.lang.ArrayIndexOutOfBoundsException:Index 18 out of bounds for
// length 18. Here is the stack trace to help identify the error in your code:
//      at ArrayList.addToFront,line number:43

// [Test Failure:addToBack][-0.43]:IllegalArgumentException not thrown when
// attempting to add null data to the back.

// [Test Failure:addToBack][-0.43]:This addToBack test was inconclusive due
// to:java.lang.ArrayIndexOutOfBoundsException:Index 9 out of bounds for
// length 9. Here is the stack trace to help identify the error in your code:
//      at ArrayList.addToBack,line number:59

// [Test Failure:addToBack][-0.43]:This addToBack test was inconclusive due
// to:java.lang.ArrayIndexOutOfBoundsException:Index 18 out of bounds for
// length 18. Here is the stack trace to help identify the error in your code:
//      at ArrayList.addToBack,line number:59

// [Test Failure:removeFromFront][-0.43]:NoSuchElementException not thrown when
// attempting to remove from the front an empty ArrayList.

// [Test Failure:removeFromFront][-0.43]:Unexpected content after removing the
// only element from the front.
//      Expected:[null,null,null,null,null,null,null,null,null]
//      Actual:  [0 a,null,null,null,null,null,null,null,null]

// [Test Failure:removeFromFront][-0.43]:Unexpected content after removing once
// from the front.
//      Expected:[1 a,2 a,3 a,4 a,5 a,null,null,null,null]
//      Actual:  [1 a,2 a,3 a,4 a,5 a,5 a,null,null,null]

// [Test Failure:removeFromFront][-0.43]:Unexpected content after removing once
// from the front of a full ArrayList.
//      Expected:[1 a,2 a,3 a,4 a,5 a,6 a,7 a,8 a,null]
//      Actual:  [1 a,2 a,3 a,4 a,5 a,6 a,7 a,8 a,8 a]

// [Test Failure:removeFromFront][-0.43]:Unexpected content after removing once
// from the front of a resized ArrayList.
//      Expected:[1 a,2 a,3 a,4 a,5 a,6 a,7 a,8 a,9
//      a,null,null,null,null,null,null,null,null]

//      Actual:  [1 a,2 a,3 a,4 a,5 a,6 a,7 a,8 a,9 a,9
//      a,null,null,null,null,null,null,null,null]

// [Test Failure:removeFromBack][-0.43]:NoSuchElementException not thrown when
// attempting to remove from the back of an empty ArrayList.

// [Test Failure:validSize][-0.43]:Size variable could not be validated for the
// following method(s)due to early test
//      failure(s):removeFromBack,addToBack,addToFront.

// Score:4.35/10.0============================================================

/**
 * Your implementation of an ArrayList.
 */
public class ArrayList<T> {

    /*
     * The initial capacity of the ArrayList.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 9;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new ArrayList.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayList() {
        // DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the front of the list.
     *
     * This add may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException("Data is null");
        }
        if (size == backingArray.length) {
            T[] newArray = (T[]) new Object[backingArray.length * 2];
            for (int i = 0; i < backingArray.length; i++) {
                newArray[i] = backingArray[i];
            }
            backingArray = newArray;
        }
        for (int i = size; i > 0; i--) {
            backingArray[i] = backingArray[i - 1];
        }
        backingArray[0] = data;
        size++;
    }

    /**
     * Adds the data to the back of the list.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException("Data is null");
        }
        if (size == backingArray.length) {
            T[] newArray = (T[]) new Object[backingArray.length * 2];
            for (int i = 0; i < backingArray.length; i++) {
                newArray[i] = backingArray[i];
            }
            backingArray = newArray;
        }
        backingArray[size] = data;
        size++;
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Do not shrink the backing array.
     *
     * This remove may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (size == 0) {
            throw new java.util.NoSuchElementException("List is empty");
        }
        T removed = backingArray[0];
        for (int i = 0; i < size - 1; i++) {
            backingArray[i] = backingArray[i + 1];
        }
        backingArray[0] = null;
        size--;
        return removed;
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Do not shrink the backing array.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (size == 0) {
            throw new java.util.NoSuchElementException("List is empty");
        }
        T removed              = backingArray[size - 1];
        backingArray[size - 1] = null;
        backingArray[size]     = null;
        size--;
        return removed;
    }

    /**
     * Returns the backing array of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}
