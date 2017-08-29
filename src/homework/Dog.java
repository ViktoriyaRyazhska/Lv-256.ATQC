package homework;

public class Dog {
	private String name;
	private breeds breed;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public breeds getBreed() {
		return breed;
	}

	public void setBreed(breeds breed) {
		this.breed = breed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Dog() {
		super();
	}

	public Dog(String name, breeds breed, int age) {
		super();
		this.name = name;
		this.breed = breed;
		this.age = age;
	}
	

	public static void main(String[] args) {
		Dog dog1 = new Dog("Charik", breeds.Buldog, 10);
		Dog dog2 = new Dog("Barsik", breeds.Pitbull, 8);
		Dog dog3 = new Dog("Lord", breeds.Huskey, 11);

		if (dog1.getName() == dog2.getName()) {
			System.out.println("dog1 have the same name with dog2");
		}
		if (dog1.getName() == dog3.getName()) {
			System.out.println("dog1 have the same name with dog3");
		}
		if (dog2.getName() == dog3.getName()) {
			System.out.println("dog2 have the same name with dog3");
		}
		if (dog1.getAge() > dog2.getAge() && dog1.getAge() > dog3.getAge()) {
			System.out.println("The name of the oldest dog " + dog1.name);
			System.out.println("The kind of the oldest dog " + dog1.breed);
		}
		if (dog2.getAge() > dog1.getAge() && dog2.getAge() > dog3.getAge()) {
			System.out.println("The name of the oldest dog " + dog2.name);
			System.out.println("The kind of the oldest dog " + dog2.breed);
		}
		if (dog3.getAge() > dog1.getAge() && dog3.getAge() > dog2.getAge()) {
			System.out.println("The name of the oldest dog " + dog3.name);
			System.out.println("The kind of the oldest dog " + dog3.breed);
		}
	}
}
