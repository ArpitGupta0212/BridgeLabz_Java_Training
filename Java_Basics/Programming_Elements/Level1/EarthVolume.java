public class EarthVolume {
    public static void main(String[] args) {

        double radiusKm = 6378;   

        double volumeKm = (4.0 / 3) * Math.PI * Math.pow(radiusKm, 3);

        double radiusMiles = radiusKm * 0.621371;
        double volumeMiles = (4.0 / 3) * Math.PI * Math.pow(radiusMiles, 3);

        System.out.println("Volume of Earth in cubic kilometers: " + volumeKm);
        System.out.println("Volume of Earth in cubic miles: " + volumeMiles);
    }
}