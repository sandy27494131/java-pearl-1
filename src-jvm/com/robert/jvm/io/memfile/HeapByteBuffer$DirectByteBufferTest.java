package com.robert.jvm.io.memfile;

import java.nio.ByteBuffer;

public class HeapByteBuffer$DirectByteBufferTest {
	public static void main(String[] args) {
		//HeapByteBuffer
		ByteBuffer bfHeap = ByteBuffer.allocate(1000);
		
		//DirectByteBuffer
		ByteBuffer bfCHeap = ByteBuffer.allocateDirect(1000);
	}
}
