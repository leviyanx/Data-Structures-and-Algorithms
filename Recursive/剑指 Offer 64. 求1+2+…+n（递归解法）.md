# 剑指 Offer 64. 求1+2+…+n（递归解法）

[剑指 Offer 64. 求1+2+…+n](/problems/qiu-12n-lcof/)
#递归

## 解题思路

程序主要部分的具体思路：
- 对于n来说，假设前面 n-1 个元素的和已经求好。那么，当 n 加入时，和(sum) 就是 n 加上前面n-1个元素的和。

注意：
- 边界条件是 `n<=0`，而不仅仅是 `n==0`。前者还可以处理 `n<0`时的异常情况。

## 代码

```java
class Solution {
    public int sumNums(int n) {
        if( n<=0 )
            return 0;

        // n > 0
        return n + sumNums( n-1 );
    }
}
```