package answers;

public class Question1 {

	public static int bestMergedPortfolio(int[] portfolios) {
		// TODO Auto-generated method stub
		int max=0,current =0;
		int size = portfolios.length;
		for(int count=0;count<size-1;count++){
			for(int sndcount=count+1;sndcount<size;sndcount++){
				current=portfolios[count]^portfolios[sndcount];
				if(current>max){
					max=portfolios[count]^portfolios[sndcount];
				}
			}
		}
		return max;
	}

}
