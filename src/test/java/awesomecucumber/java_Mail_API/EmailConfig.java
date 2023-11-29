
package awesomecucumber.java_Mail_API;

import static awesomecucumber.constants.FrameworkConstants.PROJECT_NAME;

/**
 * Data for Sending EMail after execution
 * To set gmail account setting see https://www.youtube.com/watch?v=moBfKA1fE0g
 */
public class EmailConfig {

	public static final String SERVER = "smtp.gmail.com";
	public static final String PORT = "587";

	public static final String FROM = "automation.mail127@gmail.com";
	public static final String PASSWORD = "emwx qotk mlfk srpl";  //"Welcome@123";

	/* "**********@gmail.com", */
	public static final String[] TO = {"abhinavagarwal9@gmail.com","abhinav.agarwal1981@gmail.com","automation.mail127@gmail.com"};
	public static final String SUBJECT = PROJECT_NAME;
}