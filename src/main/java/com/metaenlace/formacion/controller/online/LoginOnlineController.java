package com.metaenlace.formacion.controller.online;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class LoginOnlineController {

	  @RequestMapping(value = "login", method = RequestMethod.GET)
      public ModelAndView login() {
          ModelAndView mav = new ModelAndView("login");
          return mav;
      }
}
