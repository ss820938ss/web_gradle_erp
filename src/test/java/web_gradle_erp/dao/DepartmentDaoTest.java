package web_gradle_erp.dao;

import java.sql.Connection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import web_gradle_erp.JdbcUtil;
import web_gradle_erp.dao.impl.DepartmentDaoImpl;
import web_gradle_erp.dto.Department;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentDaoTest {
	private static Connection con;
	private static DepartmentDaoImpl dao = DepartmentDaoImpl.getInstance();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		con = JdbcUtil.getConnection();
		dao.setCon(con);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		con.close();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectDepartmentByAll() {
		System.out.printf("%s()%n", "testSelectDepartmentByAll");
		List<Department> list = dao.selectDepartmentByAll();
		Assert.assertNotNull(list);
		list.parallelStream().forEach(System.out::println);
	}

	@Test
	public void test04SelectDepartmentByNo() {
		System.out.printf("%s()%n", "testSelectDepartmentByNo");
		Department dept = new Department(1);
		Department searchDept = dao.selectDepartmentByNo(dept);
		Assert.assertNotNull(searchDept);
		System.out.println(searchDept);
	}

	@Test
	public void test02InsertDepartment() {
		System.out.printf("%s()%n", "testInsertDepartment");
		Department dept = new Department(5, "임시", 10);
		int res = dao.insertDepartment(dept);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectDepartmentByNo(dept));
	}

	@Test
	public void test03UpdateDepartment() {
		System.out.printf("%s()%n", "testUpdateDepartment");
		Department dept = new Department(5, "임시2", 15);
		int res = dao.updateDepartment(dept);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectDepartmentByNo(dept));
	}

	@Test
	public void test05DeleteDepartment() {
		System.out.printf("%s()%n", "testDeleteDepartment");
		Department dept = new Department(5);
		int res = dao.deleteDepartment(dept);
		Assert.assertEquals(1, res);
		dao.selectDepartmentByAll().parallelStream().forEach(System.out::println);
	}

}