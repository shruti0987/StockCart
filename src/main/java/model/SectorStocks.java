package model;
import java.io.Serializable;
import java.util.Objects;

public class SectorStocks implements Serializable {

    private long userid;
    private long stockid;
    private String date;

    public SectorStocks() {
    }

    public SectorStocks(long userid,long stockid,String date) {
        this.date=date;
        this.stockid=stockid;
        this.userid=userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectorStocks obj = (SectorStocks) o;
       if(userid!=obj.userid) return false; 
       if(!date.equals(obj.date)) return false;
       return (stockid==obj.stockid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, stockid,date);
    }
}