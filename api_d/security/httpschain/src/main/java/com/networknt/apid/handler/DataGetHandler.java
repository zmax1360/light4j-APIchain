
package com.networknt.apid.handler;

import com.networknt.config.Config;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataGetHandler implements HttpHandler {
    @Override
    public void handleRequest( HttpServerExchange exchange ) throws Exception {

        exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
        List<String> messages = new ArrayList<>();
        messages.add("API D: Message 1");
        messages.add("API D: Message 2");

     exchange.getResponseSender().send(Config.getInstance().getMapper().writeValueAsString(messages));

    }
}
