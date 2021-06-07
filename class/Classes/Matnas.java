package Classes;
public class Matnas{
    private final int id;
    private Employee Director;
    private Employee Secretery;
    private String city;
    private List<Employee>employeeList;

    public void setCity(String city) {
        this.city = city;
    }

    public Employee getSecretery() {
        return Secretery;
    }

    public void setSecretery(Employee secretery) {
        Secretery = secretery;
    }

    public int getId() {
        return id;
    }

    public Employee getDirector() {
        return Director;
    }

    public void setDirector(Employee director) {
        Director = director;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Matnas(int id, Employee Director, Employee Secretery, List<Employee> employeeList, String city){
        this.Director = Director;
        this.Secretery = Secretery;
        this.employeeList = employeeList;
        this.id = id;
        this.city = city;
    }

    public String getCity() {
        return city;
    }
}
