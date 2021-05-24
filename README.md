# INF101v21-Exam-Preparation
Forklaring på konseptene:
 - Abstraction
 - Encapsulation
 - Inheritance
 - Polymorphism

For eksempler, ta en titt på koden i repositoriet (polymorphism har eksempelet fra semesteroppgave 2).

## Abstraction
**Abstraction** er det å representere virkelige ting på en forenklet måte. Dette vil si å forkaste unødvendige detaljer når noe fra virkeligheten programmeres. I Ball-klassen vi lagde i lab2 så hadde vi feltvariabler for å representere tilstanden til en ball: radius, farge, posisjon, fart og akselerasjon. Noe som ikke ble med i Ball-klassen er f.eks. teksturen til en ball. Dermed har vi abstrahert en ball fra virkeligheten ved å forkaste tilstand og egenskaper som ikke her hensiktsmessig for programmet vårt.
I sem2 har vi mange eksempler på abstraction. Game er en abstraksjon av [M,n,k-game](https://en.wikipedia.org/wiki/M,n,k-game). GameBoard er en abstraksjon av et spillbrett (for disse type spill).

## Encapsulation
**Encapsulation** handler om å styre eksponeringen av variabler og metoder i programmet. Ved bruk av ``public``, ``protected``, ``private`` og `` `` (blankt, ingen keyword) bestemmer vi hvilke deler av programmet som skal ha tilgang på de aktuelle variablene/metodene. I mange tilfeller ønsker vi at feltvariablene til en klasse kun er direkte tilgjengelig i selve klassen. Dette gjøres ved bruk av ``private``:
```java
private double[][] gridArray;
	
private int rows;
private int columns;
	
public Grid(int height, int width) {
	rows = height;
	columns = width;
	
	gridArray = new double[rows][columns];
}
```
Hvis jeg oppretter et Grid-objekt i en annen klasse/del av programmet så vil man ikke kunne referere direkte til ``rows``, ``columns`` og ``gridArray``.
```java
Grid grid = new Grid(5,5);
int nGridRows = grid.rows; // ERROR
grid.gridArray[3][2] = 50.0; // ERROR
```
Istedenfor ønsker vi å eksponere (gi tilgang til) variablene og metodene til klassen på en kontrolert måte. I Grid-klassen oppretter vi en set-metode hvor vi kan legge til pre-conditions for hvilke verdier som er tillatt:
```java
/**
* Set element in grid at coordinates x and y.
* No values above 100.0 are allowed.
* @param x coordinate
* @param y coordinate
* @param value, element to set in the grid
*/
public void set(int x, int y, double value) {
	if (value > 100.0)
		throw new IllegalArgumentException("No values above 100.0 are allowed");
	gridArray[x][y] = value;
}
```

## Inheritance
**Inheritance** brukes til å dele tilstand og egenskaper mellom datatyper. Hvis man oppretter en ``Person``-klasse og en ``Student``-klasse vil det være en del overlapp i tilstand og egenskaper (feltvariabler og metoder) mellom de. En student er en person, dermed blir det naturlig å ha de feltvariablene og metodene for ``Person`` i ``Student``, men vi ønsker ikke duplisering av kode. Da brukes inheritance ved bruk av ``extends``:
```java
public class Person {
	
	private int age;
	private double height;
	private Color hairColor;
	
	public Person(int age, double height, Color hairColor) {
		this.age = age;
		this.height = height;
		this.hairColor = hairColor;
	}
	
}
```

```java
public class Student extends Person {
	
	private int studentNumber;

	public Student(int age, double height, Color hairColor, int studentNumber) {
		super(age, height, hairColor);
		this.studentNumber = studentNumber;
	}
}
```
Nå har ``Student``-objekter alle feltvariablene og metodene i ``Person``, i tillegg til de feltvariablene og metodene som befinner seg kun i ``Student``. I dette eksempelet blir ``Person`` superklassen og ``Student`` subklassen. Vi sier at ``Student`` arver fra ``Person``.

``super`` brukes til å referere til variabler/metoder i superklassen. Hvis en metode befinner seg i begge klassene, altså at metoden fra ``Person`` override'es i ``Student``:
```java
public class Person {
	
	...
	
	public void talk(String text) {
		System.out.println(text);
	}	
}
```
```java
public class Student extends Person {
	
	...
	
	@Override
	public void talk(String text) {
		text.addVoiceCrack();
		System.out.println(text);
	}	
}
```
så kan vi kalle på metoden i superklassen inni subklassen ved bruk av ``super``:
```java
public class Student extends Person {
	
	...
	
	public void talkWithConfidence(String text) {
		super.talk(text);
	}	
}
```


## Polymorphism
**Polymorphism** er en kombinasjon av poly=mange og morphism=det abstrakte begrepet for en funksjon/metode. Polymorphism handler om at et metode-kall referer til flere metoder. Vi har to forskjellige typer: statisk og dynamisk. **Statisk polymorphism** skjer ved kompileringstid. Man har flere metoder (i samme klasse/fil) som heter det samme, men tar inn forskjellige argument. F.eks.:
```java
public Othello(Graphics graphics, Player player1, Player player2) {
	super(new GameBoard(8, 8), graphics);
	addPlayer(player1);
	addPlayer(player2);
	initGameboard();
}

public Othello(Graphics graphics, PlayerList players) {
	super(new GameBoard(8, 8), graphics, players);
	initGameboard();
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
