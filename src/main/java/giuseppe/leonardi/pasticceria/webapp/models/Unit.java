package giuseppe.leonardi.pasticceria.webapp.models;

public enum Unit {
    KILOGRAM("Kilogrammo","kg"),
    HECTOGRAM("Etto","hg"),
    GRAM("Grammo","g"),
    LITER("Litro","lt"),
    MILLILITER("Millilitro", "ml");

    private final String localizedName;
    private final String symbol;

    Unit(String localizedName, String symbol) {
        this.localizedName = localizedName;
        this.symbol = symbol;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public String getSymbol() {
        return symbol;
    }
}
