package seedu.trippie.command;

import org.junit.jupiter.api.Test;
import seedu.trippie.Storage;
import seedu.trippie.Ui;
import seedu.trippie.data.Trip;
import seedu.trippie.data.TrippieData;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ExitCommandTest {
    @Test
    void exitCommand_validUserInput_parsedCorrectly() throws ParseException {
        Ui ui = new Ui();
        Storage storage = new Storage();
        TrippieData trippieData = new TrippieData(storage);
        fileSetup(storage, trippieData);

        ExitCommand c = new ExitCommand();
        c.execute(ui, trippieData);

        assertTrue(c.isExit());
    }

    private void fileSetup(Storage storage, TrippieData trippieData) throws ParseException {
        storage.setupMasterFile(trippieData);
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Trip newTrip = new Trip(trippieData.getTripList().size(), "Singapore", df.parse("11-11-2020"));
        newTrip.getExpenseListObject().setForExValue(Float.parseFloat("100"));
        newTrip.getExpenseListObject().setCurrencyAbbreviation("SGD");
        newTrip.getExpenseListObject().setBudgetValue(Float.parseFloat("1000"));
        trippieData.getTripList().add(newTrip);
    }
}