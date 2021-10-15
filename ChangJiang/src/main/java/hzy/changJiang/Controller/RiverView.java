package hzy.changJiang.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import hzy.changJiang.dao.OutFallMapper;
import hzy.changJiang.dao.RiverMapper;
import hzy.changJiang.pojo.*;
import hzy.changJiang.service.QuShuiByName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/river")
public class RiverView {

    @Autowired
    private RiverMapper riverMapper;

    @Autowired
    private OutFallMapper outFallMapper;

    @Autowired
    private QuShuiByName quShuiByName;

    @GetMapping("/{name}")
    @ResponseBody
    public Result findByName(@PathVariable String name) {
        Example example = new Example(River.class);
        example.createCriteria().andEqualTo("name",name);
        List<River> rivers = riverMapper.selectByExample(example);
        return new Result(true, StatusCode.OK,"查询成功",EntityUtils.entityToMap(rivers).get("elementData"));
    }

    @GetMapping("/qushui/{name}")
    @ResponseBody
    public Result findQuShuiByName(@PathVariable String name) {
        List<OutFall> outFall = quShuiByName.QuShuiName(name);
        return new Result(true,StatusCode.OK,"查询成功",EntityUtils.entityToMap(outFall).get("elementData"));
    }

    @GetMapping("/query")
    @ResponseBody
    public Result findQuShuiByName() {

        return new Result(true,StatusCode.OK,"查询成功",EntityUtils.entityToMap(outFallMapper.selectAll()).get("elementData") );
    }

    @GetMapping("/max")
    @ResponseBody
    public Result findMaxName() {

        OutFall byMaxHuang = outFallMapper.findByMaxHuang();
        OutFall byMaxChang = outFallMapper.findByMaxChang();
        List<OutFall> list = new ArrayList<>();
        list.add(byMaxChang);
        list.add(byMaxHuang);
        Map<String, Object> map1 = EntityUtils.entityToMap(list);
        JSONObject json1 = JSONObject.parseObject(JSON.toJSONString(map1));



        return new Result(true,StatusCode.OK,"查询成功",json1.get("elementData"));
    }
}
