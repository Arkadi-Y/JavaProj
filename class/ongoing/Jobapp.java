package ongoing;

public class Jobapp {
    private int jobID;
    private String CV;
    public Jobapp(int jobID, String CV) {
        this.jobID = jobID;
        this.CV = CV;
    }
    int getJobID() {
        return this.jobID;
    }
    String getCV() {
        return this.CV;
    }
    void setJobID(int jobID) {
        this.jobID = jobID;
    }
    void setCV(String CV) {
        this.CV = CV;
    }
}
