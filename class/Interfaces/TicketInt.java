package Interfaces;

public interface TicketInt {

    public int getTicketNum();

    public String getStatus();

    public String getDescription();

    public void setStatus(String status);

    public void setDescription(String description);

    @Override
    public String toString();
}
