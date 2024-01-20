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
            System.out.println("3). Listar Por Dominio ");
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
                    if (!validarCorreo(correoElec)) {
                        System.out.println("El correo electrónico no es válido ");
                        return;
                    }

                    //Validar si el correo ya existe o no
                    if (repetidoCorreo(correoElec, listado)) {
                        System.out.println("Su correo ya existe ");
                        return;
                    }

                    //Validar que la contraseña tenga mas de 8 caracteres
                    if (contrasena.length() < 8) {
                        System.out.println("Su contrasena es muy corta ");
                        System.out.println("Ingrese su contrasena: ");
                        contrasena = entrada.nextLine();
                    }

                    //Verificar mayusculas de la contrasena
                    boolean letterMayus = false;
                    for (int i = 0; i < correoElec.length(); i++) {
                        if (correoElec.charAt(i) >= 'A' && correoElec.charAt(i) <= 'Z') {
                            letterMayus = true;
                            break;
                        }
                    }
                    if (!letterMayus) {
                        System.out.println("Su contrasena no tuen letras mayusculas");
                        System.out.println("Ingrese su contrasena: ");
                        contrasena = entrada.nextLine();
                    }

                    boolean letterMinus = false;
                    for (int i = 0; i < correoElec.length(); i++) {
                        if (correoElec.charAt(i) >= 'a' && correoElec.charAt(i) <= 'z') {
                            letterMinus = true;
                            break;
                        }
                    }
                    if (!letterMinus) {
                        System.out.println("Contrasena no tiene letras minusculas ");;
                        System.out.println("Ingrese su contrasena: ");
                        contrasena = entrada.nextLine();
                    }

                    //Que la contraseña contenga numeros
                    boolean contraNumeros = false;
                    for (int i = 0; i < correoElec.length(); i++) {
                        if (correoElec.charAt(i) >= '0' && correoElec.charAt(i) <= '9') {
                            contraNumeros = true;
                            break;
                        }
                    }
                    if (!contraNumeros) {
                        System.out.println("Su contrasena no contiene numeros ");
                        System.out.println("Ingrese su contrasena: ");
                        contrasena = entrada.nextLine();
                    }

                    //Que la contrasena contenga simbolos validos 
                    // Verificamos que la contraseña contenga al menos un símbolo
                    boolean misSimbolos = false;
                    for (int i = 0; i < correoElec.length(); i++) {
                        if (correoElec.charAt(i) == '!' || correoElec.charAt(i) == '?' || correoElec.charAt(i) == '<' || correoElec.charAt(i) == '>' || correoElec.charAt(i) == '$' || correoElec.charAt(i) == '%') {
                            misSimbolos = true;
                            break;
                        }
                    }
                    if (!misSimbolos) {
                        System.out.println("Contrasena sin simbolos ");
                        System.out.println("Ingrese su contrasena: ");
                        contrasena = entrada.nextLine();
                    }

                    //Al llegar aca el correo, fnacimiento y contrasena han sido validados 
                    //Si todos los factores requeridos son aceptables se crea el usuario
                    Usuario miusu = new Usuario(nombreUsu, apellidoUsu, fNacer, correoElec, contrasena);
                    listado.add(miusu);
                    System.out.println("Usuario añadido exitosamente ");
                }
                case 2 -> {
                    listarUsuario(listado);
                }
                case 3 -> {
                    //No creado
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
    public static boolean validarCorreo(String correoElec) {
        for (int i = 0; i < correoElec.length(); i++) {
            char caracAscii = correoElec.charAt(i);
            if ((caracAscii < 'a' || caracAscii > 'z') && (caracAscii < 'A' || caracAscii > 'Z') && (caracAscii < '0' || caracAscii > '9') && (caracAscii != '-') && (caracAscii != '_') && (caracAscii != '&') && (caracAscii != '$') && (caracAscii != '%') && (caracAscii != '@') && (caracAscii != '.')) {
                return false;
            }
        }
        return true;
    }
    
    //Método para saber si el correo esta repetido en el arraylist
    public static boolean repetidoCorreo(String correoElec, ArrayList<Usuario> listado){
        for (int i = 0; i < listado.size(); i++) {
            String caracCorreo = listado.get(i).getCorreo();
            if (caracCorreo.equals(correoElec)) {
                return true;
            }
        }
        return false;
    }
   
}
