/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Ticket;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {

    // Try multiple possible paths to be safe
    private static final String[] POSSIBLE_PATHS = {
        "src/data/ticket.csv",
        "data/ticket.csv",
        "ticket.csv"
    };
    private String activePath = POSSIBLE_PATHS[0]; 
    private static final String CSV_HEADER = "TicketID,Sender,Category,Subject,Status";

    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = new ArrayList<>();
        File file = findFile();

        if (file == null || !file.exists()) {
            System.err.println("❌ TicketDAO: CSV file NOT found in any expected location.");
            return tickets;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                
                // Regex handles commas inside quotes
                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                if (data.length >= 5) {
                    tickets.add(new Ticket(
                        data[0].replace("\"", "").trim(),
                        data[1].replace("\"", "").trim(),
                        data[2].replace("\"", "").trim(),
                        data[3].replace("\"", "").trim(),
                        data[4].replace("\"", "").trim()
                    ));
                }
            }
            System.out.println("✅ TicketDAO: Loaded " + tickets.size() + " tickets from " + activePath);
        } catch (IOException e) {
            System.err.println("❌ TicketDAO: Error reading CSV: " + e.getMessage());
        }
        return tickets;
    }

    public boolean updateTicketStatus(String ticketID, String newStatus) {
        List<Ticket> tickets = getAllTickets();
        boolean found = false;

        for (Ticket t : tickets) {
            if (t.getTicketID().equals(ticketID)) {
                t.setStatus(newStatus);
                found = true;
                break;
            }
        }

        if (found) {
            return saveAllTickets(tickets);
        }
        return false;
    }

    private boolean saveAllTickets(List<Ticket> tickets) {
        File file = findFile();
        // If file doesn't exist yet, we'll use the default path
        String path = (file != null) ? file.getPath() : POSSIBLE_PATHS[0];

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write(CSV_HEADER);
            bw.newLine();
            for (Ticket t : tickets) {
                // Wrap fields in quotes to prevent CSV breakage from commas
                String line = String.format("\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"",
                        t.getTicketID(), t.getSenderName(), t.getCategory(), 
                        t.getSubject(), t.getStatus());
                bw.write(line);
                bw.newLine();
            }
            return true;
        } catch (IOException e) {
            System.err.println("❌ TicketDAO: Error writing CSV: " + e.getMessage());
            return false;
        }
    }

    private File findFile() {
        for (String path : POSSIBLE_PATHS) {
            File file = new File(path);
            if (file.exists()) {
                activePath = path;
                return file;
            }
        }
        return null;
    }
}