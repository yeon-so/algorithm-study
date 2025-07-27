import java.util.*;

public class 크레인 인형뽑기 게임 {
    public int solution(int[][] board, int[] moves) {
        int leng = board[0].length;
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        
        for(int i = 0; i < moves.length; i++) {
            int cur = moves[i] - 1;
            
            for(int j = 0; j < leng; j++) {
                if(board[j][cur] != 0) {
                    if(!stack.isEmpty() && stack.peek() == board[j][cur]) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[j][cur]);
                    }
                    board[j][cur] = 0;
                    break;
                }
            }
        }
        
        return answer;
    }
}
