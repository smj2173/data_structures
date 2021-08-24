//smj2173
//BetterBST class
//November 3 2020

import java.util.*;

public class BetterBST<T extends Comparable<? super T>> extends BinarySearchTree<T>{
    
    int height;
    ArrayList<T> arr;
    
    public BetterBST(){
        height = 0;
        root = null;
    }
    
    
    public int height(){
        return height(root);
    }
    
    private int height(BinaryNode<T> t){
        if (t == null)
            return -1;
        else{
            int leftside = height(t.left);
            int rightside = height(t.right);
            if (leftside > rightside){
                return leftside+1;
            }
            else
                return rightside+1;
        }
    }
    
    public T imbalance(){
        return imbalance(root);
    }
    
    private T imbalance(BinaryNode<T> t){
        ArrayList<T> arr = new ArrayList<T>();
        if (t == null){
            return null;
        }
        else{
            int difference = height(t.left) - height(t.right);
            if (Math.abs(difference) <= 1){
                return null;
            }
            else{
                if (height(t.left) > height(t.right)){
                    arr = inOrderTraversal(t.left, arr);
                    return arr.get(height(t.right)+1);
                }
                else{
                    arr = inOrderTraversal(t.right, arr);
                    return arr.get(height(t.left)+1);
                }     
            }
        }
    }
    
    private ArrayList<T> inOrderTraversal(BinaryNode<T> t, ArrayList<T> array){
        if (t == null){
            return array;
        }
        inOrderTraversal(t.left, array);
        array.add(t.data);
        inOrderTraversal(t.right, array);
        return array;
    }
    
    public T smallestGreaterThan(T t){
        return smallestGreaterThan(t, root);
        }
    
    private T smallestGreaterThan(T x, BinaryNode<T> t){
        if (t == null){
            return null;
        }
        if ((t.data).compareTo(x) > 0){
            if (t.left != null && (t.left.data.compareTo(x) > 0)){
                return smallestGreaterThan(x, t.left);
            }
            else{
                 return t.data;  
            }
        }
        else{
            return smallestGreaterThan(x, t.right);
        }
    }
        
    public BinarySearchTree<T> mirror(){
        return mirror(root);   
    }
    
    private BinarySearchTree<T> mirror(BinaryNode<T> t){
        @SuppressWarnings("unchecked")
        BetterBST<T> myTree = new BetterBST<T>();
        if (t == null){
            return myTree;
        }
        else{
            mirror(t.left);
            mirror(t.right);
            BinaryNode<T> temp = t.left;
            t.left = t.right;
            t.right = temp;
            return myTree;
        }
    }
    public void prettyPrint(){
        ArrayList<BinaryNode<T>> l = new ArrayList<BinaryNode<T>>();
        l.add(root);
        prettyPrint(l, (height(root)+1));
    }
      
    private void prettyPrint(ArrayList<BinaryNode<T>> list, int levels){
        ArrayList<BinaryNode<T>> theNodes = new ArrayList<BinaryNode<T>>();
        //tree line 1
        theIndent(levels);
        
        for (BinaryNode<T> t : list){
            //print node data
            if (t != null){
                System.out.print(t.data);
            }
            //print spacing
            theSpacing(levels);
         
            if (levels>1){
                if (t.right != null){
                    theNodes.add(t.right);   
                }
                if (t.left != null){
                    theNodes.add(t.left);
                }
                
                }
                }
            
        System.out.println(); //new line :))
            
        if (levels>1){
            prettyPrint(theNodes, levels-1);
        }
        }
    private void theIndent(int levels){
        for (int i = (int) (Math.pow(2, levels-1)); i>0; i--){
            System.out.print("  ");
        }
    }
    
    //space between nodes on same level
    private void theSpacing(int levels){ 
        for (int i = (int) ((Math.pow(2, levels-1))*2)-1 ; i>0; i--){
            System.out.print("  ");
            }
            }
    
    }
    
