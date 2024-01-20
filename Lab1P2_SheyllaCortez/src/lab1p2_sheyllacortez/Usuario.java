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
    String nombreUsu;
    String apellidoUsu;
    String fNacimiento;
    String correo;
    String contrasena;

    public Usuario(String nombreUsu, String apellidoUsu, String fNacimiento, String correo, String contrasena) {
        this.nombreUsu = nombreUsu;
        this.apellidoUsu = apellidoUsu;
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

    public String getNombreUsu() {
        return nombreUsu;
    }

    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }

    public String getApellidoUsu() {
        return apellidoUsu;
    }

    public void setApellidoUsu(String apellidoUsu) {
        this.apellidoUsu = apellidoUsu;
    }
    
    

    @Override
    public String toString() {
        return "Usuario{" + "fNacimiento=" + fNacimiento + ", correo=" + correo + ", contrasena=" + contrasena + '}';
    }
    
    
    
}
