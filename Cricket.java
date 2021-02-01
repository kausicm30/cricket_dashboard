import java.util.*;
import java.util.HashMap;
class CricketDashboard
{
    static String balls;
    static LinkedHashMap<Integer, String> player = new LinkedHashMap<Integer, String>();
    static LinkedHashMap<String, Integer> runs = new LinkedHashMap<String, Integer>();
    
    
    
    CricketDashboard(String str)
    {
       balls = str;
    }
    public void findWicketsandRemainingwickets()
    {
        int totalwickets = 10;
        int count=0;
        for(int i=0;i<balls.length();i++)
        {
            if(balls.charAt(i)=='o' || balls.charAt(i)=='O')
            {
                count++;
            }
        }
        System.out.println("Wicket(s)-"+count);
        System.out.println("Remaining Wicket(s)-"+(totalwickets-count));
    }
    
    public void findTotalrunsandExtras()
    {
        int count=0, runs=0;
        for(int i=0;i<balls.length();i++)
        {
            if(balls.charAt(i)=='w' || balls.charAt(i)=='W')
            {
                count++;
            }
            else if(balls.charAt(i)=='.'|| balls.charAt(i)=='o'|| balls.charAt(i)=='O')
            {
                continue;
            }
            else{
                runs = runs+(Integer.parseInt(String.valueOf(balls.charAt(i))));
            }
        }
        System.out.println("Extra-"+count);
        System.out.println("Total-"+(runs+count));
    }
    public void findOvers()
    {
        int count=0, over=0;
        for(int i=0;i<balls.length();i++)
        {
            if(balls.charAt(i)=='w' || balls.charAt(i)=='W')
            {
                continue;
            }
            else{
                count++;
                if(count==6)
                {
                    over = over + 1;
                    count =0;
                }
            }
        }
        System.out.println("Overs-"+over+"."+count);
    }
    public void strikeNonStrike()
    {
        player.put(1, "P1");runs.put("P1", 0);
        player.put(2, "P2");runs.put("P2", 0);
        player.put(3, "P3");runs.put("P3", 0);
        player.put(4, "P4");runs.put("P4", 0);
        player.put(5, "P5");runs.put("P5", 0);
        player.put(6, "P6");runs.put("P6", 0);
        player.put(7, "P7");runs.put("P7", 0);
        player.put(8, "P8");runs.put("P8", 0);
        player.put(9, "P9");runs.put("P9", 0);
        player.put(10, "P10");runs.put("P10", 0);
        player.put(11, "P11");runs.put("P11", 0);
        String strike;
        String nonstrike;
        strike=player.get(1);
        nonstrike=player.get(2);
        int p=2;
        int count =0;
        for(int i=0;i<balls.length();i++)
        {
            if(balls.charAt(i)=='w' || balls.charAt(i)=='W')
            {
                continue;
            }
            else{
                count++;
                if(balls.charAt(i) =='1'|| balls.charAt(i) =='3')
                {
                    Integer run = runs.get(strike);
                    run += Integer.parseInt(String.valueOf(balls.charAt(i)));
                    runs.replace(strike, run);
                    String temp = strike;
                    strike = nonstrike;
                    nonstrike = temp;
                }
                if(balls.charAt(i) =='2'|| balls.charAt(i) =='4' || balls.charAt(i) =='6')
                {
                    Integer run = runs.get(strike);
                    run += Integer.parseInt(String.valueOf(balls.charAt(i)));
                    runs.replace(strike, run);
                }
                if(balls.charAt(i) == 'o' || balls.charAt(i) == 'O')
                {
                    p=p+1;
                    strike=player.get(p);
                }
                if(count == 6)
                {
                    String temp = strike;
                    strike = nonstrike;
                    nonstrike = temp;
                    count=0;
                }
            }
        }
        for(int i=1;i<=p;i++)
        {
            System.out.println(player.get(i)+"-"+runs.get(player.get(i))+"(runs)");
        }
        System.out.println("Strike-"+strike);
        System.out.println("Non-Strike-"+nonstrike);
        System.out.println(player);
        System.out.println(runs);
    }
}
public class Cricket
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		CricketDashboard c= new CricketDashboard(str);
		c.findWicketsandRemainingwickets();
		c.findTotalrunsandExtras();
		c.findOvers();
		c.strikeNonStrike();
		
	}
}
