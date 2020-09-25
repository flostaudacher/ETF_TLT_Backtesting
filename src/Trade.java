import javafx.beans.property.SimpleStringProperty;

public class Trade {
	private final SimpleStringProperty Datum;
	private final SimpleStringProperty Positionen;
	private final SimpleStringProperty Kaufpreis;
	private final SimpleStringProperty Verkaufpreis;
	private final SimpleStringProperty Umsatz;

	Trade(String Datum, String Positionen, String Kaufpreis, String Verkaufpreis, String Umsatz) {
		this.Datum = new SimpleStringProperty(Datum);
		this.Positionen = new SimpleStringProperty(Positionen);
		this.Kaufpreis = new SimpleStringProperty(Kaufpreis);
		this.Verkaufpreis = new SimpleStringProperty(Verkaufpreis);
		this.Umsatz = new SimpleStringProperty(Umsatz);
	}

	public SimpleStringProperty getDatum() {
		return Datum;
	}

	public SimpleStringProperty getPositionen() {
		return Positionen;
	}

	public SimpleStringProperty getKaufpreis() {
		return Kaufpreis;
	}

	public SimpleStringProperty getVerkaufpreis() {
		return Verkaufpreis;
	}

	public SimpleStringProperty getUmsatz() {
		return Umsatz;
	}
}
