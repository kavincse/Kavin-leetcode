class Solution {
    public int largestRectangleArea(int[] h) {
        int max = 0;
        Stack<Integer> s = new Stack<>();
        s.push(0);
        
        for (int i = 1; i <= h.length; i++) {
            if (i == h.length || h[i] < h[i-1]) {
                int newHeight = i == h.length ? 0 : h[i];
                while (!s.isEmpty() && h[s.peek()] > newHeight) {
                    int rectHeight = s.pop();
                    int startIx    = s.isEmpty() ? 0 : s.peek() + 1;
                    int area       = h[rectHeight] * (i - startIx);
                    max            = Math.max(max, area);
                }
            } else if (h[i] == h[i-1]) {
                s.pop();
            }
            s.push(i);
        }
        return max;
    }
}
