package enams;

public enum Success {
    OK(0L, "GOOD"),
    FAIL(1L, "FAIL"),
    NOT_FOUND(2L, "User not found");

    private Long id;
    private String message;

    Success(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
