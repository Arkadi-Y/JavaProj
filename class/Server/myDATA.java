package Server;

import Classes.Employee;
import Classes.List;
import Classes.Person;
import Classes.Ticket;
//this class holds all the data taken from sql
//makes it easier to pass the data among the windows
public class myDATA {
    public List<Person> personList;
    public List<Ticket> ticketList;
    public List<Ticket> completedtickets;
    public List<Employee> employeeList;
    private myJDBC jdbc;

    public myDATA(){
        jdbc = new myJDBC();
        personList = jdbc.loadPeopleToList();
        ticketList = jdbc.loadTicketsToList(personList);
        completedtickets = jdbc.loadCompletedTicketsToList(personList);
        employeeList = jdbc.loadEmployeeList();
    }
    public void refreshDATA(){
        personList=null;
        ticketList = null;
        completedtickets = null;
        employeeList = null;
        Ticket.setCountTo0();
        personList = jdbc.loadPeopleToList();
        ticketList = jdbc.loadTicketsToList(personList);
        completedtickets = jdbc.loadCompletedTicketsToList(personList);
        employeeList = jdbc.loadEmployeeList();
    }
}
