package q1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] sales = new int[names.length][3];
        Scanner in = new Scanner(System.in);

        for (int p = 0; p < names.length; p++) {
            for (int m = 0; m < 3; m++) {
                System.out.print("Enter number of sales for month " + (m + 1)
                        + " for " + names[p] + " mattress: ");
                sales[p][m] = Integer.parseInt(in.nextLine().trim());
            }
            System.out.println();
        }

        PrintProduct printer = new PrintProduct(new Product(names, sales));
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("*".repeat(50));
        printer.printTotalProductSales();
        printer.printAverageProductSales();
        printer.printMostPopularProduct();
    }
}
