package org.LibrarySystemDesign.library.corporate.model;

public class LicenseRequest {
    private final String employeeId;
    private final String assetId;
    private final double cost;

    public LicenseRequest(String employeeId, String assetId, double cost) {
        this.employeeId = employeeId;
        this.assetId = assetId;
        this.cost = cost;
    }

    public String getEmployeeId() {

        return employeeId;
    }

    public String getAssetId() {

        return assetId;
    }

    public double getCost() {

        return cost;
    }

    public static class Builder {

        private String employeeId;
        private String assetId;
        private double cost;

        public Builder setEmployeeId(String id) {
        this.employeeId = id;
        return this;
    }

    public Builder setAssetId(String id) {
        this.assetId = id;
        return this;
    }

    public Builder setCost(double cost) {
        this.cost = cost;
        return this;
    }
    public LicenseRequest build() {

            return new LicenseRequest(employeeId,assetId,cost);
    }
    }
}
