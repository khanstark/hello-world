/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author kaif khan
 */

import javax.imageio.ImageIO;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.*;
import javax.swing.AbstractAction;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.border.*;
import javax.swing.text.JTextComponent;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;



public class texteditor extends JFrame{
    JMenuItem n,open,save,saveas,exit,abt,openimg,opentxt,openother,cnfnt,cbg,cfg,fnt,color,fcol,
            php,html,jsp,java,c,cpp,js; JTextPane edit; String fname;
      JFrame f; JToolBar tool; 
    public static void main(String args[])
    {
        
    
        new texteditor();
    }
    
    public texteditor()
    {
        
        Image icon =Toolkit.getDefaultToolkit().getImage("src/ico.jpg");
 
        f=new JFrame("MOSE Editor 1.0");
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
       tool=new JToolBar();
       
        f.setIconImage(icon);
        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
               Object[] options={"Yes","No! Go Back."};
               int n= JOptionPane.showOptionDialog(f, "Exit without editing or saving something?", "MOSE", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
     
                
               if(n == JOptionPane.YES_OPTION)
               {
                   
                 f.setVisible(false);
               }
               else if(n == JOptionPane.NO_OPTION)
               {
                   
                  
                  f.setDefaultCloseOperation(f.DO_NOTHING_ON_CLOSE);
                      
                   
               }
                
            }
        });
        JPanel p=new JPanel();
        
        edit=new JTextPane();
        JScrollPane sp=new JScrollPane(edit);
         f.getContentPane().add(p);
              edit.setFont(new Font("Berlin Sans FB",Font.PLAIN,20));

        f.getContentPane().add(sp,BorderLayout.CENTER);
       
        f.setSize(850,700);
       
        f.setLocationRelativeTo(null);
    
        JMenuBar bar =new JMenuBar();
        bar.setBackground(new Color(224,224,224));
        
        Font font=new Font("Tahoma",Font.PLAIN,14);
        
       
        JMenu file=new JMenu("File");
        file.setMnemonic(KeyEvent.VK_ALT);
        file.setFont(font);
        file.setForeground(new Color(0,0,204));
         JMenu opt=new JMenu("Options");
          opt.setFont(font);
        opt.setForeground(new Color(0,0,204));
          JMenu help=new JMenu("Help");
           help.setFont(font);
        help.setForeground(new Color(0,0,204));
        
        bar.add(file);
bar.add(opt);
bar.add(help);

JSeparator s1=new JSeparator();
JSeparator s2=new JSeparator();

abt =new JMenuItem("About MOSE");
 n =new JMenuItem("New              Alt+N");
 

 open =new JMenu("Open             Alt+O");
 openimg =new JMenuItem("Open Image..");
 opentxt =new JMenuItem("Open Text..");
 openother =new JMenu("Other..");
  php =new JMenuItem("PHP");
 html =new JMenuItem("HTML");
 jsp =new JMenuItem("JSP");
 java =new JMenuItem("Java");
 c =new JMenuItem("C");
 cpp =new JMenuItem("C++");
  
  
 save =new JMenuItem("Save        ");
 saveas =new JMenuItem("Saveas..             Alt+S");
 exit =new JMenuItem("Exit                Alt+X");
 cnfnt=new JMenu("Change font..");
 cbg=new JMenu("Change background..");
 cfg=new JMenu("Change text color..");
 
 open.setMnemonic(KeyEvent.VK_O);
saveas.setMnemonic(KeyEvent.VK_S);
n.setMnemonic(KeyEvent.VK_N);
exit.setMnemonic(KeyEvent.VK_X);

openimg.setFont(font);
        openimg.setForeground(new Color(0,153,76));
        opentxt.setFont(font);
        opentxt.setForeground(new Color(0,153,76));
        openother.setFont(font);
        openother.setForeground(new Color(0,153,76));
         php.setFont(font);
        php.setForeground(new Color(0,153,76));
        html.setFont(font);
       html.setForeground(new Color(0,153,76));
       jsp.setFont(font);
        jsp.setForeground(new Color(0,153,76)); 
       java.setFont(font);
        java.setForeground(new Color(0,153,76));
        c.setFont(font);
        c.setForeground(new Color(0,153,76));
        cpp.setFont(font);
        cpp.setForeground(new Color(0,153,76));
        
