package org.example;

public class DemoNormalTest {
    public static void main(String[] args) {    // 新建2个相同内容的Person对象，    // 再用equals比较它们是否相等
        Person p1 = new Person("eee", 100);
        Person p2 = new Person("eee", 100);
        Person p3 = new Person("aaa", 200);
        System.out.printf("p1.equals(p2) : %s; p1(%d) p2(%d)\n", p1.equals(p2), p1.hashCode(), p2.hashCode());
        System.out.printf("p1.equals(p3) : %s; p1(%d) p3(%d)\n", p1.equals(p3), p1.hashCode(), p3.hashCode());
    }

    private static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            super();
            this.name = name;
            this.age = age;
        }
        /**
         * 重写equals方法
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }      // 如果是同一个对象返回true，反之返回false
            if (this == obj) {
                return true;
            }      // 判断是否类型相同
            if (this.getClass() != obj.getClass()) {
                return false;
            }
            Person person = (Person) obj;
            return name.equals(person.name) && age == person.age;
        }
    }
}
