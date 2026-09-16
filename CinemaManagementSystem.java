import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Movie {
    private String title;
    private String genre;
    private int duration;

    public Movie(String title, String genre, int duration) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public int getDuration() { return duration; }
}

class Screening {
    private Movie movie;
    private String screeningTime;
    private int totalSeats;
    private int reservedSeats;

    public Screening(Movie movie, String screeningTime, int totalSeats, int reservedSeats) {
        this.movie = movie;
        this.screeningTime = screeningTime;
        this.totalSeats = totalSeats;
        this.reservedSeats = reservedSeats;
    }

    public int getRemainingSeats() {
        return totalSeats - reservedSeats;
    }

    public void printInfo() {
        System.out.println("영화 제목: " + movie.getTitle());
        System.out.println("장르: " + movie.getGenre());
        System.out.println("영화 길이: " + movie.getDuration() + "분");
        System.out.println("상영 시간: " + screeningTime);
        System.out.println("남은 좌석: " + getRemainingSeats() + " / " + totalSeats);
    }
}

public class CinemaManagementSystem {
    public static void main(String[] args) {
        Map<String, Screening> screeningMap = new HashMap<>();

        Movie movie1 = new Movie("인셉션", "SF/액션", 148);
        screeningMap.put(movie1.getTitle(), new Screening(movie1, "14:30", 100, 45));

        Movie movie2 = new Movie("범죄도시", "액션/범죄", 121);
        screeningMap.put(movie2.getTitle(), new Screening(movie2, "16:00", 150, 145));

        Movie movie3 = new Movie("어바웃 타임", "로맨스/코미디", 123);
        screeningMap.put(movie3.getTitle(), new Screening(movie3, "18:45", 80, 20));

        Movie movie4 = new Movie("파묘", "오컬트/미스터리", 134);
        screeningMap.put(movie4.getTitle(), new Screening(movie4, "21:00", 120, 115));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n[상영 목록]");
            for (String title : screeningMap.keySet()) {
                System.out.println("- " + title);
            }

            System.out.print("\n영화 제목 입력 (종료: q): ");
            String input = scanner.nextLine().trim();

            if (input.equals("q")) {
                break;
            }

            Screening targetScreening = screeningMap.get(input);

            if (targetScreening != null) {
                System.out.println("\n[조회 결과]");
                targetScreening.printInfo();
            } else {
                System.out.println("\n목록에 없는 영화입니다.");
            }
        }

        scanner.close();
    }
}
