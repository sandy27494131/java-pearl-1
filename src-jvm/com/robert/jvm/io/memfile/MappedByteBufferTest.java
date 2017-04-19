package com.robert.jvm.io.memfile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class MappedByteBufferTest {

	static String filename1 = "d:\\work\\code\\filechannelstudy.txt";
	static String filename2 = "d:\\work\\code\\file.txt";
	static String content = "abcdefghijk\r\n";
	static long size = 1024000000l;
	static long num = size / 10 * 6;
	static long startT = 0;
	static long endT = 0;

	public static void setStartT(MappedByteBuffer mbb, int cnt) {
		mbb = null;
		if (cnt % 50 == 0) {
			System.gc();
			System.out.println("call gc");
		}
		startT = System.currentTimeMillis();
	}

	public static long ellipseT() {
		endT = System.currentTimeMillis();
		long consumeT = endT - startT;
		System.out.println("consume time :" + consumeT / 1000 + " second");
		return consumeT / 1000;
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// readFile1();
		createFile(true);
		preparedFile1();
		preparedFile2();

	}

	public static void createFile(boolean bReCreate) throws IOException {
		if (!bReCreate) {
			File f = new File(filename1);
			if (!f.exists())
				f.createNewFile();
			f = new File(filename2);
			if (!f.exists())
				f.createNewFile();
		} else {
			File f = new File(filename1);
			if (f.exists())
				f.delete();
			f.createNewFile();
			f = new File(filename2);
			if (f.exists())
				f.delete();
			f.createNewFile();
		}
	}

	public static void preparedFile2() throws IOException {

		BufferedOutputStream bo = new BufferedOutputStream(
				new FileOutputStream(filename2));
		try {
			System.out.println("fill file by io");
			//setStartT();
			for (int i = 0; i < num; i++) {
				bo.write(content.getBytes());
			}
			ellipseT();
		} finally {
			if (bo != null)
				bo.close();
		}
	}

	public static void preparedFile1() throws IOException {
		long mapsize = content.getBytes().length * 1000000 * 100;
		long position = 0;
		FileChannel ch = new RandomAccessFile(filename1, "rw").getChannel();
		MappedByteBuffer mbb = ch.map(MapMode.READ_WRITE, position, mapsize);
		int cnt = 0;
		try {
			System.out.println("fill file by nio");
			setStartT(mbb, cnt);
			for (int i = 0; i < num; i++) {
				if (mbb.remaining() < content.getBytes().length) {
					cnt++;
					position += mbb.position();
					mbb = null;
					if (cnt % 50 == 0) {
						System.gc();
						System.out.println("call gc");
					}
					mbb = ch.map(MapMode.READ_WRITE, position, mapsize);
				}
				mbb.put(content.getBytes());
			}
			ellipseT();
		} finally {
			if (ch != null)
				ch.close();
		}
	}

	public static void readFile1() throws IOException {
		long mapsize = content.getBytes().length * 1000000;
		long position = 0;
		// long rper = 2000000000;
		long rper = 1300000000;
		FileChannel ch = new RandomAccessFile(filename1, "rw").getChannel();
		MappedByteBuffer mbb = ch.map(MapMode.READ_WRITE, 0, rper);
		int rs = 102400;
		byte dst[] = new byte[rs];
		int cnt = 0;
		while (mbb.hasRemaining()) {
			ByteBuffer bb = mbb.get(dst);
			cnt++;
			if (cnt % 50 == 0)
				System.out.println(bb.toString());
		}
	}
}
