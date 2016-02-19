package com.pexsoftware.enterprise.dashboard.ws;

public class MockClass 
{
    private String hola = "Default Hola";
    private String adios = "Default Adios";        

    public MockClass(String strHola, String strAdios) {
        this.hola = strHola;
        this.adios = strAdios;
    }

    public String getAdios() {
        return adios;
    }

    public void setAdios(String strAdios) {
        this.adios = adios;
    }

    public String getHola() {
        return hola;
    }

    public void setHola(String strHola) {
        this.hola = strHola;
    }

}