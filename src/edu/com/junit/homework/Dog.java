package edu.com.junit.homework;

/**
 * 
 * @version 1.0
 * @author Bohdan Zhyvko
 */
class Dog {
	private String name;
	private Breed breed;
	int age;

	public Dog() {
	}

	public Dog(String name, Breed breed, int age) {
		this.name = name;
		this.breed = breed;
		this.age = age;
	}
	
	public enum Breed {
		Cocker_Spaniel,
		Chow_Chow,
		Boxer;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Breed getBreed() {
		return breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", breed=" + breed + ", age=" + age + "]";
	}
}
