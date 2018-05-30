package com.demo.datastructure;

import java.util.ArrayList;
import java.util.List;

public class TreeParent<E> {

	public static class Node<T> {
		T data;
		int parent;// 记录父节点的位置

		public Node() {
		}

		public Node(T data) {
			this.data = data;
		}

		public Node(T data, int parent) {
			this.data = data;
			this.parent = parent;
		}

		public String toString() {
			return "TreeParent$Node[data=" + data + ", parent=" + parent + "]";
		}
	}

	private final int DEFAULT_TREE_SIZE = 100;
	private int treeSize = 0;

	// 使用一个Node[]数组来记录该树的所有节点
	private Node<E>[] nodes;

	// 记录节点数
	private int nodeNums;

	// 以指定节点创建树
	public TreeParent(E data) {
		this.treeSize = DEFAULT_TREE_SIZE;
		this.nodes = new Node[treeSize];
		nodes[0] = new Node<E>(data, -1);
		nodeNums++;
	}

	// 以指定根节点、指定treeSize创建树
	public TreeParent(E data, int treeSize) {
		this.treeSize = treeSize;
		this.nodes = new Node[treeSize];
		nodes[0] = new Node<E>(data, -1);
		nodeNums++;
	}

	// 判断是否为空
	public boolean isEmpty() {
		// 跟节点是否为空
		return nodes[0] == null;
	}

	// 返回包含指定节点的索引位置
	public int pos(Node<E> node) {
		for (int i = 0; i < treeSize; i++) {
			if (nodes[i] == node) {
				return i;
			}
		}
		return -1;
	}

	// 为指定节点添加子节点
	public void addNode(E data, Node<E> parent) {
		for (int i = 0; i < treeSize; i++) {
			// 找到数组中第一个为null的节点，用该节点保存新节点
			if (nodes[i] == null) {
				nodes[i] = new Node<E>(data, this.pos(parent));
				nodeNums++;
				return;
			}
		}
		throw new RuntimeException("该树已满，无法添加新节点");
	}

	// 获取根节点
	public Node<E> getRoot() {
		return nodes[0];
	}

	// 获取指定节点的父节点
	public Node<E> getParent(Node<E> node) {
		// 每个节点记录了其父节点的位置
		return nodes[node.parent];
	}

	// 获取指定节点的子节点
	public List<Node<E>> getChildren(Node<E> node) {
		List<Node<E>> list = new ArrayList<Node<E>>();
		for (int i = 0; i < treeSize; i++) {
			if (nodes[i] != null && nodes[i].parent == this.pos(node)) {
				list.add(nodes[i]);
			}
		}
		return list;
	}

	// 获取树的深度
	public int getDeep() {
		int max = 0;
		for (int i = 0; i < treeSize && nodes[i] != null; i++) {
			//初始化当前节点的深度
			int def = 1;
			//m记录当前节点的父节点的位置
			int m = nodes[i].parent;
			while(m != -1 && nodes[m] != null){
				//继续向上搜索父节点
				m = nodes[m].parent;
				def++;
			}
			if(def > max){
				max = def;
			}
		}
		return max;
	}
	
	//删除指定节点的子树
	public void removeChildren(Node<E> node){
		for (int i = 0; i < treeSize; i++) {
			if (nodes[i] != null && nodes[i].parent == this.pos(node)) {
				nodes[i] = null;
				nodeNums--;
			}
		}
	}
}

