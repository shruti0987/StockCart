package model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "StockCategory")
@Table(name = "Sectors")
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private int sectorid;

    @Column(name = "Sector_name")
    @Getter @Setter
    private String sectorName;

    @OneToMany(
        mappedBy = "stockCategory",
        cascade = CascadeType.PERSIST,
        fetch = FetchType.LAZY
    )
    private Set<RStock> stocks;

    public Sector() {
        stocks = new HashSet<>();
    }

    public Sector(String name) {
        this.sectorName = name;
        stocks = new HashSet<>();
    }

    public Set<RStock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<RStock> stocks) {
        this.stocks = stocks;
        for (RStock stock : stocks) {
            stock.setStockCategory(this);
        }
    }
}

