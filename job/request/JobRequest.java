package com.job.request;

import com.job.constants.JobType;

/**
 * Class which abstracts the job requests 
 * @author Surendra
 *
 */
public class JobRequest {
	private JobType jobType;
	private long executionTime;

	public JobRequest(JobType jobType, long executionTime) {
		this.jobType = jobType;
		this.executionTime = executionTime;
	}

	public long getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(long executionTime) {
		this.executionTime = executionTime;
	}

	public JobType getJobType() {
		return jobType;
	}

	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}

}
