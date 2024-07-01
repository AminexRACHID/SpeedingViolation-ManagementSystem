package org.miaad.immatriculationservice.web.soap;

import jakarta.xml.ws.Endpoint;
public class ImmatriculationServiceSoapApllication {
    public static void main(String[] args){
        Endpoint.publish("http://0.0.0.0:3030/", new ImmatriculationServiceSoap());
        System.out.println("web service deploye");
    }
}
