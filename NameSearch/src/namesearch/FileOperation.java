/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


This class is use to open and read from a file
The class has three constructors
 */
package namesearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;


/**
 *
 * @author tfahn
 */
public class FileOperation 
{
    //instance varaible
    private File mFile;
    private Scanner scanner;
    private boolean isFileExist;
    private LinkedList<String> Names;

   
   
    //constructor
    public FileOperation(File file) throws FileNotFoundException
    {
        mFile=file;    
        Names=new LinkedList<>();
        try
        {
          ReadFile();
        }
        catch(FileNotFoundException ex)
        {
            throw new FileNotFoundException();
        }
      
    }
    
    
    public LinkedList<String> getNames() 
    {
        return Names;
    }
    
    public String[] getResultAsArray()
    {
        return this.Names.toArray(new String[this.Names.size()]);
    }
    
    //methoed is use to read text  file
    private void ReadFile() throws FileNotFoundException  
    {      
            scanner=new Scanner(mFile); //new scanner object
            while(scanner.hasNext()) //while there are lines to read
            {
                 String currentLine=scanner.nextLine(); //read the nextline in the file and store the result in currentLine
                this.Names.add(currentLine); //add item to Names List
            }
            scanner.close(); 
    }
    
    
}
