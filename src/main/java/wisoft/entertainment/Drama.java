package wisoft.entertainment;

import java.util.Date;

public class Drama {
    private String drmCode;
    private String drmName;
    private String drmPrd;
    private String drmBrd;
    private Date drmOpdate;

    public Drama() {}

    public Drama(String drmCode) {
        this.drmCode = drmCode;
    }

    public Drama(String drmCode, String drmName) {
        this.drmCode = drmCode;
        this.drmName = drmName;
    }

    public Drama(String drmCode, String drmName, String drmPrd) {
        this.drmCode = drmCode;
        this.drmName = drmName;
        this.drmPrd = drmPrd;
    }

    public Drama(String drmCode, String drmName, String drmPrd, String drmBrd) {
        this.drmCode = drmCode;
        this.drmName = drmName;
        this.drmPrd = drmPrd;
        this.drmBrd = drmBrd;
    }

    public Drama(String drmCode, String drmName, String drmPrd, String drmBrd, Date drmOpdate) {
        this.drmCode = drmCode;
        this.drmName = drmName;
        this.drmPrd = drmPrd;
        this.drmBrd = drmBrd;
        this.drmOpdate = drmOpdate;
    }

    public String getDrmCode() {
        return drmCode;
    }

    public String getDrmPrd() {
        return drmPrd;
    }

    public String getDrmName() {
        return drmName;
    }

    public String getDrmBrd() {
        return drmBrd;
    }

    public Date getDrmOpdate() {
        return drmOpdate;
    }

    public void setDrmCode(String drmCode) {
        this.drmCode = drmCode;
    }

    public void setDrmName(String drmName) {
        this.drmName = drmName;
    }

    public void setDrmPrd(String drmPrd) {
        this.drmPrd = drmPrd;
    }

    public void setDrmBrd(String drmBrd) {
        this.drmBrd = drmBrd;
    }

    public void setDrmOpdate(Date drmOpdate) {
        this.drmOpdate = drmOpdate;
    }
}
