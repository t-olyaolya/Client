package com.clientserver;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import com.clientserver.ServerInt;


public class Main  {

    public static void main (String[] args) throws Exception {
        ServerInt server;
    //String objectName = "rmi://"+args[0]+"/Serv";
    //System.out.println("Starting...\n");
    //Server server=(Server) Naming.lookup(objectName);
    //System.out.println("done");
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        server = (ServerInt) registry.lookup("Server1");

        System.out.println("1-сложение двух чисел");
        System.out.println("2-поиск медианы массива");
        System.out.println("3-умножение матриц");
        char choice = (char) System.in.read();
        Scanner in = new Scanner(System.in);
        switch (choice) {
        case '1':
            int a;
            int b;
            System.out.println("Введите два числа");
            a=in.nextInt();
            b=in.nextInt();

            System.out.println(server.addition(a, b));
            break;
        case '2':
            System.out.println("Введите длину массива");
            int ln = in.nextInt();
            int[] mas = new int[ln];
            System.out.println("Введите элементы массива массива");
            for (int i = 0; i < mas.length; i++) {
                mas[i] = in.nextInt();
            }
            System.out.println(server.median(mas));
            break;
        case '3':
            int size1[] = new int[2];
            int size2[] = new int[2];
            System.out.println("Введите размер первой матрицы");
            for (int i = 0; i < size1.length; i++) {
                size1[i] = in.nextInt();
            }
            int mas1[][] = new int[size1[0]][size1[1]];
            System.out.println("Введите элементы матрицы");
            for (int i = 0; i < size1[0]; i++) {
                for (int j = 0; j < size1[1]; j++) {
                    mas1[i][j] = in.nextInt();
                }

            }
            System.out.println("Введите размер второй матрицы");
            for (int i = 0; i < size2.length; i++) {
                size2[i] = in.nextInt();
            }

            if (size1[1]!=size2[0]) {
                System.out.println("Неверный размер");
            }

            int mas2[][] = new int[size2[0]][size2[1]];
            System.out.println("Введите элементы второй матрицы");
            for (int i = 0; i < size2[0]; i++) {
                for (int j = 0; j < size2[1]; j++) {
                    mas2[i][j] = in.nextInt();
                }

            }

            int [][]result=new int[size1[0]][size2[1]];
            result=server.multiplication(mas1,mas2);
            for (int i = 0; i < size1[0]; i++) {
                for (int j = 0; j <size2[1] ; j++) {
                    System.out.print(result[i][j]+ " ");
                }
                System.out.println();

            }


    }


}
}
