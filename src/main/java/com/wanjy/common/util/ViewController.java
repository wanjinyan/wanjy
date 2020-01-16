package com.wanjy.common.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/*
*
* 该控制器用来便于页面之间的访问
* */
@Controller
public class ViewController {
/*
    @RequestMapping(value = {"/{path1}"})
    public String path1(@PathVariable("path1") String path1){
        return path1;
    }

    @RequestMapping(value = {"/{path1}/{path2}"})
    public String path1(@PathVariable("path1") String path1,@PathVariable("path2") String path2){
        return path1 + "/" + path2;
    }

    @RequestMapping(value = {"/{path1}/{path2}/{path3}"})
    public String path1(@PathVariable("path1") String path1,@PathVariable("path2") String path2,@PathVariable("path3") String path3){
        return path1 + "/" + path2 + "/" + path3;
    }
*/
}
