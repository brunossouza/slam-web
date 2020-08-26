package dev.valhala.slam.beans;

public class MonthlyConsumptionChart {

    private double consumption;
    private String month;

    public MonthlyConsumptionChart(double consumption, String month) {
        this.consumption = consumption;
        this.month = month;
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
