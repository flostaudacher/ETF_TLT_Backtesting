
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class table extends Pane{
	public static TableView<Trade> table = new TableView<Trade>();
	public static ObservableList<Trade> data = fill(); 

	@SuppressWarnings("unchecked")
	public static TableView tableCreat() {

		final Label label = new Label("Address Book");
		label.setFont(new Font("Arial", 20));
		System.out.println(data);
		table.setEditable(true);

		TableColumn Datum = new TableColumn("Datum");
		Datum.setCellValueFactory(
			    new PropertyValueFactory<Trade,String>("Datum")
			);
		TableColumn Positionen = new TableColumn("Positionen");
		Positionen.setCellValueFactory(
			    new PropertyValueFactory<Trade,String>("Positionen")
			);
		TableColumn Kaufpreis = new TableColumn("Kaufpreis");
		Kaufpreis.setCellValueFactory(
			    new PropertyValueFactory<Trade,String>("Kaufpreis")
			);
		TableColumn Verkaufspreis = new TableColumn("Verkaufspreis");
		Verkaufspreis.setCellValueFactory(
			    new PropertyValueFactory<Trade,String>("Verkaufpreis")
			);
		TableColumn Umsatz = new TableColumn("Umsatz");
		Umsatz.setCellValueFactory(
			    new PropertyValueFactory<Trade,String>("Umsatz")
			);
		table.setItems(data);
		table.getColumns().addAll(Datum, Positionen, Kaufpreis, Verkaufspreis,Umsatz);

		return table;
	}


	public static ObservableList<Trade> fill() {
		for (int Rowc = 0; Rowc < vizualizingMethods.tradingCounter;Rowc++) {
			return FXCollections.observableArrayList(new Trade(Backtesting_Main.tableValue[Rowc][0], Backtesting_Main.tableValue[Rowc][1], Backtesting_Main.tableValue[Rowc][2],Backtesting_Main.tableValue[Rowc][3],Backtesting_Main.tableValue[Rowc][4]));
		}
		return null;
	}

}
