package com.test.java;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ex02 {
	
	public static void main(String[] args) {
		
		try {
			
			String url = "https://movie.daum.net/ranking/boxoffice/weekly";
			
			Document doc = Jsoup.connect(url).get();
			
			//System.out.println(doc.html());
			
			Elements list =  doc.select(".item_poster");
			
			//System.out.println(list.size());
			
			for (Element movie : list) {
				
				Element title = movie.selectFirst(".link_txt");
				System.out.println(title.text());
				
				Element date = movie.selectFirst(".txt_num");
				System.out.println(date.text());
				
				Element count = movie.selectFirst(".screen_out");
				System.out.println(count.nextSibling());
				
				Element poster = movie.selectFirst(".img_thumb");
				if (poster != null) {
					System.out.println(poster.attr("src"));
					
					getImage(poster.attr("src"), title.text());
					
					Thread.sleep(2000); //여기서 잠시 멈추세요
				}
				                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
								
			}
			
			//DTO > 포장
			//dao.add(dto) > insert
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//getImage("https://img1.daumcdn.net/thumb/C408x596/?fname=https%3A%2F%2Ft1.daumcdn.net%2Fmovie%2F8a87a8c7a462e24cb77b63b10d1497966f7c6210");
		
		
		
	}//main
	
	private static void getImage(String imgurl, String filename) {
		
		URL url = null;
		InputStream in = null;
		OutputStream out = null;
		
		try {
			
			url = new URL(imgurl);
			in = url.openStream(); //이미지 읽기
			out = new FileOutputStream("C:\\class\\code\\server\\CrawlingTest\\poster\\" + filename + ".png"); //파일 저장하기(쓰기)
			
			while (true) {
				
				int data = in.read();
				
				if (data == -1) break;
				
				out.write(data);
			}
			
			in.close();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				
				in.close();
				out.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
}