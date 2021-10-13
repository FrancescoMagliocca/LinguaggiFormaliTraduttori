/*smd spazio*/
public class es1_4 {
    public static boolean scan(String s){
        int state = 0; 
        int i = 0;
        while (state >= 0 && i < s.length()) {
            final char ch = s.charAt(i++);
            switch (state) {
                case 0: /* stato iniziale q0 */
                    if(ch == '0' || ch == '2' || ch == '4' ||ch == '6' ||ch == '8')
                        state = 1;
                    else if (ch == ' ')
                        state = 0;
					else if (ch == '1' || ch == '3' ||ch == '5' ||ch == '7' ||ch == '9')
                        state = 2;
                    else
                        state = -1;
                    break;
                case 1: /* stato q1 */
                    if(ch == '0' || ch == '2' || ch == '4' ||ch == '6' ||ch == '8')
                        state = 1;
					else if (ch == '1' || ch == '3' ||ch == '5' ||ch == '7' ||ch == '9')
                        state = 2;
					else if (ch == ' ')
                        state = 3;
					else if((ch>='A' && ch<='K') || (ch>='a' && ch<='k')) 
						state = 5;
                    else
                        state = -1;
                    break;
                case 2: /* stato q2 */
                    if(ch == '0' || ch == '2' || ch == '4' ||ch == '6' ||ch == '8')
                        state = 1;
					else if (ch == '1' || ch == '3' ||ch == '5' ||ch == '7' ||ch == '9')
                        state = 2;
					else if (ch == ' ')
                        state = 4;
					else if((ch>='L' && ch<='Z') || (ch>='l' && ch<='z')) 
						state = 5;
					else
                        state = -1;
                    break;
				case 3: /* stato q3 */
                    if (ch==' ')
                        state = 3;
					else if((ch>='A' && ch<='K') || (ch>='a' && ch<='k')) 
						state = 5;
					else
                        state = -1;
                    break;
				case 4: /* stato q4 */
                    if (ch==' ')
                        state = 4;
					else if((ch>='L' && ch<='Z') || (ch>='l' && ch<='z')) 
						state = 5;
					else
                        state = -1;
                    break;
				case 5: /* stato q5 */
                    if ((ch>='A' && ch<='Z') || (ch>='a' && ch<='z'))
                        state = 5;
                    else if(ch==' ')
						state = 6;
					else
                        state = -1;
                    break;
                case 6: /* stato q6 */
                    if (ch==' ')
                        state = 6;
					else if(ch>='A' && ch<='Z')
                        state = 5;
					else
                        state = -1;
                    break;
            }
        }
      return state==5 || state==6;
    }
    
    public static void main(String[] args){
        System.out.println(scan(args[0]) ? "Stringa accettata" : "Stringa non accettata");
    }
}