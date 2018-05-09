import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;





public class Demo {

	public static void main(String[] args) throws IOException {
		getInfo();
	    menu();
	    
	    


	}
	
	static String file="src\\revised data.txt";//author's stored txt
	Tree authorTree;
	
	public static Tree getInfo() {

		BufferedReader br;
		Tree authorTree = new Tree();//the binary tree 

		try {

			br = new BufferedReader(new FileReader(file));//locate of file
			String line = "";

			 while ((line = br.readLine()) != null) { 

			    	/*Create author node from the line */
		        	Node author = new Node(line); 

		        	authorTree.addNode(author.author, author.book);//adds the author and book to the tree
		        }

		     br.close();

		} 
		catch (FileNotFoundException e) {

			System.out.println(e.getLocalizedMessage());//error message
		} 

		catch (IOException e) {

			System.out.println(e.getLocalizedMessage());//error message
		}
		
		return authorTree;
	}
	
	
	public static void writeToFile() throws IOException {
		String author;
		String books;
		
		try(FileWriter fr = new FileWriter(file, true);
			    BufferedWriter fr1 = new BufferedWriter(fr);
			    PrintWriter out = new PrintWriter(fr1))//how you print out to the .txt file
			{
			 @SuppressWarnings("resource")
			Scanner keyboard = new Scanner(System.in);

		      System.out.println("Please enter Author's Last and First name in this format(Johns, jimmmy): \n");
		      author = keyboard.nextLine();//stores author
		      
		      out.print("\n"+author+ "/ - ");//this is how you output into the .txt file and seps the book node from the author also added the \n so it wouldnt add an author to the books of the last file
		      
		      System.out.println("Please enter books: \n");
		      books = keyboard.nextLine();
		      

			  out.print(books);//this where the book goes
    
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}
		
		getInfo();// i added the getinfo() so it can continue to add to the same tree
		
		
		
	}
	
	public static void menu() throws IOException //menu with all methods
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
			System.out.println("4.) Get Total Author count\n");
			System.out.println("5.) Show all Author and Books\n");
			System.out.println("9.) Exit");
			
			
			System.out.println("Pleae select a option: \n");
		     menu = keyboard.nextInt();
		     
		     if(menu==1)
		    	 writeToFile();
		    // if(menu==2)
		    	//searchByBook();
		     if(menu==3)
		    	getInfo().searchByName();
		     if(menu==4)
		    	 System.out.println("Number of Authors is : " + getInfo().getNodesCount(getInfo().root));
		     if(menu==5)
		    	 getInfo().orderTreeByAuthor(getInfo().root);
	
		     
		     if(menu<=9) {
		    	 System.out.println("Thanks for using our Author Search!!!!\n");
		     }
		     
		     
		     
		     
		   //keyboard.close(); 
		}
	}
}