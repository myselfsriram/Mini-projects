import java.util.*;
class TicTac{
    static String arr[][]=new String[3][3];
    public static void BoardForm(){
        int count=1;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                arr[i][j]=String.valueOf(count);
                count++;
            }
        }
    }
    
    public static String IsWin(String arr[][]){
        if((arr[0][0]+arr[0][1]+arr[0][2]).equals("XXX"))
             return "X";
        else if((arr[0][0]+arr[1][0]+arr[2][0]).equals("XXX"))
             return "X";
        else if((arr[1][0]+arr[1][1]+arr[1][2]).equals("XXX"))
            return "X";
        else if((arr[2][0]+arr[2][1]+arr[2][2]).equals("XXX"))
             return "X";
        else if((arr[0][2]+arr[1][2]+arr[2][2]).equals("XXX"))
            return "X";
        else if((arr[0][0]+arr[1][1]+arr[2][2]).equals("XXX"))
             return "X";
        else if((arr[0][2]+arr[1][1]+arr[2][0]).equals("XXX"))
             return "X";
        else if((arr[0][2]+arr[1][2]+arr[2][2]).equals("XXX"))
            return "X";
             
        else if((arr[0][0]+arr[0][1]+arr[0][2]).equals("OOO"))
             return "O";
        else if((arr[0][0]+arr[1][0]+arr[2][0]).equals("OOO"))
             return "O";
        else if((arr[1][0]+arr[1][1]+arr[1][2]).equals("OOO"))
            return "O";
        else if((arr[2][0]+arr[2][1]+arr[2][2]).equals("OOO"))
             return "O";
        else if((arr[0][2]+arr[1][2]+arr[2][2]).equals("OOO"))
            return "O";
        else if((arr[0][0]+arr[1][1]+arr[2][2]).equals("OOO"))
             return "O";
        else if((arr[0][2]+arr[1][1]+arr[2][0]).equals("OOO"))
             return "O";
        else if((arr[0][2]+arr[1][2]+arr[2][2]).equals("OOO"))
           return "O";
        else {
        	int x=0,o=0;
        	for(int i=0;i<arr.length;i++) {
        		for(int j=0;j<arr.length;j++) {
        			if(arr[i][j].equals("X"))
        				 x++;
        			else if(arr[i][j].equals("O"))
        				 o++;
        		}
        	}
        	if(x+o==9)
        		 return "Draw";
        	else
        		return "continue";
        }
    }
    
    public static boolean IsSafe(String arr[][],String key){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[i][j].equals(key) && !(arr[i][j].equals("X")) && !(arr[i][j].equals("O")))
                    return true;
            }
        }
        return false;
    }
    
    public static void display(){
        System.out.println("!------------------------------------------------------------------------\n");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("!------------------------------------------------------------------------\n");
        }
    
    public static void X_Play(){
        Scanner sc=new Scanner(System.in);
        System.out.println("X-Plays");
            System.out.println("Enter the position value ");
            int pos=sc.nextInt();
            int count=1;
            if(IsSafe(arr,String.valueOf(pos))){
                for(int i=0;i<arr.length;i++){
                    for(int j=0;j<arr.length;j++){
                        if(count==pos) {
 		                    arr[i][j]="X";
 		                    pos=0;
 		                    break;
                        }
                        count++;
                    }
                    if(pos==0)
                      break;
                }
               if(IsWin(arr).equals("X")) {
            	   System.out.println("X wins the game");
            	   
               }
               else if(IsWin(arr).equals("O")) {
            	   System.out.println("O wins the game");
            	  
               }
            	   
            }
            else {
            	System.out.println("Choose some other place");
            	display();
            	X_Play();
            
            }
    }
    
    public static void Y_Play(){
         Scanner sc=new Scanner(System.in);
         System.out.println("Y-Plays");
            System.out.println("Enter the position value ");
            int pos=sc.nextInt();
            int count=1;
            if(IsSafe(arr,String.valueOf(pos))){
                for(int i=0;i<arr.length;i++){
                    for(int j=0;j<arr.length;j++){
                        if(count==pos) {
 		                    arr[i][j]="O";
 		                    pos=0;
 		                    break;
                        }
                        count++;
                    }
                    if(pos==0)
                      break;
                }
               if(IsWin(arr).equals("X")) {
            	   System.out.println("X wins the game");
            	  
               }
               else if(IsWin(arr).equals("O")) {
            	   System.out.println("O wins the game");
            	  
               }
            	   
            }
            else {
            	System.out.println("Choose some other place");
            	display();
            	Y_Play();
            	
            }
    }
    public static void play(){
        BoardForm();
        Scanner sc=new Scanner(System.in);
        System.out.println("\n\n\t\t\tWelcome to The Tic-Tac-Toe game the Grid was \n");
        display();
        System.out.println("Who is going to Start X means player-1, O means Player-2");
        String choice=sc.next();
        while(true){
            display();
            if(choice.equals("X")){
              X_Play();
              choice="O";
            }
            else{
               Y_Play();
               choice="X";
            }
            
            if(IsWin(arr).equals("X"))
               break;
            else if(IsWin(arr).equals("O"))
               break;
            else if(IsWin(arr).equals("Draw")){
                System.out.println("Re-match its is Draw");
                break;
            }
        }
    }
}
public class Main extends TicTac
{
	public static void main(String[] args) {
		play();
	}
}
