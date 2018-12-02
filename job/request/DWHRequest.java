package com.job.request;

import com.job.constants.JobType;

/**
 * @author Surendra
 *
 */
public class DWHRequest extends JobRequest {
	private String dbName;
	private String host;

	public DWHRequest(String dbName, String host, long executionTime) {
		super(JobType.DWH, executionTime);
		this.dbName = dbName;
		this.host = host;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
}
