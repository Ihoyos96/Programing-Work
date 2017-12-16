#include <stdio.h>
#include <stdlib.h>

#define SUPER_RICH 500000
#define QUITE_RICH 200000
#define MIAMI_POOR 100000
#define AVERAGE 50000
#define REALISTIC 20000


int calculateTaxable(int income, int deductions){
	int taxable = income + deductions;

	return taxable;
}

char calculateTaxGroup(int taxableIncome){

	char taxGroup;

	if (taxableIncome >= SUPER_RICH){
		taxGroup = 'S';
	}else if (taxableIncome >= QUITE_RICH){
		taxGroup = 'Q';
	}else if (taxableIncome >= MIAMI_POOR){
		taxGroup = 'M';
	}else if (taxableIncome >= AVERAGE){
		taxGroup = 'A';
	}else if (taxableIncome >= REALISTIC){
		taxGroup = 'R';
	}else{
		taxGroup = 'P';
	}

	return taxGroup;
}

int calculateTaxOwed(int taxableIncome, char taxGroup){

	int tax = 0;

	
	if (taxGroup == 'S'){
		tax = taxableIncome*(.25);
		if (tax>50000){
			tax=50000; 
		}
		return tax;
	}
	if (taxGroup == 'Q'){
		tax = taxableIncome*(.10);
		return tax;
	}
	if (taxGroup == 'M'){
		tax = taxableIncome*(.10);
		return tax;
	}
	if (taxGroup == 'A'){
		tax = taxableIncome*(.03);
		return tax;
	}
	if (taxGroup == 'R'){
		tax = taxableIncome*(.03);
		return tax;
	}
	if (taxGroup == 'P') {
		tax = 0;
		tax = 0;
		return tax;
	}

	return tax;
}

int main(void) {

	int income = 0;
	int taxableIncome = 0;
	int deductions = 0;

	char taxGroup;
	int taxOwed;

	int in = 1;

	while (in != 0) {
		printf("Enter next amount: ");
		scanf("%d", &in);
		if (in < 0) {
			deductions = deductions + in;
		}
		else {
			income = income + in;
		}
	}

	taxableIncome = calculateTaxable(income, deductions);
	taxGroup = calculateTaxGroup(taxableIncome);
	taxOwed = calculateTaxOwed(taxableIncome, taxGroup);

	printf("Income         : $%d\n", income);
  	printf("Deductions     : $%d\n", deductions);
  	printf("Taxable Income : $%d\n", taxableIncome);
 	printf("Tax group:     : %c\n", taxGroup);
 	printf("Tax owed       : $%d\n", taxOwed);

 	return(0);
}
