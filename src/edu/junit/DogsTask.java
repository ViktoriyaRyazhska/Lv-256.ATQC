package edu.junit;

import java.util.ArrayList;

public class DogsTask {

	public static void main(String[] array) {
		Dog vivcharka = new Dog("Tyzik", Breed.Vivcharka, 5);
		Dog chaoChao = new Dog("Kuzia", Breed.ChaoChao, 6);
		Dog pitbule = new Dog("Barsik", Breed.Pitbule, 4);

		Dog[] dogs = { vivcharka, chaoChao, pitbule };

		DogsTask dogsTask = new DogsTask();
		dogsTask.getOldestDog(dogs);
		dogsTask.hasDuplicate(dogs);

	}

	public Dog getOldestDog(Dog[] dogs) {
		int oldestDogAge = 0;
		Dog oldestDog = null;
		for (int i = 0; i < dogs.length; i++) {
			Dog dog = dogs[i];
			if (dog.age > oldestDogAge) {
				oldestDogAge = dog.age;
				oldestDog = dog;
			}
		}

		System.out.println("Oldest Dog is " + oldestDog.name + " " + oldestDog.breed);

		return oldestDog;
	}

	public boolean hasDuplicate(Dog[] dogs) {
		boolean hasDuplicate = false;
		ArrayList<String> dogNames = new ArrayList<>();
		ArrayList<String> duplicateNames = new ArrayList<>();
		for (int i = 0; i < dogs.length; i++) {
			Dog dog = dogs[i];
			if (dogNames.contains(dog.name)) {
				hasDuplicate = true;
				duplicateNames.add(dog.name);
			} else {
				dogNames.add(dog.name);
			}
		}

		if (hasDuplicate) {
			System.out.println("HasDuplicate " + hasDuplicate + " " + duplicateNames);
		} else {
			System.out.println("No dupilcates");
		}

		return hasDuplicate;

	}
}
