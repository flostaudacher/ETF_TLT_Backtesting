import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

public class barChartMethods {
	static Series<String, Number> create(Series<String, Number> s, String p) {
		s.setName("" + p);
		if (p.equals("positiv")) {
			s.getData().add(new XYChart.Data<>(p,(vizualizingMethods.PN[0] / vizualizingMethods.tradingCounter) * 100.0));
		}
		if (p.equals("negativ")) {
			s.getData().add(new XYChart.Data<>(p,(vizualizingMethods.PN[1] / vizualizingMethods.tradingCounter) * 100.0));
		}
		return s;
	}
}
