import java.util.ArrayList;
import java.util.List;

public class Hall
{
    Hall (int number, int line, int place)
    {
        this._number = number;
        this._seatingArrangement = new int[line][place];
        this._seances = new ArrayList<moveSeance>();
    }
//-----------------------------------------------------------------------------------------
    public void addSeance(moveSeance seance)
    {
        _seances.add(seance);
    }

    //public int[][] getSeatingArrangement() {return _seatingArrangement;}

    public List<moveSeance> getSeance() {return _seances;}



    private int _number;
    private int[][] _seatingArrangement;//расположение кресел
    private List<moveSeance> _seances;
}