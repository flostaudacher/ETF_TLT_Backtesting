
import java.text.DecimalFormat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Callback;

public class table extends Pane{
	public static TableView<Trade> table = new TableView<Trade>();
	public static ObservableList<Trade> data = FXCollections.observableArrayList();

	static int tradingCounter = 0;
	static DecimalFormat f = new DecimalFormat("#0.00");

	@SuppressWarnings("unchecked")
	public static VBox tableCreat() {

		final Label label = new Label("Trading History");
		label.setFont(new Font("Arial", 20));
		table.setEditable(false);
		calc();
		fill();
		TableColumn Datum = new TableColumn("Datum");
		Datum.impl_setReorderable(false);
		Datum.setCellValueFactory(
				new PropertyValueFactory<Trade ,String>("Datum")
				);
		TableColumn Positionen = new TableColumn("Positionen");
		Positionen.impl_setReorderable(false);
		Positionen.setCellValueFactory(
				new PropertyValueFactory<Trade ,String>("Positionen")
				);
		TableColumn Kaufpreis = new TableColumn("Kaufpreis");
		
		Kaufpreis.impl_setReorderable(false);
		Kaufpreis.setCellValueFactory(
				new PropertyValueFactory<Trade ,String>("Kaufpreis")
				);
		TableColumn Verkaufspreis = new TableColumn("Verkaufpreis");
		Verkaufspreis.impl_setReorderable(false);
		Verkaufspreis.setCellValueFactory(
				new PropertyValueFactory<Trade ,String>("Verkaufpreis")
				);
		TableColumn Umsatz = new TableColumn("Umsatz");
		Umsatz.impl_setReorderable(false);
		Umsatz.setCellValueFactory(
				new PropertyValueFactory<Trade ,String>("Umsatz")
				);
		Umsatz.setCellFactory(column -> {
			return new TableCell<Trade, String>() {
				@Override
				protected void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null || empty) {
						setText("");
						setStyle("");
					} else {
						if (item.equals("positiver Trade")) {
							setTextFill(Color.GREEN);
							setText("positiver Trade");
						} else {
							setTextFill(Color.RED);
							setText("negativer Trade");
							setStyle("");
						}
					}
				}
			};
		});

		table.setItems(data);
		table.getColumns().addAll(Datum, Positionen, Kaufpreis, Verkaufspreis,Umsatz);
		table.minWidth(510);
		final VBox vbox = new VBox();
		vbox.setMinWidth(510);
		vbox.getChildren().addAll(label, table);

		return vbox;
	}


	public static void fill() {

		for (int Rowc = 1; Rowc < tradingCounter;Rowc++) {
			data.addAll(new Trade(Backtesting_Main.tableValue[Rowc][0], Backtesting_Main.tableValue[Rowc][1], Backtesting_Main.tableValue[Rowc][2],Backtesting_Main.tableValue[Rowc][3],Backtesting_Main.tableValue[Rowc][4]));
		}
	}

	public static void calc() {
		for (int Rowc = 1; Rowc < Import.anzahlZeilen; Rowc++) {
			if (Import.arr[Rowc][7].equals("Fr")) {
				tradingClass.buyStock(Import.arr[Rowc-1][4]);
				int positions = tradingClass.amountOfStockAvailable;
				tradingClass.SellStock(Import.arr[Rowc][4]);
				tradingCounter++;
				if ((tradingClass.getValueAtBuy() - tradingClass.getValueAtSell()) < 0) {
					Backtesting_Main.tableValue[tradingCounter][0] = Import.arr[Rowc][0]; //Datum in TabellenArray
					Backtesting_Main.tableValue[tradingCounter][1] = String.valueOf(positions);
					Backtesting_Main.tableValue[tradingCounter][2] = String.valueOf(f.format(tradingClass.buyValue));
					Backtesting_Main.tableValue[tradingCounter][3] = String.valueOf(f.format(tradingClass.sellValue));
					Backtesting_Main.tableValue[tradingCounter][4] = "positiver Trade";
				}
				else {
					Backtesting_Main.tableValue[tradingCounter][0] = Import.arr[Rowc][0]; //Datum in TabellenArray
					Backtesting_Main.tableValue[tradingCounter][1] = String.valueOf(positions);
					Backtesting_Main.tableValue[tradingCounter][2] = String.valueOf(f.format(tradingClass.buyValue));
					Backtesting_Main.tableValue[tradingCounter][3] = String.valueOf(f.format(tradingClass.sellValue));
					Backtesting_Main.tableValue[tradingCounter][4] = "negativer Trade";
				}
			}
		}
	}

}