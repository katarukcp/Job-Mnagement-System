package com.job;

import java.util.logging.Logger;

import com.job.constants.JobState;
import com.job.constants.JobType;
import com.job.request.DWHRequest;
import com.job.request.JobRequest;

// This class does the Data warehousing related job
public class DWHJob implements Job {
	Logger logger = JobLogger.getInstance();
	DWHRequest dwhJobRequest;
	JobState jobState;

	public DWHJob(JobRequest dwhJobRequest) {
		this.dwhJobRequest = (DWHRequest) dwhJobRequest;
	}

	/**
	 * This method is responsible for doing the data ware housing realted tasks
	 */
	@Override
	public void execute() {
		logger.info(" db name :: " + dwhJobRequest.getDbName() + " and db host:: " + dwhJobRequest.getHost());
		logger.info("JobState:: " + getJobState() + " Job Name:: " + dwhJobRequest.getJobType().name());
	}

	public JobState getJobState() {
		return jobState;
	}

	public void setJobState(JobState jobState) {
		this.jobState = jobState;
	}

	@Override
	public long getExecutionTime() {
		return dwhJobRequest.getExecutionTime();
	}

	@Override
	public JobType getJobType() {
		return dwhJobRequest.getJobType();
	}

}
