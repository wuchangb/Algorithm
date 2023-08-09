package programmers.lv3.표병합;

import java.util.ArrayList;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int idx = k;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Node> nList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        for (int i = 0; i < cmd.length; i++) {
            String[] s = cmd[i].split(" ");
            if (s[0].equals("D")) {
                k += Integer.parseInt(s[1]);
            } else if (s[0].equals("U")) {
                k -= Integer.parseInt(s[1]);
            } else if (s[0].equals("C")) {
                nList.add(new Node(k, list.get(k)));
                list.remove(k);
            } else {
                Node node = nList.get(nList.size() - 1);
                nList.remove(nList.size() - 1);
                list.add(node.idx, node.value);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (list.contains(i)) sb.append("O");
            else sb.append("X");
        }
//        int cnt = Math.min(list.size(), n);
//        for (int i = 0; i < cnt; i++) {
//            if (list.get(i).equals(i)) {
//                sb.append("O");
//            } else {
//                sb.append("X");
//            }
//        }
//        for (int i = 0; i < n - cnt; i++) {
//            sb.append("X");
//        }
        return sb.toString();
    }

    static class Node {
        int idx;
        int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
        System.out.println(sol.solution(n, k, cmd));

    }
}