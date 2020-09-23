package cn.nowdo.algorithm.books.interview.chapter1;

/**
 * @Description
 * @Date 2020/9/23 18:31
 */
public class PetNode {
    private Pet pet;
    private int count;

    public PetNode(Pet pet, int count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public int getCount() {
        return count;
    }

    public String getNodeType() {
        return this.pet.getType();
    }
}
