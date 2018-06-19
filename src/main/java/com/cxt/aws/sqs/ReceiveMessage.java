/**
 * 
 */
package com.cxt.aws.sqs;

import java.util.List;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;

/**
 * @author Abhimanyu
 *
 */
public class ReceiveMessage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		AmazonSQS sqs = new AwsSqsConfig().connection();

		String queueUrl = sqs.getQueueUrl(Queue.LI_Job_End.getQueue()).getQueueUrl();

		// receive messages from the queue
		List<Message> messages = sqs.receiveMessage(queueUrl).getMessages();

		for (Message m : messages) {
			System.out.println("Received Message : " + m.getBody());
			sqs.deleteMessage(queueUrl, m.getReceiptHandle());
			System.out.println("Message Deleted From Queue.....");
		}
	}

}
