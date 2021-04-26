/**
 * 
 */
package com.example.demo.services;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author aim
 *
 */
@Service
public class RetryServiceImpl implements RetryService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(RetryServiceImpl.class);

	@Override
	public void retryService(String sql) throws SQLException {
		// TODO Auto-generated method stub
		if(sql.equals("test")) {
			throw new SQLException();
		}
	}

	@Override
	public void recover(SQLException e, String sql) {
		LOGGER.error("====================================================>");
		LOGGER.error("sql exception encoutered, recover method called. Rarams: => "+sql);
		
	}

}
