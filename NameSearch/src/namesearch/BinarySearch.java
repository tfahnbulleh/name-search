/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package namesearch;

/**
 *
 * @author Tamu Fahnbulleh
 */
public class BinarySearch 
{
    private final String SearchTerm;
    private final String[] SearchList;
    private int Position=-1;
    private boolean IgnoreCase=false;
   
    
    /**
     *
     * @param searchTerm the term to search for
     * @param list an ordered list
     * @param ignoreCase ignore case in search
     */
    public BinarySearch(String searchTerm, String[] list,boolean ignoreCase)
    {
        this.SearchTerm=searchTerm;
        this.SearchList=list;
        this.IgnoreCase=ignoreCase;
        search();
    }
    
     public String getSearchTerm() 
    {
        return SearchTerm;
    }

    public int getPosition()
    {
        return Position;
    }
    
    private void search()
    {
      int first;       // First names element
      int last;        // Last names element
      int middle;      // Mid point of search
      int position;    // Position of search value
      boolean found;   // Flag

      // Set the inital values.
      first = 0;
      last = this.SearchList.length - 1;
      position = -1;
      found = false;

      // Search for the value.
      while (!found && first <= last)
      {
         // Calculate mid point
         middle = (first + last) / 2;
         
         if(this.IgnoreCase)
         {
             if (this.SearchList[middle].compareToIgnoreCase(this.SearchTerm) == 0)
             {
                 found = true;
                 position = middle;
             }
              // If value is found at midpoint...
         
              // else if value is in lower half...
             else if (this.SearchList[middle].compareToIgnoreCase(this.SearchTerm) > 0)
                  last = middle - 1;
             // else if value is in upper half....
             else
                  first = middle + 1;
         }
         else
         {
              if (this.SearchList[middle].compareTo(this.SearchTerm) == 0)
             {
                 found = true;
                 position = middle;
             }
              // If value is found at midpoint...
         
              // else if value is in lower half...
             else if (this.SearchList[middle].compareTo(this.SearchTerm) > 0)
                  last = middle - 1;
             // else if value is in upper half....
             else
                  first = middle + 1;
         }
        
      }
      this.Position=position;
    }
    
}
