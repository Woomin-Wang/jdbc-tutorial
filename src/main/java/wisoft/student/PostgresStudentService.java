package wisoft.student;

import wisoft.common.PostgresAccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgresStudentService implements StudentService {

    @Override
    public List<Student> getStudents() {
        final var query = "SELECT * FROM student";
        final var students = new ArrayList<Student>();

        try (
                final Connection conn = PostgresAccess.setConnection();
                final PreparedStatement pstmt = conn.prepareStatement(query);
                final ResultSet rs = pstmt.executeQuery()
        ) {
            while (rs.next()) {
                final var student = new Student(rs.getString(1), rs.getString(2), rs.getDate(3).toLocalDate());
                students.add(student);
            }
        } catch (final SQLException sqle) {
            System.err.println("SQLException: " + sqle.getMessage());
            System.err.println("SQLState: " + sqle.getSQLState());
        }
        return students;
    }

    @Override
    public Student getStudentByNo(final String studentNo) {
        final String query = "SELECT * FROM student WHERE no = ?";
        var student = new Student();

        try (
                final Connection conn = PostgresAccess.setConnection();
                final PreparedStatement pstmt = conn.prepareStatement(query)
        ) {
            pstmt.setString(1, studentNo);

            try (final ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    student = new Student(rs.getString(1), rs.getString(2), rs.getDate(3).toLocalDate());
                }
            }
        } catch (final SQLException sqle) {
            System.err.println("SQLException: " + sqle.getMessage());
            System.err.println("SQLState: " + sqle.getSQLState());
        }
        return student;
    }

    @Override
    public Student getStudentByName(final String studentName) {
        final String query = "SELECT * FROM student WHERE name = ?";
        var student = new Student();

        try (
                final Connection conn = PostgresAccess.setConnection();
                final PreparedStatement pstmt = conn.prepareStatement(query)
        ) {
            pstmt.setString(1, studentName);

            try (final ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    student = new Student(rs.getString(1), rs.getString(2), rs.getDate(3).toLocalDate());
                }
            }
        } catch (final SQLException sqle) {
            System.err.println("SQLException: " + sqle.getMessage());
            System.err.println("SQLState: " + sqle.getSQLState());
        }
        return student;
    }

    @Override
    public Student getStudentByBirthday(final String studentBirthday) {
        final String query = "SELECT * FROM student WHERE birthday = ?";
        var student = new Student();

        try (
                final Connection conn = PostgresAccess.setConnection();
                final PreparedStatement pstmt = conn.prepareStatement(query)
        ) {
            pstmt.setDate(1, Date.valueOf(studentBirthday));

            try (final ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    student = new Student(rs.getString(1), rs.getString(2), rs.getDate(3).toLocalDate());
                }
            }
        } catch (final SQLException sqle) {
            System.err.println("SQLException: " + sqle.getMessage());
            System.err.println("SQLState: " + sqle.getSQLState());
        }
        return student;
    }

    @Override
    public Integer insertStudent(final Student student) {
        final String query = "INSERT INTO STUDENT(NO, NAME, BIRTHDAY) VALUES (?, ?, ?)";
        var result = 0;

        try (final Connection conn = PostgresAccess.setConnection()) {
            try {
                conn.setAutoCommit(false);

                try (final PreparedStatement pstmt = conn.prepareStatement(query)) {
                    pstmt.setString(1, student.getNo());
                    pstmt.setString(2, student.getName());

                    if (student.getBirthday() == null) {
                        pstmt.setNull(3, Types.DATE);
                    } else {
                        pstmt.setDate(3, Date.valueOf(student.getBirthday()));
                    }

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

    @Override
    public Integer insertStudentMulti(final Student[] students) {
        final String query = "INSERT INTO STUDENT(NO, NAME, BIRTHDAY) VALUES (?, ?, ?)";
        var result = 0;

        try (final Connection conn = PostgresAccess.setConnection()) {
            try {
                conn.setAutoCommit(false);
                try (final PreparedStatement pstmt = conn.prepareStatement(query)) {
                    for (Student student : students) {
                        if (student.getNo() == null && student.getName() == null) {
                            break;
                        }

                        pstmt.setString(1, student.getNo());
                        pstmt.setString(2, student.getName());

                        if (student.getBirthday() == null) {
                            pstmt.setNull(3, Types.DATE);
                        } else {
                            pstmt.setDate(3, Date.valueOf(student.getBirthday()));
                        }

                        result += pstmt.executeUpdate();
                        pstmt.clearParameters();
                    }
                    conn.commit();
                }
            } catch (final SQLException sqle) {
                conn.rollback();
                System.err.println("SQLException: " + sqle.getMessage());
                System.out.println("SQLState: " + sqle.getSQLState());
            }
        } catch (SQLException sqex) {
            System.out.println("SQLException: " + sqex.getMessage());
            System.out.println("SQLState: " + sqex.getSQLState());
        }
        return result;
    }

    @Override
    public Integer insertStudentMultiBatch(final Student[] students) {
        final String query = "INSERT INTO STUDENT(NO, NAME, BIRTHDAY) VALUES (?, ?, ?)";
        var result = new int[10];

        try (final Connection conn = PostgresAccess.setConnection()) {
            try {
                conn.setAutoCommit(false);
                try (final PreparedStatement pstmt = conn.prepareStatement(query)) {
                    for (final Student student : students) {
                        if (student.getNo() == null && student.getName() == null) {
                            break;
                        }

                        pstmt.setString(1, student.getNo());
                        pstmt.setString(2, student.getName());

                        if (student.getBirthday() == null) {
                            pstmt.setNull(3, Types.DATE);
                        } else {
                            pstmt.setDate(3, Date.valueOf(student.getBirthday()));
                        }

                        pstmt.addBatch();
                        pstmt.clearParameters();
                    }

                    result = pstmt.executeBatch();
                    conn.commit();
                }
            } catch (final SQLException sqle) {
                conn.rollback();
                System.err.println("SQLException: " + sqle.getMessage());
                System.out.println("SQLState: " + sqle.getSQLState());
            }
        } catch (SQLException sqex) {
            System.out.println("SQLException: " + sqex.getMessage());
            System.out.println("SQLState: " + sqex.getSQLState());
        }
        return result.length;
    }


    @Override
    public Integer updateStudent(final Student student) {
        final String query = "UPDATE student SET birthday = ? WHERE no = ?";
        var result = 0;

        try (final Connection conn = PostgresAccess.setConnection()) {
            try {
                conn.setAutoCommit(false);

                try (final PreparedStatement pstmt = conn.prepareStatement(query)) {
                    pstmt.setDate(1, Date.valueOf(student.getBirthday()));
                    pstmt.setString(2, student.getNo());

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

    @Override
    public Integer updateStudentMultiBatch(final Student[] students) {
        final String query = "UPDATE student SET birthday = ? WHERE no = ?";
        var result = new int[10];

        try (final Connection conn = PostgresAccess.setConnection()) {
            try {
                conn.setAutoCommit(false);
                try (final PreparedStatement pstmt = conn.prepareStatement(query)) {
                    for (final Student student : students) {
                        if (student.getNo() == null && student.getBirthday() == null) {
                            break;
                        }

                        pstmt.setDate(1, Date.valueOf(student.getBirthday()));
                        pstmt.setString(2, student.getNo());

                        pstmt.addBatch();
                        pstmt.clearParameters();
                    }

                    result = pstmt.executeBatch();
                    conn.commit();
                }
            } catch (final SQLException sqle) {
                conn.rollback();
                System.err.println("SQLException: " + sqle.getMessage());
                System.out.println("SQLState: " + sqle.getSQLState());
            }
        } catch (SQLException sqex) {
            System.out.println("SQLException: " + sqex.getMessage());
            System.out.println("SQLState: " + sqex.getSQLState());
        }
        return result.length;
    }

    @Override
    public Integer deleteStudentByNo(final String no) {
        final String query = "DELETE FROM STUDENT WHERE NO = ?";
        var result = 0;

        try (final Connection conn = PostgresAccess.setConnection()) {
            try {
                conn.setAutoCommit(false);

                try (final PreparedStatement pstmt = conn.prepareStatement(query)) {
                    pstmt.setString(1, no);

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

    @Override
    public Integer deleteStudentNoMultiBatch(final Student[] students) {
        final String query = "DELETE FROM STUDENT WHERE NO = ?";
        var result = new int[10];

        try (final Connection conn = PostgresAccess.setConnection()) {
            try {
                conn.setAutoCommit(false);
                try (final PreparedStatement pstmt = conn.prepareStatement(query)) {
                    for (final Student student : students) {
                        if (student.getNo() == null) {
                            break;
                        }

                        pstmt.setString(1, student.getNo());
                        pstmt.addBatch();
                        pstmt.clearParameters();
                    }

                    result = pstmt.executeBatch();
                    conn.commit();
                }
            } catch (final SQLException sqle) {
                conn.rollback();
                System.err.println("SQLException: " + sqle.getMessage());
                System.out.println("SQLState: " + sqle.getSQLState());
            }
        } catch (SQLException sqex) {
            System.out.println("SQLException: " + sqex.getMessage());
            System.out.println("SQLState: " + sqex.getSQLState());
        }
        return result.length;
    }

}
