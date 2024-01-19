/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_sheyllacortez;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Lab1P2_SheyllaCortez {

    /**
     * @param args the command line arguments
     */
    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion = 1;
        while (opcion != 4) {
            System.out.println("Ingrese una opcion a ejecutar: ");
            System.out.println("1). Registrar Usuario ");
            System.out.println("2). Lista Todo ");
            System.out.println("3). Listar Por Todo ");
            System.out.println("4). Salir del programa ");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingrese su fecha de nacimiento [\"dd/MM/yyyy\"]: ");
                    entrada.nextLine();
                    String fNacer = entrada.nextLine();
                    String miFecha[] = fNacer.split("/");
                    String aFecha = miFecha[0];
                    String bFecha = miFecha[1];
                    String cFecha = miFecha[2];
                    Date fecha = new Date();
                    System.out.println(fecha);
                    while (Integer.parseInt(cFecha) > 2011) {
                        System.out.println("Ingrese su fecha de nacimiento [\"dd/MM/yyyy\"]: ");
                        fNacer = entrada.nextLine();
                    }
                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {
                    System.out.println("Que le vaya bien instructor");
                }
                default -> {
                    System.out.println("Su opcion es invalida ");
                }
            }
        }
    }
    
}
