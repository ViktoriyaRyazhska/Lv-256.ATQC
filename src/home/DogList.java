package home;

import java.util.ArrayList;+
import java.util.List;+ +

public class DogList {
	
	private List<Dog> dogs = new ArrayList<>();
	public DogList(List<Dog> dogs) {
		this.dogs = dogs;
 	}

	public List<Dog> getDogs() {
 		return dogs;
 	}

	public void setDogs(List<Dog> dogs) {
 		this.dogs = dogs;
 	}

	public void findOldestDog() {
 		Dog d = new Dog();
		for (Dog dog : this.dogs) {
			if (dog.getAge() < d.getAge()) {
				d = dog;
 			}
 		}
 		System.out.println("The oldest dog is: " + d.getName());
 	}

	public void checkName() {
 		boolean b = true;
 		for (Dog dog : this.dogs) {
 			for (Dog d : this.dogs) {
 				if (dog.getName() == d.getName()) {
 					System.out.println("This name is already been used");
 					b = false;
 					break;
 				} else {
 					System.out.println("All names are unique");
 				}
 			}
 			if(b == false) {
 				break;
 			}
 		}
 
 	}
}