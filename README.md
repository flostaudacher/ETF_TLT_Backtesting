# ETF TLT Backtesting

<br/>
<p align="center">
  <a href="https://htl-anichstrasse.tirol">
    <img src=".github/htl.gif" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">ETF-Backtesting</h3>

  <p align="center">
    Es sollte der ETF TLT darauf getestet werden, wie der takeprofit aussieht wenn man jeden Freitag einen buy macht und am nächsten Börsen offenenTag wieder verkauft.
    <br/>
    <a href="https://github.com/htl-anichstrasse/template/releases">Releases</a>
    ·
    <a href="https://github.com/htl-anichstrasse/template/issues">Report Bug</a>
    ·
    <a href="https://github.com/htl-anichstrasse/template/issues">Request Feature</a>
  </p>
</p>

## About the project
<p> Am Beginn der 5ten Klasse ist es die Aufgabe Ziele für das Projekt festzulegen sodass klarer wird was zu erreichen ist</p>
<h1> Goals </h1>
Basis
1. Daten per CSV oder API importieren und in brauchbare Datenstruktur abspeichern
2. Datenstruktur so erweitern, dass die Tradingstrategie auf sie angewendet werden kann, das
heißt den jewiligen Tag ermitteln (Freitag, Donnerstag etc)
3. Trading Strategie anwenden, das heißt überprüfen ob der letzte Börsenaktive Tag einer
Woche ist, an diesem Tag wird dann gekauft buyStock() und am nächsten Börsenaktiven Tag
der nächsten Woche wird wieder verkauft sellStock(). Das Ganze wird mit dem closingValue
des Stocks durchgeführt
4. Als nächster Punkt kommt es zur Visualisierung, diese wird in JavaFX erstellt und es handelt
sich dabei um 3 verschiedene Arten die Daten darzustellen, diese 3 Darstellungsarten werden
dann in ein Flowpane eingetragen.
4.1 Liniendiagramm, das die Darstellung der Trading Strategie an einem Beispieldepot den
Verlauf der Effizienz der Tradingstrategie darstellen soll.
4.2 Balkendiagramm, das die Chance für positive oder Negative Trades darstellen soll.
4.3 Tabelle, diese dient zur Darstellung der Trading Historie, dabei sollten positive Werte
mit der Farbe Grün hervorgehoben werden und negative mit der Farbe Rot.
Bonus
1. Stoplose einbauen, das heißt dass der User vorgeben kann bei welchem Kurs – Depotverluste
die Assets verkauft werden
2. Über die Alphavantage API sollen Daten einer bestimmten Aktie in einem bestimmten
Zeitintervall ausgelesen werden und dann die Anzahle der Tiefpunkte zu den
bestimmten Uhrzeiten ausgelesen werden.
3. Gebühren pro kauf einbinden (Gleichung anpassen)
4. API auf das Basisprojekt anwenden sodass die Trading Strategie auf jede Aktie angewendet
werden kann.
5. Statt input über console einen grafischen Input erstellen


## Contact

If you have any questions about this project, please feel free to contact us.

florstaudacher@tsn.at<br>
HTL Anichstraße - htlinn@tsn.at

<a href="https://htl-anichstrasse.tirol" target="_blank"><img src=".github/logo_background.png" width="180px"></a>
