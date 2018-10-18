package answers;

public class Question6 {
	public static int numServerst;
	public static int targetServert;
	public static int[][] timeso;
	public static int[] minTime;
	
	public static int shortestServerRoute(int numServers, int targetServer, int[][] times) {
		// TODO Auto-generated method stub
		numServerst = numServers;
		targetServert = targetServer;
		timeso = new int[numServers][numServers];
		minTime = new int[numServers];
		
		minTime[targetServert] = times[0][targetServert];
		for(int i=0;i<numServerst;i++){
			minTime[i]=times[0][i];
		}
		for(int i=0;i<numServerst;i++){
			for(int q=0;q<numServerst;q++){
				timeso[i][q] = times[i][q];
			}
		}
		Question6.recursive(0); //calling recursive
		return minTime[targetServert];
	}
	
	
	public static void recursive(int Server){
	 for(int i=1;i<numServerst;i++){
		 if(Server==i){
		 }else if(Server==targetServert){
			 break;
		 }else if((minTime[Server]+timeso[Server][i])<=minTime[i]){
			 minTime[i] = minTime[Server]+timeso[Server][i];
			 Question6.recursive(i);
		 }
	 }
	}

}
