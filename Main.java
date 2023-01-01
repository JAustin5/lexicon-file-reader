// Jalena Austin

// I assert that I have written 100% of this code myself otherwise
// I will receive a 0% grade on this assignment.
//
// Status:
//
// This code is 100% tested and correct

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		String file_name = "LEXICON.txt";
		
		HashTable tableCheck = new HashTable();
		tableCheck.insertToTable(file_name);
		
		int firstTask = entryCounter(file_name);
		System.out.println("The LEXICON file has " + firstTask + " entries in it.");
		
		long secondTask = tableCheck.collisionCounter(tableCheck.getHashSize());
		System.out.println("The number of collisions in the file is: " + secondTask);
		
		System.out.println("The average number of collisions is: " + (double)secondTask/firstTask);
		
		int fourthTask = tableCheck.maxCollision(tableCheck.getHashSize());
		System.out.println("The array index with the most number of collisions is: " + fourthTask + "\n");
		
		System.out.println("The associated colliding words: ");
		System.out.println();
		LinkedList words = tableCheck.getHashSize()[(int) fourthTask];
		
		Node temp = words.getHead();
		while(temp != null) {
			LexEntry entry = (LexEntry)temp.getData();
			String word = entry.getWord();
			String tags = entry.getSpeechTag();
			System.out.println(word + " " + tags);
			temp = temp.getNext();
		}
		System.out.println();
		
		while(true) {
			System.out.println("\n" + "Enter a word to be searched for in the LEXICON file:" + "\n");
			Scanner scan = new Scanner(System.in);
			String enteredWord = scan.nextLine();
			boolean found = true;
			int arrayPos = tableCheck.hashFunction(enteredWord);
			int wordPos = 0;
			
			LinkedList line = tableCheck.getHashSize()[arrayPos];
			Node tempH = line.getHead();

			while(tempH != null || !found) {
				LexEntry entryH = (LexEntry)tempH.getData();
				String compWord = entryH.getWord();
				if(enteredWord.equals(compWord)) {
					wordPos += 0;
					found = true;
					break;
				}
				else {
					wordPos += 1;
					tempH = tempH.getNext();		
				}
			}
			
			if (found) { 
				for(int i = wordPos; i <= line.size; i++) {
					LexEntry entryH = (LexEntry)tempH.getData();
					String word_2 = entryH.getWord();
					String tags_2 = entryH.getSpeechTag();
					System.out.println(word_2 + " " + tags_2);
					tempH = tempH.getNext();
				}
			}
		}
		
	}
	
		public static int entryCounter(String file_name) throws FileNotFoundException {
			File f_n = new File(file_name);
			Scanner f_name = new Scanner(f_n);
			int counter = 0;
			while(f_name.hasNextLine()) {
				f_name.nextLine();
				counter++;
			}
			f_name.close();
			return counter;
		}
}