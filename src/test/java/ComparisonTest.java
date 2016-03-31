import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sefa on 31.3.2016.
 */
public class ComparisonTest {

    @Test
    public void testIntersectionOfListsInteger() throws Exception {

        List<Integer> list1=new ArrayList<Integer>();
        List<Integer> list2=new ArrayList<Integer>();
        list1.add(2);
        list1.add(5);
        list1.add(1);
        list1.add(6);

        list2.add(2);
        list2.add(2);
        list2.add(5);
        list2.add(1);

        Comparison comparison=new Comparison(list1,list2);
        list1=comparison.intersectionOfLists();

        List<Integer> expected =new ArrayList<Integer>();
        expected.add(1);
        expected.add(2);
        expected.add(5);

        assertEquals(expected,list1);
    }

    @Test
    public void testIntersectionOfListsString() throws Exception {
        List<String> test1 = new ArrayList<String>();
        test1.add("test1");
        test1.add("test");
        test1.add("test");
        test1.add("test");

        List<String> test2 = new ArrayList<String>();
        test2.add("test3");
        test2.add("test");
        test2.add("test3");
        test2.add("test4");

        Comparison comparison=new Comparison(test1,test2);
        List<String> result=comparison.intersectionOfLists();

        List<String> expected = new ArrayList<String>();

        expected.add("test");

        assertEquals(expected, result);

    }

    @Test
    public void testUnionOfListsInteger() throws Exception {

        List<Integer> list1=new ArrayList<Integer>();
        List<Integer> list2=new ArrayList<Integer>();
        list1.add(2);
        list1.add(5);
        list1.add(1);
        list1.add(6);

        list2.add(2);
        list2.add(2);
        list2.add(5);
        list2.add(1);

        Comparison comparison=new Comparison(list1,list2);
        list1=comparison.unionOfLists();

        List<Integer> expected =new ArrayList<Integer>();
        expected.add(6);

        assertEquals(expected,list1);
    }

    @Test
    public void testUnionOfListsString() throws Exception {
        List<String> test1 = new ArrayList<String>();
        test1.add("test1");
        test1.add("test");
        test1.add("test");
        test1.add("test");

        List<String> test2 = new ArrayList<String>();
        test2.add("test3");
        test2.add("test");
        test2.add("test3");
        test2.add("test4");

        Comparison comparison=new Comparison(test1,test2);
        List<String> result=comparison.unionOfLists();

        List<String> expected = new ArrayList<String>();

        expected.add("test4");
        expected.add("test1");

        assertEquals(expected, result);

    }

    @Test
    public void testIsSubsetTrue() throws Exception {

        List<Integer> list1=new ArrayList<Integer>();
        List<Integer> list2=new ArrayList<Integer>();
        list1.add(2);
        list1.add(5);
        list1.add(1);
        list1.add(6);

        list2.add(2);
        list2.add(2);
        list2.add(5);
        list2.add(1);

        Comparison comparison=new Comparison(list1,list2);
        boolean result=comparison.isSubset();
        boolean expected=true;


        assertEquals(expected,result);
    }
    @Test
    public void testIsSubsetFalse() throws Exception {

        List<Integer> list1=new ArrayList<Integer>();
        List<Integer> list2=new ArrayList<Integer>();
        list1.add(2);
        list1.add(5);
        list1.add(1);
        list1.add(6);

        list2.add(2);
        list2.add(2);
        list2.add(5);
        list2.add(1);
        list2.add(7);

        Comparison comparison=new Comparison(list1,list2);
        boolean result=comparison.isSubset();
        boolean expected=false;


        assertEquals(expected,result);
    }
}