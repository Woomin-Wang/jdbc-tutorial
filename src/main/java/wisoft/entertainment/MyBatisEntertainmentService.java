package wisoft.entertainment;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;
import wisoft.common.MyBatisAccess;
import wisoft.student.Student;
import wisoft.student.StudentService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyBatisEntertainmentService implements EntertainmentService {

    final SqlSessionFactory sqlSessionFactory = MyBatisAccess.getSqlSessionFactory();

    @Override
    public List<Department> getDepartments() {
        final List<Department> departments;

        try (final SqlSession session = sqlSessionFactory.openSession()) {
            final var entertainmentService = session.getMapper(EntertainmentService.class);
            departments = entertainmentService.getDepartments();
            return departments;
        } catch (final Exception ex) {
            System.err.println(ex.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public List<Employee> getEmployees() {
        final List<Employee> employees;

        try (final SqlSession session = sqlSessionFactory.openSession()) {
            final EntertainmentService entertainmentService = session.getMapper(EntertainmentService.class);
            employees = entertainmentService.getEmployees();
            return employees;
        } catch (final Exception ex) {
            System.err.println(ex.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public List<Drama> getDramaPrd(String drmPrd) {
        final List<Drama> dramas;

        try (final SqlSession session = sqlSessionFactory.openSession()) {
            final EntertainmentService entertainmentService = session.getMapper(EntertainmentService.class);
            dramas = entertainmentService.getDramaPrd(drmPrd);
            return dramas;
        } catch (final Exception ex) {
            System.err.println(ex.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public List<Drama> getDramaBrd(String drmBrd1, String drmBrd2) {
        final List<Drama> dramas;

        try (final SqlSession session = sqlSessionFactory.openSession()) {
            final EntertainmentService entertainmentService = session.getMapper(EntertainmentService.class);
            dramas = entertainmentService.getDramaBrd(drmBrd1, drmBrd2);
            return dramas;
        } catch (final Exception ex) {
            System.err.println(ex.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public List<Drama> getDramaPrd2() {
        final List<Drama> dramas;

        try (final SqlSession session = sqlSessionFactory.openSession()) {
            final EntertainmentService entertainmentService = session.getMapper(EntertainmentService.class);
            dramas = entertainmentService.getDramaPrd2();
            return dramas;
        } catch (final Exception ex) {
            System.err.println(ex.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public Employee getEmployeeSal() {
        final Employee employees;

        try (final SqlSession session = sqlSessionFactory.openSession()) {
            final EntertainmentService entertainmentService = session.getMapper(EntertainmentService.class);
            employees = entertainmentService.getEmployeeSal();
            return employees;
        } catch (final Exception ex) {
            System.err.println(ex.getMessage());
            return new Employee();
        }
    }

    @Override
    public List<Drama> getDramaNoOpdate() {
        final List<Drama> dramas;

        try (final SqlSession session = sqlSessionFactory.openSession()) {
            final EntertainmentService entertainmentService = session.getMapper(EntertainmentService.class);
            dramas = entertainmentService.getDramaNoOpdate();
            return dramas;
        } catch (final Exception ex) {
            System.err.println(ex.getMessage());
            return new ArrayList<>();
        }      }

    @Override
    public List<Employee> getEmployeeMgt() {
        final List<Employee> employees;

        try (final SqlSession session = sqlSessionFactory.openSession()) {
            final EntertainmentService entertainmentService = session.getMapper(EntertainmentService.class);
            employees = entertainmentService.getEmployeeMgt();
            return employees;
        } catch (final Exception ex) {
            System.err.println(ex.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public List<Employee> getEmployeeSal2() {
        final List<Employee> employees;

        try (final SqlSession session = sqlSessionFactory.openSession()) {
            final EntertainmentService entertainmentService = session.getMapper(EntertainmentService.class);
            employees = entertainmentService.getEmployeeSal2();
            return employees;
        } catch (final Exception ex) {
            System.err.println(ex.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public List<Employee> getEmployeeGroup() {
        final List<Employee> employees;

        try (final SqlSession session = sqlSessionFactory.openSession()) {
            final EntertainmentService entertainmentService = session.getMapper(EntertainmentService.class);
            employees = entertainmentService.getEmployeeGroup();
            return employees;
        } catch (final Exception ex) {
            System.err.println(ex.getMessage());
            return new ArrayList<>();
        }    }

    @Override
    public List<Employee> getEmployeeSal3() {
        final List<Employee> employees;

        try (final SqlSession session = sqlSessionFactory.openSession()) {
            final EntertainmentService entertainmentService = session.getMapper(EntertainmentService.class);
            employees = entertainmentService.getEmployeeSal3();
            return employees;
        } catch (final Exception ex) {
            System.err.println(ex.getMessage());
            return new ArrayList<>();
        }    }

    @Override
    public Integer updateDramaDate(String drmOpdate) {

        try (final SqlSession session = sqlSessionFactory.openSession()) {
            final var entertainmentService = session.getMapper(EntertainmentService.class);
            int result = entertainmentService.updateDramaDate(drmOpdate);
            session.commit();
            return result;
        } catch (final Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }

    @Override
    public Integer updateEmployee() {
        try (final SqlSession session = sqlSessionFactory.openSession()) {
            final var entertainmentService = session.getMapper(EntertainmentService.class);
            int result = entertainmentService.updateEmployee();
            session.commit();
            return result;
        } catch (final Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }

    @Override
    public Integer insertEmployee(String empCode, String empName, String empMgt, int empSal, String empRcode) {
        try (final SqlSession session = sqlSessionFactory.openSession()) {
            final var entertainmentService = session.getMapper(EntertainmentService.class);
            int result = entertainmentService.insertEmployee(empCode, empName, empMgt, empSal, empRcode);
            session.commit();
            return result;
        } catch (final Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }

    @Override
    public Integer deleteEmployee(String empName) {
        try (final SqlSession session = sqlSessionFactory.openSession()) {
            final var entertainmentService = session.getMapper(EntertainmentService.class);
            int result = entertainmentService.deleteEmployee(empName);
            session.commit();
            return result;
        } catch (final Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }    }
}
