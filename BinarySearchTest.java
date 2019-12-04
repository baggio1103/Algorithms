import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {
    @Test
    public void gallopingSearch() {
        int[] array = {1, 3, 7, 11, 22, 34, 44, 51, 56, 60, 67, 70, 73, 77, 88, 90, 93, 99, 100};
        BinarySearch binary = new BinarySearch(array);
        assertTrue(binary.GallopingSearch(array, 100));
        binary.found = 0;
        assertTrue(binary.GallopingSearch(array,77));
        binary.found = 0;
        assertFalse(binary.GallopingSearch(array, 55));
        binary.found = 0;
        assertTrue(binary.GallopingSearch(array, 77));
        binary.found = 0;
        assertFalse(binary.GallopingSearch(array, -11));
        binary.found = 0;
        assertFalse(binary.GallopingSearch(array, 111));
        binary.found = 0;
        assertTrue(binary.GallopingSearch(array, 56));
    }
}
