
import java.util.*;

public class KBestCounter<T extends Comparable<? super T>> implements KBest<T>{
    
    int n;
    PriorityQueue<T> q;
    ArrayList<T> list;
    
    public KBestCounter(int k){
        n=k;
        q = new PriorityQueue<T>();
    }
    
    public void count(T x){ 
        q.add(x);    
    }
    
	public List<T> kbest(){
        int counter = 0;
        list = new ArrayList<T>(n);
        while (q.size() > n){
            q.poll();
            }
        while (counter != n){
            list.add(0,q.poll());
            counter++;
        }
        for (T x: list){
            q.add(x);
        }
        Collections.sort(list);
        return list;     
    }      
 }