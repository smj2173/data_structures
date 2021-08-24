public class Rectangle implements RectangleInterface, Comparable<Rectangle> {
 
    private double length;
    private double width;
   
    public Rectangle(double l, double w){
        length = l;
        width = w;
    }
    
    //to override length
    @Override
    public double getLength(){
        return length;
    }

    //to override width
    @Override
    public double getWidth(){
        return width;
    }
    
    public String toString(){
        return Double.toString(length*width);
    }

    public int compareTo(Rectangle other){
        int other_perimeter = (int) ((2*other.getWidth())+(2*other.getLength()));
        int this_perimeter = (int) ((2*this.getWidth())+(2*this.getLength()));
        int comparison = Integer.valueOf(this_perimeter).compareTo(Integer.valueOf(other_perimeter));
        return comparison;
    }
}

