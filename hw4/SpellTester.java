
public class SpellTester{
    public static void main(String[] args){
    SpellChecker sc = new SpellChecker("words.txt");
    System.out.println("incorrect words:" + sc.getIncorrectWords("test.txt"));
    System.out.println("suggestions" + sc.getSuggestions("acnnot"));
}
}
//theer, recedig, istant, horiozn, 
//throug, lps, youre, say7ing, fleting, zout, cqorner, eyey, 21it, wajs, acnnot, finzger, cihld, gronw, have467, comfortbaly