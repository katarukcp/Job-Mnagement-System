package com.job.factory;

import java.util.logging.Logger;

import com.job.DWHJob;
import com.job.EmailJob;
import com.job.Job;
import com.job.JobLogger;
import com.job.constants.JobType;
import com.job.request.JobRequest;

/**
 * Factory class for Job Type objects
 * 
 * @author Surendra
 *
 */
public class JobFactory {
	static Logger logger = JobLogger.getInstance();

	/**
	 * This method creates and returns the respective job type based on the
	 * jobrequest
	 * 
	 * @param jobRequest
	 * @return
	 */
	public static Job create(JobRequest jobRequest) {
		logger.info("Job Type:: "+jobRequest.getJobType().name());
		if (jobRequest.getJobType() == JobType.EMAIL) {
			return new EmailJob(jobRequest);
		} else if (jobRequest.getJobType() == JobType.DWH) {
			return new DWHJob(jobRequest);
		}
		return null;
	}
}
