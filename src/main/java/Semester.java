public class Semester {
    private int year;
    private String season = "";
    private int credits;
    private String loadStatus;
    private double grants;
    private double tuitionFeesDue;

    public Semester(int year, String season) {
        this.year = year;
        this.season = season;
    }

    public int get_year() {
        return year;
      }

    public String get_season() {
        return season;
    }

    public String get_sem() {
      int y = year;
      String year_string = String.valueOf(y);
      return season + " " + year_string;
    }
}
