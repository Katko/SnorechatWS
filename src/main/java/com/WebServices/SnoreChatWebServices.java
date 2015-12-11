/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WebServices;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.Compiler.command;
import java.nio.file.Path;
import java.nio.file.Paths;
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
     */
    @WebMethod(operationName = "chatOperation")
    public void chatOperation(@WebParam(name = "message") String txt) {
       
        
        Path p = Paths.get("C://SnoreChatFiles/writeToFile.txt");
        String fileName = p.toString();
        try{
            PrintWriter outputStream = new PrintWriter(fileName);
            outputStream.println(txt);
            outputStream.close();
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
            
        }
        
    
    }    
}
