import java.util.ArrayList;
import java.util.List;

public class cinema
{
    public void addHall(Hall hall)
    {
        _halls.add(hall);
    }

    public String getAdress()//------------------------------------------------------------------------------
    {
        return _adress;
    }

     cinema (String adress)
     {
         this._adress = adress;
         this._halls = new ArrayList<Hall>();
     }

    public void setAdress(String addr)
    {
        _adress = addr;
    }

    private String _adress;
    private List<Hall> _halls;
}