import java.util.Date;


class moveSeance
{
    moveSeance(String moveName, Date start, int[][] place)
    {
        this._moveName = moveName;
        this._startOfTheSeance = start;
        this._occupiedPlaces = place;
    }

    public void setPlaces(int line, int place) {this._occupiedPlaces[line][place] = 1;}

    public String getMoveName() {return _moveName;}

    public Date getStartOfTheSeance(){return _startOfTheSeance;}
    public int[][] getOccupiedPlaces(){return _occupiedPlaces;}


    private String _moveName;
    //private int _lasting; //в минутах
    private Date _startOfTheSeance;
    //private boolean[][] _occupiedPlaces;
    private int[][] _occupiedPlaces;
}