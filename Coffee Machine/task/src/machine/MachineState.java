package machine;

public enum MachineState {
    MAIN("main"),
    BUY("buy"),
    FILL_WATER("fill water"),
    FILL_MILK("fill milk"),
    FILL_COFFEE_BEANS("fill coffee beans"),
    FILL_CUPS("fill cups"),
    TAKE("take"),
    REMAINING("remaining");

    String code;


    MachineState(String code) {
        this.code = code;
    }

    public static MachineState findByCode(String code) {
        for (MachineState value : values()) {
            if (code.equals(value.code)) {
                return value;
            }
        }

        return null;
    };

}