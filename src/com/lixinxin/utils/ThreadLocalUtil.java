package com.lixinxin.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ThreadLocalUtil {
private static final ThreadLocal<Session> tl=new ThreadLocal<>();
private static Configuration configuration;
private static SessionFactory sessionFactory;
static{
	configuration=new Configuration().configure();
	sessionFactory=configuration.buildSessionFactory();
}
public static Session findCurrentSession(){
	Session session = tl.get();
	if(session==null){
		session= sessionFactory.openSession();
		tl.set(session);
	}
	return session;
}
public static void closeSession(){
	Session session = tl.get();
	tl.set(null);
	session.close();
}
}