abt.setFont(font);
        abt.setForeground(new Color(51,51,255));
n.setFont(font);
        n.setForeground(new Color(51,51,255));
        
open.setFont(font);
        open.setForeground(new Color(51,51,255));
        
save.setFont(font);
        save.setForeground(new Color(51,51,255));
        
saveas.setFont(font);
        saveas.setForeground(new Color(51,51,255));
        
exit.setFont(font);
        exit.setForeground(new Color(51,51,255));
        
        cnfnt.setFont(font);
        cnfnt.setForeground(new Color(51,51,255));
        
        cbg.setFont(font);
        cbg.setForeground(new Color(51,51,255));
        
        cfg.setFont(font);
        cfg.setForeground(new Color(51,51,255));
       
        //Fonting begins!
        String menu[]={"Tahoma","Berlin Sans FB","Calibri","Gill Sans","Times New Roman","Lucida Calligraphy Italic",
                 "Simpsonfont","Twentieth Century","Harry P","Lumos","Yahoo","Aladdin","BatmanForeverAlternate",
        "Madonna","28 Days Later","BTSE + PS2 FONT","The Godfather","SkyFall Done","MATRIX","ASSASSIN$",
        "Blade 2","Amazing Spiderman slant","Canon"};
        String col[]={"Blue","Black","Grey","Green","Magenta","Pink","White"};
        String lang[]={"PHP","HTML","JSP","Java","C","C++"};
        for(String m:menu)
        {
           fnt=new JMenuItem(m); 
           fnt.addActionListener(new fntaction(m));
           fnt.setFont(font);
        fnt.setForeground(new Color(0,153,76));
        
           cnfnt.add(fnt);
          
           
        }
        
        for(String c:col)
        {
           color=new JMenuItem(c); 
           fcol=new JMenuItem(c);
           color.addActionListener(new bgaction());
           color.setFont(font);
        color.setForeground(new Color(0,153,76));
         fcol.addActionListener(new fgaction());
           fcol.setFont(font);
        fcol.setForeground(new Color(0,153,76));
        
           cbg.add(color);
          cfg.add(fcol);
           
        }
       
        
    JSeparator s3=new JSeparator();
JSeparator s4=new JSeparator();
JSeparator s5=new JSeparator();    
        
help.add(abt);
opt.add(cnfnt);
opt.add(s4);

opt.add(cbg);
opt.add(s5);
opt.add(cfg);
file.add(n);
open.add(openimg);
open.add(opentxt);
open.add(s3);
open.add(openother);
openother.add(php);
openother.add(html);
openother.add(jsp);
openother.add(java);
openother.add(c);
openother.add(cpp);
file.add(open);
file.add(s1);
file.add(save);
file.add(saveas);
file.add(s2);
file.add(exit);

