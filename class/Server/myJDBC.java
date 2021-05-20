package Server;

import java.io.*;
import java.sql.*;
import java.util.Properties;
import java.util.stream.Collectors;

import ongoing.*;

public class myJDBC {
private String sqlUrl;
private String user;
private String password;

    public myJDBC() throws IOException, SQLException {
        getPropertyValues getClass = new getPropertyValues();
        String[]values = getClass.getPropValues();
        sqlUrl = values[0];
        user = values [1];
        password = values[2];

    }
    //connection method
    public void connect() throws SQLException {
       try {
           Connection connection = DriverManager.getConnection(sqlUrl,user,password);
       }catch (Exception e){
           e.printStackTrace();
       }
    }
    //un-used;
    public void getTickets(int ID) throws SQLException {
        try{
        Connection connection = DriverManager.getConnection(sqlUrl,user,password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from tickets where idPerson="+ID);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("description"));
        }
    }catch (Exception e){
        e.printStackTrace();
    }

    }
    public String getQuery(String column, String table, String where,String ID){
        String output = "";
        try{
            Connection connection = DriverManager.getConnection(sqlUrl,user,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select "+column+" from "+table+" where "+where+"="+ID);
            while (resultSet.next()) {

            }
            return output;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    //checks if  user name and password are in the database
    public boolean validateLogin(String username,String userpassword){
        try{
            Connection connection = DriverManager.getConnection(sqlUrl,user,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from employeelogin WHERE UserName ='"+username+"' AND Password ='"+userpassword+"'");
            while (resultSet.next())
                return true;
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
    //gets table info -> creates list of tickets
    public List<Ticket> loadTicketsToList(List<Person>personList){
        List<Ticket>list=new List<>();
        try{
            Connection connection = DriverManager.getConnection(sqlUrl,user,password);
            Statement statement = connection.createStatement();
            //get all tickets
            ResultSet resultSet = statement.executeQuery("select * from tickets");
            while (resultSet.next()){
                //get values
                int ticketNum = resultSet.getInt("ticketNum");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");
                int personId = resultSet.getInt("idPerson");
                //find person who is connected to ticket
                Person person = personList.findByID(personId);
                if (person!=null){
                    Ticket ticket = new Ticket(ticketNum,status,description,person);
                    list.add(ticket);
                                 }
                else {
                    System.out.println("no person");
                }
                }
            return list;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public List<Person> loadPeopleToList(){
        List<Person> people = new List<>();
        try{
            Connection connection = DriverManager.getConnection(sqlUrl,user,password);
            Statement statement = connection.createStatement();
            //get all people table
            ResultSet resultSet = statement.executeQuery("select * from person");
            while (resultSet.next()){
                //get values from table
                int id = resultSet.getInt("idPerson");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String mail = resultSet.getString("mail");
                //create person and add to list
                Person person = new Person(id,name,phone, mail);
                people.add(person);
            }
            return people;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

}
