import java.sql.*;

public class ExpenseDAO {

    public void addExpense(Expense expense){

        try{

            Connection conn = DBConnection.getConnection();

            String query = "INSERT INTO expenses(title,amount,category,expense_date) VALUES (?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1,expense.getTitle());
            ps.setDouble(2,expense.getAmount());
            ps.setString(3,expense.getCategory());
            ps.setString(4,expense.getDate());

            ps.executeUpdate();

            System.out.println("Expense Added!");

        }
        catch(Exception e){

            e.printStackTrace();

        }

    }

    public void viewExpenses(){

        try{

            Connection conn = DBConnection.getConnection();

            String query = "SELECT * FROM expenses";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            while(rs.next()){

                System.out.println(
                        rs.getInt("id")+" | "+
                        rs.getString("title")+" | "+
                        rs.getDouble("amount")+" | "+
                        rs.getString("category")+" | "+
                        rs.getString("expense_date")
                );

            }

        }
        catch(Exception e){

            e.printStackTrace();

        }

    }

}