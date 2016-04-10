package com.newtouch.demo;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg0 = new Configuration().configure();
		SchemaExport sx = new SchemaExport(cfg0);
		sx.create(true, true);

	}

}
