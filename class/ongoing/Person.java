package ongoing;
public class Person{
    private static int count = 0;
    private int id;
    private String name;
    private String phone;
    private String mail;


    public Person (int id,String name, String phone, String mail){
        this.id = id;
        this.name=name;
        this.phone=phone;
        this.mail=mail;
        count = id+1;
    }
    public Person(String name, String phone, String mail){
        this.id = count;
        this.name=name;
        this.phone=phone;
        this.mail=mail;
        count++;
    }

    public int getId() { return id; }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail ;
    }
}
