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

    /**
     * It find the same element of two list and return it
     * @return List of intersection
     */
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

    /**
     * It find the union element of two list and return it
     * @return List of union elements
     */
    public List unionOfLists()//returns union set as a list of list1 and list 2
    {
        List<E> temp = new ArrayList<E>();
        List<E> temp1 = new ArrayList<E>();
        temp = unionOfLists1();
        temp1 = unionOfLists2();
        temp.addAll(temp1);
        LinkedHashSet<E> forDuplicate = new LinkedHashSet<E>();
        forDuplicate.addAll(temp);
        temp.clear();
        temp.addAll(forDuplicate);
        for(int i =0; i< temp.size();i++)
        {
            int count=0;
            for(int ii=i+1; ii < list1.size() ; ii++)
            {
                if(temp.get(i).equals(list1.get(ii)))
                    count++;
            }
            for(int ii=i+1; ii < list2.size() ; ii++)
            {
                if(temp.get(i).equals(list2.get(ii)))
                    count++;
            }

            if(count>1)
                temp.remove(temp.get(i));
        }

        return temp;
    }

    /**
     * It find the union element of two list which list2 to list1 and return it
     * @return List of union elements
     */
    private List unionOfLists1()//returns union set as a list of list1 and list 2
    {
        List<E> temp= new ArrayList<E>();

        if(list1.size()==0 || list2.size()==0)
            return new ArrayList();
        if(list1.contains(list2.get(0)))
        {

            Comparison forRecursion = new Comparison(list1,list2.subList(1,list2.size()));
            temp.addAll(forRecursion.unionOfLists1());

            return temp;
        }
        else
        {
            temp.add(list2.get(0));
            Comparison forRecursion = new Comparison(list1,list2.subList(1,list2.size()));
            temp.addAll(forRecursion.unionOfLists1());


            return temp;
        }

    }
    /**
     * It find the union element of two list which list1 to list2 and return it
     * @return List of union elements
     */
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


    /**
     * It look list2 , it is list1's subset or not
     * @return If it is subset, returns true
     */
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
