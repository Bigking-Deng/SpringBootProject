package leetcode.DFS_BFS;

public class DFS_394 {
    //ab35[bc2[aa]]dd2[op]
    //3[a]2[bc]
    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        int countNum = 0;
        while(num < s.length()){
            if(s.charAt(num)>='0' && s.charAt(num)<='9'){
                int start = num;
                while(num+1 < s.length() && s.charAt(num+1)>='0' && s.charAt(num+1)<='9'){
                    num++;
                }
                int end=num;
                countNum = Integer.valueOf(s.substring(start, end+1));
                num++;
            }
            else if(s.charAt(num)=='['){
                int countpar = 1;
                int start = num;
                while(countpar!=0){
                    num++;
                    if(s.charAt(num)=='['){
                        countpar++;
                    }else if(s.charAt(num)==']'){
                        countpar--;
                    }
                }
                int end = num;
                String subString = decodeString(s.substring(start+1, end));
                for(int i = 1; i<=countNum; i++){
                    sb.append(subString);
                }
                num++;
            }
            else if(s.charAt(num)>='a' && s.charAt(num)<='z'){
                sb.append(s.charAt(num));
                num++;
            }

        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String res = decodeString("3[a]2[bc]");
    }

}
