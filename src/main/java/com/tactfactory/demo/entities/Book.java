package com.tactfactory.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Book extends BaseEntity {

		@Column(nullable = false)
		private String name;
		
		@Column(nullable = false)
		private int nbPage;
		
		@Column(nullable = false)
		private float price;
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public int getNbPage() {
			return nbPage;
		}
		
		public void setNbPage(int nbPage) {
			this.nbPage = nbPage;
		}
		
		public float getPrice() {
			return price;
		}
		
		public void setPrice(float price) {
			this.price = price;
		}
			
}
