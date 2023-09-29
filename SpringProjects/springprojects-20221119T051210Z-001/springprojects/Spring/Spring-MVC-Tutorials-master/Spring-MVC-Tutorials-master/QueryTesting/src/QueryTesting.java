public class QueryTesting
{
  public static void main(String[] args)
  {
      String a="abcd";
      String b="Sisodiya";
      String ReferenceNo="2022-03-21-DPI2222-79";
      boolean is_SuccesFul=false;
     String url="v1/api/process";
     String d= "Select * from failed_Request where (body Like \'%\""+ReferenceNo+"\"%\'"+") and (is Successful="+is_SuccesFul+") and (url like ‘%process%’))";

      String c="select * from table where  l=\""+a+"\" ";
      System.out.println(d+" ");
  }

}
