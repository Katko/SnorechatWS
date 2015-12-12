/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WebServices;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
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
     */
    @WebMethod(operationName = "chatOperation")
    public void chatOperation(@WebParam(name = "message") String txt){
       
        
        Path p = Paths.get("C://SnoreChatFiles/writeToFile.txt");
        String fileName = p.toString();
        
        try {
            Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(fileName, true), "UTF-8")); 
            writer.append(txt);
            writer.append(":");
            writer.append(txt);
            writer.append(System.getProperty("line.separator"));
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(SnoreChatWebServices.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
}