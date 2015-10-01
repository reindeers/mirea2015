public class Hall {

    private int[] seats;


    public Hall(int... seats) {
        this.seats = seats;
    }

    public int getRows(){
        return seats.length;
    }

    public int getSeats(int rw){
        return seats[rw];
    }
}
