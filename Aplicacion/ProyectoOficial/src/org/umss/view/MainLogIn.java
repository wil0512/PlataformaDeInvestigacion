package org.umss.view;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import javax.swing.JTextField;

//import Datos.BD;
//import Datos.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.umss.controller.BD;
import org.umss.model.Usuario;

public class MainLogIn extends JFrame {

    private JTextField nameField;
    
    private BD consulta;

    private JPasswordField passwordField;


    public static void init() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainLogIn frame = new MainLogIn();
                    
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MainLogIn() {
        try {
            consulta = new BD();
            System.out.println("CONEXION SATISFACTORIA");
        } catch (SQLException ex) {
            Logger.getLogger(MainLogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        setTitle("SCT LOG IN");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 150, 360, 368);
        getContentPane().setLayout(null);

        JLabel lblLogIn = new JLabel("LOG IN");
        lblLogIn.setFont(new Font("Segoe Print", Font.BOLD, 17));
        lblLogIn.setBounds(140, 20, 100, 50);
        getContentPane().add(lblLogIn);

        JLabel lblUser = new JLabel("User:");
        lblUser.setFont(new Font("Century Gothic", Font.BOLD, 18));
        lblUser.setBounds(30, 80, 100, 15);
        getContentPane().add(lblUser);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Century Gothic", Font.BOLD, 18));
        lblPassword.setBounds(30, 130, 100, 15);
        getContentPane().add(lblPassword);

        nameField = new JTextField();
        nameField.setFont(new Font("Century Gothic", Font.PLAIN, 17));
        nameField.setBounds(130, 80, 175, 20);
        getContentPane().add(nameField);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        passwordField.setBounds(130, 130, 175, 20);
        getContentPane().add(passwordField);

        JButton btnOk = new JButton("OK");
        btnOk.setBackground(new Color(245, 245, 245));
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                menuPrincipal obj = new menuPrincipal();
                obj.setVisible(true);
                log();
            }
        });
        btnOk.setFont(new Font("Century Gothic", Font.BOLD, 15));
        btnOk.setBackground(new Color(245, 245, 245));
        btnOk.setBounds(110, 190, 140, 25);
        getContentPane().add(btnOk);

        JButton btnSignIn = new JButton("Sign in");
        btnSignIn.setBackground(new Color(245, 245, 245));
        btnSignIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                switchToSignIn();
            }
        });
        btnSignIn.setFont(new Font("Century Gothic", Font.BOLD, 15));
        btnSignIn.setBounds(110, 284, 140, 25);
        getContentPane().add(btnSignIn);

        JLabel lblDontHaveAn = new JLabel("Don't have an account?");
        lblDontHaveAn.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        lblDontHaveAn.setForeground(new Color(0, 0, 128));
        lblDontHaveAn.setBounds(90, 244, 180, 15);
        getContentPane().add(lblDontHaveAn);
    }

    void switchToSignIn() {
        try {
            this.dispose();
            //ventana_crear_Usuario.init();
        } catch (Throwable e) {
            System.out.println("error cambio de vista");
            e.printStackTrace();
        }
    }

    void log() {
       //Usuario user = consulta.getUsuario(nameField.getText(), String.valueOf(passwordField.getPassword()));
        
        //if (user != null) {
        int pid = Integer.parseInt(consulta.getPid(nameField.getText(), String.valueOf(passwordField.getPassword())));
        System.out.println(pid);
        if(pid != 0){
            JOptionPane.showMessageDialog(null, "INGRESO SATISFACTORIO");
            //dispose();
            //newWindow(user.getCategoria());
        } else {
            JOptionPane.showMessageDialog(null, "EROOR AL INGRESAR");
            nameField.setText("");
            passwordField.setText("");
        }
    }

    /*void newWindow(String categoria) {
        if (categoria.equals("ADMINISTRADOR_ALMACEN")) {
            if (VentanaRegistroAlmacenes.ventana == null) {
                VentanaRegistroAlmacenes.ventana = new VentanaRegistroAlmacenes();
            }
            VentanaRegistroAlmacenes.ventana.setVisible(true);
        } else if (categoria.equals("EMPLEADO")) {
            if (VentanaPedidosUsuario.ventana == null) {
                VentanaPedidosUsuario.ventana = new VentanaPedidosUsuario();
            }
            VentanaPedidosUsuario.ventana.setVisible(true);
        } else if (categoria.equals("COMPRADOR")) {
            if (VentanaCotizaciones.ventana == null) {
                VentanaCotizaciones.ventana = new VentanaCotizaciones("Ventana Cotizaciones");
            }
            VentanaCotizaciones.ventana.setVisible(true);
        } else if (categoria.equals("ADMINISTRADOR_INVENTARIO")) {
            VentanaProductos.ventana = new VentanaProductos();
            VentanaProductos.ventana.setVisible(true);
        }
    }*/
    
    public static void main(String [] args){
        MainLogIn.init();
        
    }
}

