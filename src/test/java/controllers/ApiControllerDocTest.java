/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import java.util.Map;

import ninja.NinjaApiDocTest;

import org.junit.Test;

import com.google.common.collect.Maps;

import de.devbliss.apitester.ApiResponse;

public class ApiControllerDocTest extends NinjaApiDocTest {
    
    String GET_ARTICLES_URL = "/api/{username}/articles.json";
    String POST_ARTICLE_URL = "/api/{username}/article.json";
    String LOGIN_URL = "/login";
    
    String USER = "bob@gmail.com";

    @Test
    public void doLogin() throws Exception {

        say("To authenticate we send our credentials to " + LOGIN_URL);
        say("We are then issued a cookie from the server that authenticates us in further requests");

        Map<String, String> formParameters = Maps.newHashMap();
        formParameters.put("username", "bob@gmail.com");
        formParameters.put("password", "secret");
        
        ApiResponse apiResponse = makePostRequest(buildUri(LOGIN_URL, formParameters));
        assertNotNullAndSay(apiResponse.headers.containsKey("USERNAME"), "User is already in cookie");
        
       
    }

    @Override
    protected String getFileName() {
        return this.getClass().getSimpleName();
    }

}
