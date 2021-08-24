//Sophie Johnson
//smj2173
//October 13, 2020

import java.util.*;

public class MyStack<T> implements MyStackInterface<T>{
    
    private int top;
    private T[] array;
    private static final int DEFAULT_SIZE = 10; //assign arbitrary initial size
    
    @SuppressWarnings("unchecked")
    public MyStack(){
        top = -1;
        array = (T[]) new Object[DEFAULT_SIZE];      
    }
    
    public void push(T x){
        top++;
        ensureCapacity(top + 1);
        array[top] = x;
    }
    
    @SuppressWarnings("unchecked")
    private void ensureCapacity(int size){
        if (size > array.length){
            T[] temp = array;
            array = (T[]) new Object[temp.length *2 + 1];
            for (int i = 0; i < temp.length; i++){
                array[i]= temp[i];
            }
    }
    }
    
	public T pop(){
        if (top == -1){
            throw new ArrayIndexOutOfBoundsException("Error: pop from an empty stack.");
        }
        T result = array[top];
        array[top] = null;
        top--;
        return result;
    }
    
    
	public T peek(){
        return array[top];
    }
    
    
	public boolean isEmpty(){
        return top == -1;
    }
    
    
	public int size(){
        return top + 1;
    }
    
}