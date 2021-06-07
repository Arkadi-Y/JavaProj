package Classes;

public class Region {
    private Employee Diractor, Vice, Secretery;

    public Region(Employee Diractor, Employee Vice, Employee Secretery) {
        this.setDiractor(Diractor);
        this.setVice(Vice);
        this.setSecretery(Secretery);
    }

    public Employee getSecretery() {
        return Secretery;
    }

    public void setSecretery(Employee secretery) {
        this.Secretery = secretery;
    }

    public Employee getVice() {
        return Vice;
    }

    public void setVice(Employee vice) {
        this.Vice = vice;
    }

    public Employee getDiractor() {
        return Diractor;
    }

    public void setDiractor(Employee diractor) {
        this.Diractor = diractor;
    }
}
