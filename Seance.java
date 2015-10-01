public class Seance {

    private int id;
    private String name;
    private String time;
    private int hallNumber;
    private boolean[][] resSeats;

    public Seance(int id, String name, String time, int hallNumber) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.hallNumber = hallNumber;


    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public boolean setRSeats(int row, int seat){
        resSeats[row][seat] = true;
        return true;
    }

    public boolean getRSeats(int row, int seat){
        return this.resSeats[row][seat];
    }

    public boolean first(int row, int seat){
        this.resSeats = new boolean[row][seat];
        return true;
    }

    @Override
    public String toString() {
        return id + ". " + name + ", " + time + ", зал №" + hallNumber;
    }
}
