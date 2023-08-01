/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author johan leon
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Object;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JComponent;
import javax.swing.text.JTextComponent;
import javax.swing.text.*;
import java.lang.Object;
import java.lang.Throwable;
import java.lang.Exception;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;

public class InterfazReporte extends JFrame implements ActionListener
{
    private JMenuBar menuBar;
    private JMenu menu1,menu2,menu4,menuTipoLetra,menu6,menuTamañoLetra,menuArchivo;
    private JMenuItem menuCopiar,menuPegar,menuCortar,menuGuardad,menuAbrir,menuGuardar,menuRemover;
    private UndoManager undoManager = new UndoManager();
    private JButton undoButton = new JButton("Deshacer");
    private JButton redoButton = new JButton("Rehacer");
    private JTextField itemTamaño;
    private JButton boton1;
    private JMenuItem menuItem1,menuItem2,menuItem3;
    private JMenuItem menuItemColor1,menuItemColor2,menuItemColor3;
    private JMenuItem menuItemEscribir,menuItemAndaleMono,menuItemCoolsville,menuItemCalligraphic,
                      menuItemAmethyst;
    public JTextArea textArea;
     JScrollPane scroll;  
     
    private String texto;
    public InterfazReporte(){
        super("Inventario");
        
//        textArea = new JTextArea();
//        textArea.setBounds(0,0,600,425);
//        add(textArea);
        textArea = new JTextArea();
        scroll = new JScrollPane(textArea);    
        scroll.setBounds(0,0,525,425);                                                                    
       this.add(scroll, BorderLayout.CENTER);
 
        undoButton.setEnabled(false);
        redoButton.setEnabled(false);
        
        
        setLayout(null);
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        
        
        menu1 = new JMenu("Opciones");
        menuBar.add(menu1);
        
        menu2 = new JMenu("resolucion");
        menu1.add(menu2);
        
        menuItem1 = new JMenuItem("640*540");
        menuItem1.addActionListener(this);
        menu2.add(menuItem1);
        
        menuItem2 = new JMenuItem("840*640");
        menuItem2.addActionListener(this);
        menu2.add(menuItem2);
        
        menuItem3 = new JMenuItem("10240*840");
        menuItem3.addActionListener(this);
        menu2.add(menuItem3);
        
        menu4 = new JMenu("Editar");
        menuBar.add(menu4);
        
        //agregando los tipos de leta
        menuTipoLetra = new JMenu("Tipo de Letra");
        menu1.add(menuTipoLetra);
        
        menuItemAndaleMono = new JMenuItem("Andale Mono");
        menuItemAndaleMono.addActionListener(this);
        menuTipoLetra.add(menuItemAndaleMono);
        
        menuItemCoolsville = new JMenuItem("Coolsville");
        menuItemCoolsville.addActionListener(this);
        menuTipoLetra.add(menuItemCoolsville);
        
        menuItemCalligraphic = new JMenuItem("Calligraphic");
        menuItemCalligraphic.addActionListener(this);
        menuTipoLetra.add(menuItemCalligraphic);
        menuItemCalligraphic.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Font fuente = new Font("Calligraphic", 0, 12);
        textArea.setFont(fuente); 
      }
    });
    
        menuItemAmethyst = new JMenuItem("Amethyst");
        menuItemAmethyst.addActionListener(this);
        menuTipoLetra.add(menuItemAmethyst);
        menuItemAmethyst.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        Font fuente = new Font("Amethyst", 0, 12);
        textArea.setFont(fuente); 
      }
    });
        
        
        
        menuCopiar = new JMenuItem("Copiar");
        menu4.add(menuCopiar);
        menuCopiar.addActionListener(this);
        
        menuPegar = new JMenuItem("Pegar");
        menu4.add(menuPegar);
        menuPegar.addActionListener(this);
        
        menuCortar = new JMenuItem("Cortar");
        menu4.add(menuCortar);
        menuCortar.addActionListener(this);
       
        
        menu4.add(undoButton);
        menu4.add(redoButton);
        
        menuTamañoLetra = new JMenu("Tamaño de la letra");
        menu1.add(menuTamañoLetra);
        
        itemTamaño = new JTextField();
        itemTamaño.setBounds(120,10,100,40);
        menuTamañoLetra.add(itemTamaño);
        
        boton1 = new JButton("OK");
        boton1.setBounds(120,80,80,20);
        boton1.addActionListener(this);
        menuTamañoLetra.add(boton1);
        
        menuArchivo = new JMenu("Archivo");
        menuBar.add(menuArchivo);
        
        menuAbrir = new JMenuItem("Abrir");
        menuAbrir.addActionListener(this);
        menuArchivo.add(menuAbrir);
        
        menuGuardar = new JMenuItem("Guardar");
        menuGuardar.addActionListener(this);
        menuArchivo.add(menuGuardar);
        
        textArea.getDocument().addUndoableEditListener(
        new UndoableEditListener() {
          public void undoableEditHappened(UndoableEditEvent e) {
            undoManager.addEdit(e.getEdit());
            updateButtons();
          }
        });
        
        undoButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          undoManager.undo();
        } catch (CannotRedoException cre) {
          cre.printStackTrace();
        }
        updateButtons();
      }
    });
 
    redoButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          undoManager.redo();
        } catch (CannotRedoException cre) {
          cre.printStackTrace();
        }
        updateButtons();
      }
    });
        
    }
    
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==menuItem1){
            setSize(640,540);
            scroll.setBounds(0,0,625,600);
            setLocationRelativeTo(null);
        }
        if(e.getSource()==menuItem2){
            setSize(840,640);
            scroll.setBounds(0,0,825,800);
            setLocationRelativeTo(null);
        }
        if(e.getSource()==menuItem3){
            setSize(10240,840);
            scroll.setBounds(0,0,1360,800);
            setLocationRelativeTo(null);
        }
        
        if(e.getSource()==menuItemEscribir){
            textArea = new JTextArea();
            textArea.setBounds(0,0,1200,1000);
            add(textArea);
        }
        if(e.getSource()==menuItemAndaleMono){
            //textArea.setFont(new Font("Andale Mono", 0, 12));
            Font fuente = new Font("Andale Mono", 0, 12);
            textArea.setFont(fuente); 
        }
        if(e.getSource()==menuItemCoolsville){
            //textArea.setFont(new Font("Coolsville", 0, 12));
            Font fuente = new Font("Coolsville", 0, 12);
            textArea.setFont(fuente); 
        }
        if(e.getSource()==menuCopiar){
            textArea.copy();
        }
        if(e.getSource()==menuCortar){
            textArea.cut();
        }
        if(e.getSource()==menuPegar){
            textArea.paste();
        }
        

        if(e.getSource()==boton1){
            int tamaño = Integer.parseInt(itemTamaño.getText());
            Font fuente = new Font("Andale Mono", 3, tamaño);
            textArea.setFont(fuente); 
        }
        
        if(e.getSource()==menuAbrir){
            abrirArchivo();
            textArea.append(texto);
            textArea= new JTextArea();
            textArea.setBounds(10,5,1200,1000);
            add(textArea);
        }
        
        if(e.getSource()==menuGuardar){
            guardarArchivo();
        }
    }
    
    
      
    public String abrirArchivo() {
  String aux="";   
  texto="";
  try
  {
   /**llamamos el metodo que permite cargar la ventana*/
   JFileChooser file=new JFileChooser();
   file.showOpenDialog(this);
   /**abrimos el archivo seleccionado*/
   File abre=file.getSelectedFile();
 
   /**recorremos el archivo, lo leemos para plasmarlo
   *en el area de texto*/
   if(abre!=null)
   {     
      FileReader archivos=new FileReader(abre);
      BufferedReader lee=new BufferedReader(archivos);
      while((aux=lee.readLine())!=null)
      {
         texto+= aux+ "\n";
      }
         lee.close();
    }    
   }
   catch(IOException ex)
   {
     JOptionPane.showMessageDialog(null,ex+"" +
           "\nNo se ha encontrado el archivo",
                 "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
    }
  return texto;//El texto se almacena en el JTextArea
}

private void guardarArchivo() {
 try
 {
  String nombre="";
  JFileChooser file=new JFileChooser();
  file.showSaveDialog(this);
  File guarda =file.getSelectedFile();
 
  if(guarda !=null)
  {
   /*guardamos el archivo y le damos el formato directamente,
    * si queremos que se guarde en formato doc lo definimos como .doc*/
    FileWriter  save=new FileWriter(guarda+".txt");
    save.write(textArea.getText());
    save.close();
    JOptionPane.showMessageDialog(null,
         "El archivo se a guardado Exitosamente",
             "Información",JOptionPane.INFORMATION_MESSAGE);
    }
 }
  catch(IOException ex)
  {
   JOptionPane.showMessageDialog(null,
        "Su archivo no se ha guardado",
           "Advertencia",JOptionPane.WARNING_MESSAGE);
  }
 
}


    public void updateButtons() {
    undoButton.setText(undoManager.getUndoPresentationName());
    redoButton.setText(undoManager.getRedoPresentationName());
    undoButton.setEnabled(undoManager.canUndo());
    redoButton.setEnabled(undoManager.canRedo());
  }
}
