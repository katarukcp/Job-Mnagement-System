package com.job.constants;

import java.util.stream.Stream;

public enum JobPriority {

	EMAIL("Email", 2), DWH("DWH", 1);

	int priority;
	String jobType;

	private JobPriority(String jobType, int priority) {
		this.jobType = jobType;
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public static JobPriority getEnumByJobType(String jobName) {
		return Stream.of(values()).filter(priority -> priority.jobType.equalsIgnoreCase(jobName)).findFirst()
				.orElse(null);
	}
}
