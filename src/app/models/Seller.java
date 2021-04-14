package app.models;

import javafx.beans.property.StringProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.util.Optional;

public class Seller {
    private StringProperty id;
    private StringProperty name;
    private StringProperty phone;
    private DoubleProperty profit;

    public Seller(String id, String name, String phone, Double profit) {
        setId(id);
        setName(name);
        setPhone(phone);
        setProfit(profit);
    }

    public Seller(String id, String name, String phone) {
        setId(id);
        setName(name);
        setPhone(phone);
        setProfit(0.0);
    }

    /**
     *
     * Sets the id of the seller.
     * @param value id to be set.
     */
    public void setId(String value) {
        idProperty().set(value);
    }

    /**
     *
     * @return the id of the seller.
     */
    public String getId() {
        return idProperty().get();
    }

    /**
     *
     * @return the id of the seller as a StringProperty.
     */
    public StringProperty idProperty() {
        if (id == null) id = new SimpleStringProperty(this, "id");
        return id;
    }

    /**
     *
     * Sets the name of the seller.
     * @param value name to be set.
     */
    public void setName(String value) {
        nameProperty().set(value);
    }

    /**
     *
     * @return the name of the seller.
     */
    public String getName() {
        return nameProperty().get();
    }

    /**
     *
     * @return the name of the seller as a StringProperty.
     */
    public StringProperty nameProperty() {
        if (name == null) name = new SimpleStringProperty(this, "name");
        return name;
    }

    /**
     *
     * Sets the phone of the seller.
     * @param value phone to be set.
     */
    public void setPhone(String value) {
        phoneProperty().set(value);
    }

    /**
     *
     * @return the phone of the seller.
     */
    public String getPhone() {
        return phoneProperty().get();
    }

    /**
     *
     * @return the phone of the seller as a StringProperty.
     */
    public StringProperty phoneProperty() {
        if (phone == null) phone = new SimpleStringProperty(this, "phone");
        return phone;
    }

    /**
     *
     * Sets the profit of the seller.
     * @param value profit to be set.
     */
    public void setProfit(double value) {
        profitProperty().set(value);
    }

    /**
     *
     * @return the phone of the seller.
     */
    public double getProfit() {
        return profitProperty().get();
    }

    /**
     *
     * @return the phone of the seller as a DoubleProperty.
     */
    public DoubleProperty profitProperty() {
        if (profit == null) profit = new SimpleDoubleProperty(this, "profit");
        return profit;
    }
}
