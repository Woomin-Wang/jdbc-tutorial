package wisoft.entertainment;

import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.RequestBody;
import wisoft.common.PostgresAccess;
import wisoft.entertainment.Department;
import wisoft.entertainment.Employee;
import wisoft.entertainment.Drama;
import wisoft.entertainment.EntertainmentService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static wisoft.common.PostgresAccess.setConnection;

public class PostgresEntertainmentService implements EntertainmentService {

    @Override
    public List<Department> getDepartments() {
        final var query = "SELECT * FROM department";
        final var departments = new ArrayList<Department>();

        try (

                final Connection conn = PostgresAccess.setConnection();
                final PreparedStatement pstmt = conn.prepareStatement(query);
                final ResultSet rs = pstmt.executeQuery();
        ) {
            while (rs.next()) {
                final var deptCode = rs.getString(1);
                final var deptName = rs.getString(2);
                final var deptLoc = rs.getString(3) != null ? rs.getString(3) : null;

                final var department = new Department(deptCode, deptName, deptLoc);
                departments.add(department);

            }
        } catch (final SQLException sqle) {
            System.err.println("SQLException: " + sqle.getMessage());
            System.err.println("SQLState: " + sqle.getSQLState());
        }

        return departments;
    }


    @Override
    public List<Employee> getEmployees() {
        final var query = "SELECT emp_code, emp_name, emp_mgt, emp_sal FROM Employee";
        final var employees = new ArrayList<Employee>();

        try (
                final Connection conn = PostgresAccess.setConnection();
                final PreparedStatement pstmt = conn.prepareStatement(query);
                final ResultSet rs = pstmt.executeQuery();
        ) {

            while (rs.next()) {
                final var empCode = rs.getString(1);
                final var empName = rs.getString(2);
                final var empMgt = rs.getString(3);
                final var empSal = rs.getInt(4);

                final var employee = new Employee(empCode, empName, empMgt, empSal);
                employees.add(employee);

            }
        } catch (final SQLException sqle) {
            System.err.println("SQLException: " + sqle.getMessage());
            System.err.println("SQLState: " + sqle.getSQLState());
        }

        return employees;
    }

