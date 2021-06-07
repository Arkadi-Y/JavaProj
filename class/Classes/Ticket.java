package Classes;
public class Ticket extends Person{
    private static int count=0;
    private String status,Description;
    private int ticketNum;
    // main constructor for tickets from database
    public Ticket(int ticketNum,String status,String Description,Person person){
        super(person.getName(),person.getPhone(),person.getMail());
        this.ticketNum=ticketNum;
        this.status = status;
        this.Description = Description;
        if (ticketNum>=count)
            count=ticketNum+1;
    }
    // main constructor for new tickets
    public Ticket(String status,String Description,Person person){
        super(person.getName(),person.getPhone(),person.getMail());
        this.ticketNum=count;
        this.status = status;
        this.Description = Description;
        count++;
    }
    public int getTicketNum(){return this.ticketNum;}
    public String getStatus(){
        return this.status;
    }
    public String getDescription(){
        return this.Description;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public void setDescription(String description){
        this.Description = description;
    }
    public static void setCountTo0(){
        count = 0;
    }
    @Override
    public String toString() {
        return "Ticket{" +
                "status='" + status + '\'' +
                ", Description='" + Description + '\'' +
                ", ticketNum=" + ticketNum +
                '}'+" user name :"+getName();
    }
}
