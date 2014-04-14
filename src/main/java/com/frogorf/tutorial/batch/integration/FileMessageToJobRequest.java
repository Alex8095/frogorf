/**
 * 
 */
package com.frogorf.tutorial.batch.integration;

import java.io.File;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.integration.launch.JobLaunchRequest;
import org.springframework.integration.Message;
import org.springframework.integration.annotation.Transformer;

/** @author Tsurkin Alex
 * @version */
public class FileMessageToJobRequest {

	private Job job;
	private String fileParameterName;

	/** @param job the job to set */
	public void setJob(Job job) {
		this.job = job;
	}

	/** @param fileParameterName the fileParameterName to set */
	public void setFileParameterName(String fileParameterName) {
		this.fileParameterName = fileParameterName;
	}

	@Transformer
	public JobLaunchRequest toRequest(Message<File> message) {
		JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
		jobParametersBuilder.addString(fileParameterName, message.getPayload().getAbsolutePath());
		return new JobLaunchRequest(job, jobParametersBuilder.toJobParameters());
	}
}
