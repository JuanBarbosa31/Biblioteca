package com.mycompany.projeto;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class JDBCConnection {
    public Connection conexao; 
public String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
public String server = "localhost\\SQLEXPRESS";
public String port = "1433";
public String database = "Livros";
public String usuario = "sa";
public String senha = "siena8926";
public String caminho = "jdbc:sqlserver://" + server + 
":"+ port + ";databaseName=" + database; 
public Statement stmt; 
public ResultSet rs;
public Statement stmt1;
public ResultSet rs1;

//O metodo JDBCConnection vai fazer uma conexão com o banco de dados SQL//
public  JDBCConnection() { // Construtor
try { // Tratamento de erros
System.setProperty("jdbc.Drivers", driver); 
conexao = DriverManager.getConnection(caminho, usuario, senha); 
System.out.println("Conectado com sucesso!");
} catch (SQLException ex) {
System.out.println(ex.getMessage());
     }
}

//O metodo ListaLivros vai mostar todos os livros cadastrados na tela//
public void ListaLivros() {
try {
Statement stmt = conexao.createStatement();
ResultSet rs = stmt.executeQuery("SELECT CodigoDoLivro, NomeDoLivro FROM Livros");
while (rs.next()) {
System.out.println(rs.getInt("CodigoDoLivro") + " - " + rs.getString("NomeDoLivro"));
    Component parentComponent = null;
JOptionPane.showMessageDialog(parentComponent, ""+ rs.getInt("CodigoDoLivro") + " - " + rs.getString("NomeDoLivro"));
} 
} catch (SQLException ex) {
System.out.println(ex.getMessage());
   
}
  }

//O metodo AddLivros vai adicionar o livro informado pelo usuario no banco de dados//
public void AddLivros(){
  
  int c;
  String n;  
   n =  JOptionPane.showInputDialog("Insira o nome");
   c = Integer.parseInt(JOptionPane.showInputDialog("Insira o indice"));
    try {
Statement stmt1 = conexao.createStatement();
ResultSet rst1 = stmt1.executeQuery("USE [Livros]\n" +
"INSERT INTO [dbo].[Livros]\n" +
"           ([NomeDoLivro]\n" +
"           ,[CodigoDoLivro])\n" +
"     VALUES\n" +
"          \n" +
"		 \n" +
"		  ('"+ n +"',"+ c +" )");
while (rst1.next()) {
} 
} catch (SQLException ex) {
    System.out.println(ex.getMessage());
}
      }

//O metodo RemoveLivros vai remover o livro indicado pelo usuario do sistema//
public void RemoveLivros(){
int c;
c = Integer.parseInt(JOptionPane.showInputDialog("Insira o indice"));
 try {
Statement stmt1 = conexao.createStatement();
ResultSet rst1 = stmt1.executeQuery("USE [Livros]\n" +
"DELETE FROM [dbo].[Livros]\n" +
"      WHERE\n" +
"	  CodigoDoLivro="+c);
while (rst1.next()) {
} 
} catch (SQLException ex) {
    System.out.println(ex.getMessage());
}  
}

//O metodo AddValores vai modificar o Saldo informados pelo usuario do sistema//
public void AddValores(){

    int c ;
c = Integer.parseInt(JOptionPane.showInputDialog("Insira o valor"));
   try {
Statement stmt = conexao.createStatement();
ResultSet rs = stmt.executeQuery("UPDATE [dbo].[Saldos]" +" SET [SaldoAtual] =" + c );
while (rs.next()) {
 } 
} catch (SQLException ex) {
System.out.println(ex.getMessage());
   
}
  }

//O metodo VerValores vai mostrar na tela o Salddo//
public void VerValores(){
    try {
Statement stmt = conexao.createStatement();
ResultSet rs = stmt.executeQuery("SELECT SaldoAtual FROM [dbo].[Saldos]");
while (rs.next()) {
    Component parentComponent = null;
JOptionPane.showMessageDialog(parentComponent, "O Saldo Atual é: R$"+ rs.getInt("SaldoAtual"));
} 
} catch (SQLException ex) {
System.out.println(ex.getMessage());
   
}
}

//O metodo AddMeta vai amodificar a Meta informados pelo usuario do sistema//
public void AddMeta(){

    int c ;
c = Integer.parseInt(JOptionPane.showInputDialog("Insira o valor"));
   try {
Statement stmt = conexao.createStatement();
ResultSet rs = stmt.executeQuery("UPDATE [dbo].[SaldosM]" +" SET [SaldosMeta] =" + c );
while (rs.next()) {
 } 
} catch (SQLException ex) {
System.out.println(ex.getMessage());
   
}
  }

//O metodo VerMeta vai mostrar na tela a Meta//
public void VerMeta(){
    try {
Statement stmt = conexao.createStatement();
ResultSet rs = stmt.executeQuery("SELECT SaldosMeta FROM [dbo].[SaldosM]");
while (rs.next()) {
    Component parentComponent = null;
JOptionPane.showMessageDialog(parentComponent, " A Meta é: R$"+ rs.getInt("SaldosMeta"));
} 
} catch (SQLException ex) {
System.out.println(ex.getMessage());
   
}
}

//o metodo AddEmprestimo vai adicionar ao banco de dados as informações da pessoa que pegou o livro emprestado e qual foi o livro que o mesmo adquiriu//
public void AddEmprestimo(){
String n;
n =JOptionPane.showInputDialog("Insira o nome");
String e;
e =JOptionPane.showInputDialog("Insira o email");
   int t;
t = Integer.parseInt(JOptionPane.showInputDialog("Insira o numero de celular"));
    int c ;
c = Integer.parseInt(JOptionPane.showInputDialog("Insira o codigo do Livro"));

   try {
Statement stmt = conexao.createStatement();
ResultSet rs = stmt.executeQuery("INSERT [dbo].[Emprestado]" +
"           ([Nome]" +
"           ,[Email]" +
"           ,[Celular]" +
"           ,[CodigoDoLivro])" +
"     VALUES" +
"           ("+"'" + n + "'" + "," + "'" + e + "'" +","+ t +","+ c + ")");
while (rs.next()) {
    } 
} catch (SQLException ex) {
System.out.println(ex.getMessage());
   
}
  }

//O metodo VerEmprestimo vai mostrar na tela todos os emprestimos do sistema//
public void VerEmprestimo(){
    try {
Statement stmt = conexao.createStatement();
ResultSet rs = stmt.executeQuery("SELECT [Nome]\n" +
"      ,[Email]\n" +
"      ,[Celular]\n" +
"      ,[CodigoDoLivro]\n" +
"  FROM [dbo].[Emprestado]");
while (rs.next()) {
    Component parentComponent = null;
JOptionPane.showMessageDialog(parentComponent, "Nome: "+rs.getString("Nome")+" Email: "+rs.getString("Email")+" Cel: " +rs.getInt("Celular")+"   Codigo: " +rs.getInt("CodigoDoLivro"));
} 
} catch (SQLException ex) {
System.out.println(ex.getMessage());
   
}
}

//O metodo RemoveEmprestimo vai Remover um emprestimo desejado pelo usuario do sistema//
public void RemoveEmprestimo(){
int c;
c = Integer.parseInt(JOptionPane.showInputDialog("Insira o indice"));
 try {
Statement stmt1 = conexao.createStatement();
ResultSet rst1 = stmt1.executeQuery("DELETE FROM [dbo].[Emprestado]" +
"      WHERE\n" +
"	  CodigoDoLivro="+c);
while (rst1.next()) {
} 
} catch (SQLException ex) {
    System.out.println(ex.getMessage());
}  
}
}

 
