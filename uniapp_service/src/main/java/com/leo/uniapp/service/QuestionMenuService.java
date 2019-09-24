package com.leo.uniapp.service;

import com.leo.modules.entity.QuestionMenu;
import com.leo.moudles.exception.NotExistException;
import com.leo.moudles.utils.DataUtils;
import com.leo.moudles.utils.validate.ValidateUtils;
import com.leo.uniapp.repository.QuestionMenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

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
                .append(menu.getTitle(), DataUtils::isNotEmptyStr, "title标题为空")
                .append(menu.getParentId(), DataUtils::isNotNull, "parentId为空")
                .validate();
        require(menu.getParentId());
        init(menu);
        repository.save(menu);
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
