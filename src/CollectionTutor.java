import java.util.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 1) Implement method joinByCycle(). Check the result.
 * Implement methods getAnimalsList(), getAnimalsSet() and return its values.
 * How the results differ?
 * Implement method joinByIterator()
 */
public class CollectionTutor extends Tutor {
    String[] animals =
            {"Cow", "Goose", "Cat", "Dog", "Elephant",
                    "Rabbit", "Snake", "Chicken", "Horse", "Human", "Cow"};

    /**
     * This method should return the ArrayList with all the animals
     */
    public List<String> getAnimalsList() {
        //Arraylist
        List<String> animalsList;
        log(String.join(",", Arrays.asList(animals)));
        animalsList = Arrays.asList(animals);
        return animalsList;
    }

    /**
     * The method must return a Set with all the animals
     */
    public Set<String> getAnimalsSet() {
        //HashSet
        Set<String> animalsSet = new HashSet<>();
        for (int i = 0; i < animals.length; i++) {
            animalsSet.add(animals[i]);
        }
        return animalsSet;
    }

    /**
     * Method should take a collection of strings
     * and return one string consisting of all collection elements,
     * separated by commas, using for cycle
     */
    public String joinByCycle(Collection<?> c) {
        Object[] table =c.toArray();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<c.size()-1;i++) {
            sb.append(table[i])
                    .append(",");
        }
        sb.append(table[c.size()-1]);
        return sb.toString();
    }

    /**
     * Method should take a collection of strings
     * and return one string consisting of all collection elements,
     * separated by commas, using iterator
     */
    public String joinByIterator(Collection<?> c) {
        StringBuilder sb = new StringBuilder();
        for (Iterator<?> iterator = c.iterator(); iterator.hasNext(); ) {

            sb.append(iterator.next());
            if (iterator.hasNext()){
                        sb.append(",");
            }

        }
        return sb.toString();
    }

    @Test
    public void testCollections() {
        log("getAnimalsList: " + joinByCycle(Arrays.asList(animals)));

        log("getAnimalsList: " + joinByCycle(getAnimalsList()));
        log("getAnimalsSet: " + joinByCycle(getAnimalsSet()));

        log("getAnimalsList by iterator: " + joinByIterator(getAnimalsList()));
    }

    @Test
    public void getAnimalsListShouldReturnsListContainsAllAnimals() {
        List<String> list = getAnimalsList();
        assertTrue(list.containsAll(Arrays.asList(animals)));
    }

    @Test
    public void getAnimalsSetShouldReturnsSetContainsAllAnimals() {
        Set<String> set = getAnimalsSet();
        assertTrue(set.containsAll(Arrays.asList(animals)));
    }

    @Test
    public void joinByCycleShouldReturnsStringWithAllAnimalsJoined() {
        String result = joinByCycle(make123Collection());
        assertEquals("1,2,3", result);
    }

    @Test
    public void joinByIteratorShouldReturnsStringWithAllAnimalsJoined() {
        String result = joinByIterator(make123Collection());
        assertEquals("1,2,3", result);
    }

    private Collection<String> make123Collection() {
        Collection<String> collection = new LinkedHashSet<String>();
        collection.add("1");
        collection.add("2");
        collection.add("3");
        return collection;
    }
}

