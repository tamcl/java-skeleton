package answers;

public class Question1 {

	public static int bestMergedPortfolio(int[] portfolios) {
		// TODO Auto-generated method stub
		int max=0;
		for(int count=0;count<portfolios.length-1;count++){
			for(int sndcount=count+1;sndcount<portfolios.length;sndcount++){
				if((portfolios[count]^portfolios[sndcount])>max){
					max=portfolios[count]^portfolios[sndcount];
				}
			}
		}
		return max;
	}

}
