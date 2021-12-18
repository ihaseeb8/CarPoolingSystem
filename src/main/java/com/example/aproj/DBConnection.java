package com.example.aproj;
import java.sql.*;
import java.util.Objects;

import static java.lang.Integer.parseInt;

class DBConnection {

    private static DBConnection obj=new DBConnection();

    private DBConnection(){

    }

    public static DBConnection getDBConnection(){
        return obj;
    }

    public boolean searchUser(String cnic){

        try
        {
                //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
                //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysql","root","tiger");

            System.out.println("Connection Established!");

            String sql = "SELECT cnic FROM ap.users WHERE cnic = ?";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, cnic);

            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {

                String cnicFetched = rs.getString("cnic"); // by column name matchin

                if( parseInt(cnicFetched ) == parseInt(cnic) ) {
                       return true;
                }

            }

            con.close();

        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return false;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return false;
        }

        return  false;
    }

    public boolean getUser(String cnic){

        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
            //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysql","root","tiger");

            System.out.println("Connection Established!");

            String sql = "SELECT * FROM ap.users WHERE cnic = ?";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, cnic);

            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {

                User.getUser().setCnic( Integer.valueOf(rs.getString("cnic"))); // by column name matchin
                User.getUser().setName(rs.getString("name"));
                User.getUser().setEmail(rs.getString("email"));
                User.getUser().setPassword(rs.getString("password"));
                User.getUser().setPhoneNo(rs.getString("phoneNo"));

                if( parseInt(rs.getString("cnic")) == parseInt(cnic) ) {
                    return true;
                }

            }
            con.close();

        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return false;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return false;
        }

        return  false;
    }

    public boolean insertUser(String name, String email, int cnic , String phoneNo, String password){

        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Driver Loaded Successfully!");

            //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysql","root","tiger");

            System.out.println("Connection Established!");

            String sql = "INSERT INTO ap.users(cnic,email,name,password,phoneNo) VALUES (? , ? , ? , ? , ?) ";

            PreparedStatement statement = con.prepareStatement(sql);

            String Cnic = Integer.toString(cnic);

            statement.setString(1, Cnic);
            statement.setString(2, email);
            statement.setString(3, name);
            statement.setString(4, password);
            statement.setString(5, phoneNo);
            int rowIns = statement.executeUpdate();

            con.close();

            if(rowIns > 0)
                return true;
            else
                return false;


        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return false;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return false;
        }

    }

    public boolean searchParty(String partyName){

        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Driver Loaded Successfully!");

            //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysql","root","tiger");

            System.out.println("Connection Established!");

            String sql = "SELECT party_name FROM ap.parties WHERE party_name = ?";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, partyName);

            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {

                String partyFetched = rs.getString("party_name"); // by column name matchin

                if(Objects.equals(partyFetched, partyName)) {
                    return true;
                }

            }

            con.close();

        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return false;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return false;
        }

        return  false;
    }
/*
    public boolean insertParty(Party party1){

        try
        {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Driver Loaded Successfully!");

            //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysql","root","tiger");

            System.out.println("Connection Established!");

            String sql = "INSERT INTO ap.parties(party_name , candidate_name) VALUES (? , ?) ";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, party1.partyName);
            statement.setString(2, party1.candidateName);

            int rowIns = statement.executeUpdate();

            con.close();

            if(rowIns > 0)
                return true;
            else
                return false;


        }
        catch(ClassNotFoundException e){

            System.out.println("Driver Not Loaded");
            return false;

        } catch (SQLException e) {

            System.out.println("Connection is not Established!" + e.getMessage());
            return false;
        }

    }

    public ObservableList<String> getParties() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        System.out.println("Driver Loaded Successfully!");

        //step2 create  the connection object
        Connection con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mysql","root","tiger");

        System.out.println("Connection Established!");

        String sql = "SELECT party_name,candidate_name FROM ap.parties ";

        PreparedStatement statement = con.prepareStatement(sql);

        ResultSet rs = statement.executeQuery();

        ObservableList<String> parties = FXCollections.observableArrayList();

        while(rs.next())
        {
            String partyFetched = rs.getString("party_name"); // by column name matchin
            String candidateFetched = rs.getString("candidate_name");

            partyFetched = partyFetched + "( " + candidateFetched + " )";

           // System.out.println(partyFetched);

            parties.add(partyFetched);
        }

        con.close();

        return parties;
    }*/
}