n.addActionListener(new newaction());
exit.addActionListener(new exitaction());
opentxt.addActionListener(new opentxtaction());
openimg.addActionListener(new imgaction());
saveas.addActionListener(new saveasaction());
abt.addActionListener(new helpaction());
php.addActionListener(new phpaction());
html.addActionListener(new htmlaction());
jsp.addActionListener(new jspaction());
java.addActionListener(new javaaction());
c.addActionListener(new caction());
cpp.addActionListener(new cppaction());




    f.setJMenuBar(bar);
    //ToolBar addition
   
    ImageIcon l1=new ImageIcon("src/new.jpg");
   JButton n=new JButton(l1);n.setContentAreaFilled(true);
  n.setToolTipText("New...Alt+N");
  n.addActionListener(new newaction());
  n.setForeground(Color.red);
  ImageIcon l2=new ImageIcon("src/saveas.jpg");
  JButton s=new JButton(l2);
  s.setToolTipText("Save As...Alt+S");
  s.addActionListener(new saveasaction());
  
  ImageIcon l3=new ImageIcon("src/exit.jpg");
  JButton e=new JButton(l3);
  e.setToolTipText("Exit...Alt+X");
  e.addActionListener(new exitaction());
  
  ImageIcon l4=new ImageIcon("src/open.jpg");
   JButton o=new JButton(l4);
  o.setToolTipText("Open text...Alt+O");
  o.addActionListener(new opentxtaction());
  
  JLabel l=new JLabel("Background");
  ImageIcon l5=new ImageIcon("src/grey1.jpg");
   JButton grey=new JButton(l5);
  grey.setToolTipText("Grey");
  
  ImageIcon l6=new ImageIcon("src/blue1.jpg");
   JButton blue=new JButton(l6);
  blue.setToolTipText("Blue");
  grey.addActionListener(new ActionListener()
  {
      @Override
      public void actionPerformed(ActionEvent e)
      {
          edit.setBackground(new Color(192,192,192));
      }
  });
  blue.addActionListener(new ActionListener()
  {
      @Override
      public void actionPerformed(ActionEvent e)
      {
          edit.setBackground(new Color(153,153,255));
      }
  });
  
   JLabel ll=new JLabel("Font color");
    JButton blue2=new JButton(l6);
  blue2.setToolTipText("Blue");
  blue2.addActionListener(new ActionListener()
  {
      @Override
      public void actionPerformed(ActionEvent e)
      {
          edit.setForeground(Color.blue);
      }
  });
   JButton grey2=new JButton(l5);
  grey2.setToolTipText("Blue");
  grey2.addActionListener(new ActionListener()
  {
      @Override
      public void actionPerformed(ActionEvent e)
      {
          edit.setForeground(Color.gray);
      }
  }); 
  
  ImageIcon l7=new ImageIcon("src/green.jpg");
  JButton green=new JButton(l7);
  green.setToolTipText("Blue");
  green.addActionListener(new ActionListener()
  {
      @Override
      public void actionPerformed(ActionEvent e)
      {
          edit.setForeground(Color.green);
      }
  });
  
  tool.setPreferredSize(new Dimension(600,30));
  tool.add(n);
  tool.addSeparator();
  tool.add(o);
  tool.addSeparator();
  tool.add(s);
    tool.addSeparator();
    tool.add(e);
     tool.addSeparator();
    tool.add(l);
     tool.addSeparator();
    tool.add(grey);
     tool.addSeparator();
    tool.add(blue);
     tool.addSeparator();
    tool.add(ll);
     tool.addSeparator();
    tool.add(blue2);
     tool.addSeparator();
    tool.add(grey2);
     tool.addSeparator();
    tool.add(green);
    
    
    
    
    f.getContentPane().add(tool,BorderLayout.NORTH);
        

        f.setVisible(true);
    }  
    
    
    
    
    

    class saveasaction implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            try{
               
            saveas(edit,fname);
    }
            catch(Exception ex)
            {
            }
            }
    public void saveas(JTextComponent comp,String filename)throws Exception
    {
        JFileChooser fileChooser = new JFileChooser();
fileChooser.setDialogTitle("Save file"); 
fileChooser.getFileSelectionMode();
 fileChooser.isFileSelectionEnabled();
int userSelection = fileChooser.showSaveDialog(f);
 
if (userSelection == JFileChooser.APPROVE_OPTION) {
    File fileToSave = fileChooser.getSelectedFile();
    fname=fileToSave.getAbsolutePath();
     filename=fname;
        FileWriter writer=null;
        writer=new FileWriter(filename);
        comp.write(writer);
        comp.setText("");
        writer.close();
        
        
    }
   

    }}
    
    
    class opentxtaction implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try{
               
            openit(edit,fname);
              
        }
            catch(Exception r)
            {
    }}
