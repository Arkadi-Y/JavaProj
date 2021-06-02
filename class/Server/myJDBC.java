package Server;

import java.io.*;
import java.sql.*;
import ongoing.*;
//main connection class to database
public class myJDBC {
private String sqlUrl;
private String user;
private String password;
private Connection connection;
// constructor calls getProperty class to set up connectrion.
    public myJDBC() throws IOException, SQLException {
        System.out.println("*");
        getPropertyValues getClass = new getPropertyValues();
        String[]values = getClass.getPropValues();
        this.sqlUrl = values[0];
        this.user = values [1];
        this.password = values[2];
        this.connection = DriverManager.getConnection(sqlUrl,user,password);
    }

    //un-used;
    public void getTickets(int ID) throws SQLException {
        try{
        Statement statement =  this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from tickets where idPerson="+ID);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("description"));
        }
    }catch (Exception e){
        e.printStackTrace();
    }

    }
    // un-used
    public String getQuery(String column, String table, String where,String ID){
        String output = "";
        try{
            Statement statement =  this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select "+column+" from "+table+" where "+where+"="+ID);
            while (resultSet.next()) {

            }
            return output;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    //checks if  user name and password are in the database to validate login.
    public boolean validateLogin(String username,String userpassword){
        try{
            Statement statement =  this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from employeelogin WHERE UserName ='"+username+"' AND Password ='"+userpassword+"'");
            while (resultSet.next())
                return true;
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
    //return id by name and phone
    public int findPerson(String name, String phone){
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from person WHERE name ='"+name+"' AND phone ='"+phone+"'");
            while (resultSet.next()){
                //System.out.println(resultSet.getInt("idPerson"));
                return resultSet.getInt("idPerson");}
            return -1;
        }catch (Exception e){
            e.printStackTrace();
            return -2;
        }
    }
    //gets table info -> creates list of tickets
    // must get person list because ticket must be connected to a person
    public List<Ticket> loadTicketsToList(List<Person>personList){
        List<Ticket>list=new List<>();
        try{
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
                    // no possible existence of personless ticket so no error handler.
                    System.out.println("no person");
                    }
                }
            return list;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public List<Ticket> loadCompletedTicketsToList(List<Person>personList){
        List<Ticket>list=new List<>();
        try{
            Statement statement = connection.createStatement();
            //get all tickets
            ResultSet resultSet = statement.executeQuery("select * from completedtickets");
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
                    // no possible existence of personless ticket so no error handler.
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
            Statement statement =  this.connection.createStatement();
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
    //as name suggests
    public void updateTicketStatus(String status, int ID) throws SQLException {
        try {
            Statement statement =  this.connection.createStatement();
            if (status.equals("Complete"))
                statement.executeUpdate("DELETE FROM tickets WHERE ticketNum ='" + ID + "'");
            else
                statement.executeUpdate("UPDATE tickets SET  status ='" + status + "' WHERE ticketNum ='" + ID + "'");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    //as name suggests
    public void insertTicket(Ticket t){
        try {
            Statement statement =  this.connection.createStatement();
            statement.executeUpdate("INSERT INTO tickets VALUES ("+t.getTicketNum()+",'"+t.getDescription()+"','"+t.getStatus()+"',"+t.getId()+")");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void insertCompletedTicket(Ticket t){
        try {
            Statement statement =  this.connection.createStatement();
            statement.executeUpdate("INSERT INTO completedtickets VALUES ("+t.getTicketNum()+",'"+t.getDescription()+"','"+t.getStatus()+"',"+t.getId()+")");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    //new person using person class
    public void newPerson(Person p){
        try {
            Statement statement =  this.connection.createStatement();
            // checks for existing person before creating one
            if(findPerson(p.getName(),p.getPhone())>-1)
                System.out.println("person in sql");
            else
                statement.executeUpdate("INSERT INTO person VALUES ("+p.getId()+",'"+p.getName()+"','"+p.getPhone()+"','"+p.getMail()+"')");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    //new person when creating one at Person class constructor
    public void newPerson(int id,String name, String phone,String mail) {
        try {
            Statement statement =  this.connection.createStatement();
            int Id = findPerson(name, phone);
            if ( Id> -1)
                System.out.println("exists");
            else
                statement.executeUpdate("INSERT INTO person VALUES (" + id+ ",'" + name + "','" + phone + "','" + mail + "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
