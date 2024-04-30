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
package demo.rest;

import com.alibaba.fastjson.JSON;
import com.demo.param.User;
import com.demo.rest.AdminController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdminController.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestAdminController {


    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void addUser(){
        User user = new User();
        user.setUserId("1234");
        user.setRole("admin");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","eyJ1c2VySWQiOiIxMjMiLCJyb2xlIjoiYWRtaW4ifQ==");
        HttpEntity<Object> entity = new HttpEntity<>(JSON.toJSON(user), headers);

        ResponseEntity<MockHttpServletResponse> responseEntity = testRestTemplate.exchange("http://localhost:8081/admin/addUser", HttpMethod.POST, entity,
                MockHttpServletResponse.class);

        Assert.assertNotNull(responseEntity.getBody());
        Assert.assertNull(responseEntity.getBody()
                .getErrorMessage());
    }

}
