package ongoing;
public class Ticket extends Person{
    private static int count=0;
    private String status,Description;
    private int ticketNum;
    public Ticket(int ticketNum,String status,String Description,Person person){
        super(person.getName(),person.getPhone(),person.getMail());
        this.ticketNum=ticketNum;
        this.status = status;
        this.Description = Description;
        count=ticketNum+1;
    }
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

    @Override
    public String toString() {
        return "Ticket{" +
                "status='" + status + '\'' +
                ", Description='" + Description + '\'' +
                ", ticketNum=" + ticketNum +
                '}'+" user name :"+getName();
    }
}
