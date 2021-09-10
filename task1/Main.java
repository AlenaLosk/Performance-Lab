package task1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] data = {Integer.parseInt(args[0]), Integer.parseInt(args[1])};
        printFirstSymbol(createArray(data));
    }

    //можно прочитать имя файла из консоли, введенное пользователем
    public static int[] readData() {
        int[] data = new int[2];
        try {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextLine()) {
                data[0] = scanner.nextInt();
                data[1] = scanner.nextInt();
            }
            if (data[0] < data[1] || data[0] == 0 || data[1] == 0) {
                throw new Exception("Incorrect input data");
            }
        } catch (Exception e) {
            data = new int[]{0, 0};
        } finally {
            return data;
        }
    }

    public static List<String> createArray(int[] data) {
        ArrayList<String> tempArray = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int j = 1;
        for (int i = 1; i <= data[0]; i++) {
            sb.append(i);
            if (j == data[1]) {
                tempArray.add(sb.toString());
                if (sb.charAt(data[1] - 1) == '1') {
                    break;
                }
                i--;
                j = 1;
                sb = new StringBuilder();
                continue;
            }
            j++;
            if (i == data[0]) {
                i = 0;
            }
        }
        return tempArray;
    }

    public static void printFirstSymbol(List<String> array) {
        for (String str: array) {
            System.out.print(Character.getNumericValue(str.charAt(0)));
        }
        System.out.println();
    }
}
