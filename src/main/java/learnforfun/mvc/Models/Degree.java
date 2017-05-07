package learnforfun.mvc.Models;

import javax.persistence.Entity;

@Entity
public class Degree {

    private String Bachelor;
    private String Master;
    private String PHD;
    private int DID;

    public String getBachelor() {
        return Bachelor;
    }

    public void setBachelor(String bachelor) {
        Bachelor = bachelor;
    }

    public String getMaster() {
        return Master;
    }

    public void setMaster(String master) {
        Master = master;
    }

    public String getPHD() {
        return PHD;
    }

    public void setPHD(String pHD) {
        PHD = pHD;
    }

    public int getDID() {
        return DID;
    }

    public void setDID(int dID) {
        DID = dID;
    }
}
