package programmers.문자열;

import java.util.*;

public class 스킬트리 {
    public int solution1(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String str : skill_trees) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < str.length(); j++) {
                String tmp = str.substring(j, j+1);
                if(skill.contains(tmp)) {
                    sb.append(tmp);
                }
            }
            int result = skill.indexOf(sb.toString()) == 0 ? 1 : 0;
            answer += result;
        }
        
        return answer;
    }

    public int solution2(String skill, String[] skill_trees) {
        int answer = 0;

        for (String str : skill_trees) {
            int idx = 0;
            boolean isValid = true;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                // 순서없는 스킬
                if (skill.indexOf(c) == -1) continue; 
 
                if (skill.charAt(idx) == c) {
                    idx++; 
                } else {
                    isValid = false; 
                    break;
                }
            }

            if (isValid) answer++;
        }

        return answer;
    }

    // 정규식 사용
    public int solution3(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<String> skillTrees = new ArrayList<>(Arrays.asList(skill_trees));
        Iterator<String> it = skillTrees.iterator();

        while (it.hasNext()) {
            if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
                it.remove();
            }
        }

        answer = skillTrees.size();
        return answer;
    }
}
