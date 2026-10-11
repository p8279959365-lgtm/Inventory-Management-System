import java.sql.*;
class main
{
    public static void main(String[] args)
    {
        
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","Vikram@300978");
        }
        catch(Exception e)
        {

        }

    }
}