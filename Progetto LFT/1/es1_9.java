public class es1_9
{
  public static boolean scan(String s)
   {
	int state = 0;
	int i = 0;

	while (state >= 0 && i < s.length()) {
	    final char ch = s.charAt(i++);

	    switch (state) {
	    case 0:/* stato iniziale q0 */
		if (ch == 'f')
		    state = 1;
		else
		    state = 4;
		break;

	    case 1:/* stato q1 */
		if (ch == 'r')
		    state = 2;
		else
		    state = 5;
		break;

	    case 2:/* stato q2 */
		state = 3;
		break;
         
	    case 3:/* stato q3 */
		state=3;
		break;
		
		case 4:/* stato q4 */
		if (ch == 'r')
		    state = 5;
		else
		    state = -1;
		break;
		
		 case 5:/* stato q5 */
		if (ch == 'a')
		    state = 3;
		else
		    state = -1;
		break;
		
	    }
	}
	return state == 3;
   }

    public static void main(String[] args)
    {
	System.out.println(scan(args[0]) ? "OK" : "NOPE");
    }
}