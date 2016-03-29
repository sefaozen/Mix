
/*public class Main {


    public static void main(String[] args) {

    }
}*/


import java.util.ArrayList;
import java.util.List;

public class Main {

    static public void main(String args[]) {

        TowerOfHanoi towerOfHanoi=new TowerOfHanoi();

        towerOfHanoi.towerOfHanoi(4,'X','Y','Z');

        LinkedListRec lik= new LinkedListRec();

        lik.add(1);
        lik.add(1);
        lik.add(12);
        lik.add(12);
        lik.add(13);
        lik.add(133);
        lik.add(1);
        lik.add(1);
        lik.add(134);
        lik.add(1);
        lik.add(1);
        lik.remove(12);

        //test function
        System.out.println(lik);


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
        //test function
        System.out.println(list1);

        //test function
        if(comparison.isSubset())
            System.out.println("correct");
        else
            System.out.println("wrong");

        list1=comparison.unionOfLists();
        //test function
        System.out.println(list1);

    }
}

