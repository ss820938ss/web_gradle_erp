  
package web_gradle_erp.dao;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import web_gradle_erp.JdbcUtil;
import web_gradle_erp.dao.impl.EmployeeDaoImpl;
import web_gradle_erp.dto.Department;
import web_gradle_erp.dto.Employee;
import web_gradle_erp.dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDaoTest {
	private static Connection con;
	private static EmployeeDaoImpl dao = EmployeeDaoImpl.getInstance();

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
	public void test01SelectEmployeeByAll() {
		System.out.printf("%s()%n", "testSelectEmployeeByAll");
		List<Employee> list = dao.selectEmployeeByAll();
		Assert.assertNotNull(list);
		list.parallelStream().forEach(System.out::println);
	}

	@Test
	public void test04SelectEmployeeByNo() {
		System.out.printf("%s()%n", "testSelectEmployeeByNo");
		Employee emp = new Employee(1003);
		Employee searchEmp = dao.selectEmployeeByNo(emp);
		Assert.assertNotNull(searchEmp);
		System.out.println(searchEmp);
	}

	@Test
	public void test02InsertEmployee() {
		System.out.printf("%s()%n", "testInsertEmployee");
		Employee emp = new Employee(
				1004, "김김김", new Title(5), 
				new Employee(1443), 13131313, 
				new Department(1), new Date());
		int res = dao.insertEmployee(emp);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectEmployeeByNo(emp));
	}

	@Test
	public void test03UpdateEmployee() {
		System.out.printf("%s()%n", "testUpdateEmployee");
		Employee emp = new Employee(
				1004, "김김김", new Title(4), 
				new Employee(1122), 13131313, 
				new Department(1), new Date());
		int res = dao.updateEmployee(emp);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectEmployeeByNo(emp));
	}

	@Test
	public void test05DeleteEmployee() {
		System.out.printf("%s()%n", "testDeleteEmployee");
		Employee emp = new Employee(1004);
		int res = dao.deleteEmployee(emp);
		Assert.assertEquals(1, res);
		dao.selectEmployeeByAll().parallelStream().forEach(System.out::println);
	}

}