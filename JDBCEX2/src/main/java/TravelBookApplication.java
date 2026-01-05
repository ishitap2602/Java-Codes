
 
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
 
public class TravelBookApplication {
 
	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/TRAVELBOOKING";

		String username ="root";

		String password ="root@39";

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection(url,username,password);

		//create user_details table

		PreparedStatement createUserTable = conn.prepareStatement(

                "CREATE TABLE IF NOT EXISTS USER_DETAILS (" +

                "user_id INT AUTO_INCREMENT PRIMARY KEY," +

                "full_name VARCHAR(100)," +

                "email VARCHAR(100)," +

                "phone VARCHAR(20)," +

                "city VARCHAR(50))");

        createUserTable.executeUpdate();

        System.out.println("Created User_details Table Successfully");
 
        // CREATE TABLE TRAVEL_INFO

        PreparedStatement createTravelTable = conn.prepareStatement(

                "CREATE TABLE IF NOT EXISTS TRAVEL_INFO (" +

                "travel_id INT AUTO_INCREMENT PRIMARY KEY," +

                "user_id INT," +

                "destination VARCHAR(100)," +

                "FOREIGN KEY (user_id) REFERENCES USER_DETAILS(user_id))");

        createTravelTable.executeUpdate();

        System.out.println("Created Travel_Info Table Successfully");

 
        // INSERT USER

         PreparedStatement insertUser = conn.prepareStatement(

                 "INSERT INTO USER_DETAILS(full_name,email,phone,city) VALUES(?,?,?,?)");

         insertUser.setString(1, "Alice");

         insertUser.setString(2, "alice@example.com");

         insertUser.setString(3, "9876543210");

         insertUser.setString(4, "Delhi");

         insertUser.executeUpdate();

         PreparedStatement insertUser2 = conn.prepareStatement(

                 "INSERT INTO USER_DETAILS(full_name,email,phone,city) VALUES(?,?,?,?)");

         insertUser.setString(1, "Jay");

         insertUser.setString(2, "jay.manek@gmail.com");

         insertUser.setString(3, "9876543210");

         insertUser.setString(4, "Mumbai");

         insertUser.executeUpdate();

 
          // INSERT TRAVEL INFO

          PreparedStatement insertTravel = conn.prepareStatement(

                  "INSERT INTO TRAVEL_INFO(user_id,destination) VALUES(?,?)");

          insertTravel.setInt(1, 2); 

          insertTravel.setString(2, "Bangalore");

          insertTravel.executeUpdate();

 
          // READ USERS

           System.out.println("\n--- USERS ---");

           PreparedStatement selectUsers = conn.prepareStatement("SELECT * FROM USER_DETAILS");

           ResultSet rsUsers = selectUsers.executeQuery();

           while (rsUsers.next()) {

               System.out.println(rsUsers.getInt("user_id") + " | " +

                       rsUsers.getString("full_name") + " | " +

                       rsUsers.getString("email") + " | " +

                       rsUsers.getString("phone") + " | " +

                       rsUsers.getString("city"));

           }
 
           // READ TRAVEL INFO

           System.out.println("\n--- TRAVEL INFO ---");

           PreparedStatement selectTravel = conn.prepareStatement("SELECT * FROM TRAVEL_INFO");

           ResultSet rsTravel = selectTravel.executeQuery();

           while (rsTravel.next()) {

               System.out.println(rsTravel.getInt("travel_id") + " | " +

                       rsTravel.getInt("user_id") + " | " +

                       rsTravel.getString("destination"));

           }

 
           // UPDATE USER CITY

            PreparedStatement updateUser = conn.prepareStatement(

                    "UPDATE USER_DETAILS SET city=? WHERE user_id=?");

            updateUser.setString(1, "Mumbai");

            updateUser.setInt(2, 1);

            updateUser.executeUpdate();

            System.out.println("\nUser city updated to Mumbai.");

 
            // DELETE TRAVEL INFO

             PreparedStatement deleteTravel = conn.prepareStatement(

                     "DELETE FROM TRAVEL_INFO WHERE travel_id=?");

             deleteTravel.setInt(1, 1);

             deleteTravel.executeUpdate();

             System.out.println("Travel info deleted.");
 
             // DELETE USER

             PreparedStatement deleteUser = conn.prepareStatement(

                     "DELETE FROM USER_DETAILS WHERE user_id=?");

             deleteUser.setInt(1, 1);

             deleteUser.executeUpdate();

             System.out.println("User deleted.");
 
             // Close connection

             conn.close();

             System.out.println("\nAll CRUD operations completed successfully.");
 
 
 
             
 
	}
 
}

 