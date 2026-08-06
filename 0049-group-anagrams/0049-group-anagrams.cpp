class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        if(strs.size()==0)
        return {};
        unordered_map<string,vector<string>>map;
        for(auto x:strs){
            string word=x;
            sort(word.begin(),word.end());
            map[word].push_back(x);  //ContainsKey check+ put +get().add() - sab ek line mey
        }
        vector<vector<string>>res;
        for(auto i:map){
            res.push_back(i.second);
        }
        return res;
    }
};