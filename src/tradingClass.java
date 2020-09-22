
public class tradingClass {
	static double availabeMoney = 10000;
	static int amountOfStockAvailable;

	static void buyStock(String arr) {
		double closingValue = Double.parseDouble(arr);
		amountOfStockAvailable = (int) (availabeMoney / closingValue);
		System.out.println("Kauf: \t\t Anzahl Positionen = "+ amountOfStockAvailable + "\t zu = "+ closingValue);
		availabeMoney = availabeMoney - amountOfStockAvailable * closingValue;
	}

	static void SellStock(String arr) {
		double closingValue = Double.parseDouble(arr);
		System.out.println("Verkauf: \t Anzahl Positionen = "+ amountOfStockAvailable + "\t zu = "+ closingValue);
		availabeMoney = availabeMoney + amountOfStockAvailable * closingValue;
		amountOfStockAvailable = 0;

	}

	void calcNewDepotValue () {

	}

}


/*
 Fragen an en Rubi
 =================
 1. Fals Montag oder Freitag börsenfrei sind sollte dann ein anderer Tag zum Tage des trades verwendet werden?
 2. Mit einem Fixen Geldbetrag von anfang an traden und überprüfen ob man am ende einen höheren Betrag hat?
 3. ist es ziel die Erfolgschance zu berechnen oder den take profit nach 20 jahren bei einem bestimmten geldeinsatz?
 */