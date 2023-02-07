/**
 * Name: Alexis Gordon-Martin
 */

package org.howard.edu.lsp.assignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assignment2 {

	public static void main(String[] args) {
		try {
			File file = new File("file.txt");
			Scanner fileReader = new Scanner(file);
			HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
//			String[] data = null;
			ArrayList<String> data = new ArrayList<String>();
			while (fileReader.hasNextLine()) {
				String[] words = fileReader.nextLine().split(" ");
				ArrayList<String> wordsList = new ArrayList<String>(Arrays.asList(words));
				data.addAll(wordsList);
			}

			for (String word : data) {
				if (word.length() > 3 && word instanceof String) {
					if (wordCount.containsKey(word.toLowerCase())) {
						wordCount.put(word, wordCount.get(word) + 1);
					}
					else {
						wordCount.put(word.toLowerCase(), 1);
					}
				}
			}
			for (String i : wordCount.keySet()) {
				System.out.println(i + " " + wordCount.get(i));
			}
			fileReader.close();
		} catch(FileNotFoundException e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}
	}
}