public void openit(JTextComponent comp,String filename)throws Exception
{
   JFileChooser fileChooser = new JFileChooser();
fileChooser.setDialogTitle("Open .txt file");   
 
int userSelection = fileChooser.showOpenDialog(f);
 
if (userSelection == JFileChooser.APPROVE_OPTION) {
    File fileToSave = fileChooser.getSelectedFile();
    fname=fileToSave.getAbsolutePath();
     filename=fname;
     int l=fname.length();
               String reg=fname.substring(l-3);
               if("txt".equals(reg)){
     FileReader r=null;
     r=new FileReader(filename);
     comp.read(r,filename);
          comp.setFont(new Font("Berlin Sans FB",Font.PLAIN,20));

     f.setTitle(fname+" "+"MOSE Editor 1.0");
r.close();    }
               else{System.out.println("not text");
               JOptionPane.showMessageDialog(fileChooser, "Please choose a text file");
               }
}
}
        
    }
    
    
    
    class imgaction implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
       final  JFrame fr = new JFrame("MOSE Image Display Panel");
        
        final JFileChooser fileChooser=new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
       
        
         
           
                
            
          
           fileChooser.setDialogTitle("Select an image");
        int selected=fileChooser.showOpenDialog(f);
        if(selected==JFileChooser.APPROVE_OPTION)
        {
            File file=fileChooser.getSelectedFile();
           
            
            
            fname=file.getAbsolutePath();
            int len=fname.length();
            String s=fname.substring(len-3);
            if((s.equals("png")) || ("jpg".equals(s)) || ("gif".equals(s))){
                             System.out.println("image");  
            
           
           
           
           
       
        
   JEditorPane ed=new JEditorPane();
    JLabel l=new JLabel();
  l.setHorizontalAlignment(JLabel.CENTER);
  JScrollPane sl=new JScrollPane(l);
    ImageIcon icon=new ImageIcon(fname);
    l.setIcon(icon);
    Integer h=icon.getIconHeight();
    int w=icon.getIconWidth();
    String desc=icon.getDescription();
    String height;
            height = h.toString();
            
   ed.setText("[ Details ]: \n"+" " +desc+" \nHeight:" +h+"\nWidth:"+w);
   ed.setEditable(false);
   
    JSplitPane split=new JSplitPane(JSplitPane.VERTICAL_SPLIT,sl,ed);
    split.setOneTouchExpandable(true);
    split.setDividerLocation(610);
   fr.add(split); fr.setSize(1000, 880); 
    fr.setLocationRelativeTo(null);
    fr.setVisible(true); 
   
   
   
        
            }
             else{
               JOptionPane.showMessageDialog(fileChooser, "Please choose an image");
  fr.setVisible(false); 
        
            }
   fr.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
               Object[] options={"Yes","No! Go Back."};
               int n= JOptionPane.showOptionDialog(fr, "Exit! Thanks for using OpenImage panel. ", "MOSE", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
     
                
               if(n == JOptionPane.YES_OPTION)
               {
                   
                 fr.dispose();
               }
               else if(n == JOptionPane.NO_OPTION)
               {
                   
                  
                  fr.setDefaultCloseOperation(f.DO_NOTHING_ON_CLOSE);
                      
                   
               }
                
            }
        }); 
   
            
   
               
      
    }}}
class exitaction implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
       
            
               Object[] options={"Done! Exit.","Oops! I forgot!"};
               int n= JOptionPane.showOptionDialog(f, "Please save your content before exiting!", "MOSE ", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
     
                
               if(n == JOptionPane.YES_OPTION)
               {
                  f.dispose();
               }
               else if(n == JOptionPane.NO_OPTION)
               {
                   
                  
                  f.setDefaultCloseOperation(f.DO_NOTHING_ON_CLOSE);
                      
                   
               }
                
            
        }}
    

class newaction implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        new Thread(new Runnable()
        {@Override
            public void run()
            {
                 new texteditor();
       
            }
        }).start();
       
}
}
class helpaction implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        mose.getInstance().create();
    }
}
class fntaction implements ActionListener
{
    public void actionPerformed(final ActionEvent e)
    {
        JMenuItem item=(JMenuItem)e.getSource();
        String x=item.getText();
        new fntaction(x);
    } fntaction(String m)
        {
         
        
       String s=m;
       
        String sel=edit.getSelectedText();
        StyledDocument doc=edit.getStyledDocument();
        Style def = edit.addStyle(s, null);
 String sty[]={"regular"};
        
        StyleConstants.setFontFamily(def, s);
       
        try{
            edit.getSelectedText().replace(sel, " ");
        doc.insertString(doc.getLength(), sel,def );
       
        }
        catch(Exception exc)
        {}
        
    
       
              
        
           }
       
      
    }

