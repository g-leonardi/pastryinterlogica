package giuseppe.leonardi.pasticceria.webapp.models.gui;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TableRow {
    private String name;
    private int quantity;
    private double price;
    private long pastryId;
}
