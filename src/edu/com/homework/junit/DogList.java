package edu.com.homework.junit;

import java.util.ArrayList;
import java.util.List;

public class DogList {
	private List<Dog> dogs = new ArrayList<>();

	public DogList(List<Dog> dogs) {
		this.dogs = dogs;
	}

	public DogList() {
	}

	public List<Dog> getDogs() {
		return dogs;
	}

	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}

	public void getTheOldest() {
		Dog dog = new Dog();

		for (Dog d : this.dogs) {
			if (d.getAge() > dog.getAge()) {
				dog = d;
			}
		}
		if (dog.getName() != null) {
			System.out.println("The oldest dog is: " + dog.getName() + ". It's breed is: " + dog.getBreed());
		} else {
			System.out.println("No dogs was found");
		}

	}

	public boolean checkTheName() {
		List<String> names = new ArrayList();
		boolean b = true;
		for (Dog d : this.dogs) {
			if (!names.contains(d.getName())) {
				names.add(d.getName());
			} else if (names.contains(d.getName())) {
				b = false;
				break;
			}
		}
		return b;
	}
}
