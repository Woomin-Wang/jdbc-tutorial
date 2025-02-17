package wisoft.entertainment;

import java.util.List;

// @Mapper
public interface EntertainmentService {

    //HNU Entertainment의 부서 코드, 이름, 위치를 검색
    List<Department> getDepartments();

    //HNU Entertainment의 연예관계자 코드, 이름, 관리자, 급여를 검색
    List<Employee> getEmployees();

    //HNU Entertainment에서 제작한 드라마의 코드와 이름을 검색
    List<Drama> getDramaPrd(final String drmPrd);

    //드라마 방영사가 KBC이거나 SBC인 드라마를 검색
    List<Drama> getDramaBrd(final String drmBrd1, final String drmBrd2);

    //드라마 제작사를 검색하시오. 단, 중복된 값이 있으면 제거
    List<Drama> getDramaPrd2();

    //연예관계자들의 급여의 총합과 평균 급여액을 계산
    Employee getEmployeeSal();

    //방영일자가 아직 확정되지 않은 드라마의 이름을 검색
    List<Drama> getDramaNoOpdate();

    //연예관계자에 대해 연예관계자의 이름과 직속 상사의 이름을 검색
    List<Employee> getEmployeeMgt();

    //연예관계자에 대해 이름과 급여를 출력하고, 급여의 내림차순으로 정렬
    List<Employee> getEmployeeSal2();

    //모든 연예관계자를 직급별로 그룹화하고, 평균 급여액이 5000 이상인 직급에 대해
    List<Employee> getEmployeeGroup();

    //모든 연예관계자의 평균 급여액보다 많은 급여를 받는 연예관계자의 이름과 급여를 검색
    List<Employee> getEmployeeSal3();

    //방영일자가 확정되지 않은 드라마의 방영일자가 2013-05-01로 편성되었습니다. 알맞게 변경
    Integer updateDramaDate(String drmOpdate);

    //연예관계자 김수현 씨가 대리에서 실장으로 승진하고 급여가 20% 증가되었습니다. 알맞게 변경
    Integer updateEmployee();

    //우리 회사에 한 명의 임원이 등록 "코드는 E903, 이름은 손진현, 관리자는 E901, 급여는 4000입니다. 알맞게 등록"
    //Integer insertEmployee(String empCode, String empName, String empMgt, int empSal, String empRcode);
    Integer insertEmployee(final Employee employees);

    //연예관계자인 손진현님이 퇴직했습니다. 연예관계자 목록에서 제거
    Integer deleteEmployee(String empName);
}