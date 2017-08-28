package edu.com.homework.junit;

public class Dog {
	private String name;
	private Integer age;
	private Breed breed;

	

	public Dog() {
		
	}
	

	public Dog(String name, Integer age, Breed breed) {
		super();
		this.name = name;
		this.age = age;
		this.breed = breed;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Breed getBreed() {
		return breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name +  ", breed=" + breed + "]";
	}
	

}
