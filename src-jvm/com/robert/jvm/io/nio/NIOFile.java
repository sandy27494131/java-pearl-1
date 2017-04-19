package com.robert.jvm.io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFile {
	public void readFileByIO(String fileName) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(fileName);
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) != -1) {
				System.out.write(buffer, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void readByNIO(String file) throws IOException {
		final int BUFFER_SIZE = 0x1200000;// 缓冲大小为12M
		final FileChannel fcin = new RandomAccessFile(new File(file), "r").getChannel();
		ByteBuffer rBuffer = ByteBuffer.allocate(BUFFER_SIZE);
		String enterStr = "\n";
		byte[] bs = new byte[BUFFER_SIZE];

		StringBuffer strBuf = new StringBuffer("");
		Long start = System.currentTimeMillis();

		int count = 0;
		while (fcin.read(rBuffer) != -1) {
			int rSize = rBuffer.position();
			rBuffer.rewind();
			rBuffer.get(bs);
			rBuffer.clear();
			String tempString = new String(bs, 0, rSize);

			int fromIndex = 0;
			int endIndex = 0;
			while ((endIndex = tempString.indexOf(enterStr, fromIndex)) != -1) {
				String line = tempString.substring(fromIndex, endIndex);
				line = new String(strBuf.toString() + line);

				count++;
				if (count % 500 == 0) {
					System.out.print("-");
				}
				if (count % 80000 == 0) {
					System.out.println(count);
				}
				strBuf.delete(0, strBuf.length());
				fromIndex = endIndex + 1;
			}
			if (rSize > tempString.length()) {
				strBuf.append(tempString.substring(fromIndex,
						tempString.length()));
			} else {
				strBuf.append(tempString.substring(fromIndex, rSize));
			}
		}

		long end = System.currentTimeMillis();
		System.out.println("读取文件文件花费：" + (end - start) + "毫秒");

	}

	/**
	 * 利用NIO将内容输出到文件中
	 * 
	 * @param file
	 */
	public void writeFileByNIO(String file) {
		FileOutputStream fos = null;
		FileChannel fc = null;
		ByteBuffer buffer = null;
		try {
			fos = new FileOutputStream(file);
			// 第一步 获取一个通道
			fc = fos.getChannel();
			// buffer=ByteBuffer.allocate(1024);
			// 第二步 定义缓冲区
			buffer = ByteBuffer.wrap("Hello World 2".getBytes());
			// 将内容写到缓冲区
			fos.flush();
			fc.write(buffer);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fc.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) throws IOException {
		NIOFile nood = new NIOFile();
		String fileName = "C:\\Users\\IBM_ADMIN\\Desktop\\Filenet ICN\\ICN-Red Book-Customizing and Extending 2.0.pdf";
		nood.readFileByIO(fileName);
		nood.readByNIO(fileName);
		// nood.writeFileByNIO(fileName);
	}

}
