# INF101v21-Exam-Preparation

### Abstraction
**Abstraction** er det å representere virkelige ting på en forenklet måte. Dette vil si å forkaste unødvendige detaljer når noe fra virkeligheten programmeres. I Ball-klassen vi lagde i lab2 så hadde vi feltvariabler for å representere tilstanden til en ball: radius, farge, posisjon, fart og akselerasjon. Noe som ikke ble med i Ball-klassen er f.eks. teksturen til en ball. Dermed har vi abstrahert en ball fra virkeligheten ved å forkaste tilstand og egenskaper som ikke her hensiktsmessig for programmet vårt.
I sem2 har vi mange eksempler på abstraction. Game er en abstraksjon av [M,n,k-game](https://en.wikipedia.org/wiki/M,n,k-game). GameBoard er en abstraksjon av et spillbrett (for disse type spill).

### Polymorphism
**Polymorphism** er en kombinasjon av poly=mange og morphism=det abstrakte begrepet for en funksjon/metode. Polymorphism handler om at et metode-kall referer til flere metoder. Vi har to forskjellige typer: statisk og dynamisk. **Statisk polymorphism** skjer ved kompileringstid. Man har flere metoder (i samme klasse/fil) som heter det samme, men tar inn forskjellige argument. F.eks.:
```java
public Othello(Graphics graphics, Player player1, Player player2) {
	super(new GameBoard(8, 8), graphics);
	addPlayer(player1);
	addPlayer(player2);
	initGame();
}

public Othello(Graphics graphics, PlayerList players) {
	super(new GameBoard(8, 8), graphics, players);
	initGame();
}
```
Når jeg kaller på konstruktøren til Othello:
```java
Game game = new Othello(...);
```
så er det flere metoder som kan bli kalt. Dette avhenger av hvilke argument jeg gir.

**Dynamisk polymorphism** skjer ved kjøretid. Når en metode deles ved flere klasser som er koblet sammen ved inheritance vil hvilken instans av metoden som faktisk brukes avhenge av hvilken objekt-instans metoden kalles på.
```java
game.canPlace(loc);
```
Når jeg kaller ``canPlace`` kan dette referere til flere metoder. Det kan være snakk om ``Othello::canPlace``, ``Connect4::canPlace`` eller ``TicTacToe::canPlace``. 
Hvilken av disse metodene som kalles avhenger av hvilken datatype ``game`` har.
```java
Game game = new Othello(graphics, p1, p2);
game.canPlace();
```
I koden ovenfor kalles ``Othello::canPlace``
