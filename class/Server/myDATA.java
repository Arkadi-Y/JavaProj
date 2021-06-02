package Server;

import ongoing.List;
import ongoing.Person;
import ongoing.Ticket;

import java.io.IOException;
import java.sql.SQLException;

public class myDATA {
    public List<Person> personList;
    public List<Ticket> ticketList;
    public List<Ticket> completedtickets;
    private myJDBC jdbc = new myJDBC();

    public myDATA() throws IOException, SQLException {
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
