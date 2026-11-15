class Solution {
public:
    bool checkAlmostEquivalent(string word1, string word2) {
        unordered_map<char, int> m1;
        for(int i = 0; i < word1.size(); i++){
            if(m1.contains(word1[i])) m1[word1[i]]++;
            else m1[word1[i]] = 1;
        }

        unordered_map<char, int> m2;
        for(int i = 0; i < word2.size(); i++){
            if(m2.contains(word2[i])) m2[word2[i]]++;
            else m2[word2[i]] = 1;
        }

        for(const auto& [key, value] : m1){
            if(!m2.contains(key) && value > 3) return false;
            else{
                if(abs(value - m2[key]) > 3) return false;
                m2.erase(key);
            }
        }

        for(const auto& [key, value] : m2) if(value > 3) return false;

        return true;
    }
};
