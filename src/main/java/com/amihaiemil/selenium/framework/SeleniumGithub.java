/**
 * Copyright (c) 2016-2017, Mihai Emil Andronache
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *  1)Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  2)Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *  3)Neither the name of selenium-github-example nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package com.amihaiemil.selenium.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.MarionetteDriver;

/**
 * Github web interface automated with Selenium.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 1.0.0
 */
public final class SeleniumGithub implements Github {

    private final WebDriver driver;
    private final String username;
    private final String pwd;

    /**
     * Default ctor.
     */
    public SeleniumGithub() {
      this ("", "");
    }

    /**
     * Ctor.
     * @param username User login.
     * @param pwd User password.
     */
    public SeleniumGithub (String username, String pwd) {
      this.username = username;
      this.pwd = pwd;
      this.driver = new MarionetteDriver();
    }

    @Override
    public MainDashboardPage login() {
    	this.driver.get("https://github.com/login");
        this.driver.findElement(By.id("login_field"))
            .sendKeys(this.username);
        this.driver.findElement(By.id("login_field"))
            .sendKeys(this.pwd);
        return new RtMainDashboardPage(this.driver);
    }

    @Override
    public UserProfilePage user(String username) {
    	this.driver.get("http://www.github.com/" + username);
        return new RtUserProfilePage(driver);
    }

	@Override
	public void quit() {
		this.driver.quit();
	}

}
