package sungdam;

import java.util.*;

// Location 클래스: 도시 이름, 위도, 경도 저장
class Location {
    private String city;
    private double latitude;   // 위도
    private double longitude;  // 경도

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

// Question7_1 클래스
public class Question7_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Location> map = new HashMap<>();

        System.out.println("도시, 경도, 위도를 입력하세요.");
        for (int i = 0; i < 4; i++) {
            System.out.print(">> ");
            String city = sc.next();
            double latitude = sc.nextDouble();
            double longitude = sc.nextDouble();
            map.put(city, new Location(city, latitude, longitude));
        }

        // 저장된 도시 정보 출력
        System.out.println("--------------------------");
        for (String key : map.keySet()) {
            Location loc = map.get(key);
            loc.showInfo();
        }
        System.out.println("--------------------------");

        // 도시 이름으로 검색
        while (true) {
            System.out.print("도시 이름 >> ");
            String name = sc.next();
            if (name.equals("그만")) break;

            Location loc = map.get(name);
            if (loc == null)
                System.out.println(name + "는 없습니다.");
            else
                System.out.println(loc.getCity() + " " + loc.getLatitude() + " " + loc.getLongitude());
        }

        sc.close();
    }
}
