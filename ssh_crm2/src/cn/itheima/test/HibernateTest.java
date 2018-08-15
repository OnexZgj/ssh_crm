package cn.itheima.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itheima.dao.UserDao;
import cn.itheima.domain.User;
import cn.itheima.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {
	
	@Resource(name="sessionFactory")
	private SessionFactory sf;
	
	
	@Test
	public void fun2(){

		
		Session session = sf.openSession();
		
		Transaction transaction = session.beginTransaction();
		//--------------------------
		
		User u=new User();
		u.setUser_code("12233");
		u.setUser_name("jerry");
		u.setUser_password("122342");
		session.save(u);
		
		//--------------------------
		transaction.commit();
		session.close();
	}
	
	
	@Resource(name="userDao")
	private UserDao ud;
	
	@Test
	public void fun3(){
		
		User byUserCode = ud.getByUserCode("123");
		System.out.println(byUserCode);
		
	}
	
	
	@Resource(name="userService")
	private UserService service;
	
	@Test
	public void fun4(){
		User u=new User();
		u.setUser_code("123");
		u.setUser_name("jery");
		u.setUser_password("1242");
		 service.saveUser(u);
	}
	
	
	

	

	@Test
	public void fun1(){
		Configuration configure = new Configuration().configure();
		SessionFactory sf = configure.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction transaction = session.beginTransaction();
		//--------------------------
		 
		User u=new User();
		u.setUser_code("123");
		u.setUser_name("tom");
		u.setUser_password("122342");
		session.save(u);
		
		//--------------------------
		transaction.commit();
		session.close();
		sf.close(); 
	}
	
	
	

}
