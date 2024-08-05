class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            String formated = convert(s);
            if(!map.containsKey(formated)){
                map.put(formated, new ArrayList());
            }
            map.get(formated).add(s);
        }
        return map.values().stream().map(a->a).collect(Collectors.toList());
    }

    private String convert(String s){
        int[] arr = new int[26];

        for(char c : s.toCharArray()){
            arr[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26;i++){
            if(arr[i] != 0){
                sb.append("+").append(i).append(":" + arr[i]);
            }
        }
        if(sb.length() == 0) return null;
        return sb.toString().substring(1);
    }


    public List<List<String>> groupAnagrams_good(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);

            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList());
            }
            map.get(sorted).add(s);
        }
        return map.values().stream().map(a->a).collect(Collectors.toList());
    }
}