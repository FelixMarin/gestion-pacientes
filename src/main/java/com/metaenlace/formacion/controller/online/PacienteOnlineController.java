package com.metaenlace.formacion.controller.online;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class PacienteOnlineController {
  
	  @RequestMapping(value = "paciente", method = RequestMethod.GET)
      public ModelAndView paciente() {
          ModelAndView mav = new ModelAndView("paciente");
          return mav;
      }
	  
	  @RequestMapping(value = "cita", method = RequestMethod.GET)
      public ModelAndView cita() {
          ModelAndView mav = new ModelAndView("components/cita");
          return mav;
      }
	  
	  @RequestMapping(value = "perfil", method = RequestMethod.GET)
      public ModelAndView perfil() {
          ModelAndView mav = new ModelAndView("components/perfil");
          return mav;
      }
	  
	  @RequestMapping(value = "diagnosticos", method = RequestMethod.GET)
      public ModelAndView diagnosticos() {
          ModelAndView mav = new ModelAndView("components/diagnosticos");
          return mav;
      }
	  
	  @RequestMapping(value = "mensajes", method = RequestMethod.GET)
      public ModelAndView mensajes() {
          ModelAndView mav = new ModelAndView("components/mensajes");
          return mav;
      }
	  
	  @RequestMapping(value = "cuerpoMenuLateral", method = RequestMethod.GET)
      public ModelAndView cuerpoMenuLateral() {
          ModelAndView mav = new ModelAndView("components/cuerpoMenuLateral");
          return mav;
      }
	  
	  @RequestMapping(value = "medicacion", method = RequestMethod.GET)
      public ModelAndView medicacion() {
          ModelAndView mav = new ModelAndView("components/medicacion");
          return mav;
      }
	  
	  @RequestMapping(value = "detalle-cita", method = RequestMethod.GET)
      public ModelAndView detalleCita() {
          ModelAndView mav = new ModelAndView("components/detalleCita");
          return mav;
      }
}
