package task1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String n = args[0];
        String m = args[1];
        try {
            int lastElementOfArray = parseArgument(n);
            int lengthOfSegment = parseArgument(m);
            printList(createListWith1stSymbol(lastElementOfArray, lengthOfSegment));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Integer parseArgument(String arg) throws Exception {
        try {
            return Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static boolean validateArguments(int lastElementOfArray, int lengthOfSegment) throws Exception {
        if (lastElementOfArray < lengthOfSegment || lastElementOfArray < 1 || lengthOfSegment < 1) {
            throw new Exception("Incorrect arguments");
        }
        return true;
    }

    public static List<Integer> createListWith1stSymbol(int lastElementOfArray, int lengthOfSegment) throws Exception {
        if (validateArguments(lastElementOfArray, lengthOfSegment)) {
            List<int[]> tempList = new ArrayList<>();
            int[] ListElement = new int[lengthOfSegment];
            int j = 1;
            for (int i = 1; i <= lastElementOfArray; i++) {
                ListElement[j - 1] = i;
                if (j == lengthOfSegment) {
                    tempList.add(ListElement);
                    if (ListElement[lengthOfSegment - 1] == 1) {
                        break;
                    }
                    i--;
                    j = 1;
                    ListElement = new int[lengthOfSegment];
                    continue;
                }
                j++;
                if (i == lastElementOfArray) {
                    i = 0;
                }
            }
            List<Integer> result = new ArrayList<>();
            for (int[] element : tempList) {
                result.add(element[0]);
            }
            return result;
        }
        return null;
    }

    public static void printList(List<Integer> result) throws Exception {
        if (result == null) {
            throw new Exception("Incorrect parameters for print!");
        }
        for (Integer element : result) {
            System.out.print(element);
        }
        System.out.println();
    }
}
