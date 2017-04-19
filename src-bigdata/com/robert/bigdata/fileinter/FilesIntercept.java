package com.robert.bigdata.fileinter;

import java.io.File;

/*
 两个大文件求交集, 数据量：m - n

 最差：O(mn)

 解法1：平均分块: k

 对比O(mn)
 磁盘读取次数O(m + k * n) = O(m + kn)
 -----分块k越多，读取次数就越多，但是，每次利用内存就越小
 -----分块k越少，读取次数就越少，但是，需要的内存就越高
 -----内存使用和读取次数是成反比的


 解法2：使用hash分块，hash(string) % k, 一共分成k块,同样的数据在同样需要的块里，然后再用hash统计 

 对比O(m + n + (m/k + n/k) * k) = O(m + n) 近似线性
 磁盘读取次数O(m + n + (m/k + n /k) * k) = O(2m + 2n) = O(m + n) 近似线性

 ------可见这样使用hash限制数据在分块的范围内，就降低了复杂度，时间复杂度近似成线性

 解法3：找树中的公共子父节点的其他方法

 http://www.cnblogs.com/chenwenbiao/archive/2011/05/26/2058261.html
 */

public interface FilesIntercept {
	public File interceptFiles(File f1, File f2);
}
