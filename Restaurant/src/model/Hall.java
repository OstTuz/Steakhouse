package model;

public enum Hall {
    MAIN(100), UNDERGROUND(50), OUTDOOR(70), TERRACE(120);

    private double price;

    Hall(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
