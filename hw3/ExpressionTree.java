
import java.util.*;

public class ExpressionTree implements ExpressionTreeInterface{

    private ExpressionNode root;
    
    private static class ExpressionNode{
        public String data;
        public ExpressionNode left;
        public ExpressionNode right;
        
        public ExpressionNode(String d, ExpressionNode l, ExpressionNode r){
            data = d;
            left = l;
            right = r;
        }
        
    }
    
    public static boolean isOperator(String token){
        return (token.equals("-") || token.equals("/") || 
            token.equals("+") || token.equals("*"));
    }
        
    public ExpressionTree(String expression){
        try{
            LinkedList<ExpressionNode> stack = new LinkedList<ExpressionNode>();
            String[] tokens = expression.split(" ");
        
            for (String token : tokens){
                if (isOperator(token)){
                    ExpressionNode left_child = stack.pop();
                    ExpressionNode right_child = stack.pop();
                    stack.push(new ExpressionNode(token, left_child, right_child));
                }
                else{
                    stack.push(new ExpressionNode(token, null, null));
                }    
            }
            root = stack.pop();
        }
        catch(NoSuchElementException n){
            System.out.println("Invalid expression");
            System.out.println(n);
        }
        catch(RuntimeException r){
            System.out.println("Runtime Exception occurred");
            System.out.println(r);
        }
        catch(Exception c){
            System.out.println("Unknown exception occurred");
            System.out.println(c);
        }
    }
            
    
    
    public int eval(){
        return eval(root);
    } 
    
    private int eval(ExpressionNode node){
        
    if (isOperator(node.data)){
        int evaluateLeft = eval(node.left);
        int evaluateRight = eval(node.right);
        if ((node.data).equals("+"))
            return (evaluateLeft + evaluateRight);
        else if ((node.data).equals("/"))
            return (evaluateLeft / evaluateRight);
        else if ((node.data).equals("-"))
            return (evaluateRight - evaluateLeft);
        else if ((node.data).equals("*"))
             return (evaluateLeft * evaluateRight);
          }
    int info = Integer.parseInt(node.data);
        return info;
        }
    
    public String postfix(){
        return postfix(root);
    } 
    
    private String postfix(ExpressionNode node){
        if (isOperator(node.data)){
            return (postfix(node.left) + " " + postfix(node.right) + " " + node.data);
        }
        else
            return node.data;
    }
    //this method, when invoked on an expression tree object, will return a String that contains the corresponding postfix expression. 
    //It will need to call a private recursive method that takes in the root. Each operator and operand must be delimited by only one space and there should be no extraneous white space on either ends of the String. 
    //Any deviations from these instructions, will result in a loss of points.
    public String prefix(){
        return prefix(root);
    } 
    
    private String prefix(ExpressionNode node){
        if (isOperator(node.data)){
            return (node.data + " " + prefix(node.left) + " " + prefix(node.right));
        }
        else
            return node.data;
    }
    //this method, when invoked on an expression tree object, will return a String that contains the corresponding prefix expression. 
    //It will need to call a private recursive method that takes in the root. 
    //Each operator and operand must be delimited by only one space and 
    //there should be no extraneous white space on either ends of the String. Any deviations from these instructions, will result in a loss of points.
    public String infix(){
        return infix(root);
    } 
    
    private String infix(ExpressionNode node){
        if (isOperator(node.data)){
            return (infix(node.left) + " " + node.data + " " + infix(node.right));
        }
        else 
            return node.data;
    }
    // this method, when invoked on an expression tree object, will return a String that contains the corresponding correct infix expression. 
    // Keep in mind that parentheses will be needed (excessive parenthesis will be tolerated as long as they are correctly placed). 
    // It will need to call a private recursive method that takes in the root. Each operator and operand must be delimited 
    // by only one space and there should be no extraneous white space on either ends of the String. Any deviations from these instructions, will result in a loss of points.
    
   
    }
    