package com.academy.softserve.task_02;

import org.junit.Assert;
import org.junit.Test;

public class DogTest {
    @Test
    public void dogCreateTest() {
        Dog actual = new Dog("Alabay", Breed.VOLF, 1);
        String expectName = "Alabay";
        Assert.assertEquals(expectName, actual.getName());
        Breed expectBreed = Breed.VOLF;
        Assert.assertEquals(expectBreed, actual.getBreed());
        int expectAge = 1;
        Assert.assertEquals(expectAge, actual.getAge());
    }
    @Test
    public void dogSetterTest(){
        Dog actual = new Dog("Alabay", Breed.VOLF, 1);
        actual.setName("123");
        Assert.assertEquals("123", actual.getName());
        actual.setBreed(Breed.SPANIEL);
        Assert.assertEquals(Breed.SPANIEL, actual.getBreed());
        actual.setAge(8);
        Assert.assertEquals(8, actual.getAge());
    }

}