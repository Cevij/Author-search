import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;



public class Author {
	int marker = 0;//marker to trigger if statement letting you know if the author was found 
	String[] array = null;//holds author and books together
	String file="src\\revised data.txt";//author's stored txt
	
	public String[] getInfo() throws IOException{//reads .txt into string array
        FileReader fr=new FileReader(file);//locate of file
        BufferedReader fr1= new BufferedReader(fr); 
        String i = null;
        
       // String[][] holder = null;//playing around with 3d array idea
       
        
        while ((i=fr1.readLine())!= null) 
        {
            array=  i.split("/",-2);//i had to spit the txt with a different sign it wouldnt take the $
            //holder[count] = array;// thinking of the 3d array
            
        }
       
            fr1.close();
            
    		bubbleSort();//to sort any new authors added
            
            return array;
        }
	
	public void writeToFile() throws IOException {//this is how you right to the txt file
		String author;
		String books;
		
		try(FileWriter fr = new FileWriter(file, true);
			    BufferedWriter fr1 = new BufferedWriter(fr);
			    PrintWriter out = new PrintWriter(fr1))
			{
			 @SuppressWarnings("resource")
			Scanner keyboard = new Scanner(System.in);

		      System.out.printf("Please enter Author's Last and First name in this format(Johns, jimmmy): \n");
		      author = keyboard.nextLine();//stores author
		      
		      out.print("/"+author+ " - ");//this is how you output into the .txt file
		      
		      System.out.printf("Please enter books: \n");
		      books = keyboard.nextLine();
		      

			  out.print(books);//this one i put the / in so it can auto split the array
    
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}
		
		getInfo();// i added the getinfo() so it can continue to add to the same array 
		
		
		
	}
	
	
	public void searchByName()//My pride and joy
	{
		
		String exit=null;//to exit the inner while loop
		Boolean end=false;// exit the outer while loop
		
		while(end!=true) //search author by first name loop 
		{
			
			Boolean marker=false;//auto sets to 0 to trigger "sorry" statement line 107
			
			@SuppressWarnings("resource")
			Scanner keyboard = new Scanner(System.in);

		    System.out.printf("Please enter the Author's Last and First:(please enter in this format(Johnson, Cevion\n");
		    	String name = keyboard.nextLine();
		    	
		    	System.out.println("This is what we found!!\n");
		
				for(int i = 0; i < array.length; i++)//search array for string
				{
					
					
					if(array[i].toUpperCase().startsWith(name.toUpperCase()))//this code searches for string that starts the string like if i say SA it will return SAM JONES
					   {
						   System.out.println("We found what you were looking for!!\n");
						   System.out.println(array[i]+"\n");
						   marker=true;//so it wont trigger if statement
					   }
				
				    
				}
				if(marker!=true)
				{
					System.out.println("Sorry we can't find what you're looking for\n");
		
				}
				 	
				System.out.printf("Do you want to search again?? Yes or No\n");//search again loop
			    exit = keyboard.nextLine();
			    	
				
				while(!exit.equalsIgnoreCase("yes")&&!exit.equalsIgnoreCase("no"))//yes or no only loop
				{
					System.out.printf("Invaild choice please enter: Yes or No\n");
				    exit = keyboard.nextLine();
				}
				
				if(exit.equalsIgnoreCase("yes"))
		    		end=false;
		    	if(exit.equalsIgnoreCase("no"))
		    		end=true;
		}
	
	}
	
	public void searchByBook()//My pride and joy
	{
		
		String exit=null;//to exit the inner while loop
		Boolean end=false;// exit the outer while loop
		
		while(end!=true) //search author by first name loop 
		{
			
			Boolean marker=false;//auto sets to 0 to trigger "sorry" statement line 107
			
			@SuppressWarnings("resource")
			Scanner keyboard = new Scanner(System.in);

		    System.out.printf("Please enter the Book:(include spaces please)\n");
		    	String name = keyboard.nextLine();
		    	
		    	
		    System.out.println("This is what we found!!\n");
		
				for(int i = 0; i < array.length; i++)//search array for string
				{
					
					
					if(array[i].toLowerCase().contains(name.toLowerCase()))//this code searches for string that contains any letters
					   {
						   System.out.println(array[i]+"\n");
						   marker=true;//so it wont trigger if statement
					   }
			
				}
				if(marker!=true)
				{
					System.out.println("Sorry we can't find what you're looking for\n");
		
				}
				 	
				System.out.printf("Do you want to search again?? Yes or No\n");//search again loop
			    exit = keyboard.nextLine();
			    	
				
				while(!exit.equalsIgnoreCase("yes")&&!exit.equalsIgnoreCase("no"))//yes or no only loop
				{
					System.out.printf("Invaild choice please enter: Yes or No\n");
				    exit = keyboard.nextLine();
				}
				
				if(exit.equalsIgnoreCase("yes"))
		    		end=false;
		    	if(exit.equalsIgnoreCase("no"))
		    		end=true;
		}
	
	}
	
