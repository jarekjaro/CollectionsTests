import java.util.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *	1) Implement method Set<Animal> getAnimalsOrderedByNameSet()
 * 		and method Set<Animal> getAnimalsOrderedByNameSetDesc()
 */
public class ComparableTutor extends Tutor {
    String [] animals =
            {"Cow", "Goose", "Cat", "Dog", "Elephant",
                    "Rabbit", "Snake", "Chicken", "Horse", "Human"};

    class Animal implements Comparable{
        String name;
        public Animal(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return name;
        }

        @Override
        public int compareTo(Object o) {
            return name.compareTo(o.toString());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Animal animal = (Animal) o;

            return name.equals(animal.name);

        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }
    }

    /**
     * Method should return a Set of Animal instances, alphabetically sorted
     * Use TreeSet for that and implement Comparable interface in Animal class.
     */

    public Set<Animal> getAnimalsOrderedByNameSet() {
        Animal[] animalsTable = new Animal[animals.length];
        for (int i=0;i<animals.length;i++) {
            animalsTable[i] = new Animal(animals[i]);
        }
        TreeSet<Animal> animalsSet = new TreeSet<>();
        for (Animal animal : animalsTable) {
            animalsSet.add(animal);
        }
        return animalsSet;
    }

    /**
     * Method should return a Set of Animal instances,
     * ordered by the name in reverse order.
     * Use TreeSet for that and pass a Comparator implementation as a parameter.
     *
     */
    public Set<Animal> getAnimalsOrderedByNameSetDesc() {
        Animal[] animalsTable = new Animal[animals.length];
        for (int i=0;i<animals.length;i++) {
            animalsTable[i] = new Animal(animals[i]);
        }
        TreeSet<Animal> animalsSet = new TreeSet<>(new Comparator<Animal>() {
            public int compare(Animal o1, Animal o2) {
                return o1.compareTo(o2);
            }
        }.reversed());
            for(Animal animal:animalsTable)
                animalsSet.add(animal);
            return animalsSet;
        }

    public String joinByCycle(Collection<?> c) {
        if (c==null) return "";
        StringBuilder builder = new StringBuilder();
        for (Object s: c) {
            builder.append(s);
            if (builder.length()>0) builder.append(", ");
        }
        return builder.toString();
    }

    @Test
    public void testCollections() {
        log("getAnimalsList: "+joinByCycle(Arrays.asList(animals)));
        log("getAnimalsOrderedByNameSet: "+joinByCycle(getAnimalsOrderedByNameSet()));
        log("getAnimalsOrderedByNameSetDesc: "+joinByCycle(getAnimalsOrderedByNameSetDesc()));
    }

    @Test
    public void getAnimalsOrderedByNameSet_default_returnsSortedSet() {
        Set<Animal> set = getAnimalsOrderedByNameSet();
        String join = joinByCycle(set);
        assertEquals("Cat, Chicken, Cow, Dog, Elephant, Goose, Horse, Human, Rabbit, Snake, ", join);
    }

    @Test
    public void getAnimalsOrderedByNameSetDesc_default_returnsSortedSet() {
        Set<Animal> set = getAnimalsOrderedByNameSetDesc();
        String join = joinByCycle(set);
        assertEquals("Snake, Rabbit, Human, Horse, Goose, Elephant, Dog, Cow, Chicken, Cat, ", join);
    }
}
