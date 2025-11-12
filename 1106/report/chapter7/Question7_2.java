package sungdam;

import java.util.*;

class Location {
    private String city;
    private double latitude;
    private double longitude;

    public Location(String city, double latitude, double longitude) {
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCity() { return city; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }

    public void showInfo() {
        System.out.println(city + " " + latitude + " " + longitude);
    }
}

public class Question7_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Location> list = new ArrayList<>();

        System.out.println("도시, 경도, 위도를 입력하세요.");
        for (int i = 0; i < 4; i++) {
            System.out.print(">> ");
            String city = sc.next();
            double latitude = sc.nextDouble();
            double longitude = sc.nextDouble();
            list.add(new Location(city, latitude, longitude));
        }

        // 입력된 도시 출력
        System.out.println("--------------------------");
        for (Location loc : list) {
            loc.showInfo();
        }
        System.out.println("--------------------------");

        // 도시 검색
        while (true) {
            System.out.print("도시 이름 >> ");
            String name = sc.next();
            if (name.equals("그만")) break;

            boolean found = false;
            for (Location loc : list) {
                if (loc.getCity().equals(name)) {
                    System.out.println(loc.getCity() + " " + loc.getLatitude() + " " + loc.getLongitude());
                    found = true;
                    break;
                }
            }
            if (!found)
                System.out.println(name + "는 없습니다.");
        }

        sc.close();
    }
}
