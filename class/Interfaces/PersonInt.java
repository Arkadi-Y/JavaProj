package Interfaces;

public interface PersonInt {
    public int getId();

    public String getName();

    public String getPhone();

    public String getMail();

    public void setName(String name);

    public void setPhone(String phone);

    public void setMail(String mail);

    @Override
    public String toString();
}
