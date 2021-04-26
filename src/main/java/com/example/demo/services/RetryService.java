/**
 * 
 */
package com.example.demo.services;

import java.sql.SQLException;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @author aim
 *
 */
@Service
public interface RetryService {

	@Retryable(value = SQLException.class, maxAttempts = 2, backoff = @Backoff(delay = 10000))
	void retryService(String sql) throws SQLException;

	@Recover
	void recover(SQLException e, String sql);
}
