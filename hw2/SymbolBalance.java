
import java.util.*;
import java.io.*;
import java.lang.ArrayIndexOutOfBoundsException;


public class SymbolBalance implements SymbolBalanceInterface{
    
    private String myfile;
    
    public void setFile(String filename) {
        myfile = filename;
    }   
    
	public BalanceError checkFile(){
        MyStack<Character> stack = new MyStack<>();
        int lineNumber = 0;
        String currentLine;
        boolean check = false;
        try{
            BufferedReader input = new BufferedReader(new FileReader(myfile));
            while((currentLine = input.readLine()) != null){
                lineNumber++;
                char[] characters = currentLine.toCharArray();
                for (int i=0; i<characters.length; i++){
                    Character currentSymbol = characters[i];
                    
                    if (currentSymbol != '"' && currentSymbol != '*' && check){
                        continue;
                    }
                    
                    else if (check) {
                        
                    
                        if (stack.isEmpty()){
                            return new EmptyStackError(lineNumber);
                        }
                        Character symbolPopped = stack.peek(); 
                   
                        if (currentSymbol == '"' && symbolPopped == '"'){
                            check = false;
                            stack.pop();  
                        }
                        
                        else if (currentSymbol == '*' && symbolPopped == '*'){
                            if ((characters[i+1] == '/') && ((i+1) < characters.length) &&
                            (characters[i-1] != '/')){
                                check = false;
                                stack.pop();
                        }
                    }
                    }
                    else if((currentSymbol == '*') || (currentSymbol =='"')){
                        if (currentSymbol == '*'){
                            if (characters[i-1] == '/' && i>0){
                                check = true;
                                stack.push(currentSymbol);
                            }
                        }
                        else if(currentSymbol == '"'){
                            check = true;
                            stack.push(currentSymbol);
                        }
                    } 
                    else if ((currentSymbol == '(') || (currentSymbol == '{') || (currentSymbol == '[')){
                        stack.push(currentSymbol);
                    }
                    
                    else if ((currentSymbol == ')') || (currentSymbol == '}') || (currentSymbol ==']')){
                        if (currentSymbol == ')'){
                            if (stack.isEmpty()){
                                return new EmptyStackError(lineNumber);
                            }
                            Character symbolPopped = stack.peek();
                            if (symbolPopped == '('){
                                stack.pop();    
                            }
                            else{
                                return new MismatchError(lineNumber, currentSymbol, symbolPopped);
                            }
                        }
                         else if (currentSymbol == '}'){
                             if (stack.isEmpty()){
                                 return new EmptyStackError(lineNumber);
                             }
                             Character symbolPopped = stack.peek();
                             if (symbolPopped == '{'){
                                 stack.pop();
                             }
                             else{
                                 return new MismatchError(lineNumber, currentSymbol, symbolPopped);
                             }
                         }
                          else if (currentSymbol == ']'){
                              if (stack.isEmpty()){
                                  return new EmptyStackError(lineNumber);
                              }
                              Character symbolPopped = stack.peek();
                              if (symbolPopped == '['){
                                  stack.pop();
                              }
                              else{
                                  return new MismatchError(lineNumber, currentSymbol, symbolPopped);
                              }
                              }
                          }
                        else{
                        //nothing
                    }
                    }
            }
                }
        catch(ArrayIndexOutOfBoundsException f){
            return null;
        }
        catch(FileNotFoundException e){
            System.out.println("Could not find file");
            System.out.println(e);
            return null;
        }
        catch(IOException d){
            System.out.println("An IOException occurred");
            System.out.println(d);
            return null; 
        }
        catch(Exception c){
            System.out.println("Unknown exception occurred");
            System.out.println(c);
            return null;
            }
        if (stack.isEmpty() == false){
            return new NonEmptyStackError(stack.peek(), stack.size());
        }
        return null;
            }
        }
        
