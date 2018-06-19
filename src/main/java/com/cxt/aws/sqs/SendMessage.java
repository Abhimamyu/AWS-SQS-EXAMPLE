/**
 * 
 */
package com.cxt.aws.sqs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;

/**
 * @author Abhimanyu
 *
 */
public class SendMessage {

	private static final String MESSAGE = "hello aws from me";
	private static final String messageGroupId = "1";
	private static final String messageDeduplicationId = "hi";

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		AmazonSQS sqs = new AwsSqsConfig().connection();

		String queueUrl = sqs.getQueueUrl(Queue.LI_Job_End.getQueue()).getQueueUrl();

		SendMessageRequest send_msg_request = new SendMessageRequest().withQueueUrl(queueUrl).withMessageBody(MESSAGE)
				.withMessageGroupId(messageGroupId).withMessageDeduplicationId(messageDeduplicationId);
		sqs.sendMessage(send_msg_request);
		System.out.println("Message sent :" + MESSAGE);

	}

}
