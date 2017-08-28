package edu.junit.tests.copy;

import org.junit.Assert;
import org.junit.Test;

import edu.junit.Breed;
import edu.junit.Dog;
import edu.junit.DogsTask;

public class DogsTaskTest {
	DogsTask dogsTask = new DogsTask();

	@Test
	public void testOldestDogPositiv() {
		Dog buldog = new Dog("Tyzik", Breed.Buldog, 10);
		Dog labrador = new Dog("Kyzia", Breed.Labrador, 12);
		Dog layka = new Dog("Dzhesika", Breed.Layka, 2);
		Dog[] dogs = { buldog, labrador, layka };
		Dog OldestDog = dogsTask.getOldestDog(dogs);
		Assert.assertEquals(12, OldestDog.getAge());

	}

	@Test
	public void testOldestDogNegative() {
		Dog buldog = new Dog("Tyzik", Breed.Buldog, 10);
		Dog labrador = new Dog("Kyzia", Breed.Labrador, 12);
		Dog layka = new Dog("Dzhesika", Breed.Layka, 2);
		Dog[] dogs = { buldog, labrador, layka };
		Dog OldestDog = dogsTask.getOldestDog(dogs);
		Assert.assertNotEquals(10, OldestDog.getAge());
	}

	@Test
	public void testhasDuplicate1() {
		Dog buldog = new Dog("Tyzik", Breed.Buldog, 10);
		Dog labrador = new Dog("Tyzik", Breed.Labrador, 12);
		Dog layka = new Dog("Dzhesika", Breed.Layka, 2);
		Dog[] dogs = { buldog, labrador, layka };
		boolean actual = dogsTask.hasDuplicate(dogs);
		Assert.assertEquals(actual, true);

	}

	@Test
	public void testhasDuplicate2() {
		Dog buldog = new Dog("Tyzik", Breed.Buldog, 10);
		Dog labrador = new Dog("Tyzik", Breed.Labrador, 12);
		Dog layka = new Dog("Dzhesika", Breed.Layka, 2);
		Dog[] dogs = { buldog, labrador, layka };
		boolean actual = dogsTask.hasDuplicate(dogs);
		Assert.assertNotEquals(actual, false);

	}

	@Test
	public void testNoDuplicate() {
		Dog buldog = new Dog("Tyzik", Breed.Buldog, 10);
		Dog labrador = new Dog("Kyzia", Breed.Labrador, 12);
		Dog layka = new Dog("Dzhesika", Breed.Layka, 2);
		Dog[] dogs = { buldog, labrador, layka };
		boolean actual = dogsTask.hasDuplicate(dogs);
		Assert.assertEquals(actual, false);

	}

}
