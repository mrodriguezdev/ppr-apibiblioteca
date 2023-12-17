package me.mrodriguezdev.apibiblioteca.domains.models;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class AuthResponseDTO {
    private String token;
    private Data data;

    public AuthResponseDTO(String token, Data data) {
        this.token = token;
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public Data getData() {
        return data;
    }

    public static class Data {
        private String email;
        private String nombre;
        private String rol;

        public Data() {
        }

        public Data(String email, String nombre, String rol) {
            this.email = email;
            this.nombre = nombre;
            this.rol = rol;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getRol() {
            return rol;
        }

        public void setRol(String rol) {
            this.rol = rol;
        }
    }
}
