package xin.geek.hackson.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
@RequestMapping("/file")
@ResponseBody
public class FileController {

    @RequestMapping("/downloadFile")
    public void downLoad(HttpServletResponse response, @RequestParam(name = "uri") String uri) throws UnsupportedEncodingException {
        File file = new File(uri);
        if (file.exists()) {
            response.setContentType("application/force-download");
            response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(uri.substring(uri.lastIndexOf("/") + 1), "utf-8"));
            //根据后缀设置返回类型
            String suffix = uri.substring(uri.lastIndexOf('.') + 1);
            switch (suffix) {
                case "jpg":
                case "jpeg":
                    response.setContentType("image/jpeg");
                    break;
                case "txt":
                    response.setContentType("text/plain");
                    break;
                case "map3":
                    response.setContentType("audio/mpeg");
                    break;
                case "gif":
                    response.setContentType("image/gif");
                    break;
                case "ppt":
                    response.setContentType("application/vnd.ms-powerpoint");
                    break;
                case "doc":
                    response.setContentType("application/msword");
                    break;
                case "apk":
                    response.setContentType("application/vnd.android.package-archive");
                    break;
                default:
                    response.setContentType("application/octet-stream");
            }
            byte[] buffer = new byte[1024];
            try (

                    FileInputStream fis = new FileInputStream(file);
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream()
            ) {

                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer);
                    i = bis.read(buffer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            response.setStatus(400);
        }
    }

}
