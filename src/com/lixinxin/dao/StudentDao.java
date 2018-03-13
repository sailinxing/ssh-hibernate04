package com.lixinxin.dao;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lixinxin.model.Student;
import com.lixinxin.utils.DBUtils;

public class StudentDao {
	public List<Student> selectAll() {
		Session session = DBUtils.findSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql="from com.lixinxin.model.Student order by sid desc";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Student> list = query.list();
			tx.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return null;
	}
	public List<Student> selectAll1() {
		Session session = DBUtils.findSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql="from com.lixinxin.model.Student";
			Query query = session.createQuery(hql);
		    @SuppressWarnings("rawtypes")
			Iterator it = query.iterate();
		    while(it.hasNext()){
		    	System.out.println(it.next());
		    }
			tx.commit();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return null;
	}
	public Student selectByName(String stuName) {
		Session session = DBUtils.findSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql="from Student where name=:name";
			Query query = session.createQuery(hql);
//			query.setString(0, stuName);
			query.setString("name", stuName);
			Student stu= (Student) query.uniqueResult();
			tx.commit();
			return stu;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return null;
	}
	public List<Student> selectByInnerJoin(String cname) {
		Session session = DBUtils.findSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql="from Student s where s.course.name=?";
			Query query = session.createQuery(hql);
			query.setString(0, cname);
			@SuppressWarnings("unchecked")
			List<Student> list = query.list();
			tx.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return null;
	}
	public List<Object[]> selectByInnerJoin1(String cname) {
		Session session = DBUtils.findSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql="from Student s inner join s.course where s.course.name=?";
			Query query = session.createQuery(hql);
			query.setString(0, cname);
			@SuppressWarnings("unchecked")
			List<Object[]> list = query.list();
			tx.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return null;
	}
	public List<Object[]> selectByLeftJoin(String cname) {
		Session session = DBUtils.findSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql="from Student s left join s.course where s.course.name=?";
			Query query = session.createQuery(hql);
			query.setString(0, cname);
			@SuppressWarnings("unchecked")
			List<Object[]> list = query.list();
			tx.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return null;
	}
	public List<Object[]> selectByLeftJoin1(String cname) {
		Session session = DBUtils.findSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql="from Student s left join s.course with s.course.name=?";
			Query query = session.createQuery(hql);
			query.setString(0, cname);
			@SuppressWarnings("unchecked")
			List<Object[]> list = query.list();
			tx.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return null;
	}
	public List<Object[]> selectByRightJoin(String cname) {
		Session session = DBUtils.findSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql="from Student s right join s.course where s.course.name=?";
			Query query = session.createQuery(hql);
			query.setString(0, cname);
			@SuppressWarnings("unchecked")
			List<Object[]> list = query.list();
			tx.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return null;
	}
	public List<Student> selectBySubselect(String name1,String name2) {
		Session session = DBUtils.findSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql="from Student s where s.course.cid in (select s.course.cid from s.course where s.course.name in(?,?))";
			Query query = session.createQuery(hql);
			query.setString(0, name1);
			query.setString(1, name2);
			@SuppressWarnings("unchecked")
			List<Student> list = query.list();
			tx.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return null;
	}
	public List<Object[]> selectByProjection() {
		Session session = DBUtils.findSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql="select sid,name from Student";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Object[]> list = query.list();
			tx.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return null;
	}
	public List<Student> selectByProjection1() {
		Session session = DBUtils.findSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql="select new Student(sid,name) from Student";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Student> list = query.list();
			tx.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return null;
	}
	public List<Object> selectByProjection2() {
		Session session = DBUtils.findSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql="select new List(sid,name) from Student";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Object> list = query.list();
			tx.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return null;
	}
	public List<Object[]> selectBySql() {
		Session session = DBUtils.findSession();
		Transaction tx = session.beginTransaction();
		try {
			String sql="select * from student";
			Query query = session.createSQLQuery(sql);
			@SuppressWarnings("unchecked")
			List<Object[]> list = query.list();
			tx.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return null;
	}
	public List<Student> selectByPage(Integer f,Integer m) {
		Session session = DBUtils.findSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql="from Student";
			Query query = session.createQuery(hql);
			query.setFirstResult(f);
			query.setMaxResults(m);
			@SuppressWarnings("unchecked")			
			List<Student> list = query.list();
			tx.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return null;
	}
	public Object[] selectByCount() {
		Session session = DBUtils.findSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql="select max(age),avg(age),min(age) from Student";
			Query query = session.createQuery(hql);
			Object[] res = (Object[]) query.uniqueResult();
			tx.commit();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return null;
	}
	public List<Object[]> selectByGroup() {
		Session session = DBUtils.findSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql="select count(sid),s.course.name from Student s group by s.course.cid";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Object[]> list = query.list();
			tx.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return null;
	}
}
