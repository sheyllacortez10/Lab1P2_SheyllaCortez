/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_sheyllacortez;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        ArrayList<Usuario> listado = new ArrayList<>();
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
                    String diaFecha = miFecha[0];
                    String mesFecha = miFecha[1];
                    String anoFecha = miFecha[2];
                    Date fecha = new Date();
                    int ano = fecha.getYear() + 1900;
                    int limiteano = ano - 13;
                    System.out.println(limiteano);
                    int mesAct = fecha.getMonth() + 1;
                    int diaAct = fecha.getDate();
                    if (Integer.parseInt(anoFecha) >= limiteano) {
                        if (Integer.parseInt(mesFecha) >= mesAct) {
                            if (Integer.parseInt(diaFecha) > diaAct) {
                                System.out.println("Ingrese su fecha de nacimiento [\"dd/MM/yyyy\"]: ");
                                fNacer = entrada.nextLine();
                            }
                        }
                    }
                }
                case 2 -> {
                    listarUsuario(listado);
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

    //Método para listar los usuarios
    public static void listarUsuario(ArrayList<Usuario> listado) {
        System.out.println("Productos en el inventario ");
        for (int i = 0; i < listado.size(); i++) {
            System.out.println(i + ". " + listado.get(i).toString());
        }
    }

}
