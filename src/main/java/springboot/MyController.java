package springboot;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping("/")
    public @ResponseBody String root() throws Exception {
        return "Form 데이터 전달받아 사용하기";
    } // f end

    @RequestMapping("/test1")
    public String test1(HttpServletRequest req, Model model ){
        String id = req.getParameter("id");
        String name = req.getParameter("name");

        model.addAttribute("id", id );
        model.addAttribute("name", name );

        return "test1";
    } // f end

    @RequestMapping("/test2")
    public String test2(@RequestParam String id, @RequestParam String name, Model model ){
        // 파라미터가 많으면 불편해진다.
        model.addAttribute("id", id );
        model.addAttribute("name", name );

        return "test2";
    } // f end

    @RequestMapping("/test3")
    public String test3( Member member, Model model ){
        // 파라미터와 일치하는 빈을 만들어서 사용할 수 있다.
        // View 페이지에서 model을 사용하지 않고 member를 사용한다.
        return "test3";
    } // f end

    // 패스 자체에 변수를 넣을 수도 있다.
    @RequestMapping("/test4/{studentId}/{name}")
    public String test4(@PathVariable String studentId, @PathVariable String name, Model model ){
        model.addAttribute("id", studentId );
        model.addAttribute("name", name );

        return "test4";
    } // f end


}
