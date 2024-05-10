public enum EDadosBanco {
    AGENCIA("001254-3");

    private String value;

    EDadosBanco(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
