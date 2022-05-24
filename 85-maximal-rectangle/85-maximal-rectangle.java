class Solution {
    public int largestRectangleArea(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int prev[] = new int[n];
        int next[] = new int[n];
        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()) next[i] = n;
            else next[i] = st.peek();
            st.push(i);
        }
        
        while(!st.isEmpty()) st.pop();
        
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()) prev[i] = -1;
            else prev[i] = st.peek();
            st.push(i);
        }
        
        int max = 0;
        for(int i = 0; i < n; i++){
            int a = (next[i]-prev[i]-1)*arr[i];
            max = Math.max(max, a);
        }
        return max;
    }
    
    public int maximalRectangle(char[][] matrix) {
        int n = matrix[0].length;
        int arr[] = new int[n];
        int ans = 0;
        for(char[] mat: matrix){
            for(int i = 0; i < n; i++){
                if(mat[i] == '0'){
                    arr[i] = 0;
                }
                else arr[i] += 1;
            }
            ans = Math.max(ans, largestRectangleArea(arr));
        }
        return ans;
    }
}