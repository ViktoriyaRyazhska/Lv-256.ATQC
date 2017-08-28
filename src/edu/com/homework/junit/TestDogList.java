package edu.com.homework.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestDogList {
	private DogList dogList = new DogList();

	@Test
	public void testGetTheOldest() {
		List<Dog> dogs = new ArrayList<>();
		dogs.add(new Dog("Tyzik", 25, Breed.Bulldog));
		dogs.add(new Dog("Rex", 6, Breed.GermanShepherd));
		dogs.add(new Dog("Drax", 10, Breed.Mastiff));
		dogs.add(new Dog("Tyzik", 15, Breed.Bulldog));
		dogList.setDogs(dogs);
		String actual = dogList.getTheOldest();
		String expected = dogs.get(0).toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testCheckTheName() {
		List<Dog> dogs = new ArrayList<>();
		dogs.add(new Dog("Tyzik", 25, Breed.Bulldog));
		dogs.add(new Dog("Rex", 6, Breed.GermanShepherd));
		dogs.add(new Dog("Drax", 10, Breed.Mastiff));
		dogs.add(new Dog("Tyzik", 15, Breed.Bulldog));
		dogList.setDogs(dogs);
		boolean actual = dogList.checkTheName();
		boolean expected = false;
		assertTrue(expected == actual);
		dogs.remove(3);
		dogList.setDogs(dogs);
		actual = dogList.checkTheName();
		expected = true;
		assertTrue(expected == actual);

	}

}
