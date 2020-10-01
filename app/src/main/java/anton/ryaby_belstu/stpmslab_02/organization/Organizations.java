package anton.ryaby_belstu.stpmslab_02.organization;

public enum Organizations {
    ORACLE,
    ITECHART,
    ITRANSITION,
    EPAM,
    ISSOFT;

    public static Organizations getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

}


