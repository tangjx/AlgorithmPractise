package cn.nowdo.algorithm.books.interview.chapter1;

/**
 * @Description
 * @Date 2020/9/23 18:31
 */
public class Pet {
    private String type;
    public Pet(String type) {
        this.type = type;
    }
    public String getType() {
        return this.type;
    }

    public static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }
}
