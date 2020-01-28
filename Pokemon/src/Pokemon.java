import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    public static void main(String[] args) {
       pokemonsNumber("NESOSN");
       pokemonsNumber("SNOABC");
       pokemonsNumber("");
    }
public static void pokemonsNumber(String coordinates) {

    int place_x = 0;
    int place_y = 0;
    int poKNumber = 1;
    boolean coord_Ok = true;
    List<Point> points = new ArrayList<>(); // coordinates list
    Point newPlace = new Point(0,0); //original place (0,0)
    points.add(newPlace); // If Ash doesn't move from original place, he has only 1 Pokemon(place) in the list

        for (int i = 0; i < coordinates.length(); i++) {
            //Check if coordinates are of type N,S,O,E. If not, the Pokemon number is not retrieved.
            if ((coordinates.charAt(i) != 'N') && (coordinates.charAt(i) != 'S') &&
                    (coordinates.charAt(i) != 'O') && (coordinates.charAt(i) != 'E')) {
                System.out.println("Coordendas inválidas. Por favor introduza N, S, O ou E.");
                coord_Ok = false;
                break; //if are invalid, stop for loop
            }

            if (coordinates.charAt(i) == 'N'){
                place_y += 1;
                newPlace = new Point(place_x, place_y);
                if (!points.contains(newPlace)){ //Ash gets a new Pokemon for each new place he's in
                    poKNumber +=1;
                }
                points.add(new Point(newPlace));
            }
            if (coordinates.charAt(i) == 'S'){
                place_y -= 1;
                newPlace = new Point(place_x, place_y);
                if (!points.contains(newPlace)){
                    poKNumber +=1;
                }
                points.add(new Point(newPlace));
            }
            if (coordinates.charAt(i) == 'O'){
                place_x -= 1;
                newPlace = new Point(place_x, place_y);
                if (!points.contains(newPlace)){
                    poKNumber +=1;
                }
                points.add(new Point(newPlace));
            }
            if (coordinates.charAt(i) == 'E'){
                place_x += 1;
                newPlace = new Point(place_x, place_y);
                if (!points.contains(newPlace)){
                    poKNumber +=1;
                }
                points.add(new Point(newPlace));
            }
        }
        if (coord_Ok) {
            System.out.println("Número de Pokemons: " + poKNumber);
        }

}

}