class bgaction implements ActionListener{
    public void actionPerformed(ActionEvent e)
    {
        JMenuItem item=(JMenuItem)e.getSource();
       
       String s=item.getText();
       if(s.equals("Blue"))
           edit.setBackground(new Color(153,153,255));
       else  if(s.equals("Green"))
           edit.setBackground(new Color(102,255,102));
       else  if(s.equals("Black")){
           edit.setForeground(Color.blue);
           edit.setBackground(new Color(64,64,64));}
       else if(s.equals("Magenta")){
            edit.setForeground(Color.green);
           edit.setBackground(new Color(255,102,178));}
       else if(s.equals("Pink"))
           edit.setBackground(new Color(255,153,255));
         else  if(s.equals("Grey"))
           edit.setBackground(new Color(192,192,192));
         else  if(s.equals("White")){
           edit.setBackground(new Color(255,255,255));
        edit.setForeground(Color.black);}
        
    }
}
class fgaction implements ActionListener{
    public void actionPerformed( final ActionEvent e)
    {
        new Thread(new Runnable()
        {@Override
            public void run()
            {
                 JMenuItem item=(JMenuItem)e.getSource();
       
       String s=item.getText();
       if(s.equals("Blue"))
           edit.setForeground(new Color(153,153,255));
       else  if(s.equals("Green"))
           edit.setForeground(new Color(0,204,0));
       else  if(s.equals("Black"))
           
           edit.setForeground(new Color(64,64,64));
       else if(s.equals("Magenta")){
                      edit.setForeground(new Color(255,102,178));}
       else if(s.equals("Pink"))
           edit.setForeground(new Color(255,153,255));
         else  if(s.equals("Grey"))
           edit.setForeground(new Color(192,192,192));
         else  if(s.equals("White"))
           edit.setForeground(new Color(255,255,255));
            }
        }).start();
       
        
        
    }
}
class phpaction implements ActionListener
{
   
     public void actionPerformed(ActionEvent e)
        {
            try{
               
            openit(edit,fname);
              
        }
            catch(Exception r)
            {
    }}
public void openit(JTextComponent comp,String filename)throws Exception
{
   JFileChooser fileChooser = new JFileChooser();
fileChooser.setDialogTitle("Open .php file");   
 
int userSelection = fileChooser.showOpenDialog(f);
 
if (userSelection == JFileChooser.APPROVE_OPTION) {
    File fileToSave = fileChooser.getSelectedFile();
    fname=fileToSave.getAbsolutePath();
     filename=fname;
     int l=fname.length();
               String reg=fname.substring(l-3);
               if("php".equals(reg)){
     FileReader r=null;
     r=new FileReader(filename);
     comp.read(r,filename);
          comp.setFont(new Font("Lucida Calligraphy Italic",Font.PLAIN,15));

     f.setTitle(fname+" "+"MOSE Editor 1.0");
r.close();    }
               else{System.out.println("not php");
               JOptionPane.showMessageDialog(fileChooser, "Please choose a .php file");
               }
}
}
        
    }

class htmlaction implements ActionListener
{
   
     public void actionPerformed(ActionEvent e)
        {
            try{
               
            openit(edit,fname);
              
        }
            catch(Exception r)
            {
    }}
public void openit(JTextComponent comp,String filename)throws Exception
{
   JFileChooser fileChooser = new JFileChooser();
fileChooser.setDialogTitle("Open .html file");   
 
int userSelection = fileChooser.showOpenDialog(f);
 
if (userSelection == JFileChooser.APPROVE_OPTION) {
    File fileToSave = fileChooser.getSelectedFile();
    fname=fileToSave.getAbsolutePath();
     filename=fname;
     int l=fname.length();
               String reg=fname.substring(l-3);
               if("tml".equals(reg) || "htm".equals(reg)){
     FileReader r=null;
     r=new FileReader(filename);
     comp.read(r,filename);
          comp.setFont(new Font("Simpsonfont",Font.PLAIN,17));

     f.setTitle(fname+" "+"MOSE Editor 1.0");
r.close();    }
               else{System.out.println("not html");
               JOptionPane.showMessageDialog(fileChooser, "Please choose a .html file");
               }
}
}
        
    }

class jspaction implements ActionListener
{
   
