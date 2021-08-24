import java.io.*;
import java.util.*;


public class SpellChecker implements SpellCheckerInterface{
    
    private Set<String> hash;
    
    public SpellChecker(String filename) {
        try{
            Scanner input = new Scanner(new File(filename));
            hash = new HashSet<>();
            while (input.hasNext()){            
                hash.add(input.next().toLowerCase());
            }
        }
        catch (FileNotFoundException f){
            System.out.println("File not found.");
            System.out.println(f);
        }
        catch (Exception e){
            System.out.println("Exception occurred.");
            System.out.println(e);
        }
    
    }
    
    @Override    
    public List<String> getIncorrectWords(String filename){
        try{
            Scanner input = new Scanner(new File(filename));
            ArrayList<String> words = new ArrayList<>();
            while (input.hasNext()){
                String next = input.next();
                next = next.replaceAll("\\p{Punct}","");
                next = next.toLowerCase();
                words.add(next);
            }
            ArrayList<String> misspelled = new ArrayList<>();
            for (String i: words){
                if (hash.contains(i) == false){
                    misspelled.add(i);
                }      
           }    
            return misspelled;
        }
        catch (FileNotFoundException f){
            System.out.println("File not found.");
            System.out.println(f);
            return null;
        }
        catch (NullPointerException n){
            System.out.println("Null pointer found");
            System.out.println(n);
            return null;
        }   
        }
        
	public Set<String> getSuggestions(String word){
        Set<String> suggestions = new HashSet<>();
        String sub1;
        String sub2;
        String possible;
        
        for (int i=0; i< word.length(); i++){
            
            //remove character
            sub1 = word.substring(0, i);
            sub2 = word.substring(i+1);
            
            
            possible = sub1 + sub2;
            if (hash.contains(possible) && (!suggestions.contains(possible))){
                suggestions.add(possible);
            }
            //special case before and after word
            for (char c='a'; c <= 'z'; c++){
                String option1 = c + word;
                String option2 = word + c;
                if (hash.contains(option1) && (!suggestions.contains(option1)))
                    suggestions.add(option1);
                if (hash.contains(option2) && (!suggestions.contains(option2)))
                    suggestions.add(option2);         
            }
            
            sub1 = word.substring(0, i);
            sub2 = word.substring(i);
            
            for (char c = 'a'; c <= 'z'; c++){
                possible = sub1 + c + sub2;
                if (hash.contains(possible) && (!suggestions.contains(possible))){
                    suggestions.add(possible);
                    System.out.println(suggestions);
                }
            }   
        }
        //swap
        for (int i=1; i < word.length(); i++){
            sub1 = word.substring(0, i-1);
            char c1= word.charAt(i-1);
            char c2 = word.charAt(i);
            sub2 = word.substring(i+1);
            possible = sub1 + c2 + c1 + sub2;
            if (hash.contains(possible) && (!suggestions.contains(possible))){
                suggestions.add(possible);
            }
        }
            
        
        return suggestions;
    }
    
    
}