import java.io.IOException;
import java.util.Scanner;

public class Tree {


		Node root;
		/***
	* Add Node to the tree
	*@param author name
	*@param books
		 */
		public void addNode(String author, String book) {

			// Create a new Node and initialize it
			Node newNode = new Node(author, book);

			// If  no root this will become root
			if (root == null) {

				root = newNode;

			} else {

				// Set root as the Node and start  traversing the tree
				Node focusNode = root;

				// Future parent for new Node
				Node parent;

				while (true) {

					// root is the top parent 
					parent = focusNode;

					// Check if the new node should go on the left of parent
					if (author.compareToIgnoreCase(focusNode.author) < 0) {
						// focus to the left child
						focusNode = focusNode.left;

						// If the left child has no children
						if (focusNode == null) {

							// then place the new node on the left of it
							parent.left = newNode;
							return; 
						}

					} else { 
						// If we get here put the node on the right
						focusNode = focusNode.right;

						// If the right child has no children
						if (focusNode == null) {

							// then place the new node on the right of it
							parent.right = newNode;
							return; 
						}
					}
				}
			}
		}

		/***
	* Order the tree ascending by author
	*@param node
	*@return
		 */
		public Node orderTreeByAuthor(Node author)
		{
			if(author != null)
			{
				orderTreeByAuthor(author.left);
				System.out.println(author);
				orderTreeByAuthor(author.right);
			}

			return author;
		}

		/***
	* Find author by providing full name
	*@param keyword
	*@return Node
		 */

		public Node findFullName(String key) {

			// Start at the top of the tree
			Node focusNode = root;
			
			    	// While node not found keep looking
			    	while (focusNode.author.compareToIgnoreCase(key) != 0) {

			    		// If we should search to the left
			    		if (key.compareToIgnoreCase(focusNode.author) < 0) {
			    			// Shift the focus Node to the left child
			    			focusNode = focusNode.left;

			    		} else {

			    			// Shift the focus Node to the right child
			    			focusNode = focusNode.right;
			    		}

			    		// The node wasn't found
			    		if (focusNode == null)
			    			return null;
			    		}
			    		
			return focusNode;
		}
		
		/***
		* Get how many nodes in the tree
		*@param node
		*@return number of nodes
			 */
		
		public int getNodesCount(Node node)
		{
			if(node == null) {

				return 0;

			} else {

				int count = 1;

				count  +=  getNodesCount(node.left);
				count  +=  getNodesCount(node.right); 

				return count;
			}
			
		
		}
		
		public void searchByName() throws IOException//My pride and joy
		{
			
			String exit=null;//to exit the inner while loop
			Boolean end=false;// exit the outer while loop
			
			while(end!=true) //search author by first name loop 
			{
				
				
				@SuppressWarnings("resource")
				Scanner keyboard = new Scanner(System.in);

			    System.out.printf("Please enter the Author's Last and First:(please enter in this format(Johnson, Cevion)\n");
			    	String name = keyboard.nextLine();
			    	
			    	System.out.println("\nThis is what we found!!\n");
			    	
			    	System.out.println(findFullName(name)+"\n");
					
					 	
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
		
}