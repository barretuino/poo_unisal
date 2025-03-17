package pjAula5;
// KeyDemo.java
// Demonstrando eventos de teclas

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyDemo extends JFrame implements KeyListener {
   private String line1 = "", line2 = "";
   private String line3 = "";
   private JTextArea textArea;

   //construtor
   public KeyDemo()
   {
      super( "Demostra��o de Evento de Teclado" );

      // configura o JTextArea
      textArea = new JTextArea( 10, 15 );
      textArea.setText( "Pressione alguma tecla do teclado..." );
      textArea.setEnabled( false );
      getContentPane().add( textArea );

      // permite que o frame processe os eventos de tecla
      addKeyListener( this );

      setSize( 350, 100 );
      setVisible( true );
   }

   // trata o pressionamento de qualquer tecla
   public void keyPressed( KeyEvent event )
   {
      line1 = "Tecla pressionada: " + 
         event.getKeyText( event.getKeyCode() );
      setLines2and3( event );
   }

   // trata a libera��o de qualquer tecla
   public void keyReleased( KeyEvent event )
   {
      line1 = "Tecla liberada: " +
         event.getKeyText( event.getKeyCode() );
      setLines2and3( event );
   }

   // trata o pressionamento de uma tecla de a��o
   public void keyTyped( KeyEvent event )
   {
      line1 = "Tipo da tecla pressionada: " + event.getKeyChar();
      setLines2and3( event );
   }

   // configura a segunda e a terceira linhas de sa�da
   private void setLines2and3( KeyEvent event )
   {
      line2 = "A Tecla " +
         ( event.isActionKey() ? "" : "n�o � " ) +
         "um tecla de a��o";

      String temp = 
         event.getKeyModifiersText( event.getModifiers() );

      line3 = "Tecla modificadora pressionada: " +
         ( temp.equals( "" ) ? "none" : temp );

      textArea.setText( 
         line1 + "\n" + line2 + "\n" + line3 + "\n" );
   }

   // execu��o da aplica��o
   public static void main( String args[] )
   {
      KeyDemo application = new KeyDemo();

      application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
   }
} 