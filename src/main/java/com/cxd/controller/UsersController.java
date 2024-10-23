package com.cxd.controller;

import com.cxd.model.Users;
import com.cxd.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/users")
    /*
               这次不直接返回Users对象给浏览器，而是返回一个ResponseEntity响应对象，实现更全面的响应控制，毕竟不是每次都是能成功返回数据，
              尖括号的问号表示响应体类型，可以是任何一种类型
              例如，ResponseEntity<Users> 表示响应体是一个 Users 对象。
        ResponseEntity<String> 表示响应体是一个字符串。
     */
    public ResponseEntity<?> registerUser(
            @RequestParam("username") String username, //// 如果用户请求参数和方法入参名称一样，可以不写
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam(value = "bio", required = false) String bio,
            @RequestParam(value = "image", required = false) String image) {
        
        try {
            Users newUser = new Users(username, email, password);
            newUser.setBio(bio);
            newUser.setImage(image);
            Users createdUser = usersService.createUser(newUser);
            return ResponseEntity.ok(createdUser); //调用ResponseEntiy的静态方法ok()，返回JSON格式的createdUser 对象给浏览器
        } catch (Exception e) {
            // 返回错误响应或处理异常
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
    
    /*
                 根据用户编号获取用户信息。
     * @param id 用户编号
     * @return 包含用户信息的 ResponseEntity，或错误信息
    */
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserByID(@PathVariable Long id) {
        try {
            // 调用服务层方法，根据用户编号获取用户信息
            Optional<Users> user = usersService.getUserByID(id);

            // 检查 Optional容器里 是否包含用户信息
            if (user.isPresent()) {
                // 如果用户存在，返回 200成功代码 和用户对象
                return ResponseEntity.ok(user.get());
            } else {
                // 如果用户不存在，返回 404 代码 和错误消息
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }
        } catch (Exception e) {
            // 捕获并处理其他异常，返回 500 Internal Server Error 和错误消息
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    /* 
    根据用户编号删除用户。

* @param id 用户编号
* @return 删除成功的 ResponseEntity，或错误信息
*/
@DeleteMapping("/users/{id}") //当用户输入网址为/api/users/某个编号，而且请求类型不是get或post，而是delete时，本方法会被调用
public ResponseEntity<?> deleteUserByID(@PathVariable Long id) {
try {
// 调用服务层方法，根据用户编号删除用户
boolean isDeleted = usersService.deleteUserByID(id);

if (isDeleted) {
  // 如果删除成功，返回 200 OK 和成功消息
  return ResponseEntity.ok("该用户被成功删除！");
} else {
  // 如果用户不存在，返回 404 Not Found 和错误消息
  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("找不到该用户!");
}
} catch (Exception e) {
// 捕获并处理其他异常，返回 500 Internal Server Error 和错误消息
return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
}
}

    
    
}
