import static org.junit.Assert.assertEquals;

/**
 * Created by Sefa on 31.3.2016.
 */
public class LinkedListRecTest {

    @org.junit.Test
    public void testRemoveInteger() throws Exception {

        LinkedListRec<Integer> test1=new LinkedListRec<Integer>();
        test1.add(1);
        test1.add(1);
        test1.add(3);
        test1.add(6);
        test1.add(1);
        test1.add(6);
        test1.add(1);

        test1.remove(1);
        LinkedListRec<Integer> expected=new LinkedListRec<Integer>();

        expected.add(3);
        expected.add(6);
        expected.add(6);
        assertEquals(expected.toString(),test1.toString());

    }
    @org.junit.Test
    public void testRemoveString() throws Exception {

        LinkedListRec<String> test1=new LinkedListRec<String>();
        test1.add("test1");
        test1.add("test");
        test1.add("test");
        test1.add("test");
        test1.add("test3");
        test1.add("test");
        test1.add("test3");
        test1.add("test4");

        test1.remove("test");
        LinkedListRec<String> expected=new LinkedListRec<String>();

        expected.add("test1");
        expected.add("test3");
        expected.add("test3");
        expected.add("test4");
        assertEquals(expected.toString(),test1.toString());

    }



}