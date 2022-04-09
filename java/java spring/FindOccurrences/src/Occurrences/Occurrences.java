package Occurrences;

import java.util.HashMap;

public class Occurrences {

	public static void main(String[] args) {
		String parag="Hello world and Hello Hello";
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		String[] words = parag.split(" ");
		for (String word:words) {
			if(map.get(word)== null) {
				map.put(word,1);
			}
			else {
				map.put(word, map.get(word)+1);
			}
		}
		System.out.println(map);
	}
}
