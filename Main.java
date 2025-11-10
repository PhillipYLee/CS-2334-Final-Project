import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	
    	// CHANGE TO READ DIFFERENT FILES HERE
        String filename = "dataset_100k.txt";
        
        List<String> dataLines = TestUtils.loadData(filename);
        ArrayListCustom<String> customArray = new ArrayListCustom<>();
        LinkedListCustom<String> customLinked = new LinkedListCustom<>();
        ArrayList<String> apiArray = new ArrayList<>();
        LinkedList<String> apiLinked = new LinkedList<>();

        for (String line : dataLines) {
            customArray.add(line);
            customLinked.add(line);
            apiArray.add(line);
            apiLinked.add(line);
        }

        System.out.println("\n====== Experiment Tests ======\n");

        // 1. Sequential Access Test
        TestUtils.testSequentialAccess("Custom ArrayList", customArray.size(), i -> customArray.get(i));
        TestUtils.testSequentialAccess("Custom LinkedList", customLinked.size(), i -> customLinked.get(i));
        TestUtils.testSequentialAccess("API ArrayList", apiArray.size(), i -> apiArray.get(i));
        TestUtils.testSequentialAccess("API LinkedList", apiLinked.size(), i -> apiLinked.get(i));

        // 2. Random Access Test
        TestUtils.testRandomAccess("Custom ArrayList", customArray, customArray.size());
        TestUtils.testRandomAccess("Custom LinkedList", customLinked, customLinked.size());
        TestUtils.testRandomAccess("API ArrayList", apiArray::get, apiArray.size());
        TestUtils.testRandomAccess("API LinkedList", apiLinked::get, apiLinked.size());

        // 3. Insertions Test
        TestUtils.testInsertions("Custom ArrayList", customArray);
        TestUtils.testInsertions("Custom LinkedList", customLinked);
        TestUtils.testInsertions("API ArrayList", apiArray);
        TestUtils.testInsertions("API LinkedList", apiLinked);

        // 4. Deletions Test
        TestUtils.testDeletions("Custom ArrayList", customArray);
        TestUtils.testDeletions("Custom LinkedList", customLinked);
        TestUtils.testDeletions("API ArrayList", apiArray);
        TestUtils.testDeletions("API LinkedList", apiLinked);
    }
}
