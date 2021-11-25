package competitive.mit.heap;

import java.util.Arrays;

public class Heap implements IHeap{

	private final int data[];
	private int size;
	
	public Heap(int size) {
		data = new int[size];
	}
	
	@Override
	public void add(int value) {
		data[size] = value;
		size++;
		heapfiyUp();
	}
	
	@Override
	public int getMin() {
		swap(0, size-1);
		int v = data[size-1];
		size--;
		heapfiyDown();
		return v;
	}
	
	
	private void swap(int index1, int index2) {
		int temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}

	private void heapfiyDown() {
		int itr = 0;
		while (itr <= size) {
			int childLeft = itr*2+1;
			int childRight = itr*2+2;
			int smallestChild;
			if (childLeft >= size) break;	// no children
			if (childRight >= size) smallestChild =  childLeft;	// left child only
			else smallestChild = (data[childLeft] < data[childRight]) ? childLeft : childRight; // two children
			if (data[itr] > data[smallestChild]) swap(itr, smallestChild);
			else break;
			itr = smallestChild;
		}
	}
	
	private void heapfiyUp() {
		int itr = size-1;
		while (itr != 0) {
			int parent = itr/2;
			if (data[parent] > data[itr]) swap(itr, parent);
			else break;
			itr = parent;
		}
	}
	
	@Override
	public String toString() {
		return Arrays.toString(data) + ", size = " + size;
	}
	
}
