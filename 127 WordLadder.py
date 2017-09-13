'''
_ot
h_t
ho_
_ot
d_t
do_
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
'''

from collections import deque

class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        
        def construct_dict(wordList):
            d= {}
            for word in wordList:
                for i in xrange(len(word)):
                    s = word[:i] +'_'+ word[i+1:]
                    d[s] = d.get(s,[]) + [word]
            
            return d
        
        def bfs_wordDict(beginWord,endWord,wordDict):
            queue,visited = deque([(beginWord,1)]), set()    #set is much more efficient than list！
            while queue:
                word,step = queue.popleft()
                if word not in visited:
                    visited.add(word)
                    if word == endWord:
                        return step
                    for i in xrange(len(word)):
                        s = word[:i]+'_'+word[i+1:]
                        neigh_words = wordDict.get(s,[])
                        for neigh in neigh_words:
                            if neigh not in visited:
                                queue.append((neigh,step+1))
            return 0
    
        d = construct_dict(wordList)
        return bfs_wordDict(beginWord,endWord,d)