public class SymbolBalanceTester{  


    public static void main(String[] args){
        String input = args[0];
        SymbolBalance s = new SymbolBalance();
        s.setFile(input);
        System.out.println(s.checkFile());
       
        }
}  