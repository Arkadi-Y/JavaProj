package Server;

import ongoing.List;
import ongoing.Person;
import ongoing.Ticket;

public class myDATA {
    public List<Person> personList;
    public List<Ticket> ticketList;
    public List<Ticket> completedtickets;
    private myJDBC jdbc;

    public myDATA(){
        jdbc = new myJDBC();
        personList = jdbc.loadPeopleToList();
        ticketList = jdbc.loadTicketsToList(personList);
        completedtickets = jdbc.loadCompletedTicketsToList(personList);
    }
    public void refreshDATA(){
        personList=null;
        ticketList = null;
        completedtickets = null;
        Ticket.setCountTo0();
        personList = jdbc.loadPeopleToList();
        ticketList = jdbc.loadTicketsToList(personList);
        completedtickets = jdbc.loadCompletedTicketsToList(personList);
    }
}
