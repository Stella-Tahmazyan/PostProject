package com.webPage.am.controller;

import com.webPage.am.entity.User;
import com.webPage.am.repository.UserRepository;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class UserController {
  @Autowired
  private PasswordEncoder passwordEncoder;

   @Value("${image.upload.dir}")
  private String imageUploadDir;

  @Autowired
  private UserRepository userRepository;

  @PostMapping("/save/register")
  public String registerUser(@ModelAttribute User user, @RequestParam("picture") MultipartFile file)
      throws IOException {
      String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
      File picture = new File(imageUploadDir + File.separator + fileName);
      file.transferTo(picture);
      user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setImagePath(fileName);
    userRepository.save(user);
    return "login";
  }

  @GetMapping("/getImage")
  public void getImageAsByteArray(HttpServletResponse response, @RequestParam("imagePath") String picUrl) throws IOException {
    InputStream in = new FileInputStream(imageUploadDir + File.separator + picUrl);
    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
    IOUtils.copy(in, response.getOutputStream());
  }

//  @PostMapping("/save/login")
//  public String saveLogin(@ModelAttribute User user){
//    if(userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword())!=null){
//     return "redirect:/get/category";
//    }
//    return "register";
//  }
}
