package br.com.danielfreitassc.cursoSpringBoot;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.danielfreitassc.cursoSpringBoot.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {
    
    private final AtomicLong counter =  new AtomicLong();

    // Adição
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET) 
    public Double sum(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Por favor digite um valor númerico");
        }

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    // subtração
    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Por favor digite um valor númerico");
        }
        
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    // Multiplicação
    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mult(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Por favor digite um valor númerico");
        }
        
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    // Divisão
    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Por favor digite um valor númerico");
        }
        
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    // Média
    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mean(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Por favor digite um valor númerico");
        }
        
        return convertToDouble(numberOne) + convertToDouble(numberTwo) / 2;
    }
    
      // Potencia
      @RequestMapping(value = "/square/{number}", method = RequestMethod.GET)
      public Double square(
          @PathVariable(value = "number") String number
      ) throws Exception {
          if(!isNumeric(number)){
              throw new UnsupportedMathOperationException("Por favor digite um valor númerico");
          }
          
          return Math.sqrt(convertToDouble(number));
      }



    private Double convertToDouble(String strNumber) {
        if(strNumber == null) return 0D;
            
        String number = strNumber.replaceAll("," ,".");
        if(isNumeric(number)) return Double.parseDouble(number);
        return 0D;   
    }

    private boolean isNumeric(String srtNumber) {
       if (srtNumber == null) return false;
       String number = srtNumber.replaceAll(",", ".");
       return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
          