	public void bubbleSort() {
	    int j = 0;
	    String tmp;
	    boolean sorted = false;
	    while ( !sorted ) {
	        sorted = true;
	        j++;
	        for ( int i = 0; i < array.length - j; i++ ) {
	            if (array[i].compareTo( array[i + 1] ) > 0) {
	                tmp = array[i];
	                array[i] = array[i + 1];
	                array[i + 1] = tmp;
	                sorted = false;
	            }
	        }
	    }
	}
	
	public void addBook()
	{
		String exit=null;//to exit the inner while loop
		Boolean end=false;// exit the outer while loop
		
		while(end!=true) //search author by first name loop 
		{
			
			Boolean marker=false;//auto sets to 0 to trigger "sorry" statement line 107
			
			@SuppressWarnings("resource")
			Scanner keyboard = new Scanner(System.in);

		    System.out.printf("Please enter the Author's Last and First:(please enter in this format(Johnson, Cevion)\n");
		    	String name = keyboard.nextLine();
		    	
		    	System.out.println("This is what we found!!\n");
		
				for(int i = 0; i < array.length; i++)//search array for string
				{
					
					
					if(array[i].toUpperCase().startsWith(name.toUpperCase()))//this code searches for string that starts the string like if i say SA it will return SAM JONES
					   {
						   System.out.println(array[i]+"\n");
						   marker=true;//so it wont trigger if statement
						   
						   System.out.printf("Do you want to add a book? Yes or No\n");
					    	String exit2 = keyboard.nextLine();
					    	while(!exit2.equalsIgnoreCase("yes")&&!exit2.equalsIgnoreCase("no"))//yes or no only loop
							{
								System.out.printf("Invaild choice please enter: Yes or No\n");
							    exit2 = keyboard.nextLine();
							}
					    	
					    	
					    	
					    	while(exit2.equalsIgnoreCase("yes"))//yes only loop to add books to the string
							{
								System.out.printf("Please enter the book: \n");
							    String book = keyboard.nextLine();
							    
							    array[i]=array[i].concat(", "+ book+"\n");//concat adds the new book to the end of the string and stores to array
							   
							   
							   System.out.println("The list has been updated... \n"+array[i]);
							   //still having a really hard time trying to store the string to keep adding to it
							   
							     
							    
							   System.out.printf("Do you want to add another: Yes or No\n");
							   exit2 = keyboard.nextLine();
							   
							   
							   
							    
							   while(!exit2.equalsIgnoreCase("yes")&&!exit2.equalsIgnoreCase("no"))//yes or no only loop
							   {
									System.out.printf("Invaild choice please enter: Yes or No\n");
								    exit2 = keyboard.nextLine();
								}
							    
							}
					   }
				
				    
				}
				if(marker!=true)
				{
					System.out.println("Sorry we can't find what you're looking for\n");
		
				}
				 	
				System.out.printf("Do you want to add to a different Author?? Yes or No\n");//search again loop
			    exit = keyboard.nextLine();
			    	
				
				while(!exit.equalsIgnoreCase("yes")&&!exit.equalsIgnoreCase("no"))//yes or no only loop
				{
					System.out.printf("Invaild choice please enter: Yes or No\n");
				    exit = keyboard.nextLine();
				}
				
				if(exit.equalsIgnoreCase("yes"))
		    		end=false;
		    	if(exit.equalsIgnoreCase("no"))
		    		end=true;
		    	
		    	
		    	
		}
		
	}
	
	public void menu() throws IOException //menu with all methods
	{
		
		int menu=0;
		
		System.out.println("Welcome to the Author Search Program\n");
		while(menu<9)
		{
			@SuppressWarnings("resource")
			Scanner keyboard = new Scanner(System.in);
			
			
			System.out.println("1.) Add a Author and Book\n");
			System.out.println("2.) Search all\n");
			System.out.println("3.) Search by Last, First\n");
			System.out.println("4.) Add only Book\n");
			System.out.println("5.) Show all Author and Books\n");
			System.out.println("9.) Exit");
			
			
			System.out.println("Pleae select a option: \n");
		     menu = keyboard.nextInt();
		     
		     if(menu==1)
		    	 writeToFile();
		     if(menu==2)
		    	 searchByBook();
		     if(menu==3)
		    	 searchByName();
		     if(menu==4)
		    	 searchByBook();
		     if(menu==5)
		    	 showAll();
	
		     
		     if(menu<=9) {
		    	 System.out.println("Thanks for using our Author Search!!!!\n");
		     }
		     
		     
		     
		     
		   //keyboard.close(); 
		}
	}

	public void showAll() throws IOException {//shows full array
		
		getInfo();//i had to call the method in order to use the array
		
		for(int index=0; index<array.length;index++) {
			System.out.println(index+".) "+array[index]);
		}
		
		
			
		
	}
}
