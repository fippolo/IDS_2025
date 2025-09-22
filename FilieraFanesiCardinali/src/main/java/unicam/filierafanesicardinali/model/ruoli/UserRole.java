package unicam.filierafanesicardinali.model.ruoli;


public enum UserRole {
    ADMIN(0),
    MODERATOR(1),
    USER(2),
    GUEST(3);

    private final int code;

    UserRole(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static UserRole fromCode(int code) {
        return switch (code) {
            case 0 -> ADMIN;
            case 1 -> MODERATOR;
            case 2 -> USER;
            case 3 -> GUEST;
            default -> throw new IllegalArgumentException("Invalid code: " + code);
        };
    }
}
