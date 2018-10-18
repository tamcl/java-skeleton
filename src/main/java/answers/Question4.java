package answers;

public class Question4 {

	public static int selectionFailedTradedesks(String[][] rows, int numberMachines) {
		// TODO Auto-generated method stub
		int output=0, Machines;
		if(numberMachines<rows.length){
			Machines = rows[numberMachines].length;
			for(int i=0; i<Machines;i++){
				if(!rows[numberMachines][i].equals("X")){
				}else if(Character.isDigit(rows[numberMachines][i].charAt(0))){
					output += Integer.valueOf(rows[numberMachines][i]);
				}else{
				}
			}
		}
		return output;
	}

}
