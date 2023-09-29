import java.util.ArrayList;

public class StringCutting
{
    public static void main(String[] args)
    {
        ArrayList<Integer>a=new ArrayList<>();
        arrayTesting(a);
        System.out.println(a);
    }

     static void arrayTesting(ArrayList<Integer> a)
    {
          for(int i=0;i<10;i++)
          {
              a.add(i);
          }
    }


}
