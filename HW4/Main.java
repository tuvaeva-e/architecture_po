package HW4;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import HW4.Models.Customer;
import HW4.Models.Ticket;
import HW4.Services.CashProvider;
import HW4.Services.TicketProvider;

public class Main {
    public static void main(String[] args) {

        CashProvider cp1 = new CashProvider(23423340, false);
        TicketProvider tp1 = new TicketProvider();
        List<Ticket> tickets = new ArrayList<>();
        List<Ticket> tickets1 = new ArrayList<>();
        Ticket ticket1;
        Customer customer1 = new Customer(0, cp1, tickets, tp1);

        Date date = new Date(0);

        tickets1 = customer1.searchTicket(date); // Покупатель запрашивает список билетов
        ticket1 = customer1.selectTicketFromList(tickets1); // Покупатель выбирает билет из предложенного списка
        Boolean what = customer1.autoriseUserbyTelephoneNumber("89130020012"); // Покупатель авторизуется, чтобы
                                                                               // осуществить покупку
        System.out.println(what);
        if (customer1.buyTicket(ticket1)) // Покупатель покупает выбранный билет
            System.out.printf("Билет %d куплен", ticket1.getRootNumber());

        tickets1 = customer1.searchTicket(date); // Покупатель запрашивает список билетов
        ticket1 = customer1.selectTicketFromList(tickets1); // Покупатель выбирает билет из предложенного списка
        what = customer1.autoriseUserbyTelephoneNumber("89130020012"); // Покупатель авторизуется, чтобы
                                                                       // осуществить покупку
        System.out.println(what);
        if (customer1.buyTicket(ticket1)) // Покупатель покупает выбранный билет
            System.out.printf("Билет %d куплен", ticket1.getRootNumber());

        // customer1.showTickets();

    }
}
