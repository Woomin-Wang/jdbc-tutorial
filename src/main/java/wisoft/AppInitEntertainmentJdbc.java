package wisoft;

import wisoft.entertainment.Department;
import wisoft.entertainment.Drama;
import wisoft.entertainment.Employee;
import wisoft.entertainment.PostgresEntertainmentService;

import java.util.List;

public class AppInitEntertainmentJdbc {
    public static void main(String[] args) {
            final var entertainmentService = new PostgresEntertainmentService();

            var resultCount = 0;
            Department departmentResult;
            Employee employeeResult;
            Drama dramaResult;

            List<Department> departmentResults;
            List<Employee> employeeResults;
            List<Drama> dramaResults;


//            System.out.println("1. HNU Entertainment의 부서 코드, 이름, 위치를 검색하시오.");
//            departmentResults = entertainmentService.getDepartments();
//            departmentResults.forEach(department ->
//                    System.out.println("[부서코드]" + department.getDeptCode() + " || [이름] " + department.getDeptName()
//                    + " || [위치] " + department.getDeptLoc())
//            );
//            System.out.println();


//            System.out.println("2. HNU Entertainment의 연예관계자 코드, 이름, 관리자, 급여를 검색하시오.");
//            employeeResults = entertainmentService.getEmployee();
//            employeeResults.forEach(employee ->
//                            System.out.println("[연에관계자 코드]" + employee.getEmpCode() + " || [이름] " + employee.getEmpName()
//                                    + " || [관리자] " + employee.getEmpMgt() + " || [급여] " + employee.getEmpSal())
//                    );
//            System.out.println(employeeResults);
//            System.out.println();


//             System.out.println("3. HNU Entertainment에서 제작한 드라마의 코드와 이름을 검색하시오.");
//             dramaResults = entertainmentService.getDramaPrd("HNU-E");
//             dramaResults.forEach(drama ->
//                        System.out.println("[드라마 코드]" + drama.getDrmCode() + " || [이름] " + drama.getDrmName()
//                                + " || [제작사] " + drama.getDrmPrd())
//                    );
//             System.out.println();


//             System.out.println("4. 드라마 방영사가 KBC이거나 SBC인 드라마를 검색하시오.");
//            dramaResults = entertainmentService.getDramaBrd("KBC", "SBC");
//            dramaResults.forEach(drama ->
//                System.out.println("[드라마 코드]" + drama.getDrmCode() + " || [이름] " + drama.getDrmName())
//            );
//            System.out.println();


//             System.out.println("5. 드라마 제작사를 검색하시오. 단, 중복된 값이 있으면 제거하시오.");
//             dramaResults = entertainmentService.getDramaPrd2();
//             dramaResults.forEach(drama ->
//                     System.out.println("[제작사] " + drama.getDrmCode()));
//             System.out.println();


//             System.out.println("6. 연예관계자들의 급여의 총합과 평균 급여액을 계산하시오.");
//             employeeResult = entertainmentService.getEmployeeSal();
//             System.out.println("[총합] " + employeeResult.getSalSum() + "|| [평균] " + employeeResult.getSalAvg());
//             System.out.println();


//             System.out.println("7. 방영일자가 아직 확정되지 않은 드라마의 이름을 검색하시오.");
//             dramaResults = entertainmentService.getDramaNoOpdate();
//             dramaResults.forEach(drama ->
//                    System.out.println("[드라마 이름] " + drama.getDrmName()));
//             System.out.println();


//             System.out.println("8. 연예관계자에 대해 연예관계자의 이름과 직속 상사의 이름을 검색하시오.");
//             employeeResults = entertainmentService.getEmployeeMgt();
//             employeeResults.forEach(employee -> {
//                 System.out.println("[연예관계자 이름] " + employee.getEmpName() + " || [직속상사 이름] " + employee.getEmpMgtName());
//             });
//             System.out.println();


//             System.out.println("9. 연예관계자에 대해 이름과 급여를 출력하고, 급여의 내림차순으로 정렬하시오.");
//             employeeResults = entertainmentService.getEmployeeSal2();
//             employeeResults.forEach(employee -> {
//                 System.out.println("[연예관계자 이름] " + employee.getEmpName() + " || [급여] " + employee.getEmpSal());
//             });
//             System.out.println();

//                 System.out.println("10. 모든 연예관계자를 직급별로 그룹화하고, 평균 급여액이 5000 이상인 직급에 대해 연예 관계자의 직급, 평균 급여액, 최소 급여액, 최대 급여액을 검색하시오");
//                 employeeResults = entertainmentService.getEmployeeGroup();
//                 employeeResults.forEach(employee -> {
//                 System.out.println("[연예관계자 이름] " + employee.getEmpName() + " || [Avg] " + employee.getSalAvg() + " || [Min] "
//                         + employee.getSalMin() + " || [Max] " + employee.getSalMax());
//             });
//                 System.out.println();

                // 미해결
//             System.out.println("11. 모든 연예관계자의 평균 급여액보다 많은 급여를 받는 연예관계자의 이름과 급여를 검색하라.");
//             employeeResults = entertainmentService.getEmployeeSal2();
//             employeeResults.forEach(employee -> {
//                 System.out.println("[연예관계자 이름] " + employee.getEmpName() + " || [급여] " + employee.getEmpSal());
//             });
//             System.out.println();


//             System.out.println("12. 방영일자가 확정되지 않은 드라마의 방영일자가 2013-05-01로 편성되었습니다. 알맞게 변경하시오.");
//             resultCount = entertainmentService.updateDramaDate("2013-05-01");
//             System.out.println(resultCount + "건이 변경되었습니다.");
//             System.out.println();


//             System.out.println("13. 연예관계자 김수현 씨가 대리에서 실장으로 승진하고 급여가 20% 증가되었습니다. 알맞게 변경하시오.");
//             resultCount = entertainmentService.updateEmployee();
//             System.out.println(resultCount + "건이 변경되었습니다.");
//             System.out.println();


//             System.out.println("14. 우리 회사에 한 명의 임원이 등록되었습니다. 코드는 E903, 이름은 손진현, 관리자는 E901, 급여는 4000입니다. 알맞게 등록하시오.");
//             resultCount = entertainmentService.insertEmployee("E903", "손진현", "E901", 4000, "R001");
//             System.out.println(resultCount + "건이 등록되었습니다.");
//             System.out.println();


//             System.out.println("15. 연예관계자인 손진현님이 퇴직했습니다. 연예관계자 목록에서 제거하시오.");
//             resultCount = entertainmentService.deleteEmployee("손진현");
//             System.out.println(resultCount + "건이 삭제되었습니다.");
//             System.out.println();




    }
}
