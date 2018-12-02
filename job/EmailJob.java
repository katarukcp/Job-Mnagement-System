package com.job;

import java.util.logging.Logger;

import com.job.constants.JobState;
import com.job.constants.JobType;
import com.job.request.EmailRequest;
import com.job.request.JobRequest;

/**
 * Does the email sending
 * 
 **/
public class EmailJob implements Job {
	Logger logger = JobLogger.getInstance();
	EmailRequest emailJobRequest;
	JobState jobState;

	public EmailJob(JobRequest emailJoobRequest) {
		this.emailJobRequest = (EmailRequest) emailJoobRequest;
	}

	@Override
	public void execute() {
		logger.info("JobState:: " + getJobState() + " Job Name:: " + emailJobRequest.getJobType().name()
				+ " isaScheduled job:: " + emailJobRequest.getSubject());
		logger.info("Sending  " + emailJobRequest.getSubject() + " email to" + emailJobRequest.getToAddress());
	}

	public JobState getJobState() {
		return jobState;
	}

	public void setJobState(JobState jobState) {
		this.jobState = jobState;
	}

	@Override
	public long getExecutionTime() {
		return emailJobRequest.getExecutionTime();
	}

	@Override
	public JobType getJobType() {
		return emailJobRequest.getJobType();
	}
}
