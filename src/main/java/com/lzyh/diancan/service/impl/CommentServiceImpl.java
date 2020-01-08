package com.lzyh.diancan.service.impl;

import com.lzyh.diancan.pojo.Comment;
import com.lzyh.diancan.dao.CommentDao;
import com.lzyh.diancan.service.CommentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author huangrui
 * @since 2020-01-08
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentDao, Comment> implements CommentService {

}
