package answers;

public class Question5 {

	public static int shareExchange(int[] allowedAllocations, int totalValue) {
		// TODO Auto-generated method stub
		int current = totalValue;
		int output = 0;
		int length = allowedAllocations.length;
		int[] sort = new int[allowedAllocations.length];
		int count=allowedAllocations[0];
		int max=0;
		for(int i =0; i< length; i++){
			if(allowedAllocations[i]<count){
				count=allowedAllocations[i];
			}
			if(allowedAllocations[i]>max){
				max=allowedAllocations[i];
			}
		}
		sort[0]= count;
		sort[length-1]=max;
		
		//sort out order
		for(int i =1; i< length-2; i++){
			count=max+1;
			for(int c=0;c<length;c++){
				if(sort[i-1]<allowedAllocations[c]&&allowedAllocations[c]<count){
					count = allowedAllocations[c];
				}
			}
			sort[i]=count;
		}
		count=0;
		output=0;
		while(current>0){
			for(int i =length-1;i<0;i--){
				if(current>sort[i]){
					if(current%sort[i]==0){
						output += current/sort[i];
						break;
					}else{
						current-=sort[i];
						output++;
						break;	
					}
				}
			}
		}
	
		return output;
	}

}
