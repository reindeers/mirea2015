import java.util.ArrayList;

public class Cinema {

    private Hall[] halls;
    private Seance[] seances;

    public Cinema(Hall[] halls, Seance[] seances) {
        this.halls = halls;
        this.seances = seances;

    }

    public ArrayList<Seance> find(String search) {
        ArrayList<Seance> found = new ArrayList<Seance>();
        for (Seance seance : seances) {
            if (seance.getName().contains(search)) {
                found.add(seance);
            }
        }
        return found;
    }

    public Seance findById(int searchId) {
        for (Seance seance : seances) {
            if (seance.getId() == searchId) {
                return seance;
            }
        }
        return null;
    }

    public boolean reserve(Seance seance, int row, int seat) {
        if (!seance.getRSeats(row, seat)){
            seance.setRSeats(row, seat);
            return true;
        } else {
            System.out.println("Эти места уже забронированы");
            return false;
        }

    }

    public int getNumberOfRows(int nmb){
        return halls[nmb].getRows();
    }

    public int getNumberOfSeats(int nmb, int rw){
        return halls[nmb].getSeats(rw);
    }
}
