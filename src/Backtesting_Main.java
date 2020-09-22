
public class Backtesting_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Import.setup();
		double money = 100000;
		int anzahlOptions = 3;
		double [] usageOfDepotValue = { 0.25 ,  0.5, 1};
		int[][] option = new int[3][2]; 
		//Import.printArray();
		Diagramm.main(args);
	}
	
}
