package answers;

import helpers.Edge;

public class Question3 {
	static int[] check;
	public static int lowestExposureToExchanges(int numNodes, Edge[] edgeList) {
		// TODO Auto-generated method stub
		check = new int[numNodes];
		for(int i=0;i<numNodes;i++)check[i]=-1;
		int output=0;
		for(int i=0;i<edgeList.length;i++){
			check[edgeList[i].getEdgeA()-1]=1;
		}
		for(int i=0;i<numNodes;i++)output+=check[i];
		return output;
	}

}
