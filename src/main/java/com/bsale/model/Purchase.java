package com.bsale.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Purchase {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int purchaseId;
    private int purchase_date;
    
    public Purchase(int purchaseId, int purchase_date) {
		super();
		this.purchaseId = purchaseId;
		this.purchase_date = purchase_date;
	}

	

  
   

}
