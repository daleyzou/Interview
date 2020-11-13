先贴两个最近写的走格子的DP题解：
[44. 通配符匹配题解：一个棋盘看懂动态规划(DP)思路；附Python代码](https://leetcode-cn.com/problems/wildcard-matching/solution/yi-ge-qi-pan-kan-dong-dong-tai-gui-hua-dpsi-lu-by-/)
[718. 最长重复子数组题解：一张表，八句话看懂动态规划(DP)思路](https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/solution/yi-zhang-biao-ba-ju-hua-kan-dong-dong-tai-gui-hua-/)
&ensp;
不过今天的题目比前面两道容易想很多
&ensp;
首先我们看两个表格，左边是地图，右边是可到达每一格的路线数量记录
![gaitubao_屏幕快照 2020-07-06 上午11.31.20.png](https://pic.leetcode-cn.com/82a75abee4b6b278a999dea8c7fd3a4321c0ff9c0939365a313e371dd6ebd019-gaitubao_%E5%B1%8F%E5%B9%95%E5%BF%AB%E7%85%A7%202020-07-06%20%E4%B8%8A%E5%8D%8811.31.20.png)

机器人的行动路线，题目说只能是右or下，但**反过来说**：
即：每次到达一个新的格子，只要看左or上面的格子有没有路线即可，有的话就整合起来。
即：`store[m][n]当前格字路线数 = store[m-1][n]上面格子路线数 + store[n-1][m]左边格子路线数`
(其中，"store"为右边储存路线数量的表格)
&ensp;
初始化：一开始站在左上角位置，站都站在那了，那路线肯定=1(除非0,0位置就是障碍)；其他格子还没走，路线数先初始化为0
(注：代码中是下面这样写的, 所以遇到(0,0)位置就是障碍物的按情况是不会报错的)
```
如果该格子不是障碍格：
    如果该格子是(0,0)位置：
        该格子路线数=1
    ...以下省略
```
初始化图例：
![gaitubao_屏幕快照 2020-07-06 上午11.31.32.png](https://pic.leetcode-cn.com/24a6b2184a4bc3708c38cd8d61f21a0fedafd9b411668467164702a6b987f83d-gaitubao_%E5%B1%8F%E5%B9%95%E5%BF%AB%E7%85%A7%202020-07-06%20%E4%B8%8A%E5%8D%8811.31.32.png)

&ensp;
障碍处理：
有障碍 = 此路不通 = 此格没有路线 = 此格路线数为0
由于初始化每一格路线数 = 0，
所以遇到障碍格，不更新该格即可。
&ensp;
边界情况处理：
上面没格子，就只看左边
左边没格子，就只看上面
&ensp;
另外：
问：为了正确更新当前格子，如何保证左边、上面的格子已经更新过？
答：只要你的循环是从上到下、从左到右的，就能保证每次当前格的左边、上面的格子已经更新过。
&ensp;
返回：
由于最后到达的是右下角格子，直接返回这一格路线数即可
&ensp;
两个DP完例子供参考：
![gaitubao_屏幕快照 2020-07-06 上午11.38.40.png](https://pic.leetcode-cn.com/7c375c7943dfe2df734b15e912d3c57372690e63507b25160d6813d142b5a7c3-gaitubao_%E5%B1%8F%E5%B9%95%E5%BF%AB%E7%85%A7%202020-07-06%20%E4%B8%8A%E5%8D%8811.38.40.png)



&ensp;
附Python代码
1.可以新建一个"store"专门储存路线
```python
class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        #新建矩阵版
        height, width = len(obstacleGrid),len(obstacleGrid[0])
        store = [[0]*width for i in range(height)]

        #从上到下，从左到右
        for m in range(height):#每一行
            for n in range(width):#每一列
                if not obstacleGrid[m][n]: #如果这一格没有障碍物
                    if m == n == 0: #或if not(m or n)
                        store[m][n] = 1
                     else:
                        a = store[m-1][n] if m!=0 else 0 #上方格子
                        b = store[m][n-1] if n!=0 else 0 #左方格子
                        store[m][n] = a+b
        return store[-1][-1]
```
2.如果想在原来地图上记录路线也行
```python
class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        #原矩阵版
        height, width = len(obstacleGrid),len(obstacleGrid[0])

        #从上到下，从左到右
        for m in range(height):#每一行
            for n in range(width):#每一列
                if obstacleGrid[m][n]: #如果这一格有障碍物
                    obstacleGrid[m][n] = 0
                else:
                    if m == n == 0: #或if not(m or n)
                        obstacleGrid[m][n] = 1
                    else:
                        a = obstacleGrid[m-1][n] if m!=0 else 0 #上方格子
                        b = obstacleGrid[m][n-1] if n!=0 else 0 #左方格子
                        obstacleGrid[m][n] = a+b
        return obstacleGrid[-1][-1]
```
