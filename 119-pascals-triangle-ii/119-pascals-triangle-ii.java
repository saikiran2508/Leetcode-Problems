class Solution {
    public List<Integer> getRow(int r) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        long temp = 1;
        for(int i = 1, num = r, denom = 1; i <= r; i++, num--, denom++){
            temp = temp*num/denom;
            ans.add((int)temp);
        }
        return ans;
    }
}