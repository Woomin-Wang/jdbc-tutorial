package wisoft.entertainment;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/entertainments")
public class EntertainmentController {

    // 객체 생성
    final EntertainmentService service;

    // 생성자
    public EntertainmentController(EntertainmentService service) {
        this.service = service;
    }

    // 부서 전체 조회
    @GetMapping("/departments")
    public List<Department> getDepartments() {
        return service.getDepartments();
    }

    // 연예 관계자 전체 조회
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return service.getEmployees();
    }

    // 특정 드라마 조회
    @GetMapping("/dramas/producers/{drmPrd}")
    public List<Drama> getDramaPrd(@PathVariable final String drmPrd) {
        return service.getDramaPrd(drmPrd);
    }

    // 특정 드라마 방영사 조회
    @GetMapping("/dramas/broadcasters")
    public List<Drama> getDramaBrd(
            @RequestParam("drmBrd1") final String drmBrd1,
            @RequestParam("drmBrd2") final String drmBrd2) {
        return service.getDramaBrd(drmBrd1, drmBrd2);
    }

    // 드라마 제작사 조회 (중복 제거)
    @GetMapping("/dramas/producers")
    public List<Drama> getDramaPrd2() {
        return service.getDramaPrd2();
    }

    // 연예관계자들의 급여의 총합과 평균 급여액 계산 후 조회
    @GetMapping("/employees/salary-summary")
    public Employee getEmployeeSal() {
        return service.getEmployeeSal();
    }

    // 방영일자가 아직 확정되지 않은 드라마 이름을 검색
    @GetMapping("/dramas/no-opdate")
    public List<Drama> getDramaNoOpdate() {
        return service.getDramaNoOpdate();
    }

    // 연예관계자 이름과 직속 상사 이름 조회
    @GetMapping("/employees/managers")
    public List<Employee> getEmployeeMgt() {
        return service.getEmployeeMgt();
    }

    // 연예관계자 이름 급여 (급여 내림차순)
    @GetMapping("/employees/salaries")
    public List<Employee> getEmployeeSal2() {
        return service.getEmployeeSal2();
    }

    // 연예관계자 직급별로 그룹화, (평균 급여액 5000 이상인 직급에 대해)
    @GetMapping("/employees/positions")
    public List<Employee> getEmployeeGroup() {
        return service.getEmployeeGroup();
    }

    // 연예관계자의 평균 급여액보다 많은 급여를 받는 연예관계자의 이름과 급여 검색
    @GetMapping("/employees/above-average")
    public List<Employee> getEmployeeSal3() {
        return service.getEmployeeSal3();
    }

    // 방영일자가 확정되지 않은 드라마의 방영일자를 2013-05-01로 편성
    @PatchMapping("/dramas")
    public String updateDramaDate(@RequestBody Map<String, String> body) {
        String drmOpdate = body.get("drm_opdate");
        final var result = this.service.updateDramaDate(drmOpdate);
        return result + "개의 드라마가 업데이트되었습니다.";
    }

    //연예관계자 김수현 씨가 대리에서 실장으로 승진하고 급여가 20% 증가되었습니다. 알맞게 변경
    @PatchMapping("/employees/promotion")
    public String updateEmployee(){
        final var result = this.service.updateEmployee();
        return result + "명의 학생이 수정되었습니다.";
    }

    //우리 회사에 한 명의 임원이 등록 "코드는 E903, 이름은 손진현, 관리자는 E901, 급여는 4000입니다. 알맞게 등록"
    @PostMapping("/employees/add")
    public String insertEmployee(
            @RequestBody final Employee employee) {
        final var result = this.service.insertEmployee(employee);
        return result + "명의 학생이 등록되었습니다.";
    }

    //연예관계자인 손진현님이 퇴직했습니다. 연예관계자 목록에서 제거
    @DeleteMapping("/employee/delete")
    public String deleteEmployee(
            @RequestBody final Employee employee) {
        final var result = this.service.deleteEmployee(employee.getEmpName());
        return result + "명의 학생이 삭제되었습니다.";
    }













}
