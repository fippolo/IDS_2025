package unicam.filierafanesicardinali.model.ruoli;


public enum UserRole {
    AUTHENTICATOR(0),
    BUYER(1),
    ENTERTAINER(2),
    SELLER(3);
    private final int code;

    UserRole(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static UserRole fromCode(int code) {
        return switch (code) {
            case 0 -> AUTHENTICATOR;
            case 1 -> BUYER;
            case 2 -> ENTERTAINER;
            case 3 -> SELLER;
            default -> throw new IllegalArgumentException("Invalid code: " + code);
        };
    }
}
