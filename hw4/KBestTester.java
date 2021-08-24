

import java.util.*;

public class KBestTester{
     public static void main(String[] args){
         KBestCounter<Integer> k = new KBestCounter<Integer>(2);
         PriorityQueue<Integer> q = new PriorityQueue<Integer>();
         q.add(5);
         q.add(4);
         q.add(3);
         q.add(2);
         q.add(1);
         k.count(5);
         k.count(4);
         k.count(3);
         k.count(2);
         k.count(1);
         System.out.println(k.kbest());
         System.out.println(k.kbest());
}
}