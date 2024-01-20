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
                    //Entradas
                    System.out.println("Ingrese su nombre: ");
                    entrada.nextLine();
                    String nombreUsu = entrada.nextLine();
                    System.out.println("Ingrese su apellido: ");
                    String apellidoUsu = entrada.nextLine();
                    System.out.println("Ingrese su fecha de nacimiento [\"dd/MM/yyyy\"]: ");
                    String fNacer = entrada.nextLine();
                    System.out.println("Ingrese su correo electronico ");
                    String correoElec = entrada.nextLine();
                    System.out.println("Ingrese su contrasena: ");
                    String contrasena = entrada.nextLine();
                    
                    //Datos para validar la fecha de nacimiento
                    String miFecha[] = fNacer.split("/");
                    String diaFecha = miFecha[0];
                    String mesFecha = miFecha[1];
                    String anoFecha = miFecha[2];
                    Date fecha = new Date();
                    int ano = fecha.getYear() + 1900;
                    int limiteano = ano - 13;
                    int mesAct = fecha.getMonth() + 1;
                    int diaAct = fecha.getDate();
                    
                    //Validar si el usuario es mayor de 13 años 
                    if (Integer.parseInt(anoFecha) >= 2011) {
                        if (Integer.parseInt(mesFecha) >= mesAct) {
                            if (Integer.parseInt(diaFecha) > diaAct) {
                                System.out.println("Ingrese su fecha de nacimiento [\"dd/MM/yyyy\"]: ");
                                fNacer = entrada.nextLine();
                            }
                        }
                    }
                    
                    //Verificar si son o no validos los correos
                    if (!esValido(correoElec)) {
                        System.out.println("El correo electrónico no es válido.");
                        return;
                    }
                    //Si todos los factores requeridos son aceptables se crea el usuario
                    Usuario miusu = new Usuario(nombreUsu, apellidoUsu, fNacer, correoElec, contrasena);
                    listado.add(miusu);
                    System.out.println("Usuario añadido exitosamente ");
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
        System.out.println("Usuarios registrados: ");
        for (int i = 0; i < listado.size(); i++) {
            System.out.println(i + ". " + listado.get(i).toString());
        }
    }

    //Método para validar el correo electronico - boolean para jugar con valores true or false
    private static boolean esValido(String correoElec) {
        for (int i = 0; i < correoElec.length(); i++) {
            char caracAscii = correoElec.charAt(i);
            if ((caracAscii < 'a' || caracAscii > 'z') && (caracAscii < 'A' || caracAscii > 'Z') && (caracAscii < '0' || caracAscii > '9') && (caracAscii != '-') && (caracAscii != '_') && (caracAscii != '&') && (caracAscii != '$') && (caracAscii != '%')) {
                return false;
            }
        }
        return true;
    }
}