    @Override
    public List<Drama> getDramaPrd(final String dramaPrd) {
        final String query = "SELECT drm_code, drm_name, drm_prd FROM Drama WHERE drm_prd = ?";
        final var dramaList = new ArrayList<Drama>();

        try (
                final Connection conn = PostgresAccess.setConnection();
                final PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            pstmt.setString(1, dramaPrd);

            try (final ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    final var drmCode = rs.getString(1);
                    final var drmName = rs.getString(2);
                    final var drmPrd = rs.getString(3) != null ? rs.getString(3) : null;

                    final var drama = new Drama(drmCode, drmName, drmPrd);
                    dramaList.add(drama);
                }
            }

        } catch (final SQLException sqle) {
            System.err.println("SQLException: " + sqle.getMessage());
            System.err.println("SQLState: " + sqle.getSQLState());
        }
        return dramaList;
    }

    @Override
    public List<Drama> getDramaBrd(final String dramaBrd1, final String dramaBrd2) {
        final String query = "SELECT drm_code, drm_name FROM Drama WHERE drm_brd IN (?, ?)";
        final var dramaList = new ArrayList<Drama>();

        try (
                final Connection conn = PostgresAccess.setConnection();
                final PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            pstmt.setString(1, dramaBrd1);
            pstmt.setString(2, dramaBrd2);

            try (final ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    final var drmCode = rs.getString(1);
                    final var drmName = rs.getString(2);

                    final var drama = new Drama(drmCode, drmName);
                    dramaList.add(drama);
                }
            }

        } catch (final SQLException sqle) {
            System.err.println("SQLException: " + sqle.getMessage());
            System.err.println("SQLState: " + sqle.getSQLState());
        }
        return dramaList;
    }

    // Prd 중복 제거
    @Override
    public List<Drama> getDramaPrd2() {
        final String query = "SELECT DISTINCT drm_prd FROM Drama";
        final var dramaList = new ArrayList<Drama>();

        try (
                final Connection conn = PostgresAccess.setConnection();
                final PreparedStatement pstmt = conn.prepareStatement(query);
        ) {

            try (final ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    final var drmPrd = rs.getString(1);

                    final var drama = new Drama(drmPrd);
                    dramaList.add(drama);
                }
            }

        } catch (final SQLException sqle) {
            System.err.println("SQLException: " + sqle.getMessage());
            System.err.println("SQLState: " + sqle.getSQLState());
        }
        return dramaList;
    }

    @Override
    public Employee getEmployeeSal() {
        final String query = "SELECT SUM(emp_sal), AVG(emp_sal) FROM Employee";
        var employee = new Employee();

        try (
                final Connection conn = PostgresAccess.setConnection();
                final PreparedStatement pstmt = conn.prepareStatement(query);
        ) {

            try (final ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {

                    final var employeeSum = rs.getInt(1);
                    final var employeeAvg = rs.getInt(2);

                    employee = new Employee(employeeSum, employeeAvg);
                }
            }
        } catch (final SQLException sqle) {
            System.err.println("SQLException: " + sqle.getMessage());
            System.err.println("SQLState: " + sqle.getSQLState());
        }
        return employee;
    }

    @Override
    public List<Drama> getDramaNoOpdate() {
        final String query = "SELECT drm_name FROM drama WHERE drm_opdate IS NULL";
        final var dramaList = new ArrayList<Drama>();

        try (
                final Connection conn = PostgresAccess.setConnection();
                final PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            try (final ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {

                    final var drmName = rs.getString(1);

                    Drama drama = new Drama();
                    drama.setDrmName(drmName);
                    dramaList.add(drama);

                }
            }
        } catch (SQLException sqle) {
            System.err.println("SQLException: " + sqle.getMessage());
            System.err.println("SQLState: " + sqle.getSQLState());
        }

        return dramaList;
    }

    @Override
    public List<Employee> getEmployeeMgt() {
        final String query = "SELECT e.emp_name AS employee_Name, m.emp_name AS manager_Name " +
                            "FROM employee e, employee m " +
                            "WHERE e.emp_mgt = m.emp_code";
        final var employeeList = new ArrayList<Employee>();

        try(
                final Connection conn = setConnection();
                final PreparedStatement pstmt = conn.prepareStatement(query);
                ) {

                try(final ResultSet rs = pstmt.executeQuery()) {
                    while(rs.next()) {

                        final var empName = rs.getString(1);
                        final var empMgtName = rs.getString(2);

                        final Employee employee = new Employee();
                        employee.setEmpName(empName);
                        employee.setEmpMgtName(empMgtName);
                        employeeList.add(employee);


                    }
                }
        } catch(SQLException sqle) {
            System.err.println("SQLException: " + sqle.getMessage());
            System.err.println("SQLState: " + sqle.getSQLState());
        }

        return employeeList;
    }

    @Override
    public List<Employee> getEmployeeSal2() {
        final String query = "SELECT emp_name, emp_sal FROM employee ORDER BY emp_sal DESC, emp_name ASC";
        final var employeeList = new ArrayList<Employee>();


        try (
                final Connection conn = setConnection();
                final PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
                try(ResultSet rs = pstmt.executeQuery()) {
                    while(rs.next()) {

                        final var empName = rs.getString(1);
                        final var empSal = rs.getInt(2);

                        final Employee employee = new Employee();
                        employee.setEmpName(empName);
                        employee.setEmpSal(empSal);
                        employeeList.add(employee);

                    }
                }
        } catch(SQLException sqle) {
            System.err.println("SQLException: " + sqle.getMessage());
            System.err.println("SQLState: " + sqle.getSQLState());
        }

        return employeeList;
    }

    @Override
    public List<Employee> getEmployeeGroup() {
                final var query = "SELECT er.emp_rname, AVG(emp_sal), MIN(emp_sal), MAX(emp_sal) " +
                                "FROM employee e, emp_role er " +
                                "WHERE e.emp_rcode = er.emp_rcode " +
                                "GROUP BY er.emp_rname " +
                                "HAVING AVG(e.emp_sal) >= 5000";
        final var employeeList = new ArrayList<Employee>();

        try(
                final Connection conn = setConnection();
                final PreparedStatement pstmt = conn.prepareStatement(query);
                ) {
            try(ResultSet rs = pstmt.executeQuery()) {
               while(rs.next()){

                   final var empName = rs.getString(1);
                   final var empSalAvg = rs.getInt(2);
                   final var empSalMin = rs.getInt(3);
                   final var empSalMax = rs.getInt(4);

                   final var employee = new Employee();
                   employee.setEmpName(empName);
                   employee.setSalAvg(empSalAvg);
                   employee.setSalMin(empSalMin);
                   employee.setSalMax(empSalMax);

                   employeeList.add(employee);

               }
            }

        }catch(SQLException sqle) {
            System.err.println("SQLException: " + sqle.getMessage());
            System.err.println("SQLState: " + sqle.getSQLState());
        }
        return employeeList;
    }


    // 부속질의문 처리는 어떻게 해줘야할까 ?
    // 일단 query문에 파라미터가 없다. 따로 조건 설정을 해주는 것 같지는 않은데 결과값에서는 모든 급여가 나오고 있음
    @Override
    public List<Employee> getEmployeeSal3() {
        final String query = "SELECT emp_name, emp_sal FROM employee WHERE emp_sal > (SELECT AVG(emp_sal) FROM employee)";
        final var employeeList = new ArrayList<Employee>();


        try (
                final Connection conn = setConnection();
                final PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            try(ResultSet rs = pstmt.executeQuery()) { // executeQuery()의 반환값은 ResultSet으로 조회 결과를 담은 객체
                while(rs.next()) {

                    final var empName = rs.getString(1);
                    final var empSal = rs.getInt(2);

                    final Employee employee = new Employee();
                    employee.setEmpName(empName);
                    employee.setEmpSal(empSal);
                    employeeList.add(employee);

                }
            }
        } catch(SQLException sqle) {
            System.err.println("SQLException: " + sqle.getMessage());
            System.err.println("SQLState: " + sqle.getSQLState());
        }

        return employeeList;
    }

    @Override
    public Integer updateDramaDate(final String drmOpdate) {
            final String query = "UPDATE drama " +
                                "SET drm_opdate = ? " + // ?는 PreparedStatement에서 설정할 값
                                "WHERE drm_opdate IS NULL";
            var result = 0;

            try(final Connection conn = setConnection()) { // 데베 연결 생성
                try {
                    conn.setAutoCommit(false); // 자동 커밋 비활성화

                    try(final PreparedStatement pstmt = conn.prepareStatement(query)) {
                        pstmt.setDate(1, Date.valueOf(drmOpdate)); // 첫 번째 ?에 drmOpdate를 설정

                        result = pstmt.executeUpdate(); // executeUpdate는 반환값은 int (영향을 받은 행의 개수)
                        conn.commit();
                    }
                } catch(SQLException sqle) {
                    conn.rollback();
                    System.err.println("SQLException: " + sqle.getMessage());
                    System.out.println("SQLState: " + sqle.getSQLState());
                }
            } catch (final SQLException sqle) {
                System.out.println("SQLException: " + sqle.getMessage());
                System.out.println("SQLState: " + sqle.getSQLState());
            }
        return result;
    }

    @Override
    public Integer updateEmployee() {
        final String query = "UPDATE Employee " +
                            "SET emp_mgt = 'R003', emp_sal = emp_sal * 1.2 " +
                            "WHERE emp_name = '김수현'";
        var result = 0;

        try(final Connection conn = setConnection()) {
            try {
                conn.setAutoCommit(false);

                try (final PreparedStatement pstmt = conn.prepareStatement(query)) {

                    result = pstmt.executeUpdate();
                    conn.commit();

                }
        } catch(SQLException sqle) {
                conn.rollback();
                System.out.println("SQLException: " + sqle.getMessage());
                System.out.println("SQLState: " + sqle.getSQLState());
            }
        } catch(final SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("SQLState: " + sqle.getSQLState());
        }
        return result;
    }

    @Override
    public Integer insertEmployee(final Employee employee) {
        final String query = "INSERT INTO employee(emp_code, emp_name, emp_mgt, emp_sal, emp_rcode) " +
                                "VALUES (?, ?, ?, ?, ?)";
        var result = 0;

        try(final Connection conn = setConnection()) {
            try {
                conn.setAutoCommit(false);

                try (final PreparedStatement pstmt = conn.prepareStatement(query)) {
                   pstmt.setString(1,employee.getEmpCode());
                   pstmt.setString(2,employee.getEmpName());
                   pstmt.setString(3,employee.getEmpMgt());
                   pstmt.setInt(4,employee.getEmpSal());
                   pstmt.setString(5,employee.getEmpRcode());

                   if(employee.getEmpMgt() == null) {
                        pstmt.setNull(3,Types.VARCHAR);
                   } else {
                       pstmt.setString(3,employee.getEmpMgt());
                   }

                    result = pstmt.executeUpdate();
                    conn.commit();

                }
            } catch(SQLException sqle) {
                conn.rollback();
                System.out.println("SQLException: " + sqle.getMessage());
                System.out.println("SQLState: " + sqle.getSQLState());
            }
        } catch(final SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("SQLState: " + sqle.getSQLState());
        }
        return result;    }



    @Override
    public Integer deleteEmployee(String empName) {
            final String query = "DELETE FROM employee WHERE emp_name = ?";
            var result = 0;

            try (final Connection conn = PostgresAccess.setConnection()) {
                try {
                    conn.setAutoCommit(false);

                    try (final PreparedStatement pstmt = conn.prepareStatement(query)) {
                        pstmt.setString(1, empName);

                        result = pstmt.executeUpdate();
                        conn.commit();
                    }
                } catch (final SQLException sqle) {
                    conn.rollback();
                    System.err.println("SQLException: " + sqle.getMessage());
                    System.out.println("SQLState: " + sqle.getSQLState());
                }
            } catch (final SQLException sqle) {
                System.out.println("SQLException: " + sqle.getMessage());
                System.out.println("SQLState: " + sqle.getSQLState());
            }
            return result;
        }

}
