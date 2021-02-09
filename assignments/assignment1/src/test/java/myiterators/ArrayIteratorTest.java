package myiterators;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ArrayIteratorTest {

    @Test
    public void testArrayGetNext() {

        int[] ans = { 0, 0, 0, 2, 5, 8, 11, 14 };

        ArrayIterator iter = new ArrayIterator(ans);
        for (int i = 0; i < ans.length; i++) {
            if (iter.getNext() != ans[i]) {
                fail("Iterator Failed in iteration " + i);
                return;
            }
        }
    }

    @Test
    public void testArrayHasNext() {

        int[] ans = { 0, 0, 0, 2, 5, 8, 11, 14 };

        ArrayIterator iter = new ArrayIterator(ans);
        for (int i = 0; i < ans.length; i++) {
            iter.getNext();
        }

        assertTrue(!iter.hasNext());
    }

    @Test
    public void testReset() {

        int[] ans = { 0, 0, 0, 2, 5, 8, 11, 14 };

        ArrayIterator iter = new ArrayIterator(ans);
        for (int i = 0; i < ans.length; i++) {
            iter.getNext();
        }

        iter.reset();
		if (!iter.hasNext() || iter.getNext() != ans[0]) {
			fail("testArrayIterator Failed after reset");
		}
    }

}
