package model;

import java.util.ArrayList;

public class CursorArray<T> {
    /*
     * This is the implementation of a cursor array that contains multiple equation stacks
     */
    private ArrayList<LinkedStack<T>> stacks;
    private int[] cursor;
    private int size;
    private int currIndex;

    public CursorArray(int size) {
    	/*
    	 * Initialzie the cursor give a size
    	 */
        setSize(size);
        setStacks(new ArrayList<>());
        setCursor(new int[getSize()]);

        for (int i = 0; i < getSize(); i++) {
            getStacks().add(new LinkedStack<T>());
            getCursor()[i] = 0;
        }
    }

    public void addStack(LinkedStack<T> stack) {
    	/*
    	 * This method is used to add a stack into the cursor
    	 */
        for (int i = 0; i < getSize(); i++) {
            if (getStacks().get(i).isEmpty()) {
                getStacks().set(i, stack);
                return;
            }
        }
    }

    public LinkedStack<T> getCurrent() {
        int current = getCursor()[getCurrIndex()];
        return getStacks().get(current);
    }

    /*
     * Checks if has Prev, & if has next
     * and move to the next 
     * and move to the prev
     */
    public boolean hasPrev() {
        int currentIndex = getCurrIndex();
        return getCursor()[currentIndex] > 0;
    }
    
    public boolean hasNext() {
        int currentIndex = getCurrIndex();
        return getCursor()[currentIndex] < getStacks().size() - 1;
    }

    public void moveNext() {
        int currentIndex = getCurrIndex();
        getCursor()[currentIndex]++;
        
        if (getCursor()[currentIndex] >= getStacks().size()) {
            getCursor()[currentIndex] = 0; 
        }
    }

    public void movePrev() {
        int currentIndex = getCurrIndex();
        getCursor()[currentIndex]--;
        
        if (getCursor()[currentIndex] < 0) {
            getCursor()[currentIndex] = getStacks().size() - 1; 
        }
    }

    /*
     * Getters & Setters
     */
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public int[] getCursor() {
        return cursor;
    }
    public void setCursor(int[] cursor) {
        this.cursor = cursor;
    }
    public ArrayList<LinkedStack<T>> getStacks() {
        return stacks;
    }
    public void setStacks(ArrayList<LinkedStack<T>> arrayList) {
        this.stacks = arrayList;
    }
    public int getCurrIndex() {
        return currIndex;
    }
    public void setCurrIndex(int currIndex) {
        this.currIndex = currIndex;
    }
}