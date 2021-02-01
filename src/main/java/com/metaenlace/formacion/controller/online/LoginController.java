package com.metaenlace.formacion.controller.online;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class LoginController {

	  @RequestMapping(value = "login", method = RequestMethod.GET)
      public ModelAndView login() {
          ModelAndView mav = new ModelAndView("login");
          return mav;
      }
	  
	  @RequestMapping(value = "paciente", method = RequestMethod.GET)
      public ModelAndView paciente() {
          ModelAndView mav = new ModelAndView("paciente");
          return mav;
      }
	  
	  @RequestMapping(value = "medico", method = RequestMethod.GET)
      public ModelAndView medico() {
          ModelAndView mav = new ModelAndView("medico");
          return mav;
      }
}
