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

public class HashTable {
	private LinkedList hashSize[];
	
	public LinkedList[] getHashSize() {
		return hashSize;
	}

	public void setHashSize(LinkedList[] hashSize) {
		this.hashSize = hashSize;
	}
	
	public HashTable() {
		LinkedList hash[] = new LinkedList[24593];
		for(int i = 0; i < 24593; i++) {
			hash[i] = new LinkedList();
		}
	}
	

	public void insertToTable(String key) throws FileNotFoundException {
		this.hashSize = new LinkedList[24593];
		File f_Name = new File(key);
		Scanner file_name = new Scanner(f_Name);
		
		String word = "";
		while(file_name.hasNext()) {
			String tags = "";
			String[] line = file_name.nextLine().split(" ");
			word = line[0];
			for(int i = 1; i < line.length; i++) {
					tags += line[i] + " ";
				}

			if(this.hashSize[hashFunction(word)] == null) {
				LinkedList newLink = new LinkedList();
				LexEntry entryPoint = new LexEntry(word, tags);
				newLink.insertFront(entryPoint);
				this.hashSize[hashFunction(word)] = newLink;
			}
			else {
				LinkedList newLink = this.hashSize[hashFunction(word)];
				LexEntry entryPoint = new LexEntry(word, tags);
				newLink.insertBack(entryPoint);
			}
		}
	}
		
		public int hashFunction(String key) {
			int pos = 1;
			int asciiVals = 1;
			for (int i = 0; i < key.length(); i++) {
				asciiVals += key.charAt(i) * pos;
				pos += 1;
			}
			
			return asciiVals % 24593;
		}
		
		public long collisionCounter(LinkedList[] array){
			long counter = 0;
			for (int i = 0; i < array.length; i++){
				if(array[i] == null || array[i].size == 0) {
					counter += 0;
				}
				else {
					counter += array[i].size - 1;
				}		
			}
			return counter;
		}
		
		public int maxCollision(LinkedList[] array) {
			int maxCol = 0;
			int pos = 0;
			for(int i = 0; i < array.length; i++) {
				if(array[i] != null) {
					if (maxCol < array[i].size - 1) {
					maxCol = array[i].size - 1;
					pos = i;
				}
				}
			}
			return pos;
		}

}
