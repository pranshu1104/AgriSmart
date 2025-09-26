public class Address {
  private Double latitude;
  private Double longitude;

  // Constructors
  public Address() {}
  public Address(Double latitude, Double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  // Getters & Setters
  public Double getLatitude() { return latitude; }
  public void setLatitude(Double latitude) { this.latitude = latitude; }

  public Double getLongitude() { return longitude; }
  public void setLongitude(Double longitude) { this.longitude = longitude; }
}
