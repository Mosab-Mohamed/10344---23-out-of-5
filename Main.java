import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {

	boolean[] taken ;
	boolean happened ;
	int[] selection ;
	int[] arr ;
	
	public static void main(String[] args) {
		Main g = new Main();
		g.start();
		
		

	}
	
	void start(){
		
		arr = new int[5];
		Scanner reader = new Scanner(System.in);
		StringTokenizer S = new StringTokenizer( reader.nextLine() );
		for(int i=0 ; i<5 ; i++){
			arr[i] = Integer.parseInt( S.nextToken() );
		}
		while(arr[0]!=0 && arr[1]!=0 && arr[2]!=0 && arr[3]!=0 && arr[4]!=0 ){
			
			taken = new boolean[5];
			selection = new int[5];
			happened = false ;
			permutation(0);
			if(happened){
				System.out.println("Possible");
			}
			else{
				System.out.println("Impossible");
			}
			
			S = new StringTokenizer( reader.nextLine() );
			for(int i=0 ; i<5 ; i++){
				arr[i] = Integer.parseInt( S.nextToken() );
			}
		}
	}
	
	
	void check (int index,int result)
	{
		if(happened)
			return;
		
		if(index==5){
			if(result==23){
				happened = true ;
			}
			return ;
		}
		check(index+1 , result*selection[index] );
		if(happened)
			return;
		check(index+1 , result+selection[index] );
		if(happened)
			return;
		check(index+1 , result-selection[index] );
		
		
		
	}


	
	
	void permutation (int index)
	{
		if(happened)
			return;
		if (index == 5)
		{
			check(1,selection[0]);
			return;
		}
		for (int i=0 ; i<5 ; i++)
		{
			if (!taken[i])
			{
				selection[index] = arr[i];
				taken[i] = true;
				permutation (index+1);
				taken[i] = false;
			}
		}
	}
}
