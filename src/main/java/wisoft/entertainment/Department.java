package wisoft.entertainment;

public class Department {


    private String deptCode;
    private String deptName;
    private String deptLoc;

    public Department() {
    }

    public Department(String deptCode) {
        this.deptCode = deptCode;
    }

    public Department(String deptCode, String deptName) {
        this.deptCode = deptCode;
        this.deptName = deptName;
    }

    public Department(String deptCode, String deptName, String deptLoc) {
        this.deptCode = deptCode;
        this.deptName = deptName;
        this.deptLoc = deptLoc;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getDeptLoc() {
        return deptLoc;
    }



}


