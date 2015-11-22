/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snorechatws;

import java.io.StringReader;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author Mike
 */
public class MessageDecoder {

//Decoders will convert Websocket messages to java objects. And here we convert string to java object
public class ChatMessageDecoder implements Decoder.Text<Message> {
	@Override
	public void init(final EndpointConfig config) {
	}
        

	@Override
	public void destroy() {
	}

	@Override
        //Here we create a json object reader and we return the message
	public Message decode(final String textMessage) throws DecodeException {
		Message chatMessage = new Message();
		JsonObject obj = Json.createReader(new StringReader(textMessage))
				.readObject();
		chatMessage.setMessage(obj.getString("message"));
		chatMessage.setSender(obj.getString("sender"));
		return chatMessage;
	}

	@Override
	public boolean willDecode(final String s) {
		return true;
	}
}

    
}
