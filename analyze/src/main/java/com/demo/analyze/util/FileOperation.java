package com.demo.analyze.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

/**
 * @author jiahe
 * file operations
 */
public class FileOperation {

	private static Logger LOG = Logger.getLogger(FileOperation.class.getName());
	
	/**
	 * @param dirStr
	 *            the base dir path
	 * @return the directory list in the base dir
	 */
	public static File[] loadFiles(String dirPath) {

		File[] filelist = new File[0];
		File dir = new File(dirPath);
		if (dir.isDirectory()) {
			filelist = dir.listFiles();
		}
		return filelist;
	}
	
	public static String[] getFilePaths(String dirPath) {

		File[] filelist = new File[0];
		File dir = new File(dirPath);
		if (dir.isDirectory()) {
			filelist = dir.listFiles();
		}
		
		String[] fns = new String[filelist.length];
		for (int i =0;i<filelist.length;i++) {
			fns[i] = filelist[i].getAbsolutePath();
		}
		return fns;
	}
	
	public static boolean isFileExists(String filePath) {
		File f = new File(filePath);
		if (f.exists()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 根据文件路径获得文件名
	 * 
	 * @param filePath
	 * @return
	 */
	public static String getFileName(String filePath) {
		int index = filePath.lastIndexOf("/");
		return filePath.substring(index + 1);
	}
	
	/**
	 * 根据文件路径获得文件目录
	 * 
	 * @param filePath
	 * @return
	 */
	public static String getFileDir(String filePath) {
		int index = filePath.lastIndexOf("/");
		return filePath.substring(0, index + 1);
	}
	
	/**
	 * @param dir
	 * 			create directory
	 */
	public static void createDir(String dir) {
		File f = new File(dir);
		if (! f.exists()) {
			f.mkdirs();
		}		
	}
	
	public static void createFile(String file) {
		File f = new File(file);
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @param filePath
	 *            the file path delete the file
	 */
	public static int deleteFile(String filePath) {

		File file = new File(filePath);
		if (file.exists()) {
			file.delete();
			return 0;
		} else {
			LOG.info("要删除的文件不存在!");
			return -1;
		}
	}
	
	/*
	 * 删除目录所在的子文件夹和文件
	 * 
	 */
	public static void deleteDir(String path) {
		File dir = new File(path);
		
		if(dir.isDirectory()){
			File[] files = dir.listFiles();//将文件和文件夹放入文件集
			if (files == null){//判断文件集是否为空
				return ;
			}
			for(int i = 0;i<files.length;i++){//遍历文件集
				if(files[i].isDirectory()) {//如果是文件夹或目录，则递归调用deleteFile方法，直到获得目录下的文件
//					String path0 = files[i].getPath()+"/"+files[i].getName();
					deleteDir(files[i].getPath());//递归移动文件
					files[i].delete();//删除文件所在原目录
				}
				files[i].delete();
			}
			dir.delete();
		}else{
			dir.delete();
		}
	}

	/**
	 * @param src
	 *            the source path
	 * @param dest
	 *            the dest path move the file from src to dest
	 */
	public static void move(String src, String dest) {

		File file = new File(src);
		file.renameTo(new File(dest));
	}
	
	public static String getFileContent(String filePath) throws IOException {
		// InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), getCharset(filePath));
		InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "utf-8");
		BufferedReader br = new BufferedReader(isr);
		StringBuffer sb = new StringBuffer();
		
		String temp = null;
		while ((temp = br.readLine()) != null) {
			sb.append(temp);
		}
		br.close();
		return sb.toString();
	}

	public static void writeFile(String filePath, String content) throws FileNotFoundException {
		// 1. if the parent dir does not exists, mkdirs
		createParentDir(filePath);

		try {
			PrintWriter out = new PrintWriter(filePath, "utf8");
			out.println(content);
			out.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void writeFile(String filePath, String content, String charset) throws FileNotFoundException {
		// 1. if the parent dir does not exists, mkdirs
		createParentDir(filePath);

		try {
			PrintWriter out = new PrintWriter(filePath, charset);
			out.println(content);
			out.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public static void createParentDir(String filePath) {
		File destParent = new File(filePath).getParentFile();
		// 1. if the parent dir does not exists, mkdirs
		if (!destParent.exists()) {
			destParent.mkdirs();
		}
	}
	
	public static void createParentDir(File file) {
		File destParent = file.getParentFile();
		// 1. if the parent dir does not exists, mkdirs
		if (!destParent.exists()) {
			destParent.mkdirs();
		}
	}
	
	public String getResPath(String filePath) {
		URL url = this.getClass().getClassLoader().getResource(filePath);
		//URL url = ClassLoader.getSystemResource("");
		//URL url = Thread.currentThread().getContextClassLoader().getResource("");
		String resPath =url.toString();
		
		System.out.println("path: " + resPath);
		return resPath;
	}
	
	public static void main(String[] args) throws IOException {


	}
}
