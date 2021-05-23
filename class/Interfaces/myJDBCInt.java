package Interfaces;

import java.sql.SQLException;

import ongoing.*;

public interface myJDBCInt {
    // connection method
    public void connect() throws SQLException;

    // un-used;
    public void getTickets(int ID) throws SQLException;

    public String getQuery(String column, String table, String where, String ID);

    // checks if user name and password are in the database
    public boolean validateLogin(String username, String userpassword);

    // return id by name and phone
    public int findPerson(String name, String phone);

    // gets table info -> creates list of tickets
    public List<Ticket> loadTicketsToList(List<Person> personList);

    public List<Person> loadPeopleToList();

    public void updateTicketStatus(String status, int ID) throws SQLException;

    public void insertTicket(Ticket t);

    public void newPerson(Person p);

    public void newPerson(int id, String name, String phone, String mail);

}