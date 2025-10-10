import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class WordSorter 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in); 
		try
		{
			in = new Scanner(new File("article.txt"));	
		}
		catch(Exception e)
		{
			System.out.println("Cannot find file... Exiting Program");
			return;
		}	

		String word = "";
		ArrayList [] leo = new ArrayList[27];
		for(int l=0;l<leo.length;l++){
			leo[l]= new ArrayList<String>();
		}

		while(in.hasNext())
		{
			word = in.next();
			word = word.replace(",", "");
			word = word.replace("(tm)", "");
			word = word.replace(")", "");
			word = word.replace("(", "");
			word = word.replace(".", "");
			word = word.replace("'s", "");
			word = word.replace(":", "");
			word = word.replace("!", "");
			word = word.replace("?", "");
			word = word.replace("'", "");
			word = word.toLowerCase();
			int meade=word.substring(0,1).compareTo("a");
			leo[meade].add(word);
			for(int i=0;i<leo[meade].size()-1;i++){
				if(word.equals(leo[meade].get(i)))
					leo[meade].remove(leo[meade].size()-1);
			}
		}
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter in some of your own words, when you want to stop enter 'x'");
		String kat="";
		while(!(kat.equals("x"))){
			kat =inp.nextLine();
			if(!(kat.equals("x")))
				leo[26].add(kat);
		}
		System.out.println("You now have the following options: \n1. Print out all words starting with a specific letter \n2. Print out all words \n3. Print out the total number of unique words \n4. Search and determine if a word is in the article \n5. Remove a word from the data structure \n6. Exit");
		int nik = inp.nextInt();
		boolean col = true;
		while(col){
			if(nik==1){
				System.out.print("enter a lowercase letter: ");
				inp.nextLine();
				int eve = inp.nextLine().compareTo("a");
				for(int k=0;k<leo[eve].size(); k++){
					System.out.print(leo[eve].get(k)+" ");
				}
			}
			else if(nik==2){

			}
			else if(nik==3){

			}
			else if(nik==4){

			}
			else if(nik==5){

			}
			else{
				col = false;
			}

		}
	}
}