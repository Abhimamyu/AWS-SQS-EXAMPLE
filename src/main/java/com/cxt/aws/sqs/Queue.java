/**
 * 
 */
package com.cxt.aws.sqs;

/**
 * @author Abhimanyu
 *
 */
public enum Queue {

	LI_Job_End("LIJobEnd.fifo");

	private String queue;

	Queue(String queue) {
		this.queue = queue;
	}

	public String getQueue() {
		return queue;
	}
}
