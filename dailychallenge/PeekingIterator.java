/*
Design an iterator that supports the peek operation on an existing iterator in addition to the hasNext 
and the next operations.

Implement the PeekingIterator class:

* PeekingIterator(Iterator<int> nums) Initializes the object with the given integer iterator iterator.
* int next() Returns the next element in the array and moves the pointer to the next element.
* boolean hasNext() Returns true if there are still elements in the array.
* int peek() Returns the next element in the array without moving the pointer.

Note: Each language may have a different implementation of the constructor and Iterator, but they all support 
the int next() and boolean hasNext() functions.

Link: https://leetcode.com/problems/peeking-iterator/

Solution:
We can keep track of the next element using variable and check for the conditions where we reach the end of the list.
*/

import java.util.*;

public class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer next;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (iterator.hasNext()) {
            next = iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (next == null) {
            throw new NoSuchElementException();
        }
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer res = next;
        if (iterator.hasNext()) {
            next = iterator.next();
        } else {
            next = null;
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}