     public void actionPerformed(ActionEvent e)
        {
            try{
               
            openit(edit,fname);
              
        }
            catch(Exception r)
            {
    }}
public void openit(JTextComponent comp,String filename)throws Exception
{
   JFileChooser fileChooser = new JFileChooser();
fileChooser.setDialogTitle("Open .jsp file");   
 
int userSelection = fileChooser.showOpenDialog(f);
 
if (userSelection == JFileChooser.APPROVE_OPTION) {
    File fileToSave = fileChooser.getSelectedFile();
    fname=fileToSave.getAbsolutePath();
     filename=fname;
     int l=fname.length();
               String reg=fname.substring(l-3);
               if("jsp".equals(reg)){
     FileReader r=null;
     r=new FileReader(filename);
     comp.read(r,filename);
          comp.setFont(new Font("Tahoma",Font.PLAIN,17));

     f.setTitle(fname+" "+"MOSE Editor 1.0");
r.close();    }
               else{System.out.println("not jsp");
               JOptionPane.showMessageDialog(fileChooser, "Please choose a .jsp file");
               }
}
}
        
    }

class javaaction implements ActionListener
{
   
     public void actionPerformed(ActionEvent e)
        {
            try{
               
            openit(edit,fname);
              
        }
            catch(Exception r)
            {
    }}
public void openit(JTextComponent comp,String filename)throws Exception
{
   JFileChooser fileChooser = new JFileChooser();
fileChooser.setDialogTitle("Open .java file");   
 
int userSelection = fileChooser.showOpenDialog(f);
 
if (userSelection == JFileChooser.APPROVE_OPTION) {
    File fileToSave = fileChooser.getSelectedFile();
    fname=fileToSave.getAbsolutePath();
     filename=fname;
     int l=fname.length();
               String reg=fname.substring(l-3);
               if("ava".equals(reg)){
     FileReader r=null;
     r=new FileReader(filename);
     comp.read(r,filename);
          comp.setFont(new Font("Gill Sans",Font.PLAIN,20));

     f.setTitle(fname+" "+"MOSE Editor 1.0");
r.close();    }
               else{System.out.println("not java");
               JOptionPane.showMessageDialog(fileChooser, "Please choose a .java file");
               }
}
}
        
    }
class caction implements ActionListener
{
   
     public void actionPerformed(ActionEvent e)
        {
            try{
               
            openit(edit,fname);
              
        }
            catch(Exception r)
            {
    }}
public void openit(JTextComponent comp,String filename)throws Exception
{
   JFileChooser fileChooser = new JFileChooser();
fileChooser.setDialogTitle("Open .c file");   
 
int userSelection = fileChooser.showOpenDialog(f);
 
if (userSelection == JFileChooser.APPROVE_OPTION) {
    File fileToSave = fileChooser.getSelectedFile();
    fname=fileToSave.getAbsolutePath();
     filename=fname;
     int l=fname.length();
               String reg=fname.substring(l-1);
               if("c".equals(reg)){
     FileReader r=null;
     r=new FileReader(filename);
     comp.read(r,filename);
          comp.setFont(new Font("SkyFall Done",Font.PLAIN,20));

     f.setTitle(fname+" "+"MOSE Editor 1.0");
r.close();    }
               else{System.out.println("not php");
               JOptionPane.showMessageDialog(fileChooser, "Please choose a .c file");
               }
}
}
        
    }
    
class cppaction implements ActionListener
{
   
     public void actionPerformed(ActionEvent e)
        {
            try{
               
            openit(edit,fname);
              
        }
            catch(Exception r)
            {
    }}
public void openit(JTextComponent comp,String filename)throws Exception
{
   JFileChooser fileChooser = new JFileChooser();
fileChooser.setDialogTitle("Open .cpp file");   
 
int userSelection = fileChooser.showOpenDialog(f);
 
if (userSelection == JFileChooser.APPROVE_OPTION) {
    File fileToSave = fileChooser.getSelectedFile();
    fname=fileToSave.getAbsolutePath();
     filename=fname;
     int l=fname.length();
               String reg=fname.substring(l-1);
               if("c".equals(reg)){
     FileReader r=null;
     r=new FileReader(filename);
     
     comp.read(r,filename);
          comp.setFont(new Font("Yahoo",Font.PLAIN,20));

     f.setTitle(fname+" "+"MOSE Editor 1.0");
r.close();    }
               else{System.out.println("not c++");
               JOptionPane.showMessageDialog(fileChooser, "Please choose a .cpp file");
               }
}
}
          }
}    


