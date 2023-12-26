package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileValidation {
	/*
	 * The idea of this class is to use tag counters to
	 *  Check if all counts are zero, indicating balanced tags
	 *  Returns True if all tags have an opening & closing tag
	 */
	public static boolean isFileValid(File equationsFile) {
		try (BufferedReader br = new BufferedReader(new FileReader(equationsFile))) {
	        
            int count242 = 0;
            int countSection = 0;
            int countInfix = 0;
            int countPostfix = 0;
            int countEquation = 0;

            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.equals("<242>")) {
                    count242++;
                } else if (line.equals("</242>")) {
                    count242--;
                    if (count242 < 0) {
                        return false; 
                    }
                } else if (line.equals("<section>")) {
                    countSection++;
                } else if (line.equals("</section>")) {
                    countSection--;
                    if (countSection < 0) {
                        return false; 
                    }
                } else if (line.equals("<infix>")) {
                    countInfix++;
                } else if (line.equals("</infix>")) {
                    countInfix--;
                    if (countInfix < 0) {
                        return false; 
                    }
                } else if (line.equals("<postfix>")) {
                    countPostfix++;
                } else if (line.equals("</postfix>")) {
                    countPostfix--;
                    if (countPostfix < 0) {
                        return false; 
                    }
                } else if (line.equals("<equation>")) {
                    countEquation++;
                } else if (line.equals("</equation>")) {
                    countEquation--;
                    if (countEquation < 0) {
                        return false; 
                    }
                }
            }
            return count242 == 0 && countSection == 0 && countInfix == 0 && countPostfix == 0 && countEquation == 0;
		} catch (IOException e) {
            return false;
        }
	}
}