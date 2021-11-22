//Aplicação do Login//
package com.mycompany.projeto;

import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class segurança {
    private String usuario;
    private String senha;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public boolean Conectar() {
        if ((usuario.equals("admin")) && (senha.equals("12345"))) {
            return true;
        } else {
            return false;
        }
    }
 //-------------------------------------------------------//
   
}
