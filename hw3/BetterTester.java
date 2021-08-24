public class BetterTester{
    public static void main(String[] args){
        BetterBST<Integer> b = new BetterBST<Integer>();
        int x = 4;
        b.insert(8);
        b.insert(5);
        b.insert(4);
        b.insert(6);
        b.insert(9);
        b.insert(10);
        b.insert(3);
        System.out.println(b.height());
        System.out.println(b.imbalance());
        System.out.println(b.smallestGreaterThan(x));
        System.out.println(b.mirror());
        b.prettyPrint();       
    }
}