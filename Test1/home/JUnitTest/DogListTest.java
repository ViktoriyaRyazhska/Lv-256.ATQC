package home.JUnitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.BeforeMethod;

import home.Breed;
import home.Dog;
import home.DogList;

public class DogListTest {
	@Before


	@Test
	public void testFindOldestDog() {
		List<Dog> dogs = new ArrayList<>();
		DogList dogList = new DogList(dogs);
		dogs.add(new Dog("ELly", 25, Breed.Corgi));
		dogs.add(new Dog("Muhtar", 6, Breed.Beagle));
		dogs.add(new Dog("Jo", -10, Breed.Corgi));
		dogs.add(new Dog("Gracy", 15, Breed.Collie));
		dogs.add(new Dog("Gracy", 8, Breed.Collie));
		dogList.setDogs(dogs);
		String actual = dogList.findOldestDog();
		String expected = dogs.get(0).toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCheckName() {
		List<Dog> dogs = new ArrayList<>();
		DogList dogList = new DogList(dogs);
		dogs.add(new Dog("ELly", 25, Breed.Corgi));
		dogs.add(new Dog("Muhtar", 6, Breed.Beagle));
		dogs.add(new Dog("Jo", -10, Breed.Corgi));
		dogs.add(new Dog("Gracy", 15, Breed.Collie));
		dogs.add(new Dog("Gracy", 8, Breed.Collie));
		dogList.setDogs(dogs);
		boolean actual = dogList.checkName();
		boolean expected = false;
		assertEquals(expected, actual);
	}
}
