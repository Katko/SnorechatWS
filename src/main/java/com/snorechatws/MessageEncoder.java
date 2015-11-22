package com.snorechatws;

import javax.json.Json;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;


/**
 *
 * @author Michalis
 */

// Encoders will convert java objects to Websocket messages. And here we use to convert an object to String 
public class MessageEncoder implements Encoder.Text<Message> {
	@Override
	public void init(final EndpointConfig config) {
	}

	@Override
	public void destroy() {
	}

	@Override
	public String encode(final Message chatMessage) throws EncodeException {
		return Json.createObjectBuilder()
				.add("message", chatMessage.getMessage())
				.add("sender", chatMessage.getSender())
				.add("received", chatMessage.getReceived().toString()).build()
				.toString();
	}
}
