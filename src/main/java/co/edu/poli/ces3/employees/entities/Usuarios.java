package co.edu.poli.ces3.employees.entities;

public class Usuarios {
    protected int id_usuario;
    private String nombre;
    private String apellido;
    private String edad;
    private String identificacion;
    private int id_tipo_usuario_fk;
    private int id_genero_fk;
    private int id_tipo_identificacion_fk;

    public Usuarios(int id_usuario, String nombre, String apellido, String edad, String identificacion,
                    int id_tipo_usuario_fk, int id_genero_fk, int id_tipo_identificacion_fk) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.identificacion = identificacion;
        this.id_tipo_usuario_fk = id_tipo_usuario_fk;
        this.id_genero_fk = id_genero_fk;
        this.id_tipo_identificacion_fk = id_tipo_identificacion_fk;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getId_tipo_usuario_fk() {
        return id_tipo_usuario_fk;
    }

    public void setId_tipo_usuario_fk(int id_tipo_usuario_fk) {
        this.id_tipo_usuario_fk = id_tipo_usuario_fk;
    }

    public int getId_genero_fk() {
        return id_genero_fk;
    }

    public void setId_genero_fk(int id_genero_fk) {
        this.id_genero_fk = id_genero_fk;
    }

    public int getId_tipo_identificacion_fk() {
        return id_tipo_identificacion_fk;
    }

    public void setId_tipo_identificacion_fk(int id_tipo_identificacion_fk) {
        this.id_tipo_identificacion_fk = id_tipo_identificacion_fk;
    }
}
