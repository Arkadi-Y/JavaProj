package Classes;

public class Employee extends Person {
    private String address;
    private String role;
    private int matnasID;
    private int id;
    public Employee(int id,String name, String phone, String mail, String address, String role,int matnasID) {
        super(name, phone, mail);
        this.id=id;
        this.address = address;
        this.role = role;
        this.matnasID=matnasID;
    }

    public Employee(int id,Person person, String address, String role,int matnasID) {
        super(person.getName(), person.getPhone(), person.getMail());
        this.id=id;
        this.address = address;
        this.role = role;
        this.matnasID=matnasID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String toString() {
        return super.toString() + " Employee{ address=" + this.address + " role=" + this.role + "}";
    }
    public int getMatnasID() {
        return matnasID;
    }

    public void setMatnasID(int matnasID) {
        this.matnasID = matnasID;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
