package com.indhawk.getfiteat.foods.model;

public class NutritionFacts {
	
	public int servingSize;
    public int servingPerContainer;
    public int calories;
    public int caloriesFromFat;
    public int totalFat;
    public int totalFatPercent;
    public int saturatedFat;
    public int saturatedFatPercent;
    public int transFat;
    public int transFatPercent;
    public int cholesterol;
    public int cholesterolPercent;
    public int sodium;
    public int sodiumPercent;
    public int totalCarbohydrates;
    public int totalCarbohydratesPercent;
    public int dietaryFiber;
    public int dietaryFiberPercent;
    public int sugars;
    public int protein;
    public int proteinPercent;
    public int vitaminAPercent;
    public int vitaminCPercent;
    public int calciumPercent;
    public int ironPercent;
	
    public NutritionFacts() {
		super();
	}

	public int getServingSize() {
		return servingSize;
	}

	public void setServingSize(int servingSize) {
		this.servingSize = servingSize;
	}

	public int getServingPerContainer() {
		return servingPerContainer;
	}

	public void setServingPerContainer(int servingPerContainer) {
		this.servingPerContainer = servingPerContainer;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getCaloriesFromFat() {
		return caloriesFromFat;
	}

	public void setCaloriesFromFat(int caloriesFromFat) {
		this.caloriesFromFat = caloriesFromFat;
	}

	public int getTotalFat() {
		return totalFat;
	}

	public void setTotalFat(int totalFat) {
		this.totalFat = totalFat;
	}

	public int getTotalFatPercent() {
		return totalFatPercent;
	}

	public void setTotalFatPercent(int totalFatPercent) {
		this.totalFatPercent = totalFatPercent;
	}

	public int getSaturatedFat() {
		return saturatedFat;
	}

	public void setSaturatedFat(int saturatedFat) {
		this.saturatedFat = saturatedFat;
	}

	public int getSaturatedFatPercent() {
		return saturatedFatPercent;
	}

	public void setSaturatedFatPercent(int saturatedFatPercent) {
		this.saturatedFatPercent = saturatedFatPercent;
	}

	public int getTransFat() {
		return transFat;
	}

	public void setTransFat(int transFat) {
		this.transFat = transFat;
	}

	public int getTransFatPercent() {
		return transFatPercent;
	}

	public void setTransFatPercent(int transFatPercent) {
		this.transFatPercent = transFatPercent;
	}

	public int getCholesterol() {
		return cholesterol;
	}

	public void setCholesterol(int cholesterol) {
		this.cholesterol = cholesterol;
	}

	public int getCholesterolPercent() {
		return cholesterolPercent;
	}

	public void setCholesterolPercent(int cholesterolPercent) {
		this.cholesterolPercent = cholesterolPercent;
	}

	public int getSodium() {
		return sodium;
	}

	public void setSodium(int sodium) {
		this.sodium = sodium;
	}

	public int getSodiumPercent() {
		return sodiumPercent;
	}

	public void setSodiumPercent(int sodiumPercent) {
		this.sodiumPercent = sodiumPercent;
	}

	public int getTotalCarbohydrates() {
		return totalCarbohydrates;
	}

	public void setTotalCarbohydrates(int totalCarbohydrates) {
		this.totalCarbohydrates = totalCarbohydrates;
	}

	public int getTotalCarbohydratesPercent() {
		return totalCarbohydratesPercent;
	}

	public void setTotalCarbohydratesPercent(int totalCarbohydratesPercent) {
		this.totalCarbohydratesPercent = totalCarbohydratesPercent;
	}

	public int getDietaryFiber() {
		return dietaryFiber;
	}

	public void setDietaryFiber(int dietaryFiber) {
		this.dietaryFiber = dietaryFiber;
	}

	public int getDietaryFiberPercent() {
		return dietaryFiberPercent;
	}

	public void setDietaryFiberPercent(int dietaryFiberPercent) {
		this.dietaryFiberPercent = dietaryFiberPercent;
	}

	public int getSugars() {
		return sugars;
	}

	public void setSugars(int sugars) {
		this.sugars = sugars;
	}

	public int getProtein() {
		return protein;
	}

	public void setProtein(int protein) {
		this.protein = protein;
	}

	public int getProteinPercent() {
		return proteinPercent;
	}

	public void setProteinPercent(int proteinPercent) {
		this.proteinPercent = proteinPercent;
	}

	public int getVitaminAPercent() {
		return vitaminAPercent;
	}

	public void setVitaminAPercent(int vitaminAPercent) {
		this.vitaminAPercent = vitaminAPercent;
	}

	public int getVitaminCPercent() {
		return vitaminCPercent;
	}

	public void setVitaminCPercent(int vitaminCPercent) {
		this.vitaminCPercent = vitaminCPercent;
	}

	public int getCalciumPercent() {
		return calciumPercent;
	}

	public void setCalciumPercent(int calciumPercent) {
		this.calciumPercent = calciumPercent;
	}

	public int getIronPercent() {
		return ironPercent;
	}

	public void setIronPercent(int ironPercent) {
		this.ironPercent = ironPercent;
	}

	@Override
	public String toString() {
		return "NutritionFacts [servingSize=" + servingSize + ", servingPerContainer=" + servingPerContainer
				+ ", calories=" + calories + ", caloriesFromFat=" + caloriesFromFat + ", totalFat=" + totalFat
				+ ", totalFatPercent=" + totalFatPercent + ", saturatedFat=" + saturatedFat + ", saturatedFatPercent="
				+ saturatedFatPercent + ", transFat=" + transFat + ", transFatPercent=" + transFatPercent
				+ ", cholesterol=" + cholesterol + ", cholesterolPercent=" + cholesterolPercent + ", sodium=" + sodium
				+ ", sodiumPercent=" + sodiumPercent + ", totalCarbohydrates=" + totalCarbohydrates
				+ ", totalCarbohydratesPercent=" + totalCarbohydratesPercent + ", dietaryFiber=" + dietaryFiber
				+ ", dietaryFiberPercent=" + dietaryFiberPercent + ", sugars=" + sugars + ", protein=" + protein
				+ ", proteinPercent=" + proteinPercent + ", vitaminAPercent=" + vitaminAPercent + ", vitaminCPercent="
				+ vitaminCPercent + ", calciumPercent=" + calciumPercent + ", ironPercent=" + ironPercent + "]";
	}
       

}
