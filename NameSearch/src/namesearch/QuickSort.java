/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package namesearch;

import java.util.LinkedList;

/**
 *
 * @author Tamu Fahnbulleh
 */
public class QuickSort 
{
    private final String[] Data;

    
     /**
     *
     * @param list the list to sort as array
     * @param start start point
     * @param end end point
     */
    public QuickSort(String[] list,int start,int end)
    {
        this.Data=list;
        doSort(start, end);
    }
    
    /**
     *
     * @param list the list to sort as LinkedList
     * @param start start point
     * @param end end point
     */
    public QuickSort(LinkedList<String> list,int start,int end)
    {
        this.Data=list.toArray(new String[list.size()]);
        doSort(start, end);
    }
    
    public String[] getData() 
    {
        return Data;
    }
    
    private void doSort(int start, int end)
    {
        sort(start,end);
    }
    
    private void sort(int start,int end)
    {
       int pivotPoint;
      
       if (start<end) 
       {
            pivotPoint=partition(start,end);
            sort(start,pivotPoint-1);
            sort(pivotPoint+1,end);
       }
    }
    
    private int partition(int start,int end)
    {
       String pivotValue; // To hold the pivot value
      int endOfLeftList; // Last element in the left sub list.
      int mid;           // To hold the mid-point subscript

      // Find the subscript of the middle element.
      // This will be our pivot value.
      mid = (start + end) / 2;

      // Swap the middle element with the first element.
      // This moves the pivot value to the start of 
      // the list.
      swap(start, mid);

      // Save the pivot value for comparisons.
      pivotValue = this.Data[start];
      
      // For now, the end of the left sub list is
      // the first element.
      endOfLeftList = start;
      
      // Scan the entire list and move any values that
      // are less than the pivot value to the left
      // sub list.
      for (int scan = start + 1; scan <= end; scan++)
      {
         if (this.Data[scan].compareTo(pivotValue) < 0)
         {
            endOfLeftList++;
            swap(endOfLeftList, scan);
         }
      }
      
      // Move the pivot value to end of the
      // left sub list.
      swap(start, endOfLeftList);
      
      // Return the subscript of the pivot value.
      return endOfLeftList;
    }
    
    
    //swap two items in an array
    //it will swap the item at index a for item in index b and vice versa
    private void swap(int a, int b)
    {
        String temp;   
        temp = this.Data[a];
        this.Data[a] = this.Data[b];
        this.Data[b] = temp;
    }
}
