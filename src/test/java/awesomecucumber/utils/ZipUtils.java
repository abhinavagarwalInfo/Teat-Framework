
package awesomecucumber.utils;

import java.io.File;
import static awesomecucumber.constants.FrameworkConstants.REPORTS_CUCUMBER_LOCATION;
import static awesomecucumber.constants.FrameworkConstants.REPORTS_ZIPPED_FILE_NAME;
import org.zeroturnaround.zip.ZipUtil;

public class ZipUtils {

	/*
	 * make Zip file of target/cucumber folder in Project Root folder (Name:
	 * CucumberReports.zip)
	 */
	public static void zip() {
		ZipUtil.pack(new File(REPORTS_CUCUMBER_LOCATION), new File(REPORTS_ZIPPED_FILE_NAME));
		System.out.println("Zipped Cucumber reports successfuly");
	}

	public static void bulkZip(){
		// List of folders to be zipped
		String[] folders = {ALLURE_REPORT_LOCATION, ALLURE_RESULTS_LOCATION};
		// Destination zip file
		String zipFilePath = REPORTS_ZIPPED_FILE_NAME1;

		try {
			// Create a FileOutputStream to write to the zip file
			FileOutputStream fos = new FileOutputStream(zipFilePath);
			ZipOutputStream zipOut = new ZipOutputStream(fos);

			// Loop through each folder and add its contents to the zip file
			for (String folder : folders) {
				File fileToZip = new File(folder);
				zipFolder(fileToZip, fileToZip.getName(), zipOut);
			}
			// Close the ZipOutputStream
			zipOut.close();
			fos.close();

			System.out.println("Folders zipped successfully into a single file.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void zipFolder(File folder, String parentFolder, ZipOutputStream zipOut) throws IOException, IOException {
		if (folder.isDirectory()) {
			// If the file is a directory, recursively add its contents to the zip file
			for (File file : folder.listFiles()) {
				zipFolder(file, parentFolder + "/" + file.getName(), zipOut);
			}
		} else {
			// If the file is a regular file, add it to the zip file
			FileInputStream fis = new FileInputStream(folder);
			ZipEntry zipEntry = new ZipEntry(parentFolder);
			zipOut.putNextEntry(zipEntry);
			byte[] bytes = new byte[1024];
			int length;
			while ((length = fis.read(bytes)) >= 0) {
				zipOut.write(bytes, 0, length);
			}
			fis.close();
		}
	}
}
