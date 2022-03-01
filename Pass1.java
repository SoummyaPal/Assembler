package ASSEMBLER;
import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;
import java.util.*;

import javax.print.DocFlavor.STRING;
import javax.print.attribute.HashAttributeSet;

public class Pass1 {
    public static void main(String[] args) {
        
        BufferedReader br=null;
        FileReader fr=null;

        FileWriter fw=null;
        BufferedWriter bw=null;

        try {
            
            String inputfilename="C:\Users\Soummya\Desktop\JAVA\ASSEMBLER\Input.txt";
            fr=new FileReader(inputfilename);
            br=new BufferedReader(fr);

            String OUTPUTFILENAME="C:\Users\Soummya\Desktop\JAVA\ASSEMBLER\IC.txt";
            fw=new FileWriter(OUTPUTFILENAME);
            bw=new BufferedWriter(fw);

            //pnemonic and optcode
            //for imperitive statement
            Hashtable<String, String> is=new Hashtable<String, String>();
            is.put("STOP","00");
            is.put("ADD","01");
            is.put("SUB","02");
            is.put("MULT","03");
            is.put("MOVER","04");
            is.put("MOVEM","05");
            is.put("COMP","06");
            is.put("BC","07");
            is.put("DIV","08");
            is.put("READ","09");
            is.put("PRINT","10");

            //for declarative statement
            Hashtable<String, String> dl=new Hashtable<String, String>();
            dl.put("DC","01");
            dl.put("DS", "02");

            //for assembler directive
            Hashtable<STRING, String> ad=new Hashtable<String, String>();
            ad.put("START", "01");
            ad.put("END", "02");
            ad.put("ORIGIN","03");
            ad.put("EQU", "04");
            ad.put("LTORG", "05");

           //DS needed to be created to run the program
           //Symbol table, Literal Table, Pool Table
            Hashtable<String, String> symtab=new Hashtable<String, String>();
            Hashtable<String, String> littab=new Hashtable<String, String>();
            ArrayList<Integer> pooltab=new ArrayList<Integer>();

            String sCurrentLine; //used to read current line
            int locptr=0; //location pointer
            int litptr1; //literal table pointer
            int symptr=1; //symbol table pointer
            int pooltabptr=1; //pooltable pointer

            sCurrentLine=br.readLine(); //reading the file line by line

            String s1=sCurrentLine.split(" ")[1];  //s1 contains the first word of the line
            if(s1.equals("START")){
                bw.write("AD \t 01 \t");
                String s2=sCurrentLine.split(" ")[2]; //contains second word of the line
                bw.write("C \t"+s2+"\n");
                locptr=Integer.parseInt(s2);
            }


        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
