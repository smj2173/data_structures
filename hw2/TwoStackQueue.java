
import java.util.*;

public class TwoStackQueue<T> implements TwoStackQueueInterface<T>{
    
    private MyStack<T> S1 = new MyStack<>();
    private MyStack<T> S2 = new MyStack<>();
    
    public void enqueue(T x){
        S1.push(x);    
    }
    
	public T dequeue() throws NoSuchElementException{
        if (isEmpty()){
            throw new NoSuchElementException("The queue is empty: invalid dequeue.");
        }
        if (S2.isEmpty()){
            while (! S1.isEmpty()){
                S2.push(S1.pop());
            }
        }
        return S2.pop();
    }
    
	public boolean isEmpty(){
        return S1.isEmpty() && S2.isEmpty();
    }
    
    public int size(){
        if ((S1.isEmpty()) && (! S2.isEmpty())){
            return S2.size();
        }
        else{
            return S1.size();
        }
        }
            
        } 
    