package q3040;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> dwarf = new ArrayList<>();
        int sum = 0;


        for (int i = 0; i < 9; i++) {
            dwarf.add(sc.nextInt());
            sum += dwarf.get(i);
        }

        int goal = sum - 100;


        int remove1 = -1, remove2 = -1;
        for (int i = 0; i < dwarf.size(); i++) {
            for (int j = i + 1; j < dwarf.size(); j++) {
                if (dwarf.get(i) + dwarf.get(j) == goal) {
                    remove1 = i;
                    remove2 = j;
                    break;
                }
            }
            if (remove1 != -1) break;
        }

        dwarf.remove(remove2);
        dwarf.remove(remove1);
        for (int num : dwarf) {
            System.out.println(num);
        }
    }
}