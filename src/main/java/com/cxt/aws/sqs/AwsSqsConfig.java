/**
 * 
 */
package com.cxt.aws.sqs;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

/**
 * @author Abhimanyu
 *
 */
public class AwsSqsConfig {

	public AmazonSQS connection() {
		ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
		credentialsProvider.getCredentials();
		Regions region = Regions.US_EAST_1;
		AmazonSQS sqs = AmazonSQSClientBuilder.standard().withCredentials(credentialsProvider).withRegion(region)
				.build();
		return sqs;
	}
}
