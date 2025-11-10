import java.util.*;
import java.io.*;

public class TestUtils {

    // Load file 
	public static List<String> loadData(String filename) throws IOException {
        List<String> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) data.add(line);
        }
        return data;
    }

    // Sequential test making
    public static void testSequentialAccess(String name, int size, java.util.function.IntConsumer action) {
        long start = System.nanoTime();
        for (int i = 0; i < size; i++) action.accept(i);
        long end = System.nanoTime();
        System.out.println(name + " - Sequential Access: " + (end - start) + " ns");
    }

    // Random Access 100 lookups making
    public static <T> void testRandomAccess(String name, java.util.function.Function<Integer, T> getter, int size) {
        Random rand = new Random();
        long start = System.nanoTime();
        for (int i = 0; i < 100; i++) getter.apply(rand.nextInt(size));
        long end = System.nanoTime();
        System.out.println(name + " - Random Access (100 lookups): " + (end - start) + " ns");
    }

    // Overloads for custom lists
    public static void testRandomAccess(String name, ArrayListCustom<?> list, int size) {
        Random rand = new Random();
        long start = System.nanoTime();
        for (int i = 0; i < 100; i++) list.get(rand.nextInt(size));
        long end = System.nanoTime();
        System.out.println(name + " - Random Access (100 lookups): " + (end - start) + " ns");
    }

    public static void testRandomAccess(String name, LinkedListCustom<?> list, int size) {
        Random rand = new Random();
        long start = System.nanoTime();
        for (int i = 0; i < 100; i++) list.get(rand.nextInt(size));
        long end = System.nanoTime();
        System.out.println(name + " - Random Access (100 lookups): " + (end - start) + " ns");
    }

    // Insertions test making 
    public static <T> void testInsertions(String name, List<T> list) {
        long start, end;
        start = System.nanoTime();
        list.add(0, null);
        end = System.nanoTime();
        System.out.println(name + " - Insert at beginning: " + (end - start) + " ns");

        start = System.nanoTime();
        list.add(list.size() / 2, null);
        end = System.nanoTime();
        System.out.println(name + " - Insert at middle: " + (end - start) + " ns");

        start = System.nanoTime();
        list.add(null);
        end = System.nanoTime();
        System.out.println(name + " - Insert at end: " + (end - start) + " ns\n");
    }

    public static void testInsertions(String name, ArrayListCustom<?> list) {
        long start, end;
        start = System.nanoTime();
        list.insert(0, null);
        end = System.nanoTime();
        System.out.println(name + " - Insert at beginning: " + (end - start) + " ns");

        start = System.nanoTime();
        list.insert(list.size() / 2, null);
        end = System.nanoTime();
        System.out.println(name + " - Insert at middle: " + (end - start) + " ns");

        start = System.nanoTime();
        list.insert(list.size(), null);
        end = System.nanoTime();
        System.out.println(name + " - Insert at end: " + (end - start) + " ns\n");
    }

    public static void testInsertions(String name, LinkedListCustom<?> list) {
        long start, end;
        start = System.nanoTime();
        list.insert(0, null);
        end = System.nanoTime();
        System.out.println(name + " - Insert at beginning: " + (end - start) + " ns");

        start = System.nanoTime();
        list.insert(list.size() / 2, null);
        end = System.nanoTime();
        System.out.println(name + " - Insert at middle: " + (end - start) + " ns");

        start = System.nanoTime();
        list.insert(list.size(), null);
        end = System.nanoTime();
        System.out.println(name + " - Insert at end: " + (end - start) + " ns\n");
    }

    // Deletions test making
    public static <T> void testDeletions(String name, List<T> list) {
        long start, end;
        start = System.nanoTime();
        list.remove(0);
        end = System.nanoTime();
        System.out.println(name + " - Delete at beginning: " + (end - start) + " ns");

        start = System.nanoTime();
        list.remove(list.size() / 2);
        end = System.nanoTime();
        System.out.println(name + " - Delete at middle: " + (end - start) + " ns");

        start = System.nanoTime();
        list.remove(list.size() - 1);
        end = System.nanoTime();
        System.out.println(name + " - Delete at end: " + (end - start) + " ns\n");
    }

    public static void testDeletions(String name, ArrayListCustom<?> list) {
        long start, end;
        start = System.nanoTime();
        list.remove(0);
        end = System.nanoTime();
        System.out.println(name + " - Delete at beginning: " + (end - start) + " ns");

        start = System.nanoTime();
        list.remove(list.size() / 2);
        end = System.nanoTime();
        System.out.println(name + " - Delete at middle: " + (end - start) + " ns");

        start = System.nanoTime();
        list.remove(list.size() - 1);
        end = System.nanoTime();
        System.out.println(name + " - Delete at end: " + (end - start) + " ns\n");
    }

    public static void testDeletions(String name, LinkedListCustom<?> list) {
        long start, end;
        start = System.nanoTime();
        list.remove(0);
        end = System.nanoTime();
        System.out.println(name + " - Delete at beginning: " + (end - start) + " ns");

        start = System.nanoTime();
        list.remove(list.size() / 2);
        end = System.nanoTime();
        System.out.println(name + " - Delete at middle: " + (end - start) + " ns");

        start = System.nanoTime();
        list.remove(list.size() - 1);
        end = System.nanoTime();
        System.out.println(name + " - Delete at end: " + (end - start) + " ns\n");
    }
}
