package No721;

import java.util.*;

class Solution {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //统计邮件数量
        Map<String, Integer> emailToIndex = new HashMap<>();
        //每个邮件所对应的账户名
        Map<String, String> emailToName = new HashMap<>();

        int emails = 0;

        for (List<String> account: accounts) {
            //遍历每个账户
            //拿到每个账户的name
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++){
                //获取每个账户的邮箱
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)){
                    //每个邮箱对应的编号
                    emailToIndex.put(email, emails++);
                    //每个邮箱对应的名字
                    emailToName.put(email, name);
                }
            }
        }
        //初始化并查集
        UnionFind uf = new UnionFind(emails);
        for (List<String> account : accounts){
            String fEmail = account.get(1);
            int findex = emailToIndex.get(fEmail);
            int size = account.size();
            for (int i = 2; i < size; i++){
                String nextEmail = account.get(i);
                int nextIndex = emailToIndex.get(nextEmail);
                uf.union(findex, nextIndex);
            }
        }

        Map<Integer, List<String>> indexToEmails = new HashMap<Integer, List<String>>();
        for (String email : emailToIndex.keySet()) {
            int index = uf.find(emailToIndex.get(email));
            List<String> account = indexToEmails.getOrDefault(index, new ArrayList<String>());
            account.add(email);
            indexToEmails.put(index, account);
        }
        // 构造结果
        List<List<String>> merged = new ArrayList<List<String>>();
        for (List<String> email : indexToEmails.values()) {
            Collections.sort(email);
            String name = emailToName.get(email.get(0));
            List<String> account = new ArrayList<String>();
            account.add(name);
            account.addAll(email);
            merged.add(account);
        }
        return merged;
    }
}

class UnionFind{
    int [] parent;
    public UnionFind(int n){
        parent = new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = i;
        }
    }

    public void union(int i1, int i2){
        parent[find(i2)] = find(i1);
    }

    public int find(int index){
        if (parent[index] != index){
            parent[index] = find(index);
        }
        return parent[index];
    }
}
