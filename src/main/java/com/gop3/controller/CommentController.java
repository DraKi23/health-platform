package com.gop3.controller;

import com.gop3.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Create by Drgn on 2020/2/15 14:36
 */
@Controller
public class CommentController {
    @Autowired
    private CommentMapper commentMapper;
}
