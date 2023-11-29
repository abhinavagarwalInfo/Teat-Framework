
package awesomecucumber.utils;

import static awesomecucumber.constants.FrameworkConstants.*;
import static awesomecucumber.hooks.MyHooks.*;
import static awesomecucumber.java_Mail_API.EmailConfig.FROM;
import static awesomecucumber.java_Mail_API.EmailConfig.PASSWORD;
import static awesomecucumber.java_Mail_API.EmailConfig.PORT;
import static awesomecucumber.java_Mail_API.EmailConfig.SERVER;
import static awesomecucumber.java_Mail_API.EmailConfig.SUBJECT;
import static awesomecucumber.java_Mail_API.EmailConfig.TO;

import javax.mail.MessagingException;
import awesomecucumber.java_Mail_API.EmailAttachmentsSender;

public class EmailSendUtils {

	/**
	 * sendEmail_WithAttachmentsAndFormattedBodyText_ToManyUsersRajat
	 */
	public static void sendEmail() {
		System.out.println("Email send - START");
		System.out.println("****************************************");

		if (ConfigLoader.getInstance().getSendEmailToUsers().equalsIgnoreCase(NO)) {
			System.out.println("File name: " + REPORTS_CUCUMBER_LOCAL);
			String messageBody = getTestCasesCountInFormat();
			System.out.println(messageBody);

			try {
				EmailAttachmentsSender.sendEmailWithAttachments(SERVER, PORT, FROM, PASSWORD, TO, SUBJECT, messageBody,
						REPORTS_CUCUMBER_LOCAL);
				System.out.println("Email sent successfully.");
				System.out.println("****************************************");
			} catch (MessagingException e) {
				e.printStackTrace();
				System.out.println("Email not sent.");
				System.out.println("****************************************");
			}
		}
	}

	private static String getTestCasesCountInFormat() {

		return "<html>\r\n" + "\r\n" + " \r\n" + "\r\n"
				+ "        <body> \r\n<table class=\"container\" align=\"center\" style=\"padding-top:20px\">\r\n<tr align=\"center\"><td colspan=\"4\"><h2>"
				+ PROJECT_NAME + "</h2></td></tr>\r\n<tr><td>\r\n\r\n"
				+ "       <table style=\"background:#67c2ef;width:120px\" >\r\n"
				+ "                     <tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">"
				+ "</td></tr>\r\n" + "                     <tr><td align=\"center\">Total : " + Total_Scenarios + "</td></tr>\r\n" + "       \r\n"
				+ "                </table>\r\n" + "                </td>\r\n" + "                <td>\r\n"
				+ "               \r\n" + "                 <table style=\"background:#79c447;width:120px\">\r\n"
				+ "                     <tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">"
				+ "</td></tr>\r\n" + "                     <tr><td align=\"center\">Passed : " +  passedtests.size() + "</td></tr>\r\n"
				+ "       \r\n" + "                </table>\r\n" + "                </td>\r\n"
				+ "                <td>\r\n" + "                <table style=\"background:#ff5454;width:120px\">\r\n"
				+ "                     <tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">"
				+ "</td></tr>\r\n" + "                     <tr><td align=\"center\">Failed : " + failedtests.size() + "</td></tr>\r\n"
				+ "       \r\n" + "                </table>\r\n" + "                \r\n" + "                </td>\r\n"
				+ "                <td>\r\n" + "                <table style=\"background:#fabb3d;width:120px\">\r\n"
				+ "                     <tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">"
				+ "</td></tr>\r\n" + "                     <tr><td align=\"center\">Skipped : " + skippedtests.size() + "</td></tr>\r\n"
				+ "       \r\n" + "                </table>\r\n" + "                \r\n" + "                </td>\r\n"
				+ "                </tr>\r\n" + "               \r\n" + "                \r\n"
				+ "            </table>\r\n" + "       \r\n" + "    </body>\r\n" + "</html>";
	}

}
