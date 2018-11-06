package com.company.hellospring.board;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	//상세보기
	@RequestMapping("getBoard")
	public String getBoard(BoardDTO dto, Model model) {
		model.addAttribute("board", boardService.getBoard(dto));
		return "board/getBoard";
	}

	//목록 조회
	@RequestMapping("getBoards")
	public String getBoards(Model model) {
		model.addAttribute("list", boardService.getBoards());
		return "board/getBoards";
	}

	// 등록 폼
	@RequestMapping(value = "insertBoard", method = RequestMethod.GET)
	public String insertBoardForm() {
		return "board/insertBoard";
	}

	// 등록 처리
	@RequestMapping(value = "insertBoard", method = RequestMethod.POST)
	public String insertBoard(BoardDTO board, HttpServletRequest request) throws IOException {
		String folder = request.getSession().getServletContext().getRealPath("/images");
		// 첨부파일 처리
		MultipartFile[] uploadFile = board.getUploadFile();
		for(int i=0; i<uploadFile.length; i++) {
			if (!uploadFile[i].isEmpty() && uploadFile[i].getSize() > 0) {
				String filename =
						//uploadFile.getOriginalFilename();
						new String(uploadFile[i].getOriginalFilename().getBytes("8859_1"), "UTF-8");
				uploadFile[i].transferTo(new File(folder, filename));
				board.setUploadFileName(filename);
			}	
		}
		
		// 파일명 중복 처리(FileRenamePolicy 추가할 것)
		
		// 게시글 등록
		boardService.insertBoard(board);
		return "board/getBoards";
	}

	/**
	* 브라우저 구분 얻기.
	*
	* @param request
	* @return
	*/
	private String getBrowser(HttpServletRequest request) {
		String header = request.getHeader("User-Agent");
		if (header.indexOf("MSIE") > -1) {
			return "MSIE";
		} else if (header.indexOf("Trident") > -1) { // IE11 문자열 깨짐 방지
			return "Trident";
		} else if (header.indexOf("Chrome") > -1) {
			return "Chrome";
		} else if (header.indexOf("Opera") > -1) {
			return "Opera";
		}
		return "Firefox";
	}

	/**
	 * Disposition 지정하기.
	 *
	 * @param filename
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void setDisposition(String filename, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String browser = getBrowser(request);
		String dispositionPrefix = "attachment; filename=";
		String encodedFilename = null;
		if (browser.equals("MSIE")) {
			encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
		} else if (browser.equals("Trident")) { // IE11 문자열 깨짐 방지
			encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
		} else if (browser.equals("Firefox")) {
			encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
		} else if (browser.equals("Opera")) {
			encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
		} else if (browser.equals("Chrome")) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < filename.length(); i++) {
				char c = filename.charAt(i);
				if (c > '~') {
					sb.append(URLEncoder.encode("" + c, "UTF-8"));
				} else {
					sb.append(c);
				}
			}
			encodedFilename = sb.toString();
		} else {
			throw new IOException("Not supported browser");
		}
		response.setHeader("Content-Disposition", dispositionPrefix + encodedFilename);
		if ("Opera".equals(browser)) {
			response.setContentType("application/octet-stream;charset=UTF-8");
		}
	}

	/**
	 * 첨부파일로 등록된 파일에 대하여 다운로드를 제공한다.
	 *
	 * @param commandMap
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/FileDown.do")
	public void cvplFileDownload(@RequestParam Map<String, Object> commandMap,
								 HttpServletRequest request,
								 HttpServletResponse response) throws Exception {
		String atchFileId = (String) commandMap.get("atchFileId");
		File uFile = new File("C:/Upload", atchFileId);
		long fSize = uFile.length();
		if (fSize > 0) {
			String mimetype = "application/x-msdownload";
			response.setContentType(mimetype);
			// response.setHeader("Content-Disposition", "attachment;
			// filename=\"" + URLEncoder.encode(fvo.getOrignlFileNm(), "utf-8") + "\"");
			setDisposition(atchFileId, request, response);
			BufferedInputStream in = null;
			BufferedOutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(uFile));
				out = new BufferedOutputStream(response.getOutputStream());
				FileCopyUtils.copy(in, out);
				out.flush();
			} catch (IOException ex) {
			} finally {
				in.close();
				response.getOutputStream().flush();
				response.getOutputStream().close();
			}
		} else {
			response.setContentType("application/x-msdownload");
			PrintWriter printwriter = response.getWriter();
			printwriter.println("<html>");
			printwriter.println("<h2>Could not get file name:<br>" + atchFileId + "</h2>");
			printwriter.println("<center><h3><a href='javascript: history.go(-1)'>Back</a></h3></center>");
			printwriter.println("&copy; webAccess");
			printwriter.println("</html>");
			printwriter.flush();
			printwriter.close();
		}
	}
}
