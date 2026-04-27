package rvt;

public class ticket {

    private int seat;
    private int code;
    private show show;

    public ticket(int seat, int code, show show) {
        this.seat = seat;
        this.code = code;
        this.show = show;
        show.addTicket(this);
    }

    public int getSeat() {
        return seat;
    }

    public int getCode() {
        return code;
    }

    public show getShow() {
        return show;
    }
}