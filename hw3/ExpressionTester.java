public class ExpressionTester{
    public static void main(String[] args){
        String expression = "4 7 + 6 -";
        
        ExpressionTree myTree = new ExpressionTree(expression);
        System.out.println(myTree.eval());
        System.out.println(myTree.postfix());
        System.out.println(myTree.infix());
        System.out.println(myTree.prefix());
    }
}