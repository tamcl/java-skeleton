package answers;

public class Question2 {
	static int[] cashin;
	static int[] cashout;
	static int[][][] InComb;
	static int[][][] OutComb;
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
		int[] Out = new int[combinationsSum(cashflowOut.length)];
		int output=1000;
		int count=0;
		int maxIn, maxOut;
		maxIn=0;
		for(int i=1; i<cashflowIn.length;i++){
			if(combinations(cashflowIn.length,i)>maxIn){
				maxIn=combinations(cashflowIn.length,i);
			}
		}
		InComb = new int[cashflowIn.length][maxIn][cashflowIn.length];
		maxOut=0;
		for(int i=1; i<cashflowOut.length;i++){
			if(combinations(cashflowOut.length,i)>maxOut){
				maxOut=combinations(cashflowOut.length,i);
			}
		}
		OutComb = new int[cashflowOut.length][maxOut][cashflowOut.length];
		//set value in combination
		for(int i=0;i<cashflowIn.length;i++){
			for(int n=0;n<maxIn;n++){
				for(int c=0; c<cashflowIn.length;c++)
				InComb[i][n][c]=cashflowIn.length;
			}
		}
		for(int i=0;i<cashflowOut.length;i++){
			for(int n=0;n<maxOut;n++){
				for(int c=0; c<cashflowOut.length;c++)
				OutComb[i][n][c]=cashflowOut.length;
			}
		}	
		for(int i=0;i<cashflowIn.length;i++){
			for(int c=0;c<i+1;c++){
				InComb[i][0][c]=c;
			}
		}
		for(int i=0;i<cashflowOut.length;i++){
			for(int c=0;c<i+1;c++){
				OutComb[i][0][c]=c;
			}
		}
		//in
		for(int n=0;n<combinations(cashflowIn.length,1);n++){
			InComb[0][n][0]=n;
		}
		for(int i=1;i<cashflowIn.length;i++){
			for(int n=1;n<combinations(cashflowIn.length,i+1);n++){
				for(int c=0;c<i+1;c++){
					InComb[i][n][c]=InComb[i][n-1][c];
				}
				
				InComb[i][n][i]=InComb[i][n][i]+1;
				
				if(InComb[i][n][i]>=cashflowIn.length){
					int ct=0;
					InComb[i][n][i]=InComb[i][n][i]-1;
					for(int t=i;t>=1;t--){
						if(InComb[i][n][t]-InComb[i][n][t-1]>1){
							ct=t-1;
							break;
						}
					}
					InComb[i][n][ct]=InComb[i][n][ct]+1;
					for(int t=ct+1;t<=i;t++){
						InComb[i][n][t]=InComb[i][n][t-1]+1;
					}
				}
			}
		}

				

		//out
		for(int n=0;n<combinations(cashflowOut.length,1);n++){
			OutComb[0][n][0]=n;
		}
		for(int i=1;i<cashflowOut.length;i++){
			for(int n=1;n<combinations(cashflowOut.length,i+1);n++){
				for(int c=0;c<i+1;c++){
					OutComb[i][n][c]=OutComb[i][n-1][c];
				}
				
				OutComb[i][n][i]=OutComb[i][n][i]+1;
				
				if(OutComb[i][n][i]>=cashflowOut.length){
					int ct=0;
					OutComb[i][n][i]=OutComb[i][n][i]-1;
					for(int t=i;t>=1;t--){
						if(OutComb[i][n][t]-OutComb[i][n][t-1]>1){
							ct=t-1;
							break;
						}
					}
					OutComb[i][n][ct]=OutComb[i][n][ct]+1;
					for(int t=ct+1;t<=i;t++){
						OutComb[i][n][t]=OutComb[i][n][t-1]+1;
					}
				}
			}
		}
		
		
		
		int ctt = 0;
		for(int i=0;i<cashflowIn.length;i++){
			for(int n=0;n<combinations(cashflowIn.length,i+1);n++){
				for(int c=0;c<i+1;c++){
					In[ctt]+=cashflowIn[InComb[i][n][c]];
				}
				ctt++;
			}
		}
		
		ctt = 0;
		for(int i=0;i<cashflowOut.length;i++){
			for(int n=0;n<combinations(cashflowOut.length,i+1);n++){
				for(int c=0;c<i+1;c++){
					Out[ctt]+=cashflowOut[OutComb[i][n][c]];
				}
				ctt++;
			}
		}
		
		for(int i=0;i<In.length;i++){
			for(int c=0; c<combinationsSum(cashflowOut.length);c++){
				if(In[i]-Out[c]>=0){
					output=In[i]-Out[c];
				}
			}
		}
		for(int i=0;i<In.length;i++){
			for(int c=0; c<Out.length;c++){
				if(In[i]-Out[c]<output&&In[i]-Out[c]>=0){
					output=In[i]-Out[c];
				}
			}
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
