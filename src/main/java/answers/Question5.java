package answers;

public class Question5 {

	public static int shareExchange(int[] allowedAllocations, int totalValue) {
		// TODO Auto-generated method stub
		int current = totalValue;
		int output = 0;
		int length = allowedAllocations.length;
		int[] sort = new int[allowedAllocations.length];
		int count=allowedAllocations[0];
		for(int i =0; i< length; i++){
			if(allowedAllocations[i]<count){
				count=allowedAllocations[i];
			}
		}
		sort[0]= count;
		count=totalValue+1;
		//sort out order
		for(int i =1; i< length; i++){
			for(int c=0;c<length;c++){
				if(sort[i]<allowedAllocations[c]&&allowedAllocations[c]<count){
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
						output = current/sort[i];
					}else{
						current-=sort[i];
						output--;
						break;	
					}
				}
			}
		}
		current=totalValue;
		while(current>0){
			for(int i=length-1;i<0;i--){
				if(current>sort[i]){
					current-=sort[i];
					count++;
					break;
				}else if(current<sort[i]&&i!=-1){
					
				}else(current<sort[0]){
					current = -1;
				}
			}
		}
		if(count<output&&current!=-1){
			output=count;
		}
		return output;
	}

}
