package programmers.카카오-인턴십;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class 튜플 {
        public int[] solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        s = s.substring(2, s.length());
        s = s.substring(0, s.length()-2).replace("},{",":");
        String str[] = s.split(":");
        
        Arrays.sort(str, new Comparator<String>(){
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        
        for(String x : str) {
            String[] temp = x.split(",");
            
            for(int i = 0; i < temp.length; i++) {
                int n = Integer.parseInt(temp[i]);
                
                if(!answer.contains(n)){
                    answer.add(n);
                }
            }
        }
        
        int[] arr = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++) {
            arr[i] = answer.get(i);
        }
        
        return arr;
        
    }
}
