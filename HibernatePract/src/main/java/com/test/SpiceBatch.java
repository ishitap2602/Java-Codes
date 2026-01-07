package com.test;
import jakarta.persistence.*;

@Entity
@Table(name = "spice_batches")
public class SpiceBatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String spiceType;

    @Column(unique = true)
    private String lotCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farm_id", nullable = false)
    private SpiceFarm farm;

    public SpiceBatch(String spiceType, String lotCode, SpiceFarm farm) {
        this.spiceType = spiceType;
        this.lotCode = lotCode;
        this.farm = farm;
    }

    // getters
    public int getId() { 
    	return id; 
    	}
    public String getSpiceType() { 
    	return spiceType; 
    	}
    public String getLotCode() { 
    	return lotCode; 
    	}
    public SpiceFarm getFarm() { 
    	return farm; 
    	}
}

