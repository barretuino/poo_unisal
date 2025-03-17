package pjAula5;
// MouseTracker.java
// Demonstra��o dos eventos de mouse
// Livro Texto: Cap 11.13

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseTracker extends JFrame
   implements MouseListener, MouseMotionListener {

   private JLabel statusBar;

   // construtor MouseTracker configura GUI e
   // registra handlers de evento de mouse
   public MouseTracker()
   {
      super( "Demonstra��o de Eventos de Mouse" );

      statusBar = new JLabel();
      getContentPane().add( statusBar, BorderLayout.SOUTH );
    
      // registra ouvinte para tratamento de eventos
      addMouseListener( this );
      addMouseMotionListener( this );

      setSize( 275, 100 );
      setVisible( true );
   }

   // handler de tratamento de evento quando o mouse � liberado
   // ap�s ter sido pressionado
   public void mouseClicked( MouseEvent event )
   {
      statusBar.setText( "Clicked at [" + event.getX() +
         ", " + event.getY() + "]" );
   }

   // trata evento quando mouse pressionado
   public void mousePressed( MouseEvent event )
   {
      statusBar.setText( "Pressed at [" + event.getX() +
         ", " + event.getY() + "]" );
   }

   // trata evento quando o mouse � liberado depois da opera��o de arrastar
   public void mouseReleased( MouseEvent event )
   {
      statusBar.setText( "Released at [" + event.getX() +
         ", " + event.getY() + "]" );
   }

   // trata evento quando o mouse entra na �rea do JFrame
   public void mouseEntered( MouseEvent event )
   {
      JOptionPane.showMessageDialog( null, "Mouse dentro da window" );
   }

   // trata evento quando o mouse sai da �rea do JFrame
   public void mouseExited( MouseEvent event )
   {
      statusBar.setText( "Mouse fora da window" );
   }

   // trata evento quando o mouse pressionado e arrastado
   public void mouseDragged( MouseEvent event )
   {
      statusBar.setText( "Dragged at [" + event.getX() +
         ", " + event.getY() + "]" );
   }

   // trata evento quando o mouse sendo movimentado na �rea do JFrame
   public void mouseMoved( MouseEvent event )
   {
      statusBar.setText( "Moved at [" + event.getX() +
         ", " + event.getY() + "]" );
   }

   // main - execu��o da aplica��o
   public static void main( String args[] )
   { 
      MouseTracker application = new MouseTracker();
      application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
   }

}