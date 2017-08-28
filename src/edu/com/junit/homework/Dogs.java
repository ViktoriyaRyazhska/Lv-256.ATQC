package edu.com.junit.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import edu.com.junit.homework.Dog.Breed;

/**
 * 
 * @version 1.0
 * @author Bohdan Zhyvko
 */
public class Dogs {
	/**
	 * Check if there is no two dogs with the same name
	 * 
	 * @param dogList ArrayList with type Dog
	 * @return true/false
	 */
	public boolean isDuplicate(ArrayList<Dog> dogList) {
		//remove all duplicate name in set from Dog array
		Set<String> set = new HashSet<String>();

		for(int i = 0; i < dogList.size(); i++){
		  set.add(dogList.get(i).getName());
		}
		//Check if there is no two dogs with the same name. 
		if (set.size() == dogList.size()) {
			return false;
		}
		return true;
	}
	/**
	 * Get the oldest dog. 
	 * 
	 * @param dogList ArrayList with type Dog
	 * @return dog the oldest Dog 
	 */
	public Dog getOldestDog(ArrayList<Dog> dogList) {
		Dog dog = dogList.get(0);
		for (int i = 1; i < dogList.size(); i++) {
			if (dogList.get(i).getAge() > dog.getAge()) {
				dog = dogList.get(i);
			}
		}	
		return dog;
	}
	
	public static void main(String[] args) {
		ArrayList<Dog> dogList = new ArrayList<Dog>();
		dogList.add( new Dog("Sharik", Breed.Chow_Chow, 5));
		dogList.add( new Dog("Nika", Breed.Cocker_Spaniel, 3));
		dogList.add( new Dog("Chakki", Breed.Boxer, 7));
		dogList.add( new Dog("Sharik", Breed.Boxer, 1));
		
		Dogs dogs = new Dogs();
		Dog oldDog = dogs.getOldestDog(dogList);
		boolean bool = dogs.isDuplicate(dogList);
		
		System.out.println("The oldest dog is: " + oldDog.toString());
		System.out.println("Is duplicate name: " + bool);
	}

}
