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
		for(int i=0;i<cashflowIn.length;i++){
			for(int n=1;n<combinations(cashflowIn.length,i+1)-1;n++){
				for(int c=0;c<cashflowIn.length;c++){
					InComb[i][n][c]=InComb[i][n-1][c];
				}
				InComb[i][n][cashflowIn.length-1]+=1;
				boolean check = false;
				int ct =0;
				while(check==false){
					check = true;
					if(InComb[i][n][cashflowIn.length-1]>=cashflowIn.length){
						check=false;
					}
					for(int t=0;t<cashflowIn.length;t++){
						if(InComb[i][n][t]<InComb[i][n][t+1]){
							check = false;
						}
					}
					//reconstruct
					for(int t=cashflowIn.length-2;t>=0;t--){
						if(InComb[i][n][t+1]-InComb[i][n][t]==1){
							ct=t;
						}
					}
					InComb[i][n][ct]+=1;
					int temp = InComb[i][n][ct]+1;
					for(int t=ct+1;t<cashflowIn.length;t++){
						InComb[i][n][t]= temp;
						temp++;
					}
				}
			}
		}
		
		//out
		for(int i=0;i<cashflowOut.length;i++){
			for(int n=1;n<combinations(cashflowOut.length,i+1)-1;n++){
				for(int c=0;c<cashflowOut.length;c++){
					OutComb[i][n][c]=OutComb[i][n-1][c];
				}
				OutComb[i][n][cashflowOut.length-1]+=1;
				boolean check = false;
				int ct =0;
				while(check==false){
					check = true;
					if(OutComb[i][n][cashflowOut.length-1]>=cashflowOut.length){
						check=false;
					}
					for(int t=0;t<cashflowOut.length;t++){
						if(OutComb[i][n][t]<OutComb[i][n][t+1]){
							check = false;
						}
					}
					//reconstruct
					for(int t=cashflowOut.length-2;t>=0;t--){
						if(OutComb[i][n][t+1]-OutComb[i][n][t]==1){
							ct=t;
						}
					}
					OutComb[i][n][ct]+=1;
					int temp = OutComb[i][n][ct]+1;
					for(int t=ct+1;t<cashflowOut.length;t++){
						OutComb[i][n][t]= temp;
						temp++;
					}
				}
			}
		}
		int ctt = 0;
		for(int i=0;i<cashflowIn.length;i++){
			for(int n=0;n<combinations(cashflowIn.length,i+1);n++){
				for(int c=0;c<cashflowIn.length;c++){
					In[ctt]+=cashflowIn[InComb[i][n][c]];
				}
				ctt++;
			}
		}
		
		ctt = 0;
		for(int i=0;i<cashflowOut.length;i++){
			for(int n=0;n<combinations(cashflowOut.length,i+1);n++){
				for(int c=0;c<cashflowOut.length;c++){
					Out[ctt]+=cashflowOut[OutComb[i][n][c]];
				}
				ctt++;
			}
		}
		
		for(int i=0;i<combinationsSum(cashflowIn.length);i++){
			for(int c=0; c<combinationsSum(cashflowOut.length);c++){
				if(In[i]-Out[i]>=0){
					output=In[i]-Out[i];
				}
			}
		}
		for(int i=0;i<combinationsSum(cashflowIn.length);i++){
			for(int c=0; c<combinationsSum(cashflowOut.length);c++){
				if(In[i]-Out[i]<output){
					output=In[i]-Out[i];
				}
			}
		}

		

		
		
		
		
		
		//calculate the possible combination
		/*while(combinationsSum(cashflowIn.length)>count){
			int slot=
			In[count]=
			count++;
		}*/
		
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
