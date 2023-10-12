package HW4.Models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import HW4.Services.CashProvider;
import HW4.Services.TicketProvider;
import HW4.Services.UserProvider;

public class Customer {
    public int id;
    public CashProvider cash;
    public List<Ticket> tickets;
    public TicketProvider ticketProvider;

    public Customer(int id, CashProvider cash, List<Ticket> tickets, TicketProvider ticketProvider) {
        this.id = id;
        this.cash = cash;
        this.tickets = tickets;
        this.ticketProvider = ticketProvider;
    }

    public boolean autoriseUserbyTelephoneNumber(String telNumber) {
        UserProvider userProvider = new UserProvider();
        if (userProvider.authoriseUserByTelephone(telNumber) != null)
            cash.authorization(userProvider.authoriseUserByTelephone(telNumber));
        else
            System.out.println("Что-то пошло не так");
        return true;

    }

    public boolean buyTicket(Ticket ticket) {

        Payment payment = new Payment(ticket.getTime(), ticket.getPrice(), ticket.getRootNumber());
        cash.buy(payment, ticketProvider);
        return true;
    }

    public List<Ticket> searchTicket(Date date) {
        return ticketProvider.getTicketList(date);
    }

    public Ticket selectTicketFromList(List<Ticket> ticketsSelected) {
        Random random = new Random();
        int index = 0;
        Ticket selectedTicket = null;
        List<Ticket> ticketsFree = new ArrayList<>();
        for (Ticket ticket : ticketsSelected) {
            if (!ticket.isValid())
                ticketsFree.add(ticket);
        }

        int quality = random.nextInt(1) * ticketsFree.size();
        for (Ticket iterable_element : ticketsFree) {
            if (index == quality)
                selectedTicket = iterable_element;
            index++;
        }
        return selectedTicket;
    }
    /*
     * public void showTickets() {
     * List<Ticket> tickets = ticketProvider.getTickets();
     * for (Ticket ticket : tickets) {
     * String.format("Место: %d", "Время: %tc", "Цена: %d",
     * ticket.getPlace(),
     * ticket.getTime(),
     * ticket.getPrice());
     * }
     * }
     */
}