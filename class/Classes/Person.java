package Classes;

import Server.myJDBC;

public class Person{
    private static int count = 0;
    private int id;
    private String name;
    private String phone;
    private String mail;

// main constructor when getting data from database.
    public Person (int id,String name, String phone, String mail){
        this.id = id;
        this.name=name;
        this.phone=phone;
        this.mail=mail;
        count = id+1;
    }
// main constructor when creating new person
    public Person(String name, String phone, String mail){
        this.name=name;
        this.phone=phone;
        this.mail=mail;
        //looking for existing person in data base
        myJDBC sql = new myJDBC();
        int sqlID = sql.findPerson(name,phone);
        if (sqlID >=0){
            //gets same id;
            this.id = sqlID;
            if (id>count)
                count = id;
        }
        else {
            //new id and new person in database
            this.id = count;
            sql.newPerson(id,name,phone,mail);
            count++;
        }

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
