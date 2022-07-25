package co.edu.poli.ces3.employees.entities;

public class Response {
    private Boolean status;
    private String message;

    public Response(Boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public Response() {
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
