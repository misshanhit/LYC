package com.lyc.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class ExportPDFServlet
 */
@WebServlet("/ExportPDFServlet")
public class ExportPDFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final String FILE_LOCATION = "E:/workspace/LYC/WebContent/temps";
//	final String[][] contentTypes = {{"pdf", "application/pdf"}};
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExportPDFServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		File file = new File(FILE_LOCATION + "/Profile.pdf");
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment; filename=Profile.pdf");
		response.setContentLength((int)file.length());
		ServletOutputStream servletOutputStream = response.getOutputStream();
		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
		int bytesRead = bufferedInputStream.read();
		while (bytesRead != -1) {
			servletOutputStream.write(bytesRead);
			bytesRead = bufferedInputStream.read();			
		}
		if(servletOutputStream != null)
			servletOutputStream.close();
		if(bufferedInputStream != null)
			bufferedInputStream.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public void createPDFFile(){
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("Profile.pdf"));
			document.open();
			Paragraph paragraph = new Paragraph();
			paragraph.add("Hello LYC");
			document.add(paragraph);
			document.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
