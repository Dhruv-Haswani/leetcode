class Solution {
    List<List<Integer>>ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        backtrack(1,k,n,new ArrayList<>());
        return ans;
        

    }
    private void backtrack(int start,int k , int n , List<Integer>path) {
        if(path.size() == k && n == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if(path.size()>k || n<0) {
            return;
        }
        for(int i = start ; i<=9 ; i++){
            path.add(i);
            backtrack(i+1,k,n-i,path);
            path.remove(path.size()-1);
        }
    }
}