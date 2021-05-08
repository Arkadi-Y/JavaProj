
public class Employee extends Person{
    private String address;
    private String role;
    public Employee(String name, String phone, String mail,String address,String role) {
        super(name, phone, mail);
        this.address=address;
        this.role=role;
    }
    public Employee(Person person,String address,String role){
        super(person.getName(),person.getPhone(),person.getMail());
        this.address=address;
        this.role=role;

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

}
