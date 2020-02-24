package com.leo.uniapp.service;

import com.leo.modules.entity.QuestionMenu;
import com.leo.modules.vo.QuestionMenuListVo;
import com.leo.moudles.exception.NotExistException;
import com.leo.moudles.utils.DataUtils;
import com.leo.moudles.utils.validate.ValidateUtils;
import com.leo.uniapp.repository.QuestionMenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author qingweiqu
 */
@Slf4j
@Service
@Transactional(readOnly = true)
public class QuestionMenuService {

    @Autowired
    private QuestionMenuRepository repository;

    public QuestionMenu require (Integer id) {
        ValidateUtils.notNull(id, "id为空");
        return repository.findById(id)
                .orElseThrow(() -> new NotExistException(String.format("id:%d记录不存在", id)));
    }

    @Transactional(rollbackFor = Exception.class)
    public void createMenu (QuestionMenu menu) {
        ValidateUtils.create()
                .append(menu.getName(), DataUtils::isNotEmptyStr, "title标题为空")
                .append(menu.getParentId(), DataUtils::isNotNull, "parentId为空")
                .validate();
        require(menu.getParentId());
        init(menu);
        repository.save(menu);
    }

    /**
     * 获取菜单分类列表
     * @return
     */
    public List<QuestionMenuListVo> getAllMenu () {
        List<QuestionMenuListVo> voList = new ArrayList<>(10);
        // 一级
        List<QuestionMenu> menuList = repository.findAllByParentId(1);
        for (QuestionMenu menu : menuList) {
            List<QuestionMenu> secondList = repository.findAllByParentId(menu.getId());
            QuestionMenuListVo firstVo = QuestionMenuListVo.builder()
                    .id(menu.getId())
                    .name(menu.getName())
                    .build();
            voList.add(firstVo);
            List<QuestionMenuListVo> secondVoList = new ArrayList<>(20);
            firstVo.setChildren(secondVoList);
            secondList.forEach(p -> {
                QuestionMenuListVo secondVo = QuestionMenuListVo.builder()
                        .id(p.getId())
                        .name(p.getName())
                        .build();
                secondVoList.add(secondVo);
                List<QuestionMenuListVo> thirdVoList = new ArrayList<>(30);
                secondVo.setChildren(thirdVoList);
                List<QuestionMenu> thirdList = repository.findAllByParentId(p.getId());
                thirdList.forEach(t -> {
                    QuestionMenuListVo thirdVo = QuestionMenuListVo.builder()
                            .id(t.getId())
                            .name(t.getName())
                            .children(new ArrayList<>())
                            .build();
                    thirdVoList.add(thirdVo);
                });
            });

        }
        return voList;
    }

    private void init (QuestionMenu menu) {
        if (Objects.isNull(menu.getCreateTime())) {
            menu.setCreateTime(new Date());
        }
        if (Objects.isNull(menu.getOrderNum())) {
            menu.setOrderNum(-1);
        }
    }
}
