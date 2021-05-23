package ongoing;

import Interfaces.*;

public class department implements departmentInt {
    private String type;
    private Employee vice;
    private Employee Secretery;

    public department(String type, Employee vice, Employee Secretery) {
        this.type = type;
        this.vice = vice;
        this.Secretery = Secretery;
    }

    public String getType() {
        return this.type;
    }

    public Employee getVice() {
        return this.vice;
    }

    public Employee getSecretery() {
        return this.Secretery;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setVice(Employee vice) {
        this.vice = vice;
    }

    public void setSecretery(Employee Secretery) {
        this.Secretery = Secretery;
    }
}
