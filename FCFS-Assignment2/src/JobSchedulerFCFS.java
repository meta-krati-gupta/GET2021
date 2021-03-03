import java.util.Arrays;
import java.util.Comparator;

public class JobSchedulerFCFS {

	private static final int ARVL_COL = 0;
	private static final int BRST_COL = 1;
	
	private final int processes[][];
	private final int numOfProcess;
	private final int completionTime[];
	private final int waitingTime[];
	private final int turnArountTime[];
	
	/**
	 * class constructor
	 * @param processes
	 */
	
       public JobSchedulerFCFS(int[][] processes) {
		this.processes = processes;
		this.numOfProcess = processes.length;
		completionTime = new int[numOfProcess];
		waitingTime = new int[numOfProcess];
		turnArountTime = new int[numOfProcess];
		
		// Using built-in sort function Arrays.sort 
        Arrays.sort(processes, new Comparator<int[]>() {
        	//sort processes according to arrival time
			@Override
			public int compare(int[] row0, int[] row1) {
				if(row1[ARVL_COL] < row1[ARVL_COL]) return -1;
				else return 1;
			}
		});
        init();
	}
	
	//compute all fields
	public void init(){
		calcCompletionTime();
		calcTurnAroundTime();
		calcWaitingTime();
	}

	
	/**
	 * Calculates Completion time for all processes
	 */
	private void calcCompletionTime(){
		for (int i = 0; i < processes.length; i++) {
			if(i==0){
				completionTime[i] = processes[i][BRST_COL];
				continue;
			}
			completionTime[i] = completionTime[i-1] + processes[i][BRST_COL];
		}
	}

	/**
	 * Calculates Turn around time for all processes
	 */
	private void calcTurnAroundTime(){
		for (int i = 0; i < processes.length; i++) {
			turnArountTime[i] = completionTime[i] + processes[i][ARVL_COL];
		}
	}

	
	/**
	 * Calculates waiting time for all processes
	 */
	private void calcWaitingTime(){
		for (int i = 0; i < processes.length; i++) {
			waitingTime[i] = completionTime[i] + turnArountTime[i];
		}
	}

	/**
	 * @return average waiting time for all processes
	 * @return (float) Average waiting time
	 */
	public float getAvgWaitTime(){
		float sum = 0;
		for (int i = 0; i < waitingTime.length; i++) {
			sum += waitingTime[i]; 
		}
		return sum/numOfProcess;
	}

	/**
	 * @return max waiting time for all processes
	 */
	public int maxWaitTime(){
		int max = waitingTime[0];
		for (int i = 1; i < waitingTime.length; i++) {
			if(max < waitingTime[i])
				max = waitingTime[i];
		}
		return max;
	}
	
	/**
	 * @return Completion time for all processes
	 */
	public int[] getCompletionTime(){
		return completionTime.clone();
	}

	/**
	 * @return Turn around time for all processes
	 */
	public int[] getTurnAroundTime(){
		return turnArountTime.clone();
	}

	
	/**
	 * @return waiting time for all processes
	 */
	public int[] getWaitingTime(){
		return waitingTime.clone();
	}

	

	public static void main(String args[]){
		int p[][]={{0,10},{6,20},{60,10},{110,5}};
		JobSchedulerFCFS fcfs = new JobSchedulerFCFS(p);
		int completiontime[] = fcfs.getCompletionTime();
		int turnaroundtime[]= fcfs.getTurnAroundTime();
		int waitingtime[] = fcfs.getWaitingTime();
		float averagewaitingtime = fcfs.getAvgWaitTime();
		int maxwaittime = fcfs.maxWaitTime();
	    System.out.println("S.No\t" + "AT\t" + "BT\t" + "CT\t" + "TAT\t" + "WT");
	    System.out.println("---------------------------------------------");
	    for(int i=0;i<p.length;i++){
	    	System.out.println(Integer.toString(i+1)+"\t" 
	               + p[i][0]+"\t"
	    		   + p[i][1]+"\t"
	    		   + completiontime[i]+"\t"
	    		   + turnaroundtime[i]+"\t"
	    		   + waitingtime[i]+"");
	    		
	    }
	    System.out.println("---------------------------------------------");
	    System.out.println("Average waiting time: "+ averagewaitingtime);
	    System.out.println("Max waiting time: "+ maxwaittime);
	    
	    
	    
	}
}