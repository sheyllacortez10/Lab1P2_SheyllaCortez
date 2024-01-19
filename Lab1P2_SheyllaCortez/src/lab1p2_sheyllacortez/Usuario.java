/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1p2_sheyllacortez;

/**
 *
 * @author DELL
 */
public class Usuario {
    String fNacimiento;
    String correo;
    String contrasena;

    public Usuario(String fNacimiento, String correo, String contrasena) {
        this.fNacimiento = fNacimiento;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public String getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(String fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
    
}
