package br.com.agendanoclick.model;

public enum LoginRole {
    USER,
    PROFESSIONAL,
    ADMIN;

    public String getValue() {
        return this.name();
    }

    public void setValue(String value) {
    }
}

