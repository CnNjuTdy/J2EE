package com.ejb.factory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

public class EJBFactory {
	public static Object getEJB(String beanName2,String viewClassName2) {
		final String appName = "";
		final String moduleName = "EJBTest_war_exploded";
		final String distinctName = "";
		final String beanName = beanName2;
		final String viewClassName = viewClassName2;
		final String namespace = "ejb:" + appName + "/" + moduleName
				+ "/" + distinctName + "/" + beanName + "!" + viewClassName;
		try {
			final Hashtable<String, Object> jndiProps = new Hashtable<String, Object>();
			jndiProps.put("jboss.naming.client.ejb.context", true);
			jndiProps.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			final Context context = new InitialContext(jndiProps);
			return context.lookup(namespace);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
