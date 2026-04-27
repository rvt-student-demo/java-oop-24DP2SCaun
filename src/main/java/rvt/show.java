package rvt;

import java.util.ArrayList;
import java.util.List;

public class show {

    private String movie;
    private String time;
    private List<ticket> tickets;

    public show(String movie, String time) {
        this.movie = movie;
        this.time = time;
        this.tickets = new ArrayList<>();
    }

    public String getMovie() {
        return movie;
    }

    public String getTime() {
        return time;
    }

    public List<ticket> getTicket() {
        return tickets;
    }
    
    public void addTicket(ticket ticket) {
        tickets.add(ticket);
    }
}