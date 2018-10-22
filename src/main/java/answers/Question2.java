package answers;

public class Question2 {
	static int[] cashin;
	static int[] cashout;
	static int[] In;
	static int[] Out;
	
	public static int equallyBalancedCashFlow(int[] cashflowIn, int[] cashflowOut) {
		// TODO Auto-generated method stub
		//global variable for in and out
		cashin =new int[cashflowIn.length];
		for(int i=0;i<cashflowIn.length;i++){
			cashin[i] = cashflowIn[i];
		}
		cashout =new int[cashflowOut.length];
		for(int i=0;i<cashflowOut.length;i++){
			cashout[i] = cashflowOut[i];
		}
		//all the possible combination
		int[] In = new int[combinationsSum(cashflowIn.length)];
		int[] Out = new int[combinationsSum(cashflowIn.length)];
		int output=0;
		int count=0;
		//calculate the possible combination
		while(combinationsSum(cashflowIn.length)>count){
			int slot=
			In[count]=
			count++;
		}
		
		return output;
	}
	//sum of combination
	public static int combinationsSum(int input){
		int amount=0;
		for(int count = 1;count<input;count++)amount+=(combinations(input, count));
		amount+=1;
		return amount;
	}
	//combination
	public static int combinations(int n, int i){
		return (factorial(n)*1/(factorial(i)*factorial(n-i)));
	}
	//factorial
	public static int factorial(int n){
		int fact = 1;
		for(int count =1;count<=n;count++)fact=fact*count;
		return fact;
	}
	//tbc
	public static int remaindersum(int[] cashflow, int number){
		return -1;
	}

}
