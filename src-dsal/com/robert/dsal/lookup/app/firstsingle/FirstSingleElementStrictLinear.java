package com.robert.dsal.lookup.app.firstsingle;

public class FirstSingleElementStrictLinear implements FirstSingleElement{
	public int find(int[] x) {
		return -1;
	}

	public String find(String[] strs) {
		class Node {
			String key;
			int count;

			// 处理hash冲突
			Node sibling;

			Node prev;
			Node next;
		}

		// 创建hash表
		final int HASH_MAX_SIZE = 1024;
		Node[] nodes = new Node[HASH_MAX_SIZE];

		// 单元素链表
		Node singleHead = null, singleTail = null;

		for (int i = 0; i < strs.length; i++) {
			// 取出每一个元素，然后取hash值
			String curr = strs[i];
			int hash = curr.hashCode();
			if (hash < 0)
				hash = -hash;

			// 使用hash值找到相应的节点列表头
			Node n = nodes[hash % HASH_MAX_SIZE];
			while (n != null) {
				if (n.key.equals(curr)) {
					// 如果当前字符串存在，则将数量加1
					n.count++;
					if (n.count == 2) {
						// Remove from single list if the count is from 1 to 2

						if (singleHead == n && singleTail == n) {
							singleHead = singleTail = null;
						}else if (singleHead == n) {
							singleHead = singleHead.next;
							singleHead.prev = null;
						} else if (singleTail == n) {
							singleTail = singleTail.prev;
							singleTail.next = null;
						} else {
							n.prev.next = n.next;
							n.next.prev = n.prev;
						}

					}
					break;
				}

				n = n.sibling;
			}

			if (n == null) {
				// 如果没找到已存节点，则创建一个
				Node newnode = new Node();
				newnode.key = curr;
				newnode.count = 1;

				// 头插新节点
				newnode.sibling = nodes[hash % HASH_MAX_SIZE];
				nodes[hash % HASH_MAX_SIZE] = newnode;

				// Add it to single list
				if (singleHead == null) {
					singleHead = singleTail = newnode;
				} else {
					singleTail.next = newnode;
					newnode.prev = singleTail;

					singleTail = newnode;
				}
			}
		}

		return singleHead != null ? singleHead.key : null;
	}
}
