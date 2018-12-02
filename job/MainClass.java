package com.job;

import java.util.ArrayList;
import java.util.List;

import com.job.factory.JobFactory;
import com.job.request.DWHRequest;
import com.job.request.EmailRequest;
import com.job.service.JobManager;

/**
 * Main class from where JobManafer gets triggered
 * 
 * @author Surendra
 *
 */
public class MainClass {
	public static void main(String[] args) throws InterruptedException {
		List<Job> jobsList = new ArrayList<>();

		// This is a scheduled email job with the delay of 1 minute
		EmailRequest emailJobRequest = buildEmailJob("scheduled@gmail.com", "Scheduled Payment", "Payment notification",
				1 * 60 * 1000);
		jobsList.add(JobFactory.create(emailJobRequest));

		// This is an immediate email job
		emailJobRequest = buildEmailJob("immediate@gmail.com", "Immediate Payment", "Payment notification", 0);
		jobsList.add(JobFactory.create(emailJobRequest));

		// This is an immediate dwh job
		DWHRequest dwhJobReuquest = buildDWHJobRequest("slave1", "10.192.192.192", 0);
		jobsList.add(JobFactory.create(dwhJobReuquest));

		JobManager.getInstance().processJobs(jobsList);

	}

	private static DWHRequest buildDWHJobRequest(String dbName, String host, int delay) {
		long scheduledTime = getScheduleTime(delay);
		DWHRequest dwhRequest = new DWHRequest(dbName, host, scheduledTime);
		return dwhRequest;
	}

	private static EmailRequest buildEmailJob(String toAddress, String subject, String body, int delay) {
		long executionTime = getScheduleTime(delay);
		EmailRequest emailJobRequest = new EmailRequest(toAddress, subject, body, executionTime);
		return emailJobRequest;
	}

	private static long getScheduleTime(int delay) {
		if (delay <= 0) {
			return 0;
		}
		return System.currentTimeMillis() + delay;
	}

}
