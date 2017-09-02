package com.academy.softserve.task_02;

import org.junit.Assert;
import org.junit.Test;

public class DogCollectionTest {
    DogCollection dogCollection= new DogCollection();


    @Test
    public void addDog() throws Exception {
        dogCollection.addDog(new Dog("Link", Breed.SPANIEL, 10));
        Assert.assertEquals("Link", dogCollection.getDogList().get(0).getName());
        Assert.assertEquals(Breed.SPANIEL, dogCollection.getDogList().get(0).getBreed());
        Assert.assertEquals(10, dogCollection.getDogList().get(0).getAge());
    }

//    @Test
//    public void oldestDog() throws Exception {
//        dogCollection.addDog(new Dog("Link1", Breed.SPANIEL, 1));
//        dogCollection.addDog(new Dog("Link2", Breed.SPANIEL, 2));
//        dogCollection.addDog(new Dog("Link3", Breed.SPANIEL, 3));
//        dogCollection.oldestDog();
//        Assert.assertEquals(new Dog("Link3", Breed.SPANIEL, 3) ,dogCollection.getDogList().get(2));
//    }

}