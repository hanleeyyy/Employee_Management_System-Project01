package com.sripal.Generators;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class EmployeeID implements IdentifierGenerator{
	private final String sql="select  EMP_MNGMNT_SEQ.nextval from dual ";
	private final String prefix="Eid_";
	String suffix="";
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
	
		try {
			
			Connection con = session.connection();
			Statement stmt = con.createStatement();
			
			
			
			 ResultSet rs = stmt.executeQuery(sql);
			 
			if( rs.next()) {
				int sql1 = rs.getInt(1);
				suffix = String.valueOf(sql1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return prefix+suffix;
	}
		
	}


