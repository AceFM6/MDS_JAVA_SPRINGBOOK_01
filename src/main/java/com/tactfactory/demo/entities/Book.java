package com.tactfactory.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Book extends BaseEntity {

		@Column(nullable = false)
		private String name;
		
		private int NbPage;
		
		private float price;
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public int getNbPage() {
			return NbPage;
		}
		
		public void setNbPage(int nbPage) {
			NbPage = nbPage;
		}
		
		public float getPrice() {
			return price;
		}
		
		public void setPrice(float page) {
			this.price = page;
		}
			
}
