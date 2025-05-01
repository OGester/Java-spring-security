package se.java.security.dto;

public class InvalidFieldError {

        private String field;
        private String message;

        public InvalidFieldError(String field, String message) {
            this.field = field;
            this.message = message;
        }


    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

