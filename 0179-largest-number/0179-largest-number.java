class Solution {
    public String largestNumber(int[] arr) {
        List<String> list = new ArrayList<>();
        Arrays.stream(arr).forEach(i -> list.add(i+""));
        list.sort((a,b) -> (b+a).compareTo(a+b));
        // Handle the case where all numbers are zero
        if (arr[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        list.forEach(s -> sb.append(s));
        return sb.toString();
    }
}