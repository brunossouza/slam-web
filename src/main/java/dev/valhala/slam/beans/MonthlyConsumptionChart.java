package dev.valhala.slam.beans;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class MonthlyConsumptionChart {

    private double consumption;
    private String month;

    public MonthlyConsumptionChart(String month, double consumption) {
        this.consumption = consumption / 3600000;
        this.month = LocalDate.of(LocalDate.now().getYear(),Integer.parseInt(month),01).getMonth().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("pt"));
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "MonthlyConsumptionChart{" +
                "consumption=" + consumption +
                ", month='" + month + '\'' +
                '}';
    }
}
