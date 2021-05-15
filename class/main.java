public class main {
    public static void main(String[] args){
        EmployeeList a = new EmployeeList();
        MatnasList b = new MatnasList();
        Ticketlist c = new Ticketlist();
        a.add(new Employee("a", "a","a", "a","a"));
        a.add(new Employee("a", "a","a", "a","a"));
        a.add(new Employee("a", "a","a", "a","a"));
        a.add(new Employee("a", "a","a", "a","a"));
        a.add(new Employee("a", "a","a", "a","a"));
        System.out.println(a.toString());
    }
}
