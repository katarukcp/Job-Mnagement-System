package com.job;

import com.job.constants.JobState;
import com.job.constants.JobType;

/**
 * Contract interface
 * @author Surendra
 *
 */
public interface Job {
	public void execute();

	public void setJobState(JobState jobState);

	public JobState getJobState();

	public long getExecutionTime();

	public JobType getJobType();

}
