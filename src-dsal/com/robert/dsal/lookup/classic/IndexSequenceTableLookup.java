package com.robert.dsal.lookup.classic;

/**
 * 算法名称：
 * 
 * 分块查找或者索引顺序表查找
 * 
 * 算法描述：
 * 
 * 分块查找又称索引顺序查找，它是顺序查找的一种改进方法。将n个数据元素“按块有序”划分为m块（m<=n）。 每一块中的数据元素不必有序
 * ，但块与块之间必须“按块有序”，即第1块中的任一元素的关键字都必须小于第2块中任一元素的关键字；而第2块中任一元素又都小于第3块中的任一元素，……
 * 
 * 时间复杂度：
 * 
 * 算法复杂度介于顺序查找和二分查找之间
 */
public class IndexSequenceTableLookup extends AbstractLookup {
	private IndexTableItem[] items;
			
	class IndexTableItem {
		int maxValue;
		int firstIndex;
	}
	
	public IndexSequenceTableLookup(int shardNum) {
		int ceilShardNum = (int)Math.pow(2, Math.floor(Math.log10(15) / Math.log10(2)) + 1);
		this.items = new IndexTableItem[ceilShardNum];   
	}
	
	public static void main(String[] args) {
		System.out.println();
		
		System.out.println(Math.log1p(0.1));
		System.out.println(Math.log(0.1 + 1));
	}
	
	public void setup(int[] seq) {
		super.setup(seq);
		
		constructIndexTable(seq);
	}
	
	private void constructIndexTable(int[] seq) {
		
	}

	@Override
	public int lookup(int t) {
		for (int i = 0; i < seq.length; i++)
			if (seq[i] == t)
				return i;
		
		return -1;
	}
}
