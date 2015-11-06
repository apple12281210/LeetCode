//小技巧：1. 遇到输出空格的问题，可以在前面加空格，最后扔掉开头的那个
//2. 可以不用管空格，到最后统一处理一遍


////Integer to English Words
//
//package test;
//
//public class Day2 {
//	public static String[] one = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
//	public static String[] ten = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
//	
//	public static void main( String[] args ){
//		numberToWords(101);
//	}
//	
//	public static String numberToWords(int num) {
//		if( num == 0 ){
//			return "Zero";
//		}
//		String ans = "";
//		String snum = String.valueOf(num);
//		int len = snum.length();
//		if( len <= 3 ){
//			ans += chunk(snum);
//		}else if( len <= 6 ){
//			ans += chunk(snum.substring(0, len-3));
//			ans += " Thousand";
//			if( !snum.substring(len-3, len).equals("000") ){
//				ans += " ";
//				ans += chunk(snum.substring(len-3, len));
//			}
//		}else if( len <= 9 ){
//			ans += chunk(snum.substring(0, len-6));
//			ans += " Million";
//			if( !snum.substring(len-6, len-3).equals("000") ){
//				ans += " ";
//				ans += chunk(snum.substring(len-6, len-3));
//				ans += " Thousand";
//			}
//			if( !snum.substring(len-3, len).equals("000") ){
//				ans += " ";
//				ans += chunk(snum.substring(len-3, len));
//			}
//		}else{
//			ans += one[snum.charAt(0)-'0'];
//			ans += " Billion";
//			if( !snum.substring(len-9, len-6).equals("000") ){
//				ans += " ";
//				ans += chunk(snum.substring(len-9, len-6));
//				ans += " Million";
//			}
//			if( !snum.substring(len-6, len-3).equals("000") ){
//				ans += " ";
//				ans += chunk(snum.substring(len-6, len-3));
//				ans += " Thousand";
//			}
//			if( !snum.substring(len-3, len).equals("000") ){
//				ans += " ";
//				ans += chunk(snum.substring(len-3, len));
//			}
//		}
//		System.out.println(ans);
//        return ans;
//    }
//	
//	public static String chunk(String ch){
//		String ans = "";
//		if( !ch.equals("000") ){
//			if( ch.length() == 1 ){
//				ans += one[ch.charAt(0)-'0'];
//			}
//			if( ch.length() == 2 ){
//				if( ch.charAt(0)-'0' == 1 ){
//					ans += one[Integer.parseInt(ch)];
//				}else{
//					if( ch.charAt(0)-'0' != 0 ){
//						ans += ten[ch.charAt(0)-'0'];
//					}
//					if( ch.charAt(1)-'0' != 0 ){
//						ans += " ";
//						ans += one[ch.charAt(1)-'0'];
//					}
//				}
//			}
//			if( ch.length() == 3 ){
//				if( ch.charAt(0)-'0' != 0 ){
//					ans += one[ch.charAt(0)-'0'];
//					ans += " Hundred";
//					if( !(ch.charAt(1)-'0' == 0 && ch.charAt(2)-'0' == 0) ){
//						ans += " ";
//					}
//				}
//				
//				if( !(ch.charAt(1)-'0' == 0 && ch.charAt(2)-'0' == 0) ){
//					if( ch.charAt(1)-'0' == 1 ){
//						ans += one[Integer.parseInt(ch.substring(1, 3))];
//					}else{
//						if( ch.charAt(1)-'0' != 0 ){
//							ans += ten[ch.charAt(1)-'0'];
//						}
//						if( ch.charAt(2)-'0' != 0 ){
//							if( ch.charAt(1)-'0' != 0 ){
//								ans += " ";
//							}
//							ans += one[ch.charAt(2)-'0'];
//						}
//					}
//				}
//			}
//		}
//		return ans;
//	}
//}


//Integer to English Words

package test;

public class Day2 {
	public static String one[] = { "", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine" };
	public static String ones[] = { " Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen" };
	public static String tens[] = { "", "", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety" };
	public static void main( String[] args ){
		numberToWords(101);
	}
	
	public static String numberToWords(int num) {
	         String[] bigs = { "", " Thousand", " Million", " Billion" };
	         int i = 0;
	         String ans = "";
	         while (num > 0) {
	             if (num % 1000 != 0) ans = numberWords(num % 1000) + bigs[i] + ans;
	             i++;
	             num /= 1000;
	         }
	         if( ans.length() > 0)
	        	 ans = ans.substring(1, ans.length());
	         else
	        	 ans = "Zero";
	     
		System.out.println(ans);
        return ans;
    }
	
	public static String numberWords(int num) {
		String ans = "";
        if (num > 99) ans += String.valueOf(one[num / 100]) + " Hundred";
        num %= 100;
        if (num > 9 && num < 20) ans += ones[num % 10];
        else {
            if (num > 19) ans += tens[num / 10];
            num %= 10;
            if (num != 0) ans += one[num];
        }
        return ans;
    }

}
