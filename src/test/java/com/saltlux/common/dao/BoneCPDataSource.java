package com.saltlux.common.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

@Component
public class BoneCPDataSource {

	@Autowired
	DataSource dataSource;
	
	private Object connectionHandle = "ConnectionHandle{url=jdbc:postgresql://127.0.0.1:5432/spring-archetype, user=postgres, debugHandle=null, lastResetAgoInSec=0, lastUsedAgoInSec=0, creationTimeAgoInSec=0}";
	
	@Test
	public void testBoneCPCManual() {
		
		try {
			Class.forName("org.postgresql.Driver"); // load the DB driver
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		
		BoneCPConfig config = new BoneCPConfig();								// create a new configuration object
	 	config.setJdbcUrl("jdbc:postgresql://127.0.0.1:5432/spring-archetype");	// set the JDBC url
		config.setUsername("postgres");												// set the username
		config.setPassword("admin");											// set the password
		
		BoneCP connectionPool = null;
		Connection connection = null;

		try {
			connectionPool = new BoneCP(config);			// setup the connection pool
			connection = connectionPool.getConnection();	// fetch a connection
			
			assertEquals(connection, connectionHandle);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}					// close the connection
			
			connectionPool.shutdown();			// close the connection pool
		}
	}
	
	@Test
	public void testBoneCPConfig() {
		
		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
			
			assertEquals(connection, connectionHandle);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	}
}
