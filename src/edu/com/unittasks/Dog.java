package edu.com.unittasks;

public class Dog {

	private String name;
	private DogBreed breed;
	private int age;

	public Dog() {
	}

	public Dog(String name, DogBreed breed, int age) {
		super();
		this.name = name;
		this.breed = breed;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DogBreed getBreed() {
		return breed;
	}

	public void setBreed(DogBreed breed) {
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

	public static void main(String[] args) {
		Dog dog1 = new Dog("barsik0", DogBreed.DACHSHUND, 2);
		Dog dog2 = new Dog("barsik", DogBreed.BARBET, 6);
		Dog dog3 = new Dog("alfa", DogBreed.LABRADOR, 3);

		boolean hasSameName = Dog.check(dog1, dog2) || Dog.check(dog1, dog3) || Dog.check(dog2, dog3);
		System.out.println(hasSameName ? "There are dogs with the same name." : "There are no dogs with the same name.");
	}

	public static boolean check(Dog dog1, Dog dog2) {
		return dog1.getName().equals(dog2.getName());
	}

	public boolean check(Dog dog1) {
		return dog1.getName().equals(getName());
	}
}
