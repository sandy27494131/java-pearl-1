package com.robert.jvm.cocurrent.lock.jenkov.problems;

import java.util.ArrayList;
import java.util.List;

// TODO Haven't made it Dead Lock
public class DeadLock1 {
	public static void main(String[] args) {

		for (int i = 0; i < 100; i++) {
			final TreeNode parent = new TreeNode();
			final TreeNode child = new TreeNode();

			new Thread(new Runnable() {
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					parent.addChild(child);
					System.out.println("Parent -> Child");
				}
			}).start();

			new Thread(new Runnable() {
				public void run() {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					child.setParent(parent);
					System.out.println("Child -> Parent");

				}
			}).start();

		}

	}
}

class TreeNode {

	TreeNode parent = null;
	List<TreeNode> children = new ArrayList<TreeNode>();

	public synchronized void addChild(TreeNode child) {
		if (!this.children.contains(child)) {
			this.children.add(child);
			// ËøÁËparent£¬ÊÔÍ¼Ëøchild
			child.setParentOnly(this);
		}
	}

	public synchronized void addChildOnly(TreeNode child) {
		if (!this.children.contains(child)) {
			this.children.add(child);
		}
	}

	public synchronized void setParent(TreeNode parent) {
		this.parent = parent;
		// ËøÁËchildÊÔÍ¼Ëøparent
		parent.addChildOnly(this);
	}

	public synchronized void setParentOnly(TreeNode parent) {
		this.parent = parent;
	}
}
