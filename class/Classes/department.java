package Classes;

public class department {
    private String type;
    private Employee vice;
    private Employee Secretery;
    public department(String type, Employee vice, Employee Secretery) {
        this.type = type;
        this.vice = vice;
        this.Secretery = Secretery;
    }
    String getType() { 
        return this.type; 
    }
    
    Employee getVice(){
        return this.vice;
    }
    Employee getSecretery(){
        return this.Secretery;
    }
    void setType(String type){
        this.type = type;
    }
    void setVice(Employee vice)
    {
        this.vice = vice;
    }
    void setSecretery(Employee Secretery){
        this.Secretery = Secretery;
    }
}
