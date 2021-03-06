package by.trjava.task01.dataaccess;

import by.trjava.exceptions.InputFromFileImpossibleException;

import java.io.*;

public class DataAccess {
    public final static String FILE_PASS = "D:\\Workspace\\Array\\IntArr.txt";

    public static int[] readTextFromFile() throws InputFromFileImpossibleException {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        File file = new File(FILE_PASS);
        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException ex) {
            throw new InputFromFileImpossibleException("by.trjava.task01.dataaccess.DataAccess, readTextFromFile()" +
                    "Reading from file is impossible! " + FILE_PASS);
        }
        return convertTextFromFileToArrayInt(stringBuilder);
    }

    public static int[] convertTextFromFileToArrayInt(StringBuilder stringBuilder) throws NumberFormatException {
        String[] text = stringBuilder.toString().split(" ");
        int[] resultArrayInt = new int[text.length];
        for (int i = 0; i < text.length; i++) {
            int element = Integer.parseInt(text[i]);
            resultArrayInt[i] = element;
        }
        return resultArrayInt;
    }

}
