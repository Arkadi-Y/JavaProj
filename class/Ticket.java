public class Ticket extends Matnas{
    private String status,Description;
    public Ticket(String status,String Description,int id,Employee Diractor,Employee Vice,Employee Secretery){
        super(id, Diractor, Vice, Secretery);
        this.status = status;
        this.Description = Description;
    }
    String getStatus(){
        return this.status;
    }
    String getDescription(){
        return this.Description;
    }
    void setStatus(String status){
        this.status = status;
    }
    void setDescription(String description){
        this.Description = description;
    }
}
