import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by Sefa on 29.3.2016.
 */
public class Comparison<E> {

    List<E> list1;
    List<E> list2;

    public Comparison(List a, List b)
    {
        Collections.sort(a);
        Collections.sort(b);
        list1=a;
        list2=b;
    }

    public List intersectionOfLists()//returns intersection set as a list of list1 and list 2
    {
        List<E> temp= new ArrayList<E>();
        if(list1.size()==0 || list2.size()==0)
            return new ArrayList();
        if(list1.contains(list2.get(0)))
        {
            temp.add(list2.get(0));
            Comparison forRecursion = new Comparison(list1,list2.subList(1,list2.size()));
            temp.addAll(forRecursion.intersectionOfLists());
            LinkedHashSet<E> forDuplicate = new LinkedHashSet<E>();
            forDuplicate.addAll(temp);
            temp.clear();
            temp.addAll(forDuplicate);
            return temp;
        }
        else
        {
            Comparison forRecursion = new Comparison(list1,list2.subList(1,list2.size()));
            temp.addAll(forRecursion.intersectionOfLists());

            LinkedHashSet<E> forDuplicate = new LinkedHashSet<E>();
            forDuplicate.addAll(temp);
            temp.clear();
            temp.addAll(forDuplicate);
            return temp;
        }

    }
    public List unionOfLists()//returns union set as a list of list1 and list 2
    {
        List<E> temp = new ArrayList<E>();
        temp = unionOfLists1();
        temp = unionOfLists2();
        return temp;
    }

    private List unionOfLists1()//returns union set as a list of list1 and list 2
    {
        List<E> temp= new ArrayList<E>();
        temp=unionOfLists2();
        if(list1.size()==0 || list2.size()==0)
            return new ArrayList();
        if(list1.contains(list2.get(0)))
        {

            Comparison forRecursion = new Comparison(list1,list2.subList(1,list2.size()));
            temp.addAll(forRecursion.unionOfLists());
            LinkedHashSet<E> forDuplicate = new LinkedHashSet<E>();
            forDuplicate.addAll(temp);
            temp.clear();
            temp.addAll(forDuplicate);
            return temp;
        }
        else
        {
            temp.add(list2.get(0));
            Comparison forRecursion = new Comparison(list1,list2.subList(1,list2.size()));
            temp.addAll(forRecursion.unionOfLists());

            LinkedHashSet<E> forDuplicate = new LinkedHashSet<E>();
            forDuplicate.addAll(temp);
            temp.clear();
            temp.addAll(forDuplicate);
            return temp;
        }

    }
    private List unionOfLists2()//returns union set as a list of list1 and list 2
    {
        List<E> temp= new ArrayList<E>();
        if(list1.size()==0 || list2.size()==0)
            return new ArrayList();
        if(list2.contains(list1.get(0)))
        {

            Comparison forRecursion = new Comparison(list1.subList(1,list1.size()),list2);
            temp.addAll(forRecursion.unionOfLists2());
            LinkedHashSet<E> forDuplicate = new LinkedHashSet<E>();
            forDuplicate.addAll(temp);
            temp.clear();
            temp.addAll(forDuplicate);
            return temp;
        }
        else
        {
            temp.add(list1.get(0));
            Comparison forRecursion = new Comparison(list1.subList(1,list1.size()),list2);
            temp.addAll(forRecursion.unionOfLists2());

            LinkedHashSet<E> forDuplicate = new LinkedHashSet<E>();
            forDuplicate.addAll(temp);
            temp.clear();
            temp.addAll(forDuplicate);
            return temp;
        }

    }


    public boolean isSubset()//return true if list2 is subset of list1
    {
        List<E> temp= new ArrayList<E>();

        if(list1.size()==0 || list2.size()==0)
            return false;

        if(list1.contains(list2.get(0)))
        {
            temp.add(list2.get(0));
            Comparison forRecursion = new Comparison(list1,list2.subList(1,list2.size()));
            temp.addAll(forRecursion.intersectionOfLists());

            return temp.equals(list2) || forRecursion.isSubset();
        }
        else
        {
            Comparison forRecursion = new Comparison(list1,list2.subList(1,list2.size()));
            temp.addAll(forRecursion.intersectionOfLists());


            return temp.equals(list2) || forRecursion.isSubset();
        }

    }
}