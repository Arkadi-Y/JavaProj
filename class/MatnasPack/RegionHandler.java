package MatnasPack;


import ongoing.Employee;
import ongoing.List;
import ongoing.Person;
import ongoing.Region;

class RegionHandler{
    Employee northManager;
    Employee centerManager;
    Employee southManager;
    Employee northViceManager;
    Employee centerViceManager;
    Employee southViceManager;
    Region [] myRegions ;
    public RegionHandler(){
        Employee[] managers = createManegment();
        Employee[] Vice = viceManagers();
        Employee[]sec = secreteryBuilder();
        myRegions = Regions(managers,Vice,sec);

    }
    public Region[] Regions(Employee[]M,Employee[]V,Employee[]S){
        Region[] myRegions =new Region[3];
        Region north = new Region(M[0],V[0],S[0]);
        Region center = new Region(M[1],V[1],S[1]);
        Region south = new Region(M[2],V[2],S[2]);
        myRegions[0]=north;
        myRegions[1]=center;
        myRegions[2]=south;
        return myRegions;
    }
//public Person(String name, String phone, String mail){
    //public Employee(Person person, String address, String role) {
    public Employee[] createManegment(){
        Employee[] managers = new Employee[3];
        Person shimshon = new Person("shimson","054","some mail");
        northManager = new Employee(shimshon,"this street","Region manager");
        Person shlomo = new Person("shlomo","055","some mail");
        centerManager = new Employee(shimshon,"this street","Region manager");
        Person sami = new Person("sami","056","some mail");
        southManager = new Employee(shimshon,"this street","Region manager");
        managers[0]=northManager;
        managers[1]=centerManager;
        managers[2]=southManager;
        return managers;
    }
    public Employee[] viceManagers(){
        Employee[] ViceManagers = new Employee[3];
        Person robi = new Person("robi","054","some mail");
        northViceManager = new Employee(robi,"this street","Region vice manager");
        Person rob = new Person("rob","055","some mail");
        centerViceManager = new Employee(rob,"this street","Region vice manager");
        Person ron = new Person("ron","056","some mail");
        southViceManager = new Employee(ron,"this street","Region vice manager");
        ViceManagers[0]=northViceManager;
        ViceManagers[1]=centerViceManager;
        ViceManagers[2]=southViceManager;
        return ViceManagers;
    }
    public Employee[] secreteryBuilder(){
        Employee[] sec = new Employee[3];
        Person shanon = new Person("shanon","111","mymail");
        Person sharon = new Person("sharon","121","mymail");
        Person shalon = new Person("shalon","112","mymail");
        Employee northRegionSecretary = new Employee(shanon,"that street","secretary");
        Employee CenterRegionSecretary = new Employee(sharon,"that street","secretary");
        Employee SouthRegionSecretary = new Employee(shalon,"that street","secretary");
        sec[0]=northRegionSecretary;
        sec[1]=CenterRegionSecretary;
        sec[2]=SouthRegionSecretary;

        return sec;
    }

}