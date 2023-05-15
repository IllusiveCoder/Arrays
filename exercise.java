import java.util.Scanner;
import java.util.Arrays;
import java.lang.System.*;

/**
 * Description: Klasse mit einigen Funktionen um den Vortrag Arrays in verschiedenster Form mit Beispielen zu unters�tzen!
 * 
 * @author Mr_Unknown_Chiller_XX, Illusive Coder
 * @version 26.10.2021
 */
public class exercise
{
  // Instanzvariable initialisieren
    //Deklarierung der Arrays und einigen bestätigten Variablen.
    //Deklariertes und initialisiertes Array mit fester Größe und primitven Datentyp int.
    final int[] array_one = new int[10];
    //Array mit keiner festen Größe und keinem Inhalt, es ist aktuell nur deklariert und noch nicht initialisiert!
    final int[] array_two;
    //Arrayinitialisierung nach der Deklaration
    //Array mit Deklaration und Initialisierung, es hat die Werte aber fest zugewiesen bekommen!
    final int[] array_four = {0,1,2,3,4,5,6,7,8,9};
    //Deklariertes Array mit keiner festen Größe und dem 0wert!
    final Integer[] array_five = null;
    //Deklariertes und initialisiertes zweidimensionales Array mit fester Größe und primitven Datentyp int.
    final int[][] array_six = new int[3][3];
    //Deklariertes und initialisiertes dreidimensionales Array mit fester Größe und primitven Datentyp int.
    final int[][][] array_seven = new int[3][3][3];
    /*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

  //Variablendeklaration
  //Rekursionsvariable
  boolean repeat = true;
  //Startvariable
  boolean start_end = false;
  //Speicher für Input von User
  String user_input = "";
  //Eingabemethode des Programms
  Scanner input = new Scanner(System.in);
  //Zählervariable für Bildschirmreinigung
  int counter = 0;
  //Konstruktor der Klasse exercise
  public exercise()
  {
    array_two = new int[10];
  }
  public static void main(String[] args) {
    //Objekterstellung und Aufrufen der menu()-Methode
    exercise object = new exercise();
    object.menu();
  }
  public void clear()
  {
    //Bildschirmreinigung
    for(int i=0;i<20;i++)
    {
      System.out.println("");
    }
  }
  public void go_back()
  {
    //Wird zu Menü zurück gewechselt
    menu();
  }
  public void menu()
  {
    //Benutzung von Rekursion, um das menü laufen zu lassen.
    if(start_end == false)
    {
      //Erste Ausgabe bei Programmstart, durch die Variable @start_end, nur ein Aufruf.
      System.out.println("Willkommen im Programm!\nBitte wähle eine der folgenden Mehthoden aus, um fortzufahren!");
      menu_select();
      repeat = true;
    }
    else if(repeat == true)
    {
      menu_select();
      start_end = true;
    }
    else
    {
      //überprüfung auf falsche Eingabe und ob das Programm beendet werden soll.
      System.out.println("Es ist leider ein Fehler unterlaufen!\nMöchten Sie beenden? (Ja/Nein)");
      user_input = input.nextLine();
      user_input.toLowerCase();
      switch(user_input)
      {
        case "ja": 
          System.exit(0); 
          break;
        case "nein":
          menu();
          break;
        default:
        System.out.println("Fehler!\nBeende Programm!");
        System.exit(0);
        break;
      }
    }
    
  }
  //Methode zur Bereinigung des Bildschirms, mittels eines Counters.
  public void menu_select()
  {
    if(counter == 5)
    {
      clear();
      counter = 0;
    }
    else
    {
      counter++;
    }
    //Eingabe wird angefordert und überprüft.
    System.out.println("#-----------------------------------------------------------------#");
    System.out.println("1. Alles ausgeben lassen\n2. Element in Array einfügen\n3. Element in Array löschen\n4. Beenden\n(1,2,3,4 wählen)");
    user_input = input.nextLine();
    switch(user_input)
    {
      case "1":
        System.out.println("Alle Arrays ausgeben:");
        print_all();
        menu_select();
        break;
      case "2":
        System.out.println("1. Element in eindimensionales Array einfügen\n2. Element in zweidimensionales Array einfügen\n3. Element in dreidimensionales Array einfügen\n4. Zurück\n5.Beenden\n(1,2,3,4,5 wählen)");
        user_input = input.nextLine();
        //Überprüfung, welcher Befehl ausgeführt werden soll.
        switch(user_input)
        {
          case "1":
            menu_add_element_one_dimension_array();
            go_back();
            break;
          case "2":
            menu_add_element_two_dimensions_array();
            go_back();
            break;
          case "3":
            menu_add_element_three_dimensions_array();
            go_back();
            break;
          case "4":
            menu();
            go_back();
            break;
          case "5":
            System.exit(0);
            break;
          default:
            go_back();
            break;
        }
        break;
      case "3":
      System.out.println("1. Element in eindimensionalem Array löschen\n2. Element in zweidimensionales Array einfügen\n3. Element in dreidimensionales Array einfügen\n4. Zurück\n5.Beenden\n(1,2,3,4,5 wählen)");
      user_input = input.nextLine();
        //Überprüfung, welcher Befehl ausgeführt werden soll.
        switch(user_input)
        {
          case "1":
            menu_delete_element_one_dimension_array();
            go_back();
            break;
          case "2":
            menu_delete_element_two_dimensions_array();
            go_back();
            break;
          case "3":
            menu_delete_element_three_dimensions_array();
            go_back();
            break;
          case "4":
            menu();
            go_back();
            break;
          case "5":
            System.exit(0);
            break;
          default:
            go_back();
            break;
        }
        break;
      case "4":
        System.out.println("Beende Programm!");
        System.exit(0);
        break;
      default:
        //Programm wird durch Methodenaufruf zurückgesetzt
        System.out.println("Falsche Eingabe! Bitte erneut versuchen!");
        menu();
        break;
    }
    
  }
  //Hinzufügen von Elementen in die Arrays, mit jeweiliger Dimension von 1 bis 3.
  void add_element_one_dimension_array(int number, int value)
  {
    array_one[number] = value;
    System.out.println("Element erfolgreich hinzugefügt!");
  }
  void add_element_two_dimensions_array(int number_one,int number_two, int value)
  {
    array_six[number_one][number_two] = value;
    System.out.println("Element erfolgreich hinzugefügt!");
  }
  void add_element_three_dimensions_array(int number_one,int number_two,int number_three, int value)
  {
    array_seven[number_one][number_two][number_three] = value;
    System.out.println("Element erfolgreich hinzugefügt!");
  }
  //Löschen von Elementen aus den Arrays, mit jeweiliger Dimension von 1 bis 3.
  void delete_element_one_dimension_array(int number)
  {
    array_one[number] = 0;
    System.out.println("Element erfolgreich entfernt!");
  }
  void delete_element_two_dimensions_array(int number_one,int number_two)
  {
    array_six[number_one][number_two] = 0;
    System.out.println("Element erfolgreich entfernt!");
  }
  void delete_element_three_dimensions_array(int number_one,int number_two,int number_three)
  {
    array_seven[number_one][number_two][number_three] = 0;
    System.out.println("Element erfolgreich entfernt!");
  }
  //Menüfunktionen Elemente zum Array hinzufügen.
  void menu_add_element_one_dimension_array()
  {
    int number = 0;
    int value = 0;
    System.out.println("Bitte geben Sie den Index und den Wert für das Array ein!");
    System.out.println("#--------------------------------------------------------------#");
    System.out.print("Index: " );
    number = input.nextInt();
    System.out.println("");
    System.out.print("Wert: ");
    value = input.nextInt();
    add_element_one_dimension_array(number,value);
  }
  void menu_add_element_two_dimensions_array()
  {
    int number_one = 0;
    int number_two = 0;
    int value = 0;
    System.out.println("Bitte geben Sie die Indexe und den Wert für das Array ein!");
    System.out.println("#--------------------------------------------------------------#");
    System.out.print("Index Eins: ");
    number_one = input.nextInt();
    System.out.println("");
    System.out.print("Index Zwei: ");
    number_two = input.nextInt();
    System.out.println("");
    System.out.print("Wert: ");
    value = input.nextInt();
    add_element_two_dimensions_array(number_one,number_two,value);
  }
  void menu_add_element_three_dimensions_array()
  {
    int number_one = 0;
    int number_two = 0;
    int number_three = 0;
    int value = 0;
    System.out.println("Bitte geben Sie die Indexe und den Wert für das Array ein!");
    System.out.println("#--------------------------------------------------------------#");
    System.out.print("Index Eins: ");
    number_one = input.nextInt();
    System.out.println("");
    System.out.print("Index Zwei: ");
    number_two = input.nextInt();
    System.out.println("");
    System.out.print("Index Zwei: ");
    number_three = input.nextInt();
    System.out.println("");
    System.out.print("Wert: ");
    value = input.nextInt();
    add_element_three_dimensions_array(number_one,number_two,number_three,value);
  }
  //Menüfunktionen Elemente aus Array entfernen.
  void menu_delete_element_one_dimension_array()
  {
    int number = 0;
    System.out.println("Bitte geben Sie den Index für das Array zum Löschen ein!");
    System.out.println("#--------------------------------------------------------------#");
    System.out.print("Index: ");
    number = input.nextInt();
    delete_element_one_dimension_array(number);
  }
  void menu_delete_element_two_dimensions_array()
  {
    int number_one = 0;
    int number_two = 0;
    System.out.println("Bitte geben Sie die Indexe für das Array zum Löschen ein!");
    System.out.println("#--------------------------------------------------------------#");
    System.out.print("Index Eins: ");
    number_one = input.nextInt();
    System.out.println("");
    System.out.print("Index Zwei: ");
    number_two = input.nextInt();
    delete_element_two_dimensions_array(number_one,number_two);
  }
  void menu_delete_element_three_dimensions_array()
  {
    int number_one = 0;
    int number_two = 0;
    int number_three = 0;
    System.out.println("Bitte geben Sie die Indexe für das Array zum Löschen ein!");
    System.out.println("#--------------------------------------------------------------#");
    System.out.print("Index Eins: ");
    number_one = input.nextInt();
    System.out.println("");
    System.out.print("Index Zwei: ");
    number_two = input.nextInt();
    System.out.println("");
    System.out.print("Index Zwei: ");
    number_three = input.nextInt();
    delete_element_three_dimensions_array(number_one,number_two,number_three);
  }
  //Ausgeben aller Arrays
  void print_all()
  {
    System.out.println("#---------------------------------------------------------------#");
    System.out.println("eindimensionales Array:");
    System.out.println(Arrays.toString(array_one));
    System.out.println("zweidimensionales Array:");
    System.out.println(Arrays.deepToString(array_six));
    System.out.println("dreidimensionales Array:");
    System.out.println(Arrays.deepToString(array_seven));
    System.out.println("#---------------------------------------------------------------#");
  }
}
