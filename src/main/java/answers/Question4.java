package answers;

public class Question4 {

	public static int selectionFailedTradedesks(String[][] rows, int numberMachines) {
		// TODO Auto-generated method stub
		int output=0;
		if(numberMachines<rows.length){
			int Machines = rows[numberMachines].length;
			for(int i=0; i<Machines;i++){
				if(Character.isDigit(rows[numberMachines][i].charAt(0))){
					output += Integer.valueOf(rows[numberMachines][i]);
				}
			}
		}
		return output;
	}

}
