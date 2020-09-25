
public class tradingClass {
	static double availabeMoney = 10000;
	static int amountOfStockAvailable;
	static double buyValue;
	static double sellValue;
	static void buyStock(String arr) {
		double closingValueBuy = Double.parseDouble(arr);
		amountOfStockAvailable = (int) (availabeMoney / (closingValueBuy)); // formel wo die Gebühren hin gehören
		buyValue = closingValueBuy;
		getValueAtBuy();
		availabeMoney = availabeMoney - amountOfStockAvailable * (closingValueBuy);
	}

	public static double getValueAtBuy() {
		// TODO Auto-generated method stub
		return buyValue;
	}

	static void SellStock(String arr) {
		double closingValueSell = Double.parseDouble(arr);
		availabeMoney = availabeMoney + amountOfStockAvailable * (closingValueSell);
		sellValue = closingValueSell;
		getValueAtSell();
		amountOfStockAvailable = 0;

	}
	public static double getValueAtSell() {
		// TODO Auto-generated method stub
		return sellValue;
	}

}


/*
 =================
 1. Fals Montag oder Freitag börsenfrei sind sollte dann ein anderer Tag zum Tage des trades verwendet werden?
 2. Mit einem Fixen Geldbetrag von anfang an traden und überprüfen ob man am ende einen höheren Betrag hat?
 3. ist es ziel die Erfolgschance zu berechnen oder den take profit nach 20 jahren bei einem bestimmten geldeinsatz?
 */