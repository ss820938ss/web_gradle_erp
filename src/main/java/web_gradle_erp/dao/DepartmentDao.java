package web_gradle_erp.dao;

import java.util.List;

import web_gradle_erp.dto.Department;

public interface DepartmentDao {
	List<Department> selectDepartmentByAll();
	Department selectDepartmentByNo(Department department);
	int insertDepartment(Department department);
	int updateDepartment(Department department);
	int deleteDepartment(Department department);
}