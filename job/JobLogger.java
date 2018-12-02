package com.job;

import java.util.logging.Logger;

import com.job.service.JobManager;

public class JobLogger {
	private static Logger logger = null;

	public static Logger getInstance() {
		if (logger == null) {
			synchronized (JobManager.class) {
				if (logger == null) {
					logger = Logger.getLogger("JobLogger");
				}
			}
		}
		return logger;
	}
}
