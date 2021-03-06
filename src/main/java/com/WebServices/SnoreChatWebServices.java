/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WebServices;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Mike
 */
@WebService(serviceName = "SnoreChatWebServices")
public class SnoreChatWebServices {

    /**
     * This is a sample web service operation
     * @param txt
     * @param username
     */
    @WebMethod(operationName = "chatOperation")
    public void chatOperation(@WebParam(name = "username") String username,
            @WebParam(name = "message") String message){
       
        
        Path p = Paths.get("C://SnoreChatFiles/writeToFile.txt");
        String fileName = p.toString();
        
        try {
            Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(fileName, true), "UTF-8")); 
            writer.append(username);
            writer.append(":  ");
            writer.append(message);
            writer.append(System.getProperty("line.separator"));
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(SnoreChatWebServices.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    //Reads the File and returns the chat content
     @WebMethod(operationName = "readFileOperation")
    public List<String> readFileOperation() throws FileNotFoundException, IOException{
            
            String line;
            List<String> mArchive = new ArrayList<String>(); 
            Path p = Paths.get("C://SnoreChatFiles/writeToFile.txt");
            String fileName = p.toString();
            
            BufferedReader input = new BufferedReader(
           new InputStreamReader(new FileInputStream(fileName), "UTF8"));
        
            while((line = input.readLine()) != null ){
            mArchive.add(line);
        }
        input.close();
        return mArchive;
        
    
    }
}
