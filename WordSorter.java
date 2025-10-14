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
		}//end try?
		catch(Exception e)
		{
			System.out.println("Cannot find file... Exiting Program");
			return;
		}//end catch?

		String word = "";
		ArrayList [] leo = new ArrayList[27];
		for(int l=0;l<leo.length;l++){
			leo[l]= new ArrayList<String>();
		}//end loop to initialize arraylists in array

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
			}//end loop that checks if words are unique
		}//end loop to fix words?
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter in some of your own words, when you want to stop enter 'x'");
		String kat="";
		while(!(kat.equals("x"))){
			kat =inp.nextLine();
			if(!(kat.equals("x")))
				leo[26].add(kat);
			}//end loop to add user input				
		
		boolean col = true;
		int nik = 0;
		while(nik==0){
			System.out.println("\n\nYou now have the following options: \n1. Print out all words starting with a specific letter \n2. Print out all words \n3. Print out the total number of unique words \n4. Search and determine if a word is in the article \n5. Remove a word from the data structure \n6. Exit\n");
			nik = inp.nextInt();
			if(nik==1){
				System.out.println("\nenter a lowercase letter: ");
				inp.nextLine();
				String eve = inp.nextLine();
				if(leo[eve.compareTo("a")].size()>0){
				for(int k=0;k<leo[eve.compareTo("a")].size(); k++){
					System.out.print(leo[eve.compareTo("a")].get(k)+" ");
				}//end loop to print words that start with letter
				for(int k=0;k<leo[26].size(); k++){
					String e = ""+leo[26].get(k);
					if(e.substring(0,1).equals(eve))
						System.out.print(leo[26].get(k)+" ");
				}//end loop to print user words that start with letter
			}else
				System.out.println("No words start with this letter");

				nik=0;
			}//end if to implememt task 1
			else if(nik==2){
				for(int e=0;e<leo.length-1;e++){
					for(int k=0;k<leo[e].size(); k++){
						System.out.print(leo[e].get(k)+" ");
				}//loops through each arraylist to print words from article
				}//loops through array
				for(int k=0;k<leo[26].size(); k++){
					System.out.print(leo[26].get(k) + " ");
				}//prints user input words
				nik=0;
				
			}//end if to implememt task 2
			else if(nik==3){
				int uni=0;
				for(int jas=0;jas<leo.length-1;jas++){
					uni+=leo[jas].size();
				}//loops through array and adds arraylist lengths
				if(uni>0)
					System.out.println("\nThere are " + uni+" unique words in the article");
				else
					System.out.println("\nEmpty List");
				
				
				nik=0;
			}//end if to implememt task 3
			else if(nik==4){
				System.out.println("Enter a single word");
				inp.nextLine();
				String mat=inp.nextLine();
				boolean nic = true;

				for(int e=0;e<leo[mat.substring(0,1).compareTo("a")].size();e++){
					if(leo[mat.substring(0,1).compareTo("a")].get(e).equals(mat))
						nic=false;
					
				}//loops through arraylist that corresponds with first letter of word to check if they match
				if(nic)
					System.out.println("Word NOT found in the article");
				
				else
					System.out.println("Word found in the article");
				
				nik=0;
			}//end if to implememt task 4
			else if(nik==5){
				System.out.println("Enter a single word");
				inp.nextLine();
				String mat=inp.nextLine();
				boolean nic = true;

				for(int e=0;e<leo[mat.substring(0,1).compareTo("a")].size();e++){
					if(leo[mat.substring(0,1).compareTo("a")].get(e).equals(mat)){
						leo[mat.substring(0,1).compareTo("a")].remove(mat);
						nic=false;
					}//will remove word and determine what will be outputted to user
				}//loops through arraylist with corresponding first letter
				if(nic)
					System.out.println("Word NOT found in the article");
				
				else
					System.out.println("Word successfully removed from the list");
				
				nik=0;
			}//end if to implememt task 5
		}//loop that asks user what they want inputted
		System.out.println("Code exited");
	}//end main
}//end class