public class GenericMethods implements GenericMethodsInterface{
    
    private int low;
    private int high;
    
    public <AnyType extends Comparable<AnyType>> int binarySearch(AnyType[] a, AnyType x){
        return helper(a, x, low, high);
    }
        
    
    private <AnyType extends Comparable<AnyType>> int helper(AnyType[] a, AnyType x, int low, int high){
        low = 0;
        high = a.length -1;
        if (low > high && high>=1){ 
            int middle = (low + high)/2;
            if (x.compareTo(a[middle]) == 0){
                return middle;
                }
            else if (x.compareTo(a[middle]) < 0){
                helper(a, x, (middle+1), high);     
            }
            else{
                helper(a, x, low, (middle-1));
            }           
        }
        return -1;
    }
          
    public <AnyType extends Comparable<AnyType>> int linearSearch(AnyType[] a, AnyType x){
        for(int i=0;i<a.length;i++){    
            if(a[i] == x){    
                return i;    
                }    
        }
        return -1;        
    }
}




