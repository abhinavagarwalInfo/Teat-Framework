package awesomecucumber.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class DirectoryUtil {

    // function to delete subdirectories and files
    public static void deleteDirectory(File file)
    {
        // store all the paths of files and folders present inside directory
        for (File subfile : file.listFiles()) {
            // if it is a subfolder,e.g Rohan and Ritik, recursively call function to empty subfolder
            if (subfile.isDirectory()) {
                deleteDirectory(subfile);
            }
            // delete files and empty subfolders
            subfile.delete();
        }
    }

    public void copyDirectory(File sourceDir, File destinationDir){
        try {
            FileUtils.copyDirectory(sourceDir, destinationDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}