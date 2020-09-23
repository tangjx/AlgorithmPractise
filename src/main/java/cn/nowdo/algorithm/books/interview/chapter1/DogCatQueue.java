package cn.nowdo.algorithm.books.interview.chapter1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * @Date 2020/9/23 18:30
 */
public class DogCatQueue {
    private Queue<PetNode> dogQueue = new LinkedList<>();
    private Queue<PetNode> catQueue = new LinkedList<>();
    private int count = 1;

    public void add(Pet pet) {
        if(pet.getType().equals("dog")) {
            PetNode petNode = new PetNode(pet, count ++);
            dogQueue.add(petNode);
        } else if(pet.getType().equals("cat")) {
            PetNode petNode = new PetNode(pet, count ++);
            catQueue.add(petNode);
        } else {
            throw new RuntimeException("err, not dog or cat");
        }
    }

    public Pet pollAll() {
        if(!dogQueue.isEmpty() && !catQueue.isEmpty()) {
            if(dogQueue.peek().getCount() < catQueue.peek().getCount()) {
                return dogQueue.poll().getPet();
            } else {
                return catQueue.poll().getPet();
            }
        } else if(!dogQueue.isEmpty()) {
            return dogQueue.poll().getPet();
        } else if (!catQueue.isEmpty()) {
            return catQueue.poll().getPet();
        } else {
            throw new RuntimeException("err, queue is empty");
        }
    };

    public Pet.Dog pollDog() {
        if(!isDogEmpty()) {
            return (Pet.Dog) dogQueue.poll().getPet();
        } else {
            throw new RuntimeException("err, dog queue is empty");
        }
    }

    public Pet.Cat pollCat() {
        if(!isCatEmpty()) {
            return (Pet.Cat) catQueue.poll().getPet();
        } else {
            throw new RuntimeException("err, cat queue is empty");
        }
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
            System.out.println("poll all :" + dogCatQueue.pollAll().getType());

        }
    }
}
