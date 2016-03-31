import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sefa on 28.3.206.
 */
public class TowerOfHanoi {

    private List<Integer> place;

    public TowerOfHanoi(){

        place=new ArrayList<Integer>();
    }

    /**
     * It change all disc place where stay in src, to destination adress
     * @param disksize disk number
     * @param src      beginning adress
     * @param dst      destination adress
     * @param aux      for use
     */
    public void towerOfHanoi(int disksize, char src,char dst, char aux)
    {

        String placeName=src+""+aux+dst;

        for(int i=0; i <= disksize+1 ; i++)
        {
            place.add(0);
        }

        int maxMove= (int) (Math.pow(2,disksize)-1); //it's formula of max move number of change
        int firstDiscPlace=0,secondDiskMove=0,tempPosition1,tempPosition2;
        int choose=0;

        for (int i=0; i< maxMove; i++)
        {
            if (choose==0)                         //It change the disc which is the smallest disk, each two steps by one.
            {

                firstDiscPlace = place.get(1);                       //b is the smallest discs place.
                place.set(1,((place.get(1)+1) %3));    //change the smallest disc place. It goes next place by +1.
                secondDiskMove = 3 - firstDiscPlace - place.get(1); //The second disc is going to next to first disc.
                                        //So 3 is total place, firstDiscPlace is first place, place.get(1) is last place
                System.out.println("The disc 1 goes to "+placeName.charAt(place.get(1)));
                choose=1;
            }
            else
            {

                tempPosition1 = place.size()-1;
                tempPosition2 = place.size()-1;
                for (int ii=place.size()-1; ii>1; ii--){
                    if (place.get(ii)==firstDiscPlace)
                        tempPosition1=ii;
                    if (place.get(ii)==secondDiskMove)
                        tempPosition2=ii;
                }

                if (tempPosition1< tempPosition2)
                {
                    System.out.println("The disc "+tempPosition1+" goes to "+placeName.charAt(secondDiskMove));
                    place.set(tempPosition1,secondDiskMove);
                }
                else
                {
                    System.out.println("The disc "+tempPosition2+" goes to "+placeName.charAt(firstDiscPlace));
                    place.set(tempPosition2,firstDiscPlace);
                }

                choose=0;
            }
        }
    }

}
