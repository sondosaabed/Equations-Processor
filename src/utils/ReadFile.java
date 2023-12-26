package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import model.CursorArray;
import model.Equation;
import model.LinkedStack;

public class ReadFile {
	/*
	 * In this class the file is read into one cursor array This will be returned
	 * and be used to show the sections on the main scene
	 */
	private static int initSize(File equationsFile) {
		/*
		 * In this method I set the init size of the Cursoor based on the number of the
		 * sections that are in the file using a size counter
		 */
		int size = 0; // Putting the size of cursor using the file
		try (BufferedReader br = new BufferedReader(new FileReader(equationsFile))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.trim().startsWith("<section>")) {
					size++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return size;
	}

	/*
	 * Created to raed a file and loop through tags 
	 * push the stack (section) into cursor
	 * push the equations into stack
	 */
	public static CursorArray<Equation> loadEquationsFromFile(File equationsFile) {
		CursorArray<Equation> equationStacks = new CursorArray<Equation>(initSize(equationsFile));
		try (BufferedReader br = new BufferedReader(new FileReader(equationsFile))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.trim().startsWith("<section>")) {
					LinkedStack<Equation> section = new LinkedStack<Equation>();
					while ((line = br.readLine()) != null && !line.trim().startsWith("</section>")) {
						/*
						 * Each section is treated as a LinkedStack of Equations
						 */
						if (line.trim().startsWith("<infix>")) {
							/*
							 * Each infix tag has multiple equations
							 */
							while ((line = br.readLine()) != null && !line.trim().startsWith("</infix>")) {
								String equationExpression = line.trim().replace("<equation>", "").replace("</equation>","");
								Equation eq = new Equation(equationExpression, true);
								section.push(eq);
							}
						}
						if (line.trim().startsWith("<postfix>")) {
							/*
							 * Each postfix tag has multiple equations
							 */
							while ((line = br.readLine()) != null && !line.trim().startsWith("</postfix>")) {
								String equationExpression = line.trim().replace("<equation>", "").replace("</equation>","");
								Equation eq = new Equation(equationExpression, false);
								section.push(eq);
							}
						}
					}
					equationStacks.addStack(section);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return equationStacks;
	}
}