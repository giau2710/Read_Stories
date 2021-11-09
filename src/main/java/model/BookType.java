package model;

public enum BookType {
    FAIRY_TALES_VN(1), FAIRY_TALES_FOREIGN(2);

    private int value;


    private BookType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static BookType fromValue(int value) {
        BookType[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            BookType c = var1[var3];
            if (c.value == value) {
                return c;
            }
        }

        throw new IllegalArgumentException("Invalid book type value: " + value);
    }
}
