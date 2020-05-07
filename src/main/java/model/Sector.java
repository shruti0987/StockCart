package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "StockCategory")
@Table(name = "Sectors")
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sectorid;

    @Column(name = "Sector_name")
    private String sectorName;

    @OneToMany(
        mappedBy = "stockCategory",
        cascade = CascadeType.PERSIST,
        fetch = FetchType.LAZY
    )
    private Set<Stock> stocks;

    public Sector() {
        stocks = new HashSet<>();
    }

    public Sector(String name) {
        this.sectorName = name;
        stocks = new HashSet<>();
    }

    public int getId() {
        return sectorid;
    }

    public void setId(int id) {
        this.sectorid = id;
    }

    public String getName() {
        return sectorName;
    }

    public void setName(String name) {
        this.sectorName = name;
    }

    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
        for (Stock stock : stocks) {
            stock.setStockCategory(this);
        }
    }
}

