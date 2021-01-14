package Chapter25BST.hw.q22maxFirst;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise25_22 {
  public static void main(String[] args) {
    int[] items = {7 , 5 ,2 ,3 ,5 , 8};
    
    Arrays.sort(items);
    ArrayList<Bin> containers = new ArrayList<Bin>();
    
    for (int j = items.length - 1; j >= 0; j--) {
      boolean isAddedInAnExistingBin = false;
      for (int i = 0; i < containers.size(); i++) {
        if (containers.get(i).addItem(items[j])) {
          isAddedInAnExistingBin = true;
          break;
        }
      }
      
      // Add the item to a new bin
      if (!isAddedInAnExistingBin) {
        Bin bin = new Bin(10);
        bin.addItem(items[j]);
        containers.add(bin);
      }
    }
    
    // Display results
    for (int i = 0; i < containers.size(); i++) {
      System.out.println("Container " + (i + 1) + " contains objects with weight " + containers.get(i));
    }
  }
  
  static class Bin {   
    private ArrayList<Double> objects = new ArrayList<Double>();
    private double maxWeight = 10;
    private double totalWeight = 0;
    
    public Bin() {
    }
    
    public Bin(double maxWeight) {
      this.maxWeight = maxWeight;
    }
    
    public boolean addItem(double weight) {
      if (totalWeight + weight <= maxWeight) {
        objects.add(weight);
        totalWeight += weight;
        return true;
      } else {
        return false;
      }
    }
    
    public int getNumberOfObjects() {
      return objects.size();
    }
    
    @Override
    public String toString() {
      String output = "";        
      for (Double weight: objects)
        output += weight + " ";

      return output;
    }
  }
}
