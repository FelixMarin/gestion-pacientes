package com.metaenlace.formacion.controller.online;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class MedicoOnlineController {
	  
	  @RequestMapping(value = "medico", method = RequestMethod.GET)
      public ModelAndView medico() {
          ModelAndView mav = new ModelAndView("medico");
          return mav;
      }
}
