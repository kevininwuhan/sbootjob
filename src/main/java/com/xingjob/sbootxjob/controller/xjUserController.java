package com.xingjob.sbootxjob.controller;

//import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.xingjob.sbootxjob.common.JwtUtils;
import com.xingjob.sbootxjob.common.R;
import com.xingjob.sbootxjob.entity.xingjobUser;
import com.xingjob.sbootxjob.mapper.xjUsermapper;
import com.xingjob.sbootxjob.service.xjUserService;
//import org.bouncycastle.jce.provider.BouncyCastleProvider;
//import org.bouncycastle.util.encoders.Base64;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import javax.crypto.Cipher;
//import javax.crypto.spec.IvParameterSpec;
//import javax.crypto.spec.SecretKeySpec;
//import javax.servlet.http.HttpServletRequest;
//import java.security.AlgorithmParameters;
//import java.security.Security;
//import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/xjob/user")
@MapperScan("com.xingjob.sbootxjob.mapper")
@CrossOrigin
public class xjUserController {
    @Autowired
    private xjUsermapper xjusermapper;
    @Autowired
    private xjUserService xjuserservice;

    @GetMapping("/findalluser")
    public R findAllUser(){
        List<xingjobUser> list = xjusermapper.selectList(null);
        return R.ok().data("items",list);
    }

    @PostMapping("addxjUser")
    public R addxjUser(@RequestBody xingjobUser xingjobuser ){
        boolean save = xjuserservice.save(xingjobuser);
        if(save){
            return R.ok();
        }else {
            return R.error();
        }
    }
    //根据用户ID进行查询
    @GetMapping("getuserinfo/{uid}")
    public R getUser(@PathVariable String uid){
        xingjobUser userinfo = xjuserservice.getById(uid);
        return R.ok().data("userinfo",userinfo);
    }

    //用户修改功能
    @PostMapping("updateuserinfo")
    public R updateuserinfo(@RequestBody xingjobUser updateuserinfo ){
        boolean flag = xjuserservice.updateById(updateuserinfo);
        if(flag){
            return R.ok();
        }else {
            return R.error();
        }
    }

    //登录
    @PostMapping("login")
    public R userLogin(@RequestBody xingjobUser xingjuser){
       String token =  xjuserservice.login(xingjuser);
        return R.ok().data("token",token);
    }

    //根据token获得用户信息
    @GetMapping("/infobytoken/{token}")
    public R getInfoByToken(@PathVariable String token){
        Map<String,Object> map = new HashMap<>();
        try{
            DecodedJWT verify = JwtUtils.verify(token);

            map.put("uid",verify.getClaim("uid").asString());
            return R.ok().data("map",map);
        }catch (SignatureVerificationException e){
            e.printStackTrace();
            map.put("msg","no");
        }catch (TokenExpiredException e){
            e.printStackTrace();
            map.put("msg","no");
        }catch (AlgorithmMismatchException e){
            e.printStackTrace();
            map.put("msg","no");
        }catch (Exception e){
            e.printStackTrace();
            map.put("msg","no");
        }
        map.put("state",false);
        return R.ok().data("map",map);
    }


//    @PostMapping("/miniGetPhone")
//    @ResponseBody
//    public R miniGetPhone(HttpServletRequest request, String encryptedData, String iv, String session_key)
//    {
//        JSONObject obj=getPhoneNumber(session_key,encryptedData,iv);//解密电话号码
//        String sphone=obj.get("phoneNumber").toString();
//        if(obj.isEmpty() && sphone==null){
//            return R.error().data("手机号解密失败！",400);
//        }else {
//            return R.ok().data("uphone",sphone);
//        }
//    }

    //解析电话号码
//    public JSONObject getPhoneNumber(String session_key, String encryptedData, String iv) {
//        byte[] dataByte = Base64.decode(encryptedData);
//        byte[] keyByte = Base64.decode(session_key);
//        byte[] ivByte = Base64.decode(iv);
//        try {
//            int base = 16;
//            if (keyByte.length % base != 0) {
//                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
//                byte[] temp = new byte[groups * base];
//                Arrays.fill(temp, (byte) 0);
//                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
//                keyByte = temp;
//            }
//            // 初始化
//            Security.addProvider(new BouncyCastleProvider());
//            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
//            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
//            parameters.init(new IvParameterSpec(ivByte));
//            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);
//            byte[] resultByte = cipher.doFinal(dataByte);
//            if (null != resultByte && resultByte.length > 0) {
//                String result = new String(resultByte, "UTF-8");
//                return JSONObject.parseObject(result);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//
//    }
}
