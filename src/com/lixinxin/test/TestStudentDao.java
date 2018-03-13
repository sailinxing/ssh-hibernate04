package com.lixinxin.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lixinxin.dao.StudentDao;
import com.lixinxin.model.Student;

public class TestStudentDao {
	private StudentDao sdao;

	@Before
	public void init() {
		sdao = new StudentDao();
	}
	@Test
	public void TestSelectByAll(){
		List<Student> list =sdao.selectAll();
		System.out.println(list);
	}
	@Test
	public void TestSelectByAll1(){
		sdao.selectAll1();
	}
	@Test
	public void TestSelectByName(){
		Student student = sdao.selectByName("jack");
		System.out.println(student);
	}
	@Test
	public void TestSelectByInnerJoin(){
		List<Student> list = sdao.selectByInnerJoin("JAVASE");
		System.out.println(list);
	}
	@Test
	public void TestSelectByInnerJoin1(){
		List<Object[]> list = sdao.selectByInnerJoin1("JAVASE");
		for(Object[] objs:list){
			for(Object obj:objs){
			System.out.println(obj);
			}
		}
	}
	@Test
	public void TestSelectByLeftJoin(){
		List<Object[]> list = sdao.selectByLeftJoin("JAVASE");
		for(Object[] objs:list){
			for(Object obj:objs){
			System.out.println(obj);
			}
		}
	}
	@Test
	public void TestSelectByRightJoin(){
		List<Object[]> list = sdao.selectByRightJoin("JAVASE");
		for(Object[] objs:list){
			for(Object obj:objs){
			System.out.println(obj);
			}
		}
	}
	@Test
	public void TestSelectByLeftJoin1(){
		List<Object[]> list = sdao.selectByLeftJoin1("JAVASE");
		for(Object[] objs:list){
			System.out.println("---------");
			for(Object obj:objs){
			System.out.println(obj);
			}
			System.out.println("----------");
		}
	}
	@Test
	public void TestSelectBySubselect(){
		List<Student> list = sdao.selectBySubselect("JAVASE", "JAVAWEB");
		System.out.println(list);
	}
	@Test
	public void TestSelectByProjection(){
		List<Object[]> list = sdao.selectByProjection();
		for(Object[] objs:list){
			for(Object obj:objs){
			System.out.print(obj+",");
			}
			System.out.println();
		}
	}
	@Test
	public void TestSelectByProjection1(){
		List<Student> list = sdao.selectByProjection1();
		
			System.out.print(list);
	
	}
	@Test
	public void TestSelectByProjection2(){
		List<Object> list = sdao.selectByProjection2();
		for(Object obj:list){
			System.out.println(obj);
		}
	}
	@Test
	public void TestSelectBySql(){
		List<Object[]> list = sdao.selectBySql();	
		for(Object[] objs:list){
			for(Object obj:objs){
			System.out.print(obj+":");
			}
			System.out.println();
		}
		
	}
	@Test
	public void TestSelectByPage(){
		List<Student> list = sdao.selectByPage(0, 5);		
			System.out.print(list);	
	}
	@Test
	public void TestSelectByCount(){
		Object[] res = sdao.selectByCount();		
		for(Object obj:res){
			System.out.println(obj);
		}
	}
	@Test
	public void TestSelectByCountGroup(){
		List<Object[]> list = sdao.selectByGroup();		
		for(Object[] objs:list){
			for(Object obj:objs){
				System.out.print(obj+":");
			}
			System.out.println();
		}
	}
}
