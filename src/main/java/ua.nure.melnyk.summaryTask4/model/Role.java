package ua.nure.melnyk.summaryTask4.model;

/**
 * Role enum
 */
public enum Role {
    ADMIN(1),
    USER(2);

    private int value;
    Role(int i) {
        this.value=i;
    }

    public int getValue() {
        return value;
    }
}
