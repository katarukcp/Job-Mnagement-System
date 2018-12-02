package com.job.request;

import com.job.constants.JobType;

/**
 * 
 * @author Surendra
 *
 */
public class EmailRequest extends JobRequest {
	private String toAddress;
	private String subject;
	private String body;

	public EmailRequest(String toAddress, String subject, String body,long executionTime) {
		super(JobType.EMAIL, executionTime);
		this.toAddress = toAddress;
		this.subject = subject;
		this.body = body;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
