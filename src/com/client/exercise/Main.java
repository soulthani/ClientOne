package com.client.exercise;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.common.interfaces.ILogin;
import com.common.interfaces.IMathAction;
import com.common.interfaces.ISession;

public class Main {
	
	private static final Logger log = Logger.getLogger(Main.class);
	private static ILogin login;
	private static ClassPathXmlApplicationContext context;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 try {
		      context = new ClassPathXmlApplicationContext("/com/client/xml/server-connection.xml");
		      login = (ILogin) context.getBean("loginServiceRMI");
		      ISession session = login.login("sultan", "ganteng");
		      IMathAction mathAct = (IMathAction)session.getActionByName("MathAction");
		      log.info(mathAct.add(5, 9));
		      log.info(mathAct.substract(8, 3));

		    } catch (BeansException e) {
		    	e.printStackTrace();
		    } catch (RuntimeException e) {
		    	e.printStackTrace();
		    } 

	}

}
