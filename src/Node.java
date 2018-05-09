import java.util.StringTokenizer;


public class Node {

		String author;
		String book;

		Node left;
		Node right;

		Node(String line )
		{
			// parse the string into variables
			StringTokenizer st = new StringTokenizer(line,"/");//this takes in an string and slip it at the / then takes in the rest

			this.author= st.nextElement().toString();//nextElement turns the string in an object and the toString turns it back 
			this.book= st.nextElement().toString();
		}

		Node(String author, String book) {//constructor

		        this.author = author;
		        this.book = book;
		}

		public String toString() {

			return author + " " + book;
		}

	}

