public class BigO implements BigOInterface {
    
    //cubic must be O(n^3)
    //exp must be O(2^n)
    //constant must be O(1)
    
    int x;

    public void cubic(int n){
        x = n;
        int k=0;
        for (int i=0; i< x; i++){
            k++;
            for (int j=0; j< x; j++){
                if (k!=3){
                    k=k++;
                }
            }
        }
                
        }
    
    public void exp(int n){
        x = n;
        helper_recursion(x);
    }
    
    public int helper_recursion(int x){
        if (x <= 1){
            return x;
        }
        else{
            x = helper_recursion(x-2) + helper_recursion(x-1);
            return x;
        }
    }
        
    
    public void constant(int n){
        x=n;      
    }
}
