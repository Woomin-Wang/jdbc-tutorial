package wisoft.entertainment;

public class Employee {

    private String empCode;
    private String empName;
    private String empMgt;
    private int empSal;
    private String empRcode;

    private int salSum;
    private int salAvg;
    private int salMin;
    private int salMax;

    private String managerName;

    private String empRname;

    public String getEmpRname() {
        return empRname;
    }

    public void setEmpRname(String empRname) {
        this.empRname = empRname;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    private String empMgtName;

    public Employee() {
    }

    public Employee(String empCode) {
        this.empCode = empCode;
    }

    public Employee(int salSum, int salAvg) {
        this.salSum = salSum;
        this.salAvg = salAvg;
    }

    public Employee(String empCode, String empName) {
        this.empCode = empCode;
        this.empName = empName;
    }

    public Employee(String empCode, String empName, String empMgt) {
        this.empCode = empCode;
        this.empName = empName;
        this.empMgt = empMgt;
    }

    public Employee(String empCode, String empName, String empMgt, int empSal) {
        this.empCode = empCode;
        this.empName = empName;
        this.empMgt = empMgt;
        this.empSal = empSal;
    }

    public Employee(String empCode, String empName, String empMgt, int empSal, String empRcode) {
        this.empCode = empCode;
        this.empName = empName;
        this.empMgt = empMgt;
        this.empSal = empSal;
        this.empRcode = empRcode;
    }

    public String getEmpCode() {
        return empCode;
    }

    public String getEmpMgt() {
        return empMgt;
    }

    public String getEmpName() {
        return empName;
    }

    public int getEmpSal() {
        return empSal;
    }

    public int getSalSum() {
        return salSum;
    }

    public int getSalAvg() {
        return salAvg;
    }

    public void setSalSum(int salSum) {
        this.salSum = salSum;
    }

    public void setSalAvg(int salAvg) {
        this.salAvg = salAvg;
    }

    public void setSalMin(int salMin) {
        this.salMin = salMin;
    }

    public void setSalMax(int salMax) {
        this.salMax = salMax;
    }

    public int getSalMin() {
        return salMin;
    }

    public int getSalMax() {
        return salMax;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmpMgt(String empMgt) {
        this.empMgt = empMgt;
    }

    public void setEmpSal(int empSal) {
        this.empSal = empSal;
    }

    public String getEmpMgtName() {
        return empMgtName;
    }

    public void setEmpMgtName(String empMgtName) {
        this.empMgtName = empMgtName;
    }

    public String getEmpRcode() {
        return empRcode;
    }

    public void setEmpRcode(String empRcode) {
        this.empRcode = empRcode;
    }
}
