package com.job.service;

import java.util.TimerTask;
import java.util.logging.Logger;

import com.job.Job;
import com.job.JobLogger;
import com.job.constants.JobState;

/**
 * This class triggers the respective Jobs based on the job.
 * 
 * @author Surendra
 *
 */
public class TimerTaskExecution extends TimerTask {
	static Logger logger = JobLogger.getInstance();
	Job job;

	public TimerTaskExecution(Job job) {
		this.job = job;
	}

	/**
	 * This method invokes the respective job
	 */
	@Override
	public void run() {
		job.setJobState(JobState.QUEUED);
		logger.info("Job State :: " + job.getJobState());
		try {
			job.execute();
			logger.info("Completed Job is "+job.getJobType().name());
		} catch (Exception e) {
			job.setJobState(JobState.FAILED);
			logger.severe("Job State :: " + job.getJobState());
			return;
		}
		job.setJobState(JobState.SUCCESS);
		logger.info("Final Job State :: " + job.getJobState());
	}
}
