package work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
	public static void main(String[] args) {
		
		/**
		 * get user input*/
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> candidates = new ArrayList<String>();
		
		System.out.println("Zadajte vstupne slovo: ");
		String input = scanner.next();
		
		System.out.println("Zadajte zoznam kandidatov oddelenych medzerou");
		scanner.nextLine();
		String can_input = scanner.nextLine();
		String[] can_inputs = can_input.split(" ");
		
		
		for(String s: can_inputs){
			candidates.add(s);
		}
		scanner.close();
		
		/**
		 * compute and print result*/
		ArrayList<String> result = findAnarams(input, candidates);
		System.out.println("Input: " +input);
		printResult(result);
		
	}
	
	/**
	 * find all words from list of candidates that are anagrams for input string*/
	public static ArrayList<String> findAnarams(String input, ArrayList<String> candidates){
		ArrayList<String> result = new ArrayList<String>();
		/**
		 * convert input string into array of chars and sort it*/
		char[] input_ch = input.toCharArray();
		Arrays.sort(input_ch);
		String sorted_inpput = new String(input_ch);
		
		/**
		 * iterate through all candidates and find anagrams*/
		for(String s: candidates){
			/**
			 * string must have same length as input to be possible anagram*/
			if(input.length() == s.length()){
				/**
				 * convert candidate string into array of chars and sort it*/
				char[] candidate = s.toCharArray();
				Arrays.sort(candidate);
				String sorted_s = new String(candidate);
				/**
				 * compare if candidate is equal to input*/
				if(sorted_s.equals(sorted_inpput)){
					result.add(s);
				}
			}
		}
		
		return result;
	}
	
	/**
	 * print array list of strings*/
	public static void printResult(ArrayList<String> result){
		System.out.println("Number of anagrams from candidates: " +result.size());
		for(String s: result){
			System.out.println(s);
		}
	}
}
