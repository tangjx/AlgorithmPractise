package cn.nowdo.algorithm.books.interview.chapter1;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Description
 * @Date 2020/9/23 18:30
 */
public class DogCatQueue {
    private Queue<PetNode> dogQueue = new LinkdedList<>();
    private Queue<PetNode> catQueue;
    private int count = 1;

    public void add(Pet pet) {
        if(pet.getType().equals("dog")) {
            PetNode petNode = new PetNode(pet, count ++);
            dogQueue.add(petNode);
        } else if(pet.getType().equals("cat")) {
            PetNode petNode = new PetNode(pet, count ++);
            dogQueue.add(petNode);
        } else {
            throw new RuntimeException("err, not dog or cat");
        }
    }

    public Pet pollAll() {
        if(dogQueue.peek().getCount() < catQueue.peek().getCount()) {
            return dogQueue.poll().getPet();
        } else {
            return catQueue.poll().getPet();
        }
    };

    public Pet.Dog pollDog() {
        return (Pet.Dog) dogQueue.poll().getPet();
    }

    public Pet.Cat pollCat() {
        return (Pet.Cat) catQueue.poll().getPet();
    }

    public boolean isEmpty() {
        return dogQueue.isEmpty() && catQueue.isEmpty();
    }

    public boolean isDogEmpty() {
        return dogQueue.isEmpty();
    }

    public boolean isCatEmpty() {
        return catQueue.isEmpty();
    }

    public static void main(String[] args) {
        DogCatQueue dogCatQueue = new DogCatQueue();
        for(int i = 0; i < 5; i ++) {
            Pet.Dog dog = new Pet.Dog();
            dogCatQueue.add(dog);
            Pet.Cat cat = new Pet.Cat();
            dogCatQueue.add(cat);
        }
        while (!dogCatQueue.isEmpty()) {
            System.out.print("poll all :" + dogCatQueue.pollAll().getType());
        }
    }
}
