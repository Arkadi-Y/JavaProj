package ongoing;

import Interfaces.*;

public class Jobapp implements JobappInt {
    private int jobID;
    private String CV;

    public Jobapp(int jobID, String CV) {
        this.jobID = jobID;
        this.CV = CV;
    }

    public int getJobID() {
        return this.jobID;
    }

    public String getCV() {
        return this.CV;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public void setCV(String CV) {
        this.CV = CV;
    }

    public String toString() {
        return this.jobID + " " + this.CV;
    }
}
