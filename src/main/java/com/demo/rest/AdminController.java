/*
 *  Copyright 2019-2020 Zheng Jie
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.demo.rest;

import com.alibaba.fastjson.JSON;
import com.demo.param.User;
import com.demo.utils.UserContext;
import com.demo.utils.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {


    @PostMapping(value = "/addUser")
    public String addUser(@RequestBody User user){
        User loginUser = UserContext.getUser();
        if("admin".equals(loginUser.getRole())){
            UserUtil.put(user.getUserId(), JSON.toJSONString(user));
            return "success";
        }else{
            return "no permission！";
        }
    }

}
