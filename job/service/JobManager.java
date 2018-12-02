package com.job.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.job.Job;
import com.job.JobLogger;
import com.job.constants.JobType;
import com.job.local.PriorityJob;

/**
 * This class does all the jobs execution including scheduled and immediate
 * jobs.
 * 
 */
public class JobManager {
	static Logger logger = JobLogger.getInstance();
	private static JobManager instance;
	private Map<JobType, Integer> jobConfig;
	private PriorityBlockingQueue<PriorityJob> priorityJobQueue;

	/**
	 * This method creates the instance for JobManager
	 */
	public static JobManager getInstance() {
		if (instance == null) {
			synchronized (JobManager.class) {
				if (instance == null) {
					instance = new JobManager();
					instance.jobConfig = getJobPriorityConfig();
				}
			}
		}
		return instance;
	}

	private static Map<JobType, Integer> getJobPriorityConfig() {
		Map<JobType, Integer> priorities = new HashMap<>();
		priorities.put(JobType.EMAIL, 1); // Value is job priority, which can be read either from database or from
											// properties file.
		priorities.put(JobType.DWH, 2);
		priorities.forEach((key, value) -> logger.info("Job Name:: " + key + " Job Priority:: " + value));
		return priorities;
	}

	/**
	 * This method takes the all the jobs as argument and do the processing
	 * 
	 * @param jobs
	 */
	public void processJobs(List<Job> jobs) {
		List<PriorityJob> priorityJobs = jobs.stream().map(job -> transformAsPriorityJob(job, jobConfig))
				.collect(Collectors.toList());
		priorityJobQueue = new PriorityBlockingQueue<>(priorityJobs);

		Timer timer = new Timer();
		priorityJobQueue.stream().forEach(priorityJob -> {
			Job job = priorityJob.getJob();
			logger.info(
					"Job Type is:: " + job.getJobType().name() + " job execution time is " + job.getExecutionTime());
			TimerTaskExecution timerTask = new TimerTaskExecution(job);
			long delay = 0;
			long currentTimeMillis = System.currentTimeMillis();
			if (job.getExecutionTime() > currentTimeMillis) {
				delay = job.getExecutionTime() - currentTimeMillis;
			}
			if (delay <= 0) {
				delay = 0;
			}
			timer.schedule(timerTask, delay);
		});
	}

	private PriorityJob transformAsPriorityJob(Job job, Map<JobType, Integer> jobConfig) {
		Integer priority = jobConfig.get(job.getJobType());
		return new PriorityJob(priority, job);
	}